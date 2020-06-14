package comparisonBasedSortingAlgorithms;
/**
GNOME SORTING ALGORITHM:	   
	Gnome Sort, also known as "Stupid Sort", is a Comparison-Based Sorting Algorithm originally proposed by an Iranian computer scientist Hamid Sarbazi-Azad in 2000. 
	Gnome Sort is similar to Insertion Sort in that it works with one item at a time but gets the item to the proper place by a series of swaps, similar to a Bubble Sort. 
	Gnome Sort is simple, requiring no nested loops. The average running time is O(N^2) but tends towards O(N) if the list is initially almost sorted.
	The algorithm finds the first place where two adjacent elements are in the wrong order and swaps them. 
	It takes advantage of the fact that performing a swap can introduce a new out-of-order adjacent pair next to the previously swapped elements. 
	It does not assume that elements forward of the current position are sorted, so it only needs to check the position directly previous to the swapped elements.
*/  

public class GnomeSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("GNOME SORT:");
		GnomeSortingAlgorithm<Integer> gnomeSortingAlgorithm = new GnomeSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Gnome Sorting:");
		gnomeSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING GNOME SORT:
		sortedArray = gnomeSortingAlgorithm.GnomeAscendingSort(inputArray);
		System.out.println("\n\nArray After Gnome Ascending Sort:");
		gnomeSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING GNOME SORT:		
		sortedArray = gnomeSortingAlgorithm.GnomeDescendingSort(inputArray);
		System.out.println("\n\nArray After Gnome Descending Sort:");
		gnomeSortingAlgorithm.printArray(sortedArray);
	}

	//THE GNOME SORTING IMPLEMENTATION: 	
  	public T[] GnomeAscendingSort(T[] inputArray) {
  		//Making a Copy of Input Array, so that we Return the Sorted One.
  		T[] copyOfArray = (T[]) inputArray.clone();
  		int size = copyOfArray.length;     
  		int index = 0; 
  		while (index < size) { 
            if (index == 0) { index++; } 
            if (copyOfArray[index].compareTo(copyOfArray[index-1]) >= 0) { index++; } 
            else { 
            	swap(copyOfArray, index, index-1); 
            	index--; 
            } 
        } 
  		return copyOfArray;
  	}
	
  	public T[] GnomeDescendingSort(T[] inputArray) {
  		//Making a Copy of Input Array, so that we Return the Sorted One.
  		T[] copyOfArray = (T[]) inputArray.clone();
  		int size = copyOfArray.length;     
  		int index = 0; 
  		while (index < size) { 
            if (index == 0) { index++; } 
            if (copyOfArray[index].compareTo(copyOfArray[index-1]) <= 0) { index++; } 
            else { 
            	swap(copyOfArray, index, index-1); 
            	index--; 
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
