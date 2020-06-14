package comparisonBasedSortingAlgorithms;
/**
INSERTION SORTING ALGORITHM:		
	It is a simple sorting algorithm that builds the final sorted array one item at a time.
	It has quadratic running time complexity O(N^2)
	It is very inefficient On large data-sets, but on arrays with 10-20 items it is quite good.
	It is more efficient than other quadratic running time sorting algorithms such as Bubble Sort or Selection Sort.
	It is an Adaptive Algorithm, it speeds up when array is already substantially sorted.
	It is a Stable Sort Algorithm, It preserves the order of the items with equal keys.
	It is an In-place Algorithm, it does not need any additional memory.
	It is an Online Algorithm, it can sort an array as it receives it. For Example: Sorting Data being downloaded from web.
	Hybrid Algorithms use Insertion Sort if the SubArray is small enough. Insertion sort is faster for small SubArrays than Quick Sort.
	A Variant of Insertion Sort is "Shell Sort".
	Sometimes Selection Sort (Less write-operations are needed) is better than Insertion Sort (More write-operations are needed). However, they are very similar algorithms.
	Insertion sort requires more write-operations, because the inner loop can require shifting large sections of the sorted portion of the array.
	In general, Insertion Sort will write to the array O(N^2) times while Selection Sort will write only O(N) times.
	For this reason Selection Sort may be preferable in cases where writing to memory is significantly more expensive than reading, as the case with for example Flash-Memory.
	Insertion Sort can be implemented using: Iterations or Recursion.
*/	

public class InsertionSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("INSERTION SORT:");
		InsertionSortingAlgorithm<Integer> insertionSortingAlgorithm = new InsertionSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;

		
		System.out.println("INSERTION SORT - ITERATIVE IMPLEMENTATION:");
		//INSERTION ITERATIVE SORT:
		System.out.println("Array Before Insertion Iterative Sorting:\t\t");
		insertionSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING INSERTION ITERATIVE SORT:
		sortedArray = insertionSortingAlgorithm.InsertionAscendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Insertion Iterative Ascending Sort:");
		insertionSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING INSERTION ITERATIVE SORT:		
		sortedArray = insertionSortingAlgorithm.InsertionDescendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Insertion Iterative Descending Sort:");
		insertionSortingAlgorithm.printArray(sortedArray);		
		
		
		System.out.println("\n\n\n\nINSERTION SORT - RECURSIVE IMPLEMENTATION:");
		//INSERTION RECURSIVE SORT:		
		System.out.println("Array Before Insertion Recursive Sorting:");
		insertionSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING INSERTION RECURSIVE SORT:
		sortedArray = insertionSortingAlgorithm.InsertionAscendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Insertion Recursive Ascending Sort:");
		insertionSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING INSERTION RECURSIVE SORT:		
		sortedArray = insertionSortingAlgorithm.InsertionDescendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Insertion Recursive Descending Sort:");
		insertionSortingAlgorithm.printArray(sortedArray);	
	}

	
	//THE INSERTION SORTING IMPLEMENTATION: 
	//ITERATIVE IMPLEMENTATION OF INSERTION SORT: 
	public T[] InsertionAscendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		for(int i=0; i<copyOfArray.length; i++) {
			int j = i;
			while ((j>0) && (copyOfArray[j-1].compareTo(copyOfArray[j]) > 0)) {
                swap(copyOfArray, j, j-1);
                j--;
            }
        }
		return copyOfArray; 
	}
		
	public T[] InsertionDescendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		for(int i=0; i<copyOfArray.length; i++) {
			int j = i;
			while ((j>0) && (copyOfArray[j-1].compareTo(copyOfArray[j]) < 0)) {
				swap(copyOfArray, j, j-1);
                j--;
            }
        }
		return copyOfArray; 
	}	
	
	//RECURSIVE IMPLEMENTATION OF INSERTION SORT: 
	public T[] InsertionAscendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		int size = copyOfArray.length;
		InsertionAscendingRecursiveHelper(copyOfArray, size);
		return copyOfArray; 
	}
	private void InsertionAscendingRecursiveHelper(T[] inputArray, int size) {
		//Base Case: 
		if (size <= 1) { return; } 
		//Sort first n-1 elements: 
		InsertionAscendingRecursiveHelper(inputArray, size-1); 
		//Insert last element at its correct position in sorted array. 
		T lastItem = inputArray[size-1]; 
		int j = size-2; 
		//Move elements > key, to one position:
		while (j >= 0 && inputArray[j].compareTo(lastItem) > 0) { 
			inputArray[j+1] = inputArray[j]; 
			j--; 
		} 
		inputArray[j+1] = lastItem; 
	}
	
	public T[] InsertionDescendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		int size = copyOfArray.length;
		InsertionDescendingRecursiveHelper(copyOfArray, size);
		return copyOfArray; 
	}
	private void InsertionDescendingRecursiveHelper(T[] inputArray, int size) {
		//Base Case: 
		if (size <= 1) { return; } 
		//Sort first n-1 elements: 
		InsertionDescendingRecursiveHelper(inputArray, size-1); 
		//Insert last element at its correct position in sorted array. 
		T lastItem = inputArray[size-1]; 
		int j = size-2; 
		//Move elements > key, to one position:
		while (j >= 0 && inputArray[j].compareTo(lastItem) < 0) { 
			inputArray[j+1] = inputArray[j]; 
			j--; 
		} 
		inputArray[j+1] = lastItem; 
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
