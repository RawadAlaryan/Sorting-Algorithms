package comparisonBasedSortingAlgorithms;
/**
STOOGE SORTING ALGORITHM:	
	Stooge Sort is a recursive Sorting Algorithm. 
	It has a bad time complexity of O(N^(log 3 / log 1.5)) = O(N^2.71). 
	It is slower than Bubble Sort. It is however more efficient than Slow Sort (Bogo Sort). 
	The name comes from The Three Stooges.
	Stooge Algorithm is defined as follows:
		If the value at the start is larger than the value at the end, swap them.
		If there are 3 or more elements in the list, then:
			Stooge Sort the initial 2/3 of the list.
			Stooge Sort the final   2/3 of the list.
			Stooge Sort the initial 2/3 of the list again.
*/

public class StoogeSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("STOOGE SORT:");
		StoogeSortingAlgorithm<Integer> stoogeSortinglgorithm = new StoogeSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
				
		System.out.println("\nArray Before Stooge Sorting:");
		stoogeSortinglgorithm.printArray(inputArray);
		
		//ASCENDING STOOGE SORT:
		sortedArray = stoogeSortinglgorithm.StoogeAscendingSort(inputArray);
		System.out.println("\n\nArray After Stooge Ascending Sort:");
		stoogeSortinglgorithm.printArray(sortedArray);
		
		//DESCENDING STOOGE SORT:		
		sortedArray = stoogeSortinglgorithm.StoogeDescendingSort(inputArray);
		System.out.println("\n\nArray After Stooge Descending Sort:");
		stoogeSortinglgorithm.printArray(sortedArray);
	}
	
	
	//THE STOOGE SORTING IMPLEMENTATION: 	
	public T[] StoogeAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = inputArray.clone();	
		StoogeAscendingSorter(copyOfArray, 0, copyOfArray.length-1);
		return copyOfArray;
	}
	private void StoogeAscendingSorter(T[] inputArray, int left, int right) { 
        if (left >= right) { return; } 
        //If first element is smaller than last, then swap them: 
        if (inputArray[left].compareTo(inputArray[right]) > 0) { swap(inputArray, left, right); }
        //If there are more than 2 elements in the array: 
        if (right - left + 1 > 2) { 
            int t = (right - left + 1) / 3; 
            //Recursively sort first 2/3 elements: 
            StoogeAscendingSorter(inputArray, left, right-t); 
            //Recursively sort last 2/3 elements: 
            StoogeAscendingSorter(inputArray, left + t, right); 
            //Recursively sort first 2/3 elements again to confirm: 
            StoogeAscendingSorter(inputArray, left, right-t); 
        } 
    } 
	
	public T[] StoogeDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = inputArray.clone();	
		StoogeDescendingSorter(copyOfArray, 0, copyOfArray.length-1);
		return copyOfArray;
	}
	private void StoogeDescendingSorter(T[] inputArray, int left, int right) { 
        if (left >= right) { return; } 
        //If first element is smaller than last, then swap them: 
        if (inputArray[left].compareTo(inputArray[right]) < 0) { swap(inputArray, left, right); }
        //If there are more than 2 elements in the array: 
        if (right - left + 1 > 2) { 
            int t = (right - left + 1) / 3; 
            //Recursively sort first 2/3 elements: 
            StoogeDescendingSorter(inputArray, left, right-t); 
            //Recursively sort last 2/3 elements: 
            StoogeDescendingSorter(inputArray, left + t, right); 
            //Recursively sort first 2/3 elements again to confirm: 
            StoogeDescendingSorter(inputArray, left, right-t); 
        } 
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
