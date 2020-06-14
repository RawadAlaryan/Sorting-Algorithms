package main.java.comparisonBasedSortingAlgorithms;
/**
QUICK SORTING ALGORITHM:		
	Quick Sort is an efficient Sorting Algorithm. It was developed by Tony Hoare in 1959.
	A well implemented Quick Sort can outperform Heap Sort and Merge Sort.
	It is a comparison-based algorithm O(N.logN). It can not reach Linear Time Complexity.
	The efficient implementation of Quick Sort is NOT Stable. It does not keep the relative order of items with equal value.
	It is an In-Place algorithm. It does not need any additional memory.
	On average case it has O(N.logN) running time. But the worst case running time is Quadratic O(N^2).
	It is widely used in programming languages; it is used in Java for sorting primitive types.
	It is based on a divide and conquer algorithm. 
		1. Pick an element from the array: this is called "Pivot Item"
		2. Partition Phase: Rearrange the array so that: 
				All elements with values less than the pivot come before the pivot. 
				All elements with values greater than the pivot come after it.  
				Equal values can go either way.
		3. Recursion Phase: Recursively apply these steps on the SubArrays.
							Base Case for Recursion: Arrays of size zero or one never need to be sorted.
			
	Choosing the Pivot Item:
		It is very important to know how to choose a good Pivot Item.
		If we keep choosing bad Pivots, the running time performance will decrease to be Quadratic O(N^2). 
			1. We can choose a Pivot at Random. Usually it is working fine.
			2. Choose the middle index of the array as the Pivot.
	
	Worst Case: O(N^2)
		The most naive pivot selection algorithm is to just choose the first element as your pivot.
		The first element will always be the minimum in the sub arrays during the ascending sorting. 
		Resulting in moving/shifting all array items during the recursive-calls. 
		This results in worst case behavior if your data is already sorted.
	Quick Sort can be implemented using: Iterations or Recursion.	
*/

public class QuickSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("QUICK SORT:");
		QuickSortingAlgorithm<Integer> quickSortingAlgorithm = new QuickSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("QUICK SORT - RECURSIVE IMPLEMENTATION:");
		//INSERTION RECURSIVE SORT:
		System.out.println("Array Before Quick Recursive Sorting:");
		quickSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING QUICK RECURSIVE SORT:
		sortedArray = quickSortingAlgorithm.QuickAscendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Quick Recursive Ascending Sort:");
		quickSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING QUICK RECURSIVE SORT:		
		sortedArray = quickSortingAlgorithm.QuickDescendingRecursiveSort(inputArray);
		System.out.println("\n\nArray After Quick Recursive Descending Sort:");
		quickSortingAlgorithm.printArray(sortedArray);				
		
		
		
		System.out.println("\n\n\n\nQUICK SORT - ITERATIVE IMPLEMENTATION:");
		//INSERTION ITERATIVE SORT:
		System.out.println("Array Before Quick Iterative Sorting:");
		quickSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING QUICK ITERATIVE SORT:
		sortedArray = quickSortingAlgorithm.QuickAscendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Quick Iterative Ascending Sort:");
		quickSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING QUICK ITERATIVE SORT:		
		sortedArray = quickSortingAlgorithm.QuickDescendingIterativeSort(inputArray);
		System.out.println("\n\nArray After Quick Iterative Descending Sort:");
		quickSortingAlgorithm.printArray(sortedArray);
	}

	//THE QUICK SORTING IMPLEMENTATION: 	
	//RECURSIVE IMPLEMENTATION OF QUICK SORTING:
	public T[] QuickAscendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		QuickAscendingSorter(copyOfArray, 0, copyOfArray.length-1);
		return copyOfArray; 
	}	
	private void QuickAscendingSorter(T[] copyOfArray, int low, int high) {
        if (low >= high) { return; }
        int pivotIndex = partitionForQuickAscendingSort(copyOfArray, low, high);
        //Recursive Call on Left SubArray:
        QuickAscendingSorter(copyOfArray, low, pivotIndex - 1);
        //Recursive Call on Right SubArray:
        QuickAscendingSorter(copyOfArray, pivotIndex + 1, high);
    }
		
	public T[] QuickDescendingRecursiveSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		QuickDescendingSorter(copyOfArray, 0, copyOfArray.length-1);
		return copyOfArray; 
	}	
	private void QuickDescendingSorter(T[] copyOfArray, int low, int high) {
        if (low >= high) { return; }
        int pivotIndex = partitionForQuickDescendingSort(copyOfArray, low, high);
        //Recursive Call on Left SubArray:
        QuickDescendingSorter(copyOfArray, low, pivotIndex - 1);
        //Recursive Call on Right SubArray:
        QuickDescendingSorter(copyOfArray, pivotIndex + 1, high);
    }
		
	//ITERATIVE IMPLEMENTATION OF QUICK SORTING:
	public T[] QuickAscendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int low = 0;									//Lower Index
		int high = copyOfArray.length - 1;	//Higher Index
        //Create Auxiliary Stack: 
        int stack[] = new int[high-low+1]; 
        //Initialize top of Stack: 
        int top = -1; 
        //Push Initial Values in Stack: 
        stack[++top] = low; 
        stack[++top] = high; 
        //Pop elements until Stack is empty: 
        while (top >= 0) { 
        	high = stack[top--]; 
            low = stack[top--]; 
            //Set Pivot: 
            int pivot = partitionForQuickAscendingSort(copyOfArray, low, high); 
            //If elements on left side of Pivot, then push left side to Stack: 
            if (pivot-1 > low) { stack[++top] = low;	stack[++top] = pivot-1; } 
            //If elements on right side of Pivot, then push right side to Stack: 
            if (pivot+1 < high) { stack[++top] = pivot+1;	stack[++top] = high; } 
        }
        return copyOfArray; 
	}
	
	public T[] QuickDescendingIterativeSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int low = 0;									//Lower Index
		int high = copyOfArray.length - 1;	//Higher Index
        //Create Auxiliary Stack: 
        int stack[] = new int[high-low+1]; 
        //Initialize top of Stack: 
        int top = -1; 
        //Push Initial Values in Stack: 
        stack[++top] = low; 
        stack[++top] = high; 
        //Pop elements until Stack is empty: 
        while (top >= 0) { 
        	high = stack[top--]; 
            low = stack[top--]; 
            //Set Pivot: 
            int pivot = partitionForQuickDescendingSort(copyOfArray, low, high); 
            //If elements on left side of Pivot, then push left side to Stack: 
            if (pivot-1 > low) { stack[++top] = low;	stack[++top] = pivot-1; } 
            //If elements on right side of Pivot, then push right side to Stack: 
            if (pivot+1 < high) { stack[++top] = pivot+1;	stack[++top] = high; } 
        }
        return copyOfArray; 
	}
	
	private int partitionForQuickAscendingSort(T[] copyOfArray, int low, int high) {
        //Choosing a Pivot Index: We can choose middle of Array. Or we can choose the Pivot Randomly!
		int pivotIndex = (low + high) / 2; 
		//We Partition the Array according to Pivot.
        swap(copyOfArray, pivotIndex, high);	//Set the Pivot to the End of Array.
        int i = low;
        for (int j=low; j<high; j++) {
            if (copyOfArray[j].compareTo(copyOfArray[high]) <= 0) {
                swap(copyOfArray, i, j);
                i++;
            }
        }
        swap(copyOfArray, i, high); //Swap back the pivot.
        return i;
    }
	
	private int partitionForQuickDescendingSort(T[] copyOfArray, int low, int high) {
		//Choosing a Pivot Index: We can choose middle of Array. Or we can choose the Pivot Randomly!
        int pivotIndex = (low + high) / 2; 
        //We Partition the Array according to Pivot.
        swap(copyOfArray, pivotIndex, high);	//Set the Pivot to the End of Array.
        int i = low;
        for (int j=low; j<high; j++) {
            if (copyOfArray[j].compareTo(copyOfArray[high]) >= 0) {
                swap(copyOfArray, i, j);
                i++;
            }
        }
        swap(copyOfArray, i, high); //Swap back the pivot.
        //We return the index of Pivot.
        return i;
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
