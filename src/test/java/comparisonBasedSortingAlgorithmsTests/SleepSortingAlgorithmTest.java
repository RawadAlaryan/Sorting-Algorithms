package comparisonBasedSortingAlgorithmsTests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import comparisonBasedSortingAlgorithms.SleepSortingAlgorithm;

public class SleepSortingAlgorithmTest {
	private static SleepSortingAlgorithm sleepSortinglgorithm;
	private long startTime;
	private long endTime;
	private long duration;
	private static Number[] inputArray;
	private Number[] expectedArray;
	private Number[] sortedArray;
	
	@BeforeAll
	public static void init() { 
		System.out.println("###   Sleep Sorting Algorithm Test   ###");
		inputArray = new Number[] {34, 3, 150, 25, 77, 60, 0, 41, 17};
		sleepSortinglgorithm = new SleepSortingAlgorithm();
	}
	
	@BeforeEach
	void setUp() throws Exception { startTime = System.nanoTime(); }

	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		endTime = System.nanoTime();
		duration = (endTime - startTime);  
		System.out.println("Execution Duration of Test Case: " + testInfo.getDisplayName() + " is:\t" + duration + " ns.");
	}
	
	@Test
	void testSleepAscendingSort() {
		expectedArray = new Integer[] {0, 3, 17, 25, 34, 41, 60, 77, 150};
		sortedArray = sleepSortinglgorithm.SleepAscendingSort(inputArray);
		//Sleeping the Current Method Thread to finish sorting.
		try { Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); }	
		assertArrayEquals(expectedArray, sortedArray);
	}

	@Test
	void testSleepDescendingSort() {
		expectedArray = new Integer[] {150, 77, 60, 41, 34, 25, 17, 3, 0};
		sortedArray = sleepSortinglgorithm.SleepDescendingSort(inputArray);
		//Sleeping the Current Method Thread to finish sorting.
		try { Thread.sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); }
		assertArrayEquals(expectedArray, sortedArray);
	}
}
