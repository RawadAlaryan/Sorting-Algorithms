package main.java.comparisonBasedSortingAlgorithms;
/**
ODD-EVEN SORTING ALGORITHM:
	It is also known as "Odd–Even Transposition Sort" or "Brick Sort".
	Odd-Even Sort is a variation of Bubble Sort. It is a Comparison-Based Sorting Algorithm.
	It is developed originally for use on parallel processors with local interconnections. 
	This algorithm is divided into two phases: 
		Odd Phase: We perform a Bubble Sort on odd indexed elements. 
		Even Phase: We perform a Bubble Sort on even indexed elements.  
	The algorithm runs until the array elements are sorted and in each iteration two phases occurs - Odd and Even Phases.
*/

public class OddEvenSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("ODD-EVEN SORT:");
		OddEvenSortingAlgorithm<Integer> oddEvenSortingAlgorithm = new OddEvenSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Odd-Even Sorting:");
		oddEvenSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING ODD-EVEN SORT:
		sortedArray = oddEvenSortingAlgorithm.OddEvenAscendingSort(inputArray);
		System.out.println("\n\nArray After Odd-Even Ascending Sort:");
		oddEvenSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING ODD-EVEN SORT:		
		sortedArray = oddEvenSortingAlgorithm.OddEvenDescendingSort(inputArray);
		System.out.println("\n\nArray After Odd-Even Descending Sort:");
		oddEvenSortingAlgorithm.printArray(sortedArray);
	}

	//THE ODD-EVEN SORTING IMPLEMENTATION: 
	public T[] OddEvenAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = copyOfArray.length;
		boolean isSorted = false; // Initially array is unsorted 
		while (!isSorted) { 
			isSorted = true; 
			//Odd Phase: Performing Bubble Sort on odd-indexed elements: 
			for (int i=1; i<=size-2; i+=2) { 
				if (copyOfArray[i].compareTo(copyOfArray[i+1]) > 0) { 
					swap(copyOfArray, i, i+1);
					isSorted = false; 
				} 
			} 
			//Even Phase: Performing Bubble Sort on even-indexed elements: 
			for (int i=0; i<=size-2; i+=2) { 
				if (copyOfArray[i].compareTo(copyOfArray[i+1]) > 0) { 
					swap(copyOfArray, i, i+1);     
					isSorted = false; 
				} 
			} 
		} 
		return copyOfArray;
	}
	
	public T[] OddEvenDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = copyOfArray.length;
		boolean isSorted = false; // Initially array is unsorted 
		while (!isSorted) { 
			isSorted = true; 
			//Odd Phase: Performing Bubble Sort on odd-indexed elements: 
			for (int i=1; i<=size-2; i+=2) { 
				if (copyOfArray[i].compareTo(copyOfArray[i+1]) < 0) { 
					swap(copyOfArray, i, i+1);
					isSorted = false; 
				} 
			} 
			//Even Phase: Performing Bubble Sort on even-indexed elements: 
			for (int i=0; i<=size-2; i+=2) { 
				if (copyOfArray[i].compareTo(copyOfArray[i+1]) < 0) { 
					swap(copyOfArray, i, i+1);     
					isSorted = false; 
				} 
			} 
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
