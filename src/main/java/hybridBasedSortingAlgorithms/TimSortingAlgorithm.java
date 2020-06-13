package main.java.hybridBasedSortingAlgorithms;

import java.lang.reflect.Array;

/**
TIM SORTING ALGORITHM:
	TIM SORT = INSERTION SORT + MERGE SORT
	It is a Hybrid Sorting Algorithm from Merge Sort and Insertion Sort.	
	It was implemented by Tim Peters in 2002 for use in the Python programming language.
	It is a Stable Sorting Algorithm.
	Best case running time: O(N)
	Worst case running time: O(N.logN)
	Worst case space complexity: O(N)
	
	Tim Sort Implementation:
		We divide the Array into blocks known as "RUN".
		We sort the RUNs using Insertion Sort one by one and then merge those RUNs using combine function in Merge Sort.
			Merge Sort performs well when sizes of SubArrays are powers of 2.
		The size of RUN may vary from 32 to 64 depending upon the size of the array.
		If the size of Array is less than RUN, then Array get sorted just by using Insertion Sort
		Insertion Sort performs well for small arrays.
*/

public class TimSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("TIM SORT:");
		TimSortingAlgorithm<Integer> timSortingAlgorithm = new TimSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Tim Sorting:");
		timSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING TIM SORT:
		sortedArray = timSortingAlgorithm.TimAscendingSort(inputArray);
		System.out.println("\n\nArray After Tim Ascending Sort:");
		timSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING TIM SORT:		
		sortedArray = timSortingAlgorithm.TimDescendingSort(inputArray);
		System.out.println("\n\nArray After Tim Descending Sort:");
		timSortingAlgorithm.printArray(sortedArray);
	}

	
	//THE TIM SORTING IMPLEMENTATION:
	private int RUN = 32; 
	public T[] TimAscendingSort(T[] inputArray) { 	
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int arrayLength = copyOfArray.length;
		//INSERTION SORT:	Sort Individual SubArrays of size RUN:  
        for (int i=0; i<arrayLength; i += RUN) { TimAscendingInsertionSort(copyOfArray, i, Math.min( (i+RUN-1), (arrayLength-1) )); } 
        //MERGE SORT:	Start Merging from size RUN. Then, It will merge to size 2*RUN, then 4*RUN, 8*RUN and so on ...  
        for (int size=RUN; size<arrayLength; size = 2*size) { 
        	//We pick starting point of Left-SubArray. After every Merge, we increase left by 2*size  
            for (int left=0; left<arrayLength; left += 2*size) { 
            	int middle = left + size - 1; 
                int right = Math.min((left + 2*size -1), (arrayLength-1)); 
                TimAscendingMergeSort(copyOfArray, left, middle, right); 
            } 
        } 
        return copyOfArray;
	} 
	private void TimAscendingInsertionSort(T[] copyOfArray, int left, int right) { 
		for(int i=left; i<=right; i++) {
			int j = i;
			while ((j>0) && (copyOfArray[j-1].compareTo(copyOfArray[j]) > 0)) {
                swap(copyOfArray, j, j-1);
                j--;
            }
        }
    }  
	//Merge Function merges the Sorted SubArray RUNs:  
    @SuppressWarnings("unchecked")
	private void TimAscendingMergeSort(T[] copyOfArray, int left, int middle, int right) { 
        //Original Array is broken into two parts: LeftArray and RightArray:  
        int leftLength = middle - left + 1; 
        int rightLength = right - middle; 
        Class<T> classOfItem = (Class<T>) copyOfArray[0].getClass();
        T[] leftItems = (T[]) Array.newInstance(classOfItem, leftLength);
		T[] rightItems = (T[]) Array.newInstance(classOfItem, rightLength);
        for (int x = 0; x < leftLength; x++) { leftItems[x] = copyOfArray[left + x]; } 
        for (int x = 0; x < rightLength; x++) { rightItems[x] = copyOfArray[middle + 1 + x]; } 
        int i = 0; 
        int j = 0; 
        int k = left; 
        //After comparing, we merge those two SubArrays into a larger SubArray:  
        while (i<leftLength && j<rightLength) { 
            if (leftItems[i].compareTo(rightItems[j]) <= 0) { copyOfArray[k] = leftItems[i];	i++; } 
            else { copyOfArray[k] = rightItems[j];	j++; } 
            k++; 
        } 
        //Copy The Remaining Elements from LeftSubArray:  
        while (i<leftLength) { 
        	copyOfArray[k] = leftItems[i]; 
            k++; 
            i++; 
        } 
        //Copy The Remaining Elements from RightSubArray:  
        while (j<rightLength) { 
        	copyOfArray[k] = rightItems[j]; 
            k++; 
            j++; 
        } 
    }  
	 
	 
	public T[] TimDescendingSort(T[] inputArray) { 	
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int arrayLength = copyOfArray.length;
		//INSERTION SORT:	Sort Individual SubArrays of size RUN:  
        for (int i=0; i<arrayLength; i += RUN) { TimDescendingInsertionSort(copyOfArray, i, Math.min( (i+RUN-1), (arrayLength-1) )); } 
        //MERGE SORT:	Start Merging from size RUN. Then, It will merge to size 2*RUN, then 4*RUN, 8*RUN and so on ...  
        for (int size=RUN; size<arrayLength; size = 2*size) { 
        	//We pick starting point of Left-SubArray. After every Merge, we increase left by 2*size  
            for (int left=0; left<arrayLength; left += 2*size) { 
            	int middle = left + size - 1; 
                int right = Math.min((left + 2*size -1), (arrayLength-1)); 
                TimDescendingMergeSort(copyOfArray, left, middle, right); 
            } 
        } 
        return copyOfArray;
	} 
	private void TimDescendingInsertionSort(T[] copyOfArray, int left, int right) { 
		for(int i=left; i<=right; i++) {
			int j = i;
			while ((j>0) && (copyOfArray[j-1].compareTo(copyOfArray[j]) < 0)) {
                swap(copyOfArray, j, j-1);
                j--;
            }
        }
    }  
	//Merge Function merges the Sorted SubArray RUNs:  
    @SuppressWarnings("unchecked")
	private void TimDescendingMergeSort(T[] copyOfArray, int left, int middle, int right) { 
        //Original Array is broken into two parts: LeftArray and RightArray:  
        int leftLength = middle - left + 1; 
        int rightLength = right - middle; 
        Class<T> classOfItem = (Class<T>) copyOfArray[0].getClass();
        T[] leftItems = (T[]) Array.newInstance(classOfItem, leftLength);
		T[] rightItems = (T[]) Array.newInstance(classOfItem, rightLength);
        for (int x = 0; x < leftLength; x++) { leftItems[x] = copyOfArray[left + x]; } 
        for (int x = 0; x < rightLength; x++) { rightItems[x] = copyOfArray[middle + 1 + x]; } 
        int i = 0; 
        int j = 0; 
        int k = left; 
        //After comparing, we merge those two SubArrays into a larger SubArray:
        while (i<leftLength && j<rightLength) { 
            if (leftItems[i].compareTo(rightItems[j]) >= 0) { copyOfArray[k] = leftItems[i];	i++; } 
            else { copyOfArray[k] = rightItems[j];	j++; } 
            k++; 
        } 
        //Copy The Remaining Elements from LeftSubArray:  
        while (i<leftLength) { 
        	copyOfArray[k] = leftItems[i]; 
            k++; 
            i++; 
        } 
        //Copy The Remaining Elements from RightSubArray:  
        while (j<rightLength) { 
        	copyOfArray[k] = rightItems[j]; 
            k++; 
            j++; 
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
