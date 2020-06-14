package comparisonBasedSortingAlgorithms;

import java.lang.reflect.Array;

/**
MERGE SORTING ALGORITHM:
	Merge Sort is a comparison-based algorithm with running time complexity O(N.logN). 
	It was invented by John von Neumann in 1945
	It is a Stable Sorting Algorithm.
	It is Not an In-Place Algorithm.
		Merge Sort has a space complexity of Theta(N). While Heap Sort requires only Theta(1) auxiliary/extra Space Complexity. 
	Efficient Quick Sort implementations generally outperform Merge Sort.
	Merge Sort is the best choice for sorting a Linked List: It is implemented to require only 	Theta(1) auxiliary/extra Space Complexity.
	Merge Sort is a Divide and Conquer Algorithm:
 		1. Divide the array into two SubArrays recursively.
		2. Sort these SubArrays recursively with Merge Sort again.
		3. If there is only a single item left in the SubArray, we consider it to be sorted!
		4. Merge the SubArrays to get the Final Sorted Array.
	Worst Case: O(N.logN); that is why it is guaranteed to perform fast! Only trade-off is Space Complexity Theta(N).
	Merge Sort can be implemented using: Iterations or Recursion.
*/

public class MergeSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("MERGE SORT:");
		MergeSortingAlgorithm<Integer> mergeSortingAlgorithm = new MergeSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		
		//MERGE RECURSIVE SORT:
		System.out.println("MERGE SORT - RECURSIVE IMPLEMENTATION:");
		System.out.println("Array Before Merge Recursive Sorting:\t\t\t");
		mergeSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING MERGE RECURSIVE SORT:
		sortedArray = mergeSortingAlgorithm.MergeAscendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Merge Recursive Ascending Sort:");
		mergeSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING MERGE RECURSIVE SORT:		
		sortedArray = mergeSortingAlgorithm.MergeDescendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Merge Recursive Descending Sort:");
		mergeSortingAlgorithm.printArray(sortedArray);				
		
		//MERGE ITERATIVE SORT:
		System.out.println("\n\n\n\nMERGE SORT - ITERATIVE IMPLEMENTATION:");
		System.out.println("Array Before Merge Iterative Sorting:");
		mergeSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING MERGE ITERATIVE SORT:
		sortedArray = mergeSortingAlgorithm.MergeAscendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Merge Iterative Ascending Sort:");
		mergeSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING MERGE ITERATIVE SORT:		
		sortedArray = mergeSortingAlgorithm.MergeDescendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Merge Iterative Descending Sort:");
		mergeSortingAlgorithm.printArray(sortedArray);	
	}

	//THE MERGE SORTING IMPLEMENTATION: 
	//RECURSIVE IMPLEMENTATION OF MERGE SORTING:
	public T[] MergeAscendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		MergeAscendingSorter(copyOfArray, 0, copyOfArray.length-1);;
		return copyOfArray; 
	}	
	private void MergeAscendingSorter(T[] copyOfArray, int low, int high) {
		if (low >= high) { return; }
        int middle = (low+high)/2;
        MergeAscendingSorter(copyOfArray, low, middle);
        MergeAscendingSorter(copyOfArray, middle + 1, high);
        MergeAscendingHelper(copyOfArray, low, middle, high);
    }
		
	public T[] MergeDescendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		MergeDescendingSorter(copyOfArray, 0, copyOfArray.length-1);;
		return copyOfArray; 
	}	
	private void MergeDescendingSorter(T[] copyOfArray, int low, int high) {
		if (low >= high) { return; }
        int middle = (low+high)/2;
        MergeDescendingSorter(copyOfArray, low, middle);
        MergeDescendingSorter(copyOfArray, middle + 1, high);
        MergeDescendingHelper(copyOfArray, low, middle, high);
    }
	
	
	//ITERATIVE IMPLEMENTATION OF MERGE SORTING:
	public T[] MergeAscendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		int size = copyOfArray.length;
		int currentSize;  
        int leftStart;	//Index of Left SubArray 
        for (currentSize=1; currentSize<=size-1; currentSize=2*currentSize) { 
        	for (leftStart=0; leftStart<size-1; leftStart+=2*currentSize) { 
                int mid = Math.min(leftStart + currentSize - 1, size-1); 
                int right_end = Math.min(leftStart + 2*currentSize - 1, size-1); 
                MergeAscendingHelper(copyOfArray, leftStart, mid, right_end); 
            } 
        } 
        return copyOfArray; 
	}	
	
	public T[] MergeDescendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		int size = copyOfArray.length;
		int currentSize;  
        int leftStart;	//Index of Left SubArray 
        for (currentSize=1; currentSize<=size-1; currentSize=2*currentSize) { 
        	for (leftStart=0; leftStart<size-1; leftStart+=2*currentSize) { 
                int mid = Math.min(leftStart + currentSize - 1, size-1); 
                int right_end = Math.min(leftStart + 2*currentSize - 1, size-1); 
                MergeDescendingHelper(copyOfArray, leftStart, mid, right_end); 
            } 
        } 
        return copyOfArray; 
	}
	
	private void MergeAscendingHelper(T[] copyOfArray, int low, int middle, int high) {
		@SuppressWarnings("unchecked")
		Class<T> classOfItem = (Class<T>) copyOfArray[0].getClass();
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) Array.newInstance(classOfItem, copyOfArray.length);
        for (int i = low; i <= high; i++) { tempArray[i] = copyOfArray[i]; }
        int i = low;			//index for traversing Left SubArray.
        int j = middle + 1;		//index for traversing Right SubArray.
        int k = low;
        //Copy the smallest values from either the left or the right side back to the original array:
        while ((i <= middle) && (j <= high)) {
            if (tempArray[i].compareTo(tempArray[j]) <= 0) {
            	copyOfArray[k] = tempArray[i];
                i++;
            } else {
            	copyOfArray[k] = tempArray[j];
                j++;
            }
            k++;
        }
        //Copy the rest of the left side of the array into the target array:
        while (i <= middle) {
        	copyOfArray[k] = tempArray[i];
            k++;
            i++;
        }
    }
	
	private void MergeDescendingHelper(T[] copyOfArray, int low, int middle, int high) {
		@SuppressWarnings("unchecked")
		Class<T> classOfItem = (Class<T>) copyOfArray[0].getClass();
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) Array.newInstance(classOfItem, copyOfArray.length);
		for (int i = low; i <= high; i++) { tempArray[i] = copyOfArray[i]; }
        int i = low;
        int j = middle + 1;
        int k = low;
        //Copy the smallest values from either the left or the right side back to the original array:
        while ((i <= middle) && (j <= high)) {
            if (tempArray[i].compareTo(tempArray[j]) >= 0) {
            	copyOfArray[k] = tempArray[i];
                i++;
            } else {
            	copyOfArray[k] = tempArray[j];
                j++;
            }
            k++;
        }
        //Copy the rest of the left side of the array into the target array:
        while (i <= middle) {
        	copyOfArray[k] = tempArray[i];
            k++;
            i++;
        }
    }	
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}
