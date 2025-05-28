import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class SimConfig {
    int numThreads;
    int dataTransferDelay;
    int[] schedule;
    public SimConfig(int numThreads, int dataTransferDelay, int[] schedule) {
	this.numThreads = numThreads;
	this.dataTransferDelay = dataTransferDelay;
	this.schedule = schedule;
    }
}

class UserJob<In,Out> {
    UserFunction<In,Out> function;
    In[] input;
    public UserJob(UserFunction<In,Out> function, In[] input) {
	this.function = function;
	this.input = input;
    }
} 

interface UserFunction<In,Out> {
    public Out apply(In x);
}

class MyFunction implements UserFunction<Integer,Integer> {
    int computationDelay;
    public MyFunction(int computationDelay) { this.computationDelay = computationDelay; }

    public Integer apply(Integer x) {
	Utils.delay(Thread.currentThread(), computationDelay);
	return 2 * x;
    }
}

class MapperThread<In,Out> extends Thread {

    int id;
    UserFunction<In,Out> function;
    In[] input;
    Out[] output;

    public MapperThread(int id, UserFunction<In,Out> function, In[] input, Out[] output) { 
	this.id = id; 
	this.function = function;
	this.input = input;
	this.output = output;
    }

    public void run() {
	//System.out.println("[T" + id + "] started");
	int s = input.length;
	for (int i = 0; i < s; i++)
	    output[i] = function.apply(input[i]);
    }
}

class Utils {

    static final Random rand = new Random();

    static List<Integer> factorsOf(int x) {
	List<Integer> all = new ArrayList<Integer>();
	all.add(1);
	for (int i = 2; i <= x; i++)
	    if (x % i == 0)
		all.add(i);
	return all;
    }

    static int[] shuffle(int n) {
	int[] a = new int[n];
	int[] b = new int[n];
	for (int i = 0 ; i < n; ++i)
	    a[i] = i;
	for (int i = n; i > 0; --i) {
	    int x = rand.nextInt(i);
	    int temp = a[x];
	    a[x] = a[i-1];
	    b[i-1] = temp;
	}
	return b;
    }

    public static void delay(Thread t, int time) {
	try { t.sleep(time); } catch (Exception e) { }
    }
}

public class ConcurrSim {

    <In,Out> void runSubJobs(MapperThread<In,Out>[] threads, int[] schedule, In[] input, int inputSize, int partSize, int dataTransferDelay, UserFunction<In,Out> function) {
	int numThreads = threads.length;
	for (int i = 0; i < numThreads; i++) {
	    In[] partIn = (In[]) new Object[partSize];
	    Out[] partOut = (Out[]) new Object[partSize];
	    int offset = i * partSize;
	    for (int j = 0; j < partSize; j++)
		partIn[j] = input[offset + j];
	    threads[i] = new MapperThread<In,Out>(i, function, partIn, partOut);
	}
	for (int i = 0; i < numThreads; i++) {
	    MapperThread t = threads[schedule[i]];
	    Utils.delay(t, dataTransferDelay);
	    t.start();
	}
	try {
	    for (int i = 0; i < numThreads; i++) {
		MapperThread t = threads[schedule[i]];
		t.join();
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    <In,Out> void joinSubJobs(MapperThread<In,Out>[] threads, int inputSize, int partSize, int dataTransferDelay, Out[] output) {
	int numThreads = threads.length;
	for (int i = 0; i < numThreads; i++) {
	    Thread t = threads[i];
	    Out[] partOut = threads[i].output;
	    int offset = i * partSize;
	    Utils.delay(t, dataTransferDelay);
	    for (int j = 0; j < partSize; j++) {
		output[offset + j] = partOut[j];
	    }
	}       
    }

    public <Out> void printSummary(int numThreads, int[] schedule, Out[] output, double startTime) {
	System.out.println("output:\t\t\t" + Arrays.toString(output));
	System.out.println("number of threads:\t" + numThreads);
	System.out.println("schedule:\t\t" + Arrays.toString(schedule));
	System.out.println("elapsed time:\t\t" + (System.currentTimeMillis() - startTime));
    }

    public <In,Out> void launch(UserJob<In,Out> job, SimConfig[] configs) {
	for (SimConfig config : configs) {
	    double startTime = System.currentTimeMillis();
	    In[] input = job.input;
	    int inputSize = input.length;
	    Out[] output = (Out[]) new Object[inputSize];
	    UserFunction<In,Out> function = job.function;
	    int numThreads = config.numThreads;
	    int[] schedule = config.schedule;
	    int partSize = inputSize / numThreads;
	    int dataTransferDelay = config.dataTransferDelay;
	    MapperThread<In,Out>[] threads = (MapperThread<In,Out>[]) new MapperThread[numThreads]; 
	    
	    runSubJobs(threads, schedule, input, inputSize, partSize, dataTransferDelay, function);
	    joinSubJobs(threads, inputSize, partSize, dataTransferDelay, output);
	    printSummary(numThreads, config.schedule, output, startTime);
	}
    }    

    public static void main(String[] args) {
	int size = 128;
	int numConfigs = 4;
	int fnDelay = 50;
	int dataTransferDelay = 50;
	Integer[] input = new Integer[size];
	for (int i = 0; i < size; i++)
	    input[i] = i;
	UserJob<Integer,Integer> job = new UserJob<Integer,Integer>(new MyFunction(fnDelay), input);
	List<Integer> factors = Utils.factorsOf(size);
	SimConfig[] configs = new SimConfig[numConfigs];	       
	for (int i = 0; i < numConfigs; i++) {
	    int dataDelay = dataTransferDelay;
	    int numThreads = factors.get(Utils.rand.nextInt(factors.size()));
	    int[] schedule = Utils.shuffle(numThreads);
	    configs[i] = new SimConfig(numThreads, dataDelay, schedule);
	}
	final ConcurrSim c = new ConcurrSim();	
	c.launch(job, configs);	
    }
    
}
