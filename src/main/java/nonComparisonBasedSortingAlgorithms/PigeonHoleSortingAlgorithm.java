package nonComparisonBasedSortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
PIGEONHOLE SORTING ALGORITHM:
	Pigeonhole Sorting is a sorting algorithm that is suitable for sorting lists of elements where: 
	The number of elements (n) and the length of the range of possible key values (N) are approximately the same.
	It requires O(n + N) time. It is similar to Counting Sort, but differs in that: 
		Pigeonhole Sort moves items twice: once to the bucket array and again to the final destination 
		Counting Sort builds an auxiliary array then uses the array to compute each item's final destination and move the item there.
	The pigeonhole sorting algorithm works as follows:
		1. Given an array of values to be sorted, set up an auxiliary array of initially empty "pigeonholes," one pigeonhole for each key through the range of the original array.
		2. Going over the original array, put each value into the pigeonhole corresponding to its key, such that each pigeonhole eventually contains a list of all values with that key.
		3. Iterate over the pigeonhole array in order, and put elements from non-empty pigeonholes back into the original array.	
*/

public class PigeonHoleSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("PIGEONHOLE SORT:");
		PigeonHoleSortingAlgorithm<Integer> pigeonHoleSortingAlgorithm = new PigeonHoleSortingAlgorithm<Integer>();
		Integer[] inputArrayForNonComparisonSort = {34, -3, 4, 25, -77, 60, 91, 0, -59};
		Integer[] sortedArrayForNonComparisonSort;
		
		System.out.println("Array Before Pigeonhole Sorting:");
		pigeonHoleSortingAlgorithm.printNumberArray(inputArrayForNonComparisonSort);
		
		//ASCENDING PIGEONHOLE SORT:
		sortedArrayForNonComparisonSort = pigeonHoleSortingAlgorithm.PigeonholeAscendingSort(inputArrayForNonComparisonSort);
		System.out.println("\n\nArray After Pigeonhole Ascending Sort:");
		pigeonHoleSortingAlgorithm.printNumberArray(sortedArrayForNonComparisonSort);
		
		//DESCENDING PIGEONHOLE SORT:		
		sortedArrayForNonComparisonSort = pigeonHoleSortingAlgorithm.PigeonholeDescendingSort(inputArrayForNonComparisonSort);
		System.out.println("\n\nArray After Pigeonhole Descending Sort:");
		pigeonHoleSortingAlgorithm.printNumberArray(sortedArrayForNonComparisonSort);
	}

	//THE PIGEONHOLE SORTING IMPLEMENTATION: 	
	//This implementation is enhanced to handle positive and negative integers in the input array.
	public Integer[] PigeonholeAscendingSort(Integer[] inputArray) {
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
		PigeonholeArraySorter((ArrayList<Integer>) positiveIntegers);
		PigeonholeArraySorter((ArrayList<Integer>) negativeIntegers);
		//Reversing the order of negativeIntegers Array:
		Collections.reverse(negativeIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i] = -1*negativeIntegers.get(i); }
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i+negativeIntegers.size()] = positiveIntegers.get(i); }
		return copyOfArray; 
	}	
	
	public Integer[] PigeonholeDescendingSort(Integer[] inputArray) {
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
	
	private void PigeonholeArraySorter(ArrayList<Integer> integerArray) {
		int min = (int) Collections.min(integerArray);
		int max = (int) Collections.max(integerArray);
		int size = integerArray.size();
		int range, i, j, index;  
		range = max - min + 1; 
        int[] pigeonholes = new int[range]; 
        Arrays.fill(pigeonholes, 0); 
        for(i = 0; i<size; i++) { pigeonholes[integerArray.get(i) - min]++; } 
        index = 0; 
        for(j = 0; j<range; j++) {
            while(pigeonholes[j]-->0) { integerArray.set(index++, j+min); }
        }
	}
	
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
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
}
