package main.java.comparisonBasedSortingAlgorithms;

import java.util.Arrays;
import java.util.Collections;

/**
BINARY INSERTION SORTING ALGORITHM:	
	It is similar to Insertion Sort. But we use binary search.
	We can use binary search to reduce the number of comparisons in a normal Insertion Sort. 
	Binary Insertion Sort uses binary search to find the proper location to insert the selected item at each iteration. 
	In normal Insertion Sort, it takes O(N) comparisons (at Nth iteration) in worst case. 
	We can reduce it to O(log N) by using binary search.
*/

public class BinaryInsertionSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("BINARY INSERTION SORT:");
		BinaryInsertionSortingAlgorithm<Integer> binarySortingAlgorithm = new BinaryInsertionSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Binary Insertion Sorting:");
		binarySortingAlgorithm.printArray(inputArray);
		
		//ASCENDING BINARY INSERTION ITERATIVE SORT:
		sortedArray = binarySortingAlgorithm.BinaryInsertionAscendingSort(inputArray);
		System.out.println("\n\nArray After Binary Insertion Ascending Sort:");
		binarySortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING BINARY INSERTION SORT:		
		sortedArray = binarySortingAlgorithm.BinaryInsertionDescendingSort(inputArray);
		System.out.println("\n\nArray After Binary Insertion Descending Sort:");
		binarySortingAlgorithm.printArray(sortedArray);
	}

	//THE BINARY INSERTION SORTING IMPLEMENTATION: 
	public T[] BinaryInsertionAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();			
		for(int i=1; i<copyOfArray.length; i++) { 
            T x = copyOfArray[i]; 
            //Finding Insertion Location using Binary Search: 
            int j = Math.abs(Arrays.binarySearch(copyOfArray, 0, i, x) + 1); 
            //Shifting the Array one location to the right: 
            System.arraycopy(copyOfArray, j, copyOfArray, j+1, i-j); 
            //Placing the element at its correct location: 
            copyOfArray[j] = x; 
        } 
		return copyOfArray;
	}
	
	public T[] BinaryInsertionDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = copyOfArray.length;
		for(int i=1; i<size; i++) { 
            T x = copyOfArray[i]; 
            //Finding Insertion Location for x using Binary Search: 
            int j = Math.abs(Arrays.binarySearch(copyOfArray, 0, i, x) + 1); 
            //Shifting the Array one location to the right: 
            System.arraycopy(copyOfArray, j, copyOfArray, j+1, i-j); 
            //Placing the element at its correct location: 
            copyOfArray[j] = x; 
        } 
		Collections.reverse(Arrays.asList(copyOfArray));
		return copyOfArray;
	}
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}
