package at.ac.testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import polyglot.ext.pbnj.tologic.LogMap;
import at.ac.testing.mocks.NewSchedule;
import at.ac.testing.mocks.TimedAction;
import java.util.Arrays;

public class NewScheduleTest {

	@BeforeClass
	public static void setupSolver() {
		LogMap.SolverOpt_IntBitWidth = 9;
	}

	@Test
	public void testScheduleInitialization() {
		NewSchedule schedule = new NewSchedule();

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init();
		System.out.println("Initial SCHEDULE			: \n" + schedule);

	}

	@Test
	public void testScheduleInitializationWithStateTransitions() {
		NewSchedule schedule = new NewSchedule();
		// If this is in input -> reorder time, keeps the values but keeps also
		// the TimedAction objects !!
		// We cannot USE null inside TimeAction. Default to -1 (or negative
		// number then !)
		TimedAction[] targetStates = new TimedAction[] { new TimedAction(-1, 5, 10), new TimedAction(-1, 10, 2), new TimedAction(-1, 3, 4) };

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init(targetStates);
		System.out.println("Input SCHEDULE			: \n" + Arrays.toString(targetStates));
		System.out.println("Initial SCHEDULE			: \n" + schedule);

	}

	@Test
	public void testScheduleInitializationWithStateTransitionsPreservesTime() {
		NewSchedule schedule = new NewSchedule();
		// If this is in input -> reorder time, keeps the values but keeps also
		// the TimedAction objects !!
		// We cannot USE null inside TimeAction. Default to -1 (or negative
		// number then !)
		TimedAction[] targetStates = new TimedAction[] { new TimedAction(0, 5, 10), new TimedAction(-1, 10, 2), new TimedAction(10, 3, 4) };

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init(targetStates);
		System.out.println("Input SCHEDULE			: \n" + Arrays.toString(targetStates));
		System.out.println("Initial SCHEDULE			: \n" + schedule);

	}

	@Test
	public void testScheduleDuration() {
		NewSchedule schedule = new NewSchedule();
		schedule.init();

		schedule.withDuration(30);
		System.out.println("With Duration SCHEDULE		: \n" + schedule);

		schedule.withMaxDuration(10);
		System.out.println("With Max Duration SCHEDULE	: \n" + schedule);

		schedule.withMinDuration(20);
		System.out.println("With Min Duration SCHEDULE	: \n" + schedule);

		schedule.withDurationInBetween(10, 20);
		System.out.println("With Between Durations SCHEDULE	: \n" + schedule);

		// Factory Method NOT WORKING
		// NewSchedule anotherSchedule = schedule.create();
		// System.out.println(anotherSchedule);
	}

	@Test
	public void testScheduleDurationPreserveStates() {
		NewSchedule schedule = new NewSchedule();
		TimedAction[] targetStates = new TimedAction[] { new TimedAction(0, 5, 10), new TimedAction(2, 10, 2), new TimedAction(10, 3, 4) };

		schedule.init(targetStates);
		System.out.println("Initial SCHEDULE		: \n" + schedule);

		// Is this working ?
		schedule.withDuration(30);
		System.out.println("With Duration SCHEDULE		: \n" + schedule);
	}

}
