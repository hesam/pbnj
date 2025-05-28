package polyglot.ext.pbnj;

import polyglot.main.Main;
import polyglot.main.Main.TerminationException;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class PBnJMain
{

    public enum MemoryModel { IN_PLACE(0), IN_PLACE_LOW_SYNC(1), IN_PLACE_SYNC(2), CP_W(3), N_REPLICATES(4); public int level; MemoryModel(int level) { this.level = level; } }

    public static MemoryModel SharedMemoryModel = MemoryModel.IN_PLACE;

    protected int USAGE_SCREEN_WIDTH = 76;
    protected int USAGE_FLAG_WIDTH = 27;
    protected int USAGE_SUBSECTION_INDENT = 8;

    public String[] start(String[] args) throws TerminationException {
	String[] newArgs = args;
        for(int i = 0; i < args.length; i++) {
	    if (args[i].equals("-model")) {
		if (i != args.length - 1) {
		    int val = -1;
		    try {
			val = Integer.parseInt(args[i+1]);
		    } catch (NumberFormatException e) {}
		     switch (val) {
		         case 0: SharedMemoryModel = MemoryModel.IN_PLACE; break;
		         case 1: SharedMemoryModel = MemoryModel.IN_PLACE_LOW_SYNC; break;
		         case 3: SharedMemoryModel = MemoryModel.CP_W; break;
		         case 4: SharedMemoryModel = MemoryModel.N_REPLICATES; break;
		         default: SharedMemoryModel = MemoryModel.IN_PLACE_SYNC;
		     }
		     System.out.println("Compiled shared memory model is " + SharedMemoryModel + ".");
		     newArgs = new String[args.length - 2];
		     for(int j = 0; j < i; j++)
			 newArgs[j] = args[j]; 
		     for(int j = i + 2; j < args.length; j++)
			 newArgs[j - 2] = args[j]; 
		     break;
		}		
	    } else if (args[i].equals("-h") || 
		       args[i].equals("-help") || 
		       args[i].equals("--help")) {
		usage();
		break;
	    }

        }
	return newArgs;
    }

    /**
     * Print usage information
     */
    public void usage() {
	PrintStream out = System.out;
        out.println("usage: pbnjc" + " [options] " +
                           "<source-file>.pbj" + " ...");
        out.println("where [options] includes:");
        usageForFlag(out, "@<file>", "read options from <file>");
        usageForFlag(out, "-d <directory>", "output directory");
        usageForFlag(out, "-assert", "recognize the assert keyword");
        usageForFlag(out, "-sourcepath <path>", "source path");
        usageForFlag(out, "-bootclasspath <path>", 
                          "path for bootstrap class files");
        usageForFlag(out, "-ext <extension>", "use language extension");
        usageForFlag(out, "-extclass <ext-class>", "use language extension");
        usageForFlag(out, "-fqcn", "use fully-qualified class names");
        usageForFlag(out, "-sx <ext>", "set source extension");
        usageForFlag(out, "-ox <ext>", "set output extension");
        usageForFlag(out, "-errors <num>", "set the maximum number of errors");
        usageForFlag(out, "-w <num>", 
                          "set the maximum width of the .java output files");
        usageForFlag(out, "-dump <pass>", "dump the ast after pass <pass>");
        usageForFlag(out, "-print <pass>",
	                  "pretty-print the ast after pass <pass>");
        usageForFlag(out, "-disable <pass>", "disable pass <pass>");
        usageForFlag(out, "-noserial", "disable class serialization");
        usageForFlag(out, "-nooutput", "delete output files after compilation");
        usageForFlag(out, "-c", "compile only to .java");
        usageForFlag(out, "-post <compiler>", 
                          "run javac-like compiler after translation");
        usageForFlag(out, "-v -verbose", "print verbose debugging information");
        usageForFlag(out, "-report <topic>=<level>", 
                          "print verbose debugging information about " +
                          "topic at specified verbosity");
	usageForFlag(out, "-model <num>", "Shared memory model: 0 -> IN_PLACE, 1 -> IN_PLACE_LOW_SYNC, 2 -> IN_PLACE_SYNC (default)");
    	usageForFlag(out, "-version", "print version info");
        usageForFlag(out, "-h", "print this message");
	System.exit(0);
    }

    protected void usageForFlag(PrintStream out, String flag, String description) {        
        out.print("  ");
        out.print(flag);
        // cur is where the cursor is on the screen.
        int cur = flag.length() + 2;
        
        // print space to get up to indentation level
        if (cur < USAGE_FLAG_WIDTH) {
            printSpaces(out, USAGE_FLAG_WIDTH - cur);
        }
        else {
            // the flag is long. Get a new line before printing the
            // description.
            out.println();
            printSpaces(out, USAGE_FLAG_WIDTH);
        }
        cur = USAGE_FLAG_WIDTH;
        
        // break up the description.
        StringTokenizer st = new StringTokenizer(description);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (cur + s.length() > USAGE_SCREEN_WIDTH) {
                out.println();
                printSpaces(out, USAGE_FLAG_WIDTH);
                cur = USAGE_FLAG_WIDTH;
            }
            out.print(s);
            cur += s.length();
            if (st.hasMoreTokens()) {
                if (cur + 1 > USAGE_SCREEN_WIDTH) {
                    out.println();
                    printSpaces(out, USAGE_FLAG_WIDTH);
                    cur = USAGE_FLAG_WIDTH;
                }
                else {
                    out.print(" ");
                    cur++;
                }
            }
        }
        out.println();
    }

    protected static void printSpaces(PrintStream out, int n) {
        while (n-- > 0) {
            out.print(' ');
        }
    } 
 
    public static final void main(String args[]) {
	try {
	    args = new PBnJMain().start(args);
	    new Main().start(args);
	}
	catch (TerminationException te) {
	    if (te.getMessage() != null)
		(te.exitCode==0?System.out:System.err).println(te.getMessage());
	    System.exit(te.exitCode);
	}
    }
}
