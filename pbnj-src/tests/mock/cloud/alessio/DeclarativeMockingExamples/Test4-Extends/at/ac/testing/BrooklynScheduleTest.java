package at.ac.testing;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import polyglot.ext.pbnj.tologic.LogMap;
import at.ac.testing.mocks.BrooklynSchedule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import polyglot.ext.pbnj.tologic.LogMap;
import at.ac.testing.mocks.NewSchedule;
import at.ac.testing.mocks.TimedAction;
import java.util.Arrays;

public class BrooklynScheduleTest {

	@BeforeClass
	public static void setupSolver() {
		LogMap.SolverOpt_IntBitWidth = 8;
	}

	int stabilityPeriodUp = 10;
	int stabilityPeriodDown = 10;
	int controlPeriod = 3;
	int actuationDelay = 0;

	@org.testng.annotations.Test
	public void testScheduleInitialization() {
		BrooklynSchedule schedule = new BrooklynSchedule(stabilityPeriodUp, stabilityPeriodDown, controlPeriod, actuationDelay);

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init();
		System.out.println("Initial SCHEDULE			: \n" + schedule);

	}

	@org.testng.annotations.Test
	public void testScheduleInitializationWithStateTransitions() {
		BrooklynSchedule schedule = new BrooklynSchedule(stabilityPeriodUp, stabilityPeriodDown, controlPeriod, actuationDelay);

		TimedAction[] targetStates = new TimedAction[] { new TimedAction(-1, 5, 10), new TimedAction(-1, 10, 2), new TimedAction(-1, 3, 4) };

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init(targetStates);
		System.out.println("Input SCHEDULE			: \n" + Arrays.toString(targetStates));
		System.out.println("Initial SCHEDULE			: \n" + schedule);
	}

	@org.testng.annotations.Test
	public void testScheduleInitializationWithStateTransitionsPreservesTime() {
		BrooklynSchedule schedule = new BrooklynSchedule(stabilityPeriodUp, stabilityPeriodDown, controlPeriod, actuationDelay);

		TimedAction[] targetStates = new TimedAction[] { new TimedAction(0, 5, 10), new TimedAction(-1, 10, 2), new TimedAction(10, 3, 4) };

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init(targetStates);
		System.out.println("Input SCHEDULE			: \n" + Arrays.toString(targetStates));
		System.out.println("Initial SCHEDULE			: \n" + schedule);

	}

	@org.testng.annotations.Test
	public void testScheduleInitializationWithoutConcurrentActions() {
		BrooklynSchedule schedule = new BrooklynSchedule(stabilityPeriodUp, stabilityPeriodDown, controlPeriod, actuationDelay);

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init();
		System.out.println("Initial SCHEDULE			: \n" + schedule);

		// This cannot modify the state of the object WHY ?!
		schedule.withoutConcurrentActions();
		System.out.println("Wihtout Concurrent Actions SCHEDULE			: \n" + schedule);
	}

	@org.testng.annotations.Test
	public void testScheduleInitializationWithStateTransitionsPreservesTimeWithoutConcurrentActions() {
		BrooklynSchedule schedule = new BrooklynSchedule(stabilityPeriodUp, stabilityPeriodDown, controlPeriod, actuationDelay);

		TimedAction[] targetStates = new TimedAction[] { new TimedAction(0, 5, 10), new TimedAction(-1, 10, 2), new TimedAction(9, 3, 4) };

		// Update itself - It's ALWAYS THE SAME OBJECT !!
		schedule.init(targetStates);
		System.out.println("Input SCHEDULE			: \n" + Arrays.toString(targetStates));
		System.out.println("Initial SCHEDULE			: \n" + schedule);

		// This cannot modify the state of the object WHY ?!
		schedule.withoutConcurrentActions();
		System.out.println("Wihtout Concurrent Actions SCHEDULE			: \n" + schedule);
	}

	@Test
	public void testScheduleDurationPreserveStates() {
		BrooklynSchedule schedule = new BrooklynSchedule(stabilityPeriodUp, stabilityPeriodDown, controlPeriod, actuationDelay);
		TimedAction[] targetStates = new TimedAction[] { new TimedAction(0, 5, 10), new TimedAction(2, 10, 2), new TimedAction(10, 3, 4) };

		schedule.init(targetStates);
		System.out.println("Initial SCHEDULE		: \n" + schedule);

		// Is this working ?
		schedule.withDuration(30);
		System.out.println("With Duration SCHEDULE		: \n" + schedule);
	}

	// @org.testng.annotations.Test
	// public void testScheduleDuration() {
	// NewSchedule schedule = new NewSchedule();
	// schedule.init();
	//
	// NewSchedule duration = schedule.withDuration(30);
	// System.out.println("With Duration SCHEDULE		: \n" + duration);
	//
	// NewSchedule maxDuration = schedule.withMaxDuration(10);
	// System.out.println("With Max Duration SCHEDULE	: \n" + maxDuration);
	//
	// NewSchedule minDuration = schedule.withMinDuration(20);
	// System.out.println("With Min Duration SCHEDULE	: \n" + minDuration);
	//
	// NewSchedule betweenDurations = schedule.withDurationInBetween(10, 20);
	// System.out.println("With Between Durations SCHEDULE	: \n" +
	// betweenDurations);
	//
	// // Factory Method NOT WORKING
	// // NewSchedule anotherSchedule = schedule.create();
	// // System.out.println(anotherSchedule);
	// }

}
