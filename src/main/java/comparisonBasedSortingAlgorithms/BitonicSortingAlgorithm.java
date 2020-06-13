package main.java.comparisonBasedSortingAlgorithms;
/**
BITONIC SORTING ALGORITHM:
	Bitonic Sort is a classic parallel algorithm for sorting. It is a Comparison-Based Sorting Algorithm.
	Bitonic Sort does O(N.Log^2N) comparisons. The number of comparisons done by Bitonic sort are more than in Merge Sort.
	Bitonic Sort is better for Parallel Implementation because we always compare elements in predefined sequence and the sequence of comparison doesn’t depend on data. 
	Therefore it is suitable for implementation in hardware and parallel processor array.
	To understand Bitonic Sort, we must first understand a Bitonic Sequence and how to make a given sequence Bitonic.
	Bitonic Sequence: A sequence is called Bitonic if it is first increasing, then decreasing. 
*/

public class BitonicSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("BITONIC SORT:");
		BitonicSortingAlgorithm<Integer> bitonicSortingAlgorithm = new BitonicSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Bitonic Sorting:");
		bitonicSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING BITONIC SORT:
		sortedArray = bitonicSortingAlgorithm.BitonicAscendingSort(inputArray);
		System.out.println("\n\nArray After Bitonic Ascending Sort:");
		bitonicSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING BITONIC SORT:		
		sortedArray = bitonicSortingAlgorithm.BitonicDescendingSort(inputArray);
		System.out.println("\n\nArray After Bitonic Descending Sort:");
		bitonicSortingAlgorithm.printArray(sortedArray);
	}

	//THE BITONIC SORTING IMPLEMENTATION: 
	//This Implementation is optimized to sort an odd number of elements:
	public T[] BitonicAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = inputArray.clone();		
		int up = 1;
		if(copyOfArray.length % 2 != 0) {
			BitonicAscendingSorter(copyOfArray, 1, copyOfArray.length, up);
			//Sorting the First item alone:
			for(int i=1; i<copyOfArray.length; i++) {
				if(copyOfArray[i-1].compareTo(copyOfArray[i]) > 0) { swap(copyOfArray, i-1, i); }
			}
		}
		else { BitonicAscendingSorter(copyOfArray, 0, copyOfArray.length, up); } 
		return copyOfArray;
	}
	private void BitonicAscendingSorter(T[] copyOfArray, int low, int count, int direction) {
		if (count > 1) { 
			int k = count/2; 
			//First, sort in Ascending Order: 
			BitonicAscendingSorter(copyOfArray, low, k, 1); 
			//Then, sort in Descending Order: 
			BitonicAscendingSorter(copyOfArray, low+k, k, 0); 
			//Merge whole sequence in Ascending Order: 
			BitonicAscendingMerger(copyOfArray, low, count, direction); 
		}
	}
	private void BitonicAscendingMerger(T[] copyOfArray, int low, int count, int direction) { 
		if (count > 1) { 
			int k = count / 2; 
            for (int i=low; i<low+k; i++) { BitonicAscendingSwapper(copyOfArray, i, i+k, direction); } 
            BitonicAscendingMerger(copyOfArray, low, k, direction); 
            BitonicAscendingMerger(copyOfArray, low+k, k, direction); 
        } 
    } 
	private void BitonicAscendingSwapper(T[] copyOfArray, int i, int j, int direction) {
		if ( (copyOfArray[i].compareTo(copyOfArray[j])>0 && direction==1) || 
			 (copyOfArray[i].compareTo(copyOfArray[j])<0 && direction==0)) { swap(copyOfArray, i, j); }
	}
	
	public T[] BitonicDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = inputArray.clone();		
		int up = 0;
		if(copyOfArray.length % 2 != 0) {
			BitonicDescendingSorter(copyOfArray, 1, copyOfArray.length, up);
			//Sorting the First item alone:
			for(int i=1; i<copyOfArray.length; i++) {
				if(copyOfArray[i-1].compareTo(copyOfArray[i]) < 0) { swap(copyOfArray, i-1, i); }
			}
		}
		else { BitonicDescendingSorter(copyOfArray, 0, copyOfArray.length, up); } 
		return copyOfArray;
	}
	private void BitonicDescendingSorter(T[] copyOfArray, int low, int count, int direction) {
		if (count > 1) { 
			int k = count/2; 
			//First, sort in Ascending Order: 
			BitonicDescendingSorter(copyOfArray, low, k, 1); 
			//Then, sort in Descending Order: 
			BitonicDescendingSorter(copyOfArray, low+k, k, 0); 
			//Merge whole sequence in Ascending Order: 
			BitonicDescendingMerger(copyOfArray, low, count, direction); 
		}
	}
	private void BitonicDescendingMerger(T[] copyOfArray, int low, int count, int direction) { 
		if (count > 1) { 
			int k = count / 2; 
            for (int i=low; i<low+k; i++) { BitonicDescendingSwapper(copyOfArray, i, i+k, direction); } 
            BitonicDescendingMerger(copyOfArray, low, k, direction); 
            BitonicDescendingMerger(copyOfArray, low+k, k, direction); 
        } 
    } 
	private void BitonicDescendingSwapper(T[] copyOfArray, int i, int j, int direction) {
		if ( (copyOfArray[i].compareTo(copyOfArray[j])<0 && direction==0) || 
			 (copyOfArray[i].compareTo(copyOfArray[j])>0 && direction==1)) { swap(copyOfArray, i, j); }
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
