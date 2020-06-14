package main.java.comparisonBasedSortingAlgorithms;
/**
COCKTAIL SORTING ALGORITHM:
	Also known as: Cocktail Shaker Sort, Bidirectional Bubble Sort, Shaker Sort, Ripple Sort, Shuffle Sort, Shuttle Sort. 
	It is a variation of Bubble Sort that is both a Stable Sorting Algorithm and a Comparison-Based Sort. 
	The algorithm differs from Bubble Sort in that it sorts in both directions on each pass through the list. 
	This sorting algorithm is only marginally more difficult to implement than Bubble Sort, and solves the problem of turtles in Bubble Sorts. 
	It provides only marginal performance improvements, and does not improve asymptotic performance. 
*/

public class CocktailSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("COCKTAIL SORT:");
		CocktailSortingAlgorithm<Integer> cocktailSortingAlgorithm = new CocktailSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Cocktail Sorting:");
		cocktailSortingAlgorithm.printArray(inputArray);

		//ASCENDING COCKTAIL SORT:
		sortedArray = cocktailSortingAlgorithm.CocktailAscendingSort(inputArray);
		System.out.println("\n\nArray After Cocktail Ascending Sort:");
		cocktailSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING COCKTAIL SORT:		
		sortedArray = cocktailSortingAlgorithm.CocktailDescendingSort(inputArray);
		System.out.println("\n\nArray After Cocktail Descending Sort:");
		cocktailSortingAlgorithm.printArray(sortedArray);	
	}

	
	//THE COCKTAIL SORTING IMPLEMENTATION: 	
	public T[] CocktailAscendingSort(T[] inputArray) {
			//Making a Copy of Input Array, so that we Return the Sorted One.
			T[] copyOfArray = (T[]) inputArray.clone();	
			boolean swapped = true; 
	        int start = 0; 
	        int end = copyOfArray.length; 
	        while (swapped == true) { 
	            swapped = false; 
	            //Loop from bottom to top same as we do in Bubble Sort: 
	            for (int i=start; i<end-1; ++i) { 
	                if (copyOfArray[i].compareTo(copyOfArray[i+1]) > 0) { 
	                    swap(copyOfArray, i, i+1);
	                    swapped = true; 
	                } 
	            } 
	            //If nothing is moved, then array is Sorted. 
	            if (swapped == false) { break; } 
	            //Otherwise, reset the swapped flag: 
	            swapped = false; 
	            //Move the end point back by one, because item at the end is in its rightful spot. 
	            end = end - 1; 
	            // from top to bottom, doing the same comparison as in the previous stage 
	            for (int i=end-1; i>=start; i--) { 
	                if (copyOfArray[i].compareTo(copyOfArray[i+1]) > 0) { 
	                	swap(copyOfArray, i, i+1);
	                	swapped = true; 
	                } 
	            } 
	            //Increase the starting point 
	            start = start + 1; 
	        } 
		    return copyOfArray; 
	}
	
	public T[] CocktailDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		boolean swapped = true; 
        int start = 0; 
        int end = copyOfArray.length; 
        while (swapped == true) { 
            swapped = false; 
            //Loop from bottom to top same as we do in Bubble Sort: 
            for (int i=start; i<end-1; ++i) { 
                if (copyOfArray[i].compareTo(copyOfArray[i+1]) < 0) { 
                    swap(copyOfArray, i, i+1);
                    swapped = true; 
                } 
            } 
            //If nothing is moved, then array is Sorted. 
            if (swapped == false) { break; } 
            //Otherwise, reset the swapped flag: 
            swapped = false; 
            //Move the end point back by one, because item at the end is in its rightful spot. 
            end = end - 1; 
            // from top to bottom, doing the same comparison as in the previous stage 
            for (int i=end-1; i>=start; i--) { 
                if (copyOfArray[i].compareTo(copyOfArray[i+1]) < 0) { 
                	swap(copyOfArray, i, i+1);
                	swapped = true; 
                } 
            } 
            //Increase the starting point 
            start = start + 1; 
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
