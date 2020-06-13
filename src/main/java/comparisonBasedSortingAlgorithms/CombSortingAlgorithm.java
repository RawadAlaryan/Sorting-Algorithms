package main.java.comparisonBasedSortingAlgorithms;
/**
COMB SORTING ALGORITHM:	
	Comb Sort is an improvement over Bubble Sort. 
	Bubble sort always compares adjacent values. 
	Comb Sort improves on Bubble Sort by using gap of size more than 1. 
	The gap starts with a large value and shrinks by a factor of 1.3 in every iteration until it reaches the value 1. 
	Comb Sort reduces number of swaps and performs better than Bubble Sort.
	The shrink factor has been empirically found to be 1.3
*/

public class CombSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("COMB SORT:");
		CombSortingAlgorithm<Integer> combSortingAlgorithm = new CombSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Comb Sorting:");
		combSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING COMB SORT:
		sortedArray = combSortingAlgorithm.CombAscendingSort(inputArray);
		System.out.println("\n\nArray After Comb Ascending Sort:");
		combSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING Comb SORT:		
		sortedArray = combSortingAlgorithm.CombDescendingSort(inputArray);
		System.out.println("\n\nArray After Comb Descending Sort:");
		combSortingAlgorithm.printArray(sortedArray);
	}

	
	//THE COMB SORTING IMPLEMENTATION: 	
	public T[] CombAscendingSort(T[] inputArray) {
			//Making a Copy of Input Array, so that we Return the Sorted One.
			T[] copyOfArray = (T[]) inputArray.clone();
			int inputSize = copyOfArray.length;
			int gap = inputSize;	//Initialize Gap 
	        boolean swapped = true; 
	        //Keep running while Gap > 1 and last iteration caused a swap: 
	        while (gap != 1 || swapped == true) { 
	        	gap = getNextGapCombSort(gap); 
	        	swapped = false; 
	        	// Compare all elements with current gap 
	            for (int i=0; i<inputSize - gap; i++) { 
	                if (copyOfArray[i].compareTo(copyOfArray[i+gap]) > 0) { 
	                	swap(copyOfArray, i, i+gap);
	                	swapped = true; 
	                } 
	            } 
	        } 
	        return copyOfArray; 
	}
	
	public T[] CombDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int inputSize = copyOfArray.length;
		int gap = inputSize;	//Initialize Gap 
        boolean swapped = true; 
        //Keep running while Gap > 1 and last iteration caused a swap: 
        while (gap != 1 || swapped == true) { 
        	gap = getNextGapCombSort(gap); 
        	swapped = false; 
        	// Compare all elements with current gap 
            for (int i=0; i<inputSize - gap; i++) { 
                if (copyOfArray[i].compareTo(copyOfArray[i+gap]) < 0) { 
                	swap(copyOfArray, i, i+gap);
                	swapped = true; 
                } 
            } 
        } 
        return copyOfArray; 
	}
	
	private int getNextGapCombSort(int gap) { 
        //Shrink gap by Shrink factor 
        gap = (gap * 10) / 13; 
        if (gap < 1) { return 1; } 
        return gap; 
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
