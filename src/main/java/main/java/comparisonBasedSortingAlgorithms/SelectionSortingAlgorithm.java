package main.java.comparisonBasedSortingAlgorithms;
/**
SELECTION SORTING ALGORITHM:	
	Selection Sort is an O(N^2) running Time Complexity Sorting Algorithm.
	Selection Sort is noted for its simplicity and it has performance advantages over more complicated algorithms.
	The algorithm divides the input list into two parts: 
		1. The SubArray of already sorted items.
		2. The SubArray of items remaining to be sorted that occupy the rest of the array.
	The algorithm finds the smallest element in the unsorted SubArray using a Linear Search.
	It exchanges/swaps it with the leftmost unsorted element, leaving the smallest element in that iteration round in its sorted position.
	Then it changes the SubArrays boundaries one element to the right and repeat steps.
	It is an In-Place Algorithm, there is no need for extra memory.
	It is particularly useful where auxiliary memory is limited, because it is an In-place algorithm.
	Selection Sort almost always outperforms Bubble Sort.
	Selection Sort is not a stable sort; it does not preserve the order of keys with equal values.
	Selection Sort and Insertion Sort are both typically faster for small arrays; arrays with 10-20 items.
	Usual Sorting Optimization method use recursive algorithms that switch to Insertion Sort or Selection Sort for small SubArrays.
	Selection Sort: Makes less writes than insertion sort. This can be important if write-operations are significantly more expensive than read-operations. 
				    For example with EEPROM or Flash Memory where every write lessens the life-span of the memory.
*/	

public class SelectionSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("SELECTION SORT:");
		SelectionSortingAlgorithm<Integer> selectionSortingAlgorithm = new SelectionSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Selection Sorting:");
		selectionSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING SELECTION SORT:
		sortedArray = selectionSortingAlgorithm.SelectionAscendingSort(inputArray);
		System.out.println("\n\nArray After Selection Ascending Sort:");
		selectionSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING SELECTION SORT:		
		sortedArray = selectionSortingAlgorithm.SelectionDescendingSort(inputArray);
		System.out.println("\n\nArray After Selection Descending Sort:");
		selectionSortingAlgorithm.printArray(sortedArray);
	}

	
	//THE SELECTION SORTING IMPLEMENTATION: 	
	public T[] SelectionAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		for (int i=0; i<copyOfArray.length-1; i++) {
			int index = i;
			for (int j=i+1; j<copyOfArray.length; j++) {
				if (copyOfArray[j].compareTo(copyOfArray[index]) < 0) { index = j; }
			}
			//No Need to Swap the number with itself.
			if (index != i) { swap(copyOfArray, i, index); }	
		}
		return copyOfArray; 
	}
	
	//THE SELECTION SORTING IMPLEMENTATION: 	
	public T[] SelectionDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		for (int i=0; i<copyOfArray.length-1; i++) {
			int index = i;
			for (int j=i+1; j<copyOfArray.length; j++) {
				if (copyOfArray[j].compareTo(copyOfArray[index]) > 0) { index = j; }
			}
			//No Need to Swap the number with itself.
			if (index != i) { swap(copyOfArray, i, index); }
		}
		return copyOfArray; 
	}
	
	//METHOD FOR SWAPPING TWO ITEMS IN ARRAY:
	private void swap(T[] copyOfArray, int index1, int index2) {
		T tempItem = copyOfArray[index1];
		copyOfArray[index1] = copyOfArray[index2];
		copyOfArray[index2] = tempItem;
	}	
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}
