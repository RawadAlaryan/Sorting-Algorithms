package test.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import main.java.nonComparisonBasedSortingAlgorithms.BucketSortingAlgorithm;

public class BucketSortingAlgorithmTest {
	private static BucketSortingAlgorithm<Integer> bucketSortingAlgorithmIntegers;
	private static BucketSortingAlgorithm<Double> bucketSortingAlgorithmDoubles;
	private long startTime;
	private long endTime;
	private long duration;
	private static Integer[] inputIntegerArray;
	private Integer[] expectedIntegerArray;
	private Integer[] sortedIntegerArray;
	private static Double[] inputDoubleArray;
	private Double[] expectedDoubleArray;
	private Double[] sortedDoubleArray;
	
	@BeforeAll
	public static void init() { 
		System.out.println("###   Bucket Sorting Algorithm Test   ###");
		inputIntegerArray = new Integer[] {34, -3, 4, 25, 60, -77, 91, 0, -59};
		inputDoubleArray= new Double[] {-0.007, 0.897, 3.565, -1.656, 0.1234, 2.665, 0.3434};
		bucketSortingAlgorithmIntegers = new BucketSortingAlgorithm<Integer>();
		bucketSortingAlgorithmDoubles = new BucketSortingAlgorithm<Double>();
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
	void testBucketAscendingSortIntegers() {
		expectedIntegerArray = new Integer[] {-77, -59, -3, 0, 4, 25, 34, 60, 91};			
		sortedIntegerArray = bucketSortingAlgorithmIntegers.BucketAscendingSortIntegers(inputIntegerArray);
		assertArrayEquals(expectedIntegerArray, sortedIntegerArray);
	}

	@Test
	void testBucketDescendingSortIntegers() {
		expectedIntegerArray = new Integer[] {91, 60, 34, 25, 4, 0, -3, -59, -77};
		sortedIntegerArray = bucketSortingAlgorithmIntegers.BucketDescendingSortIntegers(inputIntegerArray);
		assertArrayEquals(expectedIntegerArray, sortedIntegerArray);
	}

	@Test
	void testBucketAscendingSortDoubles() {
		expectedDoubleArray = new Double[] {-1.656, -0.007, 0.1234, 0.3434	, 0.897, 2.665, 3.565};			
		sortedDoubleArray = bucketSortingAlgorithmDoubles.BucketAscendingSortDoubles(inputDoubleArray);
		assertArrayEquals(expectedDoubleArray, sortedDoubleArray);
	}

	@Test
	void testBucketDescendingSortDoubles() {		
		expectedDoubleArray = new Double[] {3.565, 2.665, 0.897, 0.3434, 0.1234, -0.007, -1.656};			
		sortedDoubleArray = bucketSortingAlgorithmDoubles.BucketDescendingSortDoubles(inputDoubleArray);
		assertArrayEquals(expectedDoubleArray, sortedDoubleArray);
	}
}
