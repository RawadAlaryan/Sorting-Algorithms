package nonComparisonBasedSortingAlgorithmsTests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import nonComparisonBasedSortingAlgorithms.PigeonHoleSortingAlgorithm;

public class PigeonHoleSortingAlgorithmTest {
	private static PigeonHoleSortingAlgorithm<Integer> pigeonHoleSortinglgorithm;
	private long startTime;
	private long endTime;
	private long duration;
	private static Integer[] inputArray;
	private Integer[] expectedArray;
	private Integer[] sortedArray;
	
	@BeforeAll
	public static void init() { 
		System.out.println("###   Pigeon-Hole Sorting Algorithm Test   ###");
		inputArray = new Integer[] {34, -3, 4, 25, 60, -77, 91, 0, -59};
		pigeonHoleSortinglgorithm = new PigeonHoleSortingAlgorithm<Integer>();
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
	void testPigeonholeAscendingSort() {
		expectedArray = new Integer[] {-77, -59, -3, 0, 4, 25, 34, 60, 91};			
		sortedArray = pigeonHoleSortinglgorithm.PigeonholeAscendingSort(inputArray);
		assertArrayEquals(expectedArray, sortedArray);
	}

	@Test
	void testPigeonholeDescendingSort() {
		expectedArray = new Integer[] {91, 60, 34, 25, 4, 0, -3, -59, -77};
		sortedArray = pigeonHoleSortinglgorithm.PigeonholeDescendingSort(inputArray);
		assertArrayEquals(expectedArray, sortedArray);
	}
}
