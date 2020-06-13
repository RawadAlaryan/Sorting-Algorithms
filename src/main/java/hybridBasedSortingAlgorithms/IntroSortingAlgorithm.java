package main.java.hybridBasedSortingAlgorithms;

/**	
INTRO SORTING ALGORITHM:
	INTRO SORT = QUICK SORT + HEAP SORT
	It is also known as "Introspective Sort". It was invented by David Musser in 1997.
	It is a Hybrid Sorting Algorithm from Quick Sort and Heap Sort. 		
	It provides both fast average performance and optimal worst-case performance
	It begins with Quick Sort and switches to Heap Sort when Quick Sort becomes too slow.
*/	

public class IntroSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("INTRO SORT:");
		IntroSortingAlgorithm<Integer> introSortingAlgorithm = new IntroSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Intro Sorting:");
		introSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING INTRO SORT:
		sortedArray = introSortingAlgorithm.IntroAscendingSort(inputArray);
		System.out.println("\n\nArray After Intro Ascending Sort:");
		introSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING INTRO SORT:		
		sortedArray = introSortingAlgorithm.IntroDescendingSort(inputArray);
		System.out.println("\n\nArray After Intro Descending Sort:");
		introSortingAlgorithm.printArray(sortedArray);
	}

	
	//THE INTRO SORTING IMPLEMENTATION: 	
	public T[] IntroAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		int depth = ((int) Math.log(copyOfArray.length))*2;
		IntroAscendingSortDeceider(copyOfArray, depth, 0, copyOfArray.length-1);
		return copyOfArray;
	}
	//Sorting loop, decides whether to use Quick Sort or Heap Sort:
	private void IntroAscendingSortDeceider(T[] copyOfArray, int depth, int start, int end){
		int length = copyOfArray.length;
		if(length <= 1){ return; }
		else 
			//Heap Sort:
			if(depth == 0){ IntroAscendingHeapSorter(copyOfArray, start, end); }
			//Quick Sort:
			else{
				if(start >= end) { return; }
				T pivot = copyOfArray[(start + end)/2];
				int index =  IntroAscendingSortPartitioner(copyOfArray, start, end, pivot);
				IntroAscendingSortDeceider(copyOfArray, depth-1, start, index-1);
				IntroAscendingSortDeceider(copyOfArray, depth-1, index, end);
			}
	}
	private void IntroAscendingHeapSorter(T[] copyOfArray, int start, int end){
		for (int i = end / 2 - 1; i >= start; i--)
			IntroAscendingSortHeapify(copyOfArray, end, i);
		for (int i=end-1; i>=start; i--){
			T tempItem = copyOfArray[start];
			copyOfArray[start] = copyOfArray[i];
			copyOfArray[i] = tempItem;
			IntroAscendingSortHeapify(copyOfArray, i, start);
        }
    }
	private void IntroAscendingSortHeapify(T[] copyOfArray, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if (left < n && copyOfArray[left].compareTo(copyOfArray[largest]) > 0)
        	largest = left;
        if (right < n && copyOfArray[right].compareTo(copyOfArray[largest]) > 0)
        	largest = right;
        if (largest != i){
            T swapItem = copyOfArray[i];
            copyOfArray[i] = copyOfArray[largest];
            copyOfArray[largest] = swapItem;
            IntroAscendingSortHeapify(copyOfArray, n, largest);
        }
    }
	private int IntroAscendingSortPartitioner(T[] copyOfArray, int start, int end, T pivot){
		while(start <= end){
			while(copyOfArray[start].compareTo(pivot) < 0){ start++; }
			while(copyOfArray[end].compareTo(pivot) > 0){ end--; }
			if(start <= end){
				T tempItem = copyOfArray[start];
				copyOfArray[start] = copyOfArray[end];
				copyOfArray[end] = tempItem;
				start++;
				end--;
			}
		}
		return start;
	}
	
	
	public T[] IntroDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		int depth = ((int) Math.log(copyOfArray.length))*2;
		IntroDescendingSortDeceider(copyOfArray, depth, 0, copyOfArray.length-1);
		return copyOfArray;
	}
	//Sorting loop, decides whether to use Quick Sort or Heap Sort:
	private void IntroDescendingSortDeceider(T[] copyOfArray, int depth, int start, int end){
		int length = copyOfArray.length;
		if(length <= 1){ return; }
		else 
			//Heap Sort:
			if(depth == 0){ IntroDescendingHeapSorter(copyOfArray, start, end); }
			//Quick Sort:
			else{
				if(start >= end) { return; }
				T pivot = copyOfArray[(start + end)/2];
				int index =  IntroDescendingSortPartitioner(copyOfArray, start, end, pivot);
				IntroDescendingSortDeceider(copyOfArray, depth-1, start, index-1);
				IntroDescendingSortDeceider(copyOfArray, depth-1, index, end);
			}
	}
	private void IntroDescendingHeapSorter(T[] copyOfArray, int start, int end){
		for (int i = end / 2 - 1; i >= start; i--)
			IntroDescendingSortHeapify(copyOfArray, end, i);
		for (int i=end-1; i>=start; i--){
			T tempItem = copyOfArray[start];
			copyOfArray[start] = copyOfArray[i];
			copyOfArray[i] = tempItem;
			IntroDescendingSortHeapify(copyOfArray, i, start);
        }
    }
	private void IntroDescendingSortHeapify(T[] copyOfArray, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if (left < n && copyOfArray[left].compareTo(copyOfArray[largest]) > 0) { largest = left; }
        if (right < n && copyOfArray[right].compareTo(copyOfArray[largest]) > 0) { largest = right; }
        if (largest != i){
            T swapItem = copyOfArray[i];
            copyOfArray[i] = copyOfArray[largest];
            copyOfArray[largest] = swapItem;
            IntroDescendingSortHeapify(copyOfArray, n, largest);
        }
    }
	private int IntroDescendingSortPartitioner(T[] copyOfArray, int start, int end, T pivot){
		while(start <= end){
			while(copyOfArray[start].compareTo(pivot) > 0){ start++; }
			while(copyOfArray[end].compareTo(pivot) < 0){ end--; }
			if(start <= end){
				T tempItem = copyOfArray[start];
				copyOfArray[start] = copyOfArray[end];
				copyOfArray[end] = tempItem;
				start++;
				end--;
			}
		}
		return start;
	}	
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}
