package main.java.comparisonBasedSortingAlgorithms;
/**
PANCAKE SORTING ALGORITHM:	
	Pancake Sorting is the casual term for the mathematical problem of sorting a disordered stack of pancakes in order of size. 
	Using a Spatula inserted at any point in the stack and used to flip all pancakes above it. 
	A pancake number is the minimum number of flips required for a given number of pancakes. 
	The only allowed operation is "FLIP" to reverse the elements of some prefix of the sequence. 
	The goal is to sort the sequence in as few reversals as possible. 
	A Pancake Sort Variant of the problem is concerned with burnt pancakes, where each pancake has a burnt side and all pancakes must, in addition, end up with the burnt side on bottom.	
*/	

public class PancakeSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("PANCAKE SORT:");
		PancakeSortingAlgorithm<Integer> pancakeSortingAlgorithm = new PancakeSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Pancake Sorting:");
		pancakeSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING PANCAKE SORT:
		sortedArray = pancakeSortingAlgorithm.PancakeAscendingSort(inputArray);
		System.out.println("\n\nArray After Pancake Ascending Sort:");
		pancakeSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING PANCAKE SORT:		
		sortedArray = pancakeSortingAlgorithm.PancakeDescendingSort(inputArray);
		System.out.println("\n\nArray After Pancake Descending Sort:");
		pancakeSortingAlgorithm.printArray(sortedArray);
	}

	//THE PANCAKE SORTING IMPLEMENTATION: 	
	public T[] PancakeAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = copyOfArray.length; 
		//Start from complete array and one by one reduce current size by one: 
        for (int currentSize=size; currentSize>1; currentSize--) { 
            //Find index of the maximum element in Array: 
            int maxIndex = findMaxIndex(copyOfArray, currentSize); 
            //Move the maximum element to end of current array if it's not already at the end: 
            if (maxIndex != currentSize-1) { 
            	//To move at the end, first move maximum number to beginning: 
                flip(copyOfArray, maxIndex); 
                //Now move the maximum number to end by reversing current array: 
                flip(copyOfArray, currentSize-1); 
            } 
        } 
        return copyOfArray;
	}
    private int findMaxIndex(T[] copyOfArray, int currentSize) { 
        int maxIndex = 0;
        for (int i=0; i<currentSize; i++) { 
            if (copyOfArray[i].compareTo(copyOfArray[maxIndex]) > 0) { maxIndex = i; }
        }
        return maxIndex; 
    }
    	
    public T[] PancakeDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = copyOfArray.length; 
		//Start from complete array and one by one reduce current size by one: 
        for (int currentSize=size; currentSize>1; currentSize--) { 
            //Find index of the maximum element in Array: 
            int minIndex = findMinIndex(copyOfArray, currentSize); 
            //Move the maximum element to end of current array if it's not already at the end: 
            if (minIndex != currentSize-1) { 
            	//To move at the end, first move maximum number to beginning: 
                flip(copyOfArray, minIndex); 
                //Now move the maximum number to end by reversing current array: 
                flip(copyOfArray, currentSize-1); 
            } 
        } 
        return copyOfArray;
	}
    private int findMinIndex(T[] copyOfArray, int currentSize) { 
        int maxIndex = 0;
        for (int i=0; i<currentSize; i++) { 
            if (copyOfArray[i].compareTo(copyOfArray[maxIndex]) < 0) { maxIndex = i; }
        }
        return maxIndex; 
    }
	
    private void flip(T[] copyOfArray, int i) { 
        int start = 0; 
        while (start < i) { 
        	swap(copyOfArray, start, i); 
        	start++; 
            i--; 
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
