package main.java.nonComparisonBasedSortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
BEAD SORTING ALGORITHM:	
    Bead Sort is also called "Gravity Sort". It is a Natural Sorting Algorithm. 
    It can only be used to sort lists of positive integers.
    It is developed by Joshua J. Arulanandham, Cristian S. Calude and Michael J. Dinneen in 2002. 
    Both digital and analog hardware implementations of Bead Sort can achieve a sorting time of O(N). 
    However, the implementation of this algorithm tends to be significantly slower in software.  
    Also, it would seem that even in the best case, the algorithm requires O(N^2) space.
*/

public class BeadSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("BEAD SORT:");
		BeadSortingAlgorithm<Integer> beadSortingAlgorithm = new BeadSortingAlgorithm<Integer>();
		Integer[] integerArray = {34, -3, 4, 25, -77, 60, 91, 0, -59};
		
		System.out.println("Array Before Bead Sorting:");
		beadSortingAlgorithm.printNumberArray(integerArray);
		
		//ASCENDING BEAD SORT:
		Integer[] sortedIntegerArray = beadSortingAlgorithm.BeadAscendingSort(integerArray);
		System.out.println("\n\nArray After Bead Ascending Sort:");
		beadSortingAlgorithm.printNumberArray(sortedIntegerArray);
		
		//DESCENDING BEAD SORT:		
		sortedIntegerArray = beadSortingAlgorithm.BeadDescendingSort(integerArray);
		System.out.println("\n\nArray After Bead Descending Sort:");
		beadSortingAlgorithm.printNumberArray(sortedIntegerArray);	
	}

	
    //THE BEAD SORTING IMPLEMENTATION: 	
    //This implementation is enhanced to handle positive and negative integers in the input array.
    public Integer[] BeadAscendingSort(Integer[] inputArray) {
    	//Making a Copy of Input Array, so that we Return the Sorted One.
    	Integer[] copyOfArray = inputArray.clone();
    	//Counting number of positive/negative integers:
    	int numOfPositiveIntegers = 0;
    	int numOfNegativeIntegers = 0;
    	for(int i=0; i<copyOfArray.length; i++) {
    		if(copyOfArray[i].intValue() >= 0) { numOfPositiveIntegers++; }
    		else { numOfNegativeIntegers++; }
    	}
    	//Splitting Positive Values from Negative Values:
    	List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
    	List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
    	//Filling the Positive and Negative Arrays from Original Input Array:
    	for(int i=0; i<copyOfArray.length; i++) {
    		if(copyOfArray[i].intValue() >= 0) { positiveIntegers.add(copyOfArray[i]); }
    		else { negativeIntegers.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
    	}
    	//Calling ascendingBeadSorterIntegers on both positiveIntegers and negativeIntegers: 
    	Integer[] positiveArray = BeadAscendingSorter(positiveIntegers);
    	Integer[] negativeArray = BeadAscendingSorter(negativeIntegers);
    	//Reversing the order of negativeIntegers Array:
    	Collections.reverse(Arrays.asList(negativeArray)); 
    	//Joining both arrays into one final sorted Array:
    	for(int i=0; i<negativeArray.length; i++) { copyOfArray[i] = -1*negativeArray[i]; }
    	for(int i=0; i<positiveArray.length; i++) { copyOfArray[i+negativeArray.length] = positiveArray[i]; }
    	return copyOfArray; 
    }	
    private Integer[] BeadAscendingSorter(List<Integer> numberArray) {
    	int max = Collections.max(numberArray);
    	//Setup the Abacus (The Counting Frame):
		char[][] grid = new char[numberArray.size()][max];
		int[] levelcount = new int[max];
		for(int i=0; i<max; i++) {
			levelcount[i] = 0;
			for(int j=0; j<numberArray.size(); j++) { grid[j][i] = '_'; }
		}
		//Drop the Beads:
		for(int i=0; i<numberArray.size(); i++)	{
			int num = numberArray.get(i);
			for(int j=0; num>0; j++) {
				grid[levelcount[j]++][j] = '*';
				num--;
			}
		}
		//Count the Beads:
		Integer[] sortedArray = new Integer[numberArray.size()];
		for(int i=0; i<numberArray.size(); i++) {
			int putt = 0;
			for(int j=0; j<max && grid[numberArray.size()-1-i][j]=='*'; j++) { putt++; }
			sortedArray[i] = putt;
		}
		return sortedArray;
    }
	
    public Integer[] BeadDescendingSort(Integer[] inputArray) {
    	//Making a Copy of Input Array, so that we Return the Sorted One.
    	Integer[] copyOfArray = inputArray.clone();
    	//Counting number of positive/negative integers:
    	int numOfPositiveIntegers = 0;
    	int numOfNegativeIntegers = 0;
    	for(int i=0; i<copyOfArray.length; i++) {
    		if(copyOfArray[i].intValue() >= 0) { numOfPositiveIntegers++; }
    		else { numOfNegativeIntegers++; }
    	}
    	//Splitting Positive Values from Negative Values:
    	List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
    	List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
    	//Filling the Positive and Negative Arrays from Original Input Array:
    	for(int i=0; i<copyOfArray.length; i++) {
    		if(copyOfArray[i].intValue() >= 0) { positiveIntegers.add(copyOfArray[i]); }
    		else { negativeIntegers.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
    	}
    	//Calling ascendingBeadSorterIntegers on both positiveIntegers and negativeIntegers: 
    	Integer[] positiveArray = BeadDescendingSorter(positiveIntegers);
    	Integer[] negativeArray = BeadDescendingSorter(negativeIntegers);
    	//Reversing the order of positiveIntegers Array:
    	Collections.reverse(Arrays.asList(positiveArray));
    	//Joining both arrays into one final sorted Array:
    	for(int i=0; i<positiveArray.length; i++) { copyOfArray[i] = positiveArray[i]; }
    	for(int i=0; i<negativeArray.length; i++) { copyOfArray[i+positiveArray.length] = -1*negativeArray[i]; }
    	return copyOfArray; 
    }	
    private Integer[] BeadDescendingSorter(List<Integer> numberArray) {
    	int max = Collections.max(numberArray);
    	//Setup the Abacus (The Counting Frame):
		char[][] grid = new char[numberArray.size()][max];
		int[] levelcount = new int[max];
		for(int i=0; i<max; i++) {
			levelcount[i] = 0;
			for(int j=0; j<numberArray.size(); j++) { grid[j][i] = '_'; }
		}
		//Drop the Beads:
		for(int i=0; i<numberArray.size(); i++)	{
			int num = numberArray.get(i);
			for(int j=0; num>0; j++) {
				grid[levelcount[j]++][j] = '*';
				num--;
			}
		}
		//Count the Beads:
		Integer[] sortedArray = new Integer[numberArray.size()];
		for(int i=0; i<numberArray.size(); i++) {
			int putt = 0;
			for(int j=0; j<max && grid[numberArray.size()-1-i][j]=='*'; j++) { putt++; }
			sortedArray[i] = putt;
		}
		return sortedArray;
    }
    
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
	}
}
