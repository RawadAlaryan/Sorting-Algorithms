package main.java.nonComparisonBasedSortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
COUNTING SORTING ALGORITHM:
	It is an Integer Sorting Algorithm: We assume the values to be integers. 
	Counting Sort assumes that all the values are discrete and they are within a specific range.
	We are not able to sort floats, doubles, characters or Strings with Counting Sort. Because They are not discrete values.
	It is a Non-Comparison-Based Sorting Algorithm. Counting Sort uses key values as indexes into an array. It counts the number of occurrences of each value.
	It operates by counting the number of objects that have each distinct key value - The "Counts".
	Counting Sort uses arithmetic operations on the Counts to determine the positions of each key value in the output sorted sequence.
	Counting Sort is only suitable for direct use situations where the variation in keys is not significantly greater than the number of items.
	Counting Sort is good for sorting values within a specific range (0 - 100), the range can not be huge. 
	Counting sort is not efficient for ranges between one and million.
	Counting Sort can be used as a subroutine in Radix Sort.
	Running time: O(N+k)
		N is number of items we want to sort.
		k is difference between the maximum and minimum key values, basically the number of possible distinct keys.
			The smaller K gives a faster Linear Running Time O(N).
	Counting Sort Implementation:
	Counting Sort has two phases of execution: 
		First Phase - The Counting Phase: We traverse the input array and we count how many of each value we have. 
		Second Phase - The Sorting Phase: We use the counting array to write the values back into the input array in a sorted manner. 
	We allocate memory for a CounterArray of size k. The values are initially zero. 
	After Counting, CounterArray determines how many times the given index is present in the original array. 
	We count the occurrences in the original array for each given key.
			1. Iterating through the original array O(N).
			2. Value in the array will be the index of the Counting Array (temporaryArray) and we increment the counter.
			3. Traverse the array of counters (array of size k) O(k).
			4. The values are going to be in the Numerical Order.
	Counting Sort is NOT an In-place algorithm because we have to create a counting array.
	The length of the counting array will depend on the range of values we have, because of this, counting sort is best used when the range is around the same length of the input array.
	This algorithm is NOT Stable, but can be stable with adding some extra steps by using LinkedLists in the CountingArray.
*/

public class CountingSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("COUNTING SORT:");
		CountingSortingAlgorithm<Integer> countingSortingAlgorithm = new CountingSortingAlgorithm<Integer>();
		Integer[] inputArrayForNonComparisonSort = {34, -3, 4, 25, -77, 60, 91, 0, -59};
		Integer[] sortedArrayForNonComparisonSort;
		
		System.out.println("Array Before Counting Sorting:");
		countingSortingAlgorithm.printNumberArray(inputArrayForNonComparisonSort);
		
		//ASCENDING COUNTING SORT:
		sortedArrayForNonComparisonSort = countingSortingAlgorithm.CountingAscendingSort(inputArrayForNonComparisonSort);
		System.out.println("\n\nArray After Counting Ascending Sort:");
		countingSortingAlgorithm.printNumberArray(sortedArrayForNonComparisonSort);
		
		//DESCENDING COUNTING SORT:		
		sortedArrayForNonComparisonSort = countingSortingAlgorithm.CountingDescendingSort(inputArrayForNonComparisonSort);
		System.out.println("\n\nArray After Counting Descending Sort:");
		countingSortingAlgorithm.printNumberArray(sortedArrayForNonComparisonSort);
	}
	
	//THE COUNTING SORTING IMPLEMENTATION: 	
	//This implementation is enhanced to handle positive and negative integers in the input array.
	public Integer[] CountingAscendingSort(Integer[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Integer[] copyOfArray = (Integer[]) inputArray.clone();		
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
		List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { positiveIntegers.add(copyOfArray[i]); }
			else { negativeIntegers.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
		}
		//Calling CountingArraySorter on both positiveIntegers and negativeIntegers:
		CountingArraySorter((ArrayList<Integer>) positiveIntegers);
		CountingArraySorter((ArrayList<Integer>) negativeIntegers);
		//Reversing the order of negativeIntegers Array:
		Collections.reverse(negativeIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i] = -1*negativeIntegers.get(i); }
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i+negativeIntegers.size()] = positiveIntegers.get(i); }
		return copyOfArray; 
	}
		
	public Integer[] CountingDescendingSort(Integer[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Integer[] copyOfArray = (Integer[]) inputArray.clone();		
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
		List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { positiveIntegers.add(copyOfArray[i]); }
			else { negativeIntegers.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
		}
		//Calling CountingArraySorter on both positiveIntegers and negativeIntegers:
		CountingArraySorter((ArrayList<Integer>) positiveIntegers);
		CountingArraySorter((ArrayList<Integer>) negativeIntegers);
		//Reversing the order of positiveIntegers Array:
		Collections.reverse(positiveIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i] = positiveIntegers.get(i); }
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i+positiveIntegers.size()] = -1*negativeIntegers.get(i); }
		return copyOfArray; 
	}

	private void CountingArraySorter(ArrayList<Integer> integerArray) {
		int min = (int) Collections.min(integerArray);
		int max = (int) Collections.max(integerArray);
		//Allocate Memory for the CountingArray O(k):
		int k = max - min + 1;
		int[] countingArray= new int[k];
		//Counting integers in the IntegerArray:
		for(int integer : integerArray){ countingArray[integer - min]++; }
		int z = 0;
		//Count the occurrences:
		for(int i=min; i<=max; i++) {
			while(countingArray[i-min] > 0){
				integerArray.set(z, i);		
				z++;
				countingArray[i - min]--;
			}
		}
	}
	
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
	}
}