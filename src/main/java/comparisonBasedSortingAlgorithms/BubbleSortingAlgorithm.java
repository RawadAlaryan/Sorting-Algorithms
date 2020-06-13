package main.java.comparisonBasedSortingAlgorithms;
/**
BUBBLE SORTING ALGORITHM:	
	Bubble Sort is a comparison-based algorithm. It repeats the same steps on all items to be sorted. 
	It compares each pair of adjacent items and swaps them if they are in the wrong order.
	On every iteration we bubble up the largest item. We keep considering fewer and fewer items by each iteration-round. 
	Because on every iteration we consider one more item to be sorted.
	Bubble Sort has worst-case and average complexity both O(N^2) Quadratic Time Complexity.
	Bubble Sort is not a practical sorting algorithm. It is too slow and impractical for most problems even when compared to Insertion Sort.
	It will not be efficient in the case of a reverse-ordered collection.
	It is a Stable Sorting Algorithm.
	It is an In-place Algorithm. It does not need any additional memory. 
	Bubble Sort Applications:
		In Computer Graphics: 
			Bubble Sort is used to detect a small error - like a swap of just two elements in almost-sorted arrays - and fix it in Linear Complexity O(N).
		It a Polygon-Filling Algorithm: 
			Where bounding lines are sorted by their x coordinates at a specific scan line (a line parallel to x axis). 
			And with incrementing y, their order change (two elements are swapped) only at intersections of two lines.
	Bubble Sort can be implemented using: Iterations or Recursion.		
*/

public class BubbleSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("BUBBLE SORT:");
		BubbleSortingAlgorithm<Integer> bubbleSortingAlgorithm = new BubbleSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		//BUBBLE ITERATIVE SORT:
		System.out.println("BUBBLE SORT ITERATIVE IMPLEMENTAION:");
		System.out.println("Array Before Bubble Iterative Sorting:");
		bubbleSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING BUBBLE ITERATIVE SORT:
		sortedArray = bubbleSortingAlgorithm.BubbleAscendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Bubble Iterative Ascending Sort:");
		bubbleSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING BUBBLE ITERATIVE SORT:		
		sortedArray = bubbleSortingAlgorithm.BubbleDescendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Bubble Iterative Descending Sort:");
		bubbleSortingAlgorithm.printArray(sortedArray);
		
		//BUBBLE RECURSIVE SORT:
		System.out.println("\n\n\n\nBUBBLE SORT RECURSIVE IMPLEMENTAION:");
		System.out.println("Array Before Bubble Recursive Sorting:");
		bubbleSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING BUBBLE RECURSIVE SORT:
		sortedArray = bubbleSortingAlgorithm.BubbleAscendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Bubble Recursive Ascending Sort:");
		bubbleSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING BUBBLE RECURSIVE SORT:		
		sortedArray = bubbleSortingAlgorithm.BubbleDescendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Bubble Recursive Descending Sort:");
		bubbleSortingAlgorithm.printArray(sortedArray);
	}

	
	//THE BUBBLE SORTING IMPLEMENTATION: 
	//ITERATIVE IMPLEMENTATION OF BUBBLE SORT: 
	public T[] BubbleAscendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		for (int i=0; i<copyOfArray.length-1; i++) {
			for (int j=0; j<copyOfArray.length-1-i; j++) {
				if (copyOfArray[j].compareTo(copyOfArray[j+1]) > 0) { 
					swap(copyOfArray, j, j+1); 
				}
			}
		}
		return copyOfArray; 
	}
	
	public T[] BubbleDescendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		for (int i=0; i<copyOfArray.length-1; i++) {
			for (int j=0; j<copyOfArray.length-1-i; j++) {
				if (copyOfArray[j].compareTo(copyOfArray[j+1]) < 0) { 
					swap(copyOfArray, j, j+1); 
				}
			}
		}
		return copyOfArray; 
	}

	//RECURSIVE IMPLEMENTATION OF BUBBLE SORT:
	public T[] BubbleAscendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = copyOfArray.length;
		BubbleAscendingRecursiveHelper(copyOfArray, size);
		return copyOfArray;
	}
	private void BubbleAscendingRecursiveHelper(T[] inputArray, int size) {
		//Base Case: 
        if (size == 1) { return; } 
        for (int i=0; i<size-1; i++) 
            if (inputArray[i].compareTo(inputArray[i+1]) > 0) { swap(inputArray, i, i+1); } 
        //Recur for Remaining SubArray: 
        BubbleAscendingRecursiveHelper(inputArray, size-1);
	}
	
	public T[] BubbleDescendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = copyOfArray.length;
		BubbleDescendingRecursiveHelper(copyOfArray, size);
		return copyOfArray;
	}
	private void BubbleDescendingRecursiveHelper(T[] inputArray, int size) {
		//Base Case: 
        if (size == 1) { return; } 
        for (int i=0; i<size-1; i++) 
            if (inputArray[i].compareTo(inputArray[i+1]) < 0) { swap(inputArray, i, i+1); } 
        //Recur for Remaining SubArray: 
        BubbleDescendingRecursiveHelper(inputArray, size-1);
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
