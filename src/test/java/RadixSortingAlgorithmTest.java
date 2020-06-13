package test.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import main.java.nonComparisonBasedSortingAlgorithms.RadixSortingAlgorithm;

public class RadixSortingAlgorithmTest {
	private static RadixSortingAlgorithm<Integer> radixSortinglgorithm;
	private long startTime;
	private long endTime;
	private long duration;
	private static Integer[] inputIntegerArray;
	private static Integer[] expectedIntegerArray;
	private static Integer[] sortedIntegerArray;
	private static String[] inputStringArray;
	private static String[] sortedStringArray;
	private static String[] expectedStringArray;
	
	@BeforeAll
	public static void init() { 
		System.out.println("###   Radix Sorting Algorithm Test   ###");
		inputIntegerArray = new Integer[] {34, -3, 4, 25, 60, -77, 91, -59};
		inputStringArray = new String[] {"n", "o", "p", "q", "r", "w", "x", "y", "f", "t", "u", "v", "g", "h", "i", "a", "b", "c", "d", "e", "j", "z", "k", "l", "m" ,"s"};
		radixSortinglgorithm = new RadixSortingAlgorithm<Integer>();
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
	void testRadixAscendingSortIntegers() {
		expectedIntegerArray = new Integer[] {-77, -59, -3, 4, 25, 34, 60, 91};			
		sortedIntegerArray = radixSortinglgorithm.RadixAscendingSortIntegers(inputIntegerArray);
		assertArrayEquals(expectedIntegerArray, sortedIntegerArray);
	}

	@Test
	void testRadixDescendingSortIntegers() {
		expectedIntegerArray = new Integer[] {91, 60, 34, 25, 4, -3, -59, -77};
		sortedIntegerArray = radixSortinglgorithm.RadixDescendingSortIntegers(inputIntegerArray); 
		assertArrayEquals(expectedIntegerArray, sortedIntegerArray);
	}

	@Test
	void testRadixAscendingSortStrings() {			
		expectedStringArray = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",	"t", "u", "v", "w", "x", "y", "z"};			
		sortedStringArray = radixSortinglgorithm.RadixAscendingSortStrings(inputStringArray);
		assertArrayEquals(expectedStringArray, sortedStringArray);
	}

	@Test
	void testRadixDescendingSortStrings() {		
		expectedStringArray = new String[] {"z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f",	"e",	"d",	"c",	"b",	"a"};
		sortedStringArray = radixSortinglgorithm.RadixDescendingSortStrings(inputStringArray);
		assertArrayEquals(expectedStringArray, sortedStringArray);
	}
	
	
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public static void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
	}
}
