package comparisonBasedSortingAlgorithmsTests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import comparisonBasedSortingAlgorithms.InsertionSortingAlgorithm;

public class InsertionSortingAlgorithmTest {
	private static InsertionSortingAlgorithm<Integer> insertionSortinglgorithm;
	private long startTime;
	private long endTime;
	private long duration;
	private static Integer[] inputArray;
	private Integer[] expectedArray;
	private Integer[] sortedArray;
	
	@BeforeAll
	public static void init() { 
		System.out.println("###   Insertion Sorting Algorithm Test   ###");
		inputArray = new Integer[] {34, -3, 4, 25, 60, -77, 91, 0, -59};
		insertionSortinglgorithm = new InsertionSortingAlgorithm<Integer>();
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
	void testInsertionAscendingIterativeSort() {
		expectedArray = new Integer[] {-77, -59, -3, 0, 4, 25, 34, 60, 91};			
		sortedArray = insertionSortinglgorithm.InsertionAscendingIterativeSort(inputArray);
		assertArrayEquals(expectedArray, sortedArray);
	}

	@Test
	void testInsertionDescendingIterativeSort() {
		expectedArray = new Integer[] {91, 60, 34, 25, 4, 0, -3, -59, -77};
		sortedArray = insertionSortinglgorithm.InsertionDescendingIterativeSort(inputArray);
		assertArrayEquals(expectedArray, sortedArray);
	}

	@Test
	void testInsertionAscendingRecursiveSort() {
		expectedArray = new Integer[] {-77, -59, -3, 0, 4, 25, 34, 60, 91};			
		sortedArray = insertionSortinglgorithm.InsertionAscendingRecursiveSort(inputArray);
		assertArrayEquals(expectedArray, sortedArray);
	}

	@Test
	void testInsertionDescendingRecursiveSort() {
		expectedArray = new Integer[] {91, 60, 34, 25, 4, 0, -3, -59, -77};
		sortedArray = insertionSortinglgorithm.InsertionDescendingRecursiveSort(inputArray);
		assertArrayEquals(expectedArray, sortedArray);
	}
}
