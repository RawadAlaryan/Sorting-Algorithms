package main.java.comparisonBasedSortingAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**	
STRAND SORTING ALGORITHM:
	Strand Sort is a Comparison-Based Sorting Algorithm. 
	It works by repeatedly pulling sorted sublists out of the list to be sorted and merging them with a result array. 
	Each iteration through the unsorted list pulls out a series of elements which were already sorted, and merges those series together.
	The name comes from the "strands" of sorted data within the unsorted list which are removed one at a time. 
	It uses comparisons to remove strands/sub-arrays and then merges them into the sorted array.
	Strand Sort is: 
		In Average case:	O(N.log N)  
		In Best case:		O(N) 	(When list is already sorted). 
		In Worst case: 		O(N^2)	(When list is sorted in reverse order).
	Strand Sort is most useful for data which is stored in a linked list, due to the frequent insertions and removals of data. 
	Using another data structure, such as an array, would greatly increase/degrade the running time and complexity of the algorithm due to lengthy insertions and deletions. 
	Strand Sort is also useful for data which already has large amounts of sorted data, because such data can be removed in a single strand.	
*/

public class StrandSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("STRAND SORT:");
		StrandSortingAlgorithm<Integer> strandSortingAlgorithm = new StrandSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Strand Sorting:");
		strandSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING STRAND SORT:
		sortedArray = strandSortingAlgorithm.StrandAscendingSort(inputArray);
		System.out.println("\n\nArray After Strand Ascending Sort:");
		strandSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING STRAND SORT:		
		sortedArray = strandSortingAlgorithm.StrandDescendingSort(inputArray);
		System.out.println("\n\nArray After Strand Descending Sort:");
		strandSortingAlgorithm.printArray(sortedArray);
	}

	//THE STRAND SORTING IMPLEMENTATION: 	
	public T[] StrandAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = inputArray.clone();	
		//Convert copyOfArray to LinkedList
        LinkedList<T> inputList = new LinkedList<T>(Arrays.asList(copyOfArray));
        LinkedList<T> outputList = new LinkedList<T>();
        StrandAscendingSorter(inputList, outputList);
        for(int i=0; i<outputList.size(); i++) {
        	copyOfArray[i] = outputList.get(i);
        }
        return copyOfArray; 
	}
	private int a = 0;
	private void StrandAscendingSorter(LinkedList<T> inputList, LinkedList<T> outputList) {
		//Base Case:
		if (inputList.isEmpty()) { return; }
		//Recursive Case:
		else {
			//Create a Strand/subList and add first element to it. Then remove the first element from inputList.
			LinkedList<T> subList = new LinkedList<T>();
			subList.add(inputList.getFirst());
			inputList.removeFirst();
			//Iterate through the inputList, comparing all elements with element in the subList:
			int index = 0;
			for (int j=0; j<inputList.size(); j++) {
				if (inputList.get(j).compareTo(subList.get(index)) > 0) {
					subList.add(inputList.get(j));
					inputList.remove(j);
					j = j - 1;
					index = index + 1;
				}
			}
			//Case 1: The Adding Phase: Adding all of the elements to the solution list in sequential order.
			if (a == 0) {
				for (int i = 0; i < subList.size(); i++) {
					outputList.add(subList.get(i));
					a = a + 1;
				}
			}
			//Case 2: The Merging Phase: Merging sub-list with the solution list.
			else {
				int subEnd = subList.size() - 1;
				int solStart = 0;
				while (!subList.isEmpty()) {
					if (subList.get(subEnd).compareTo(outputList.get(solStart)) > 0) { solStart++; } 
					else {
						outputList.add(solStart, subList.get(subEnd));
						subList.remove(subEnd);
						subEnd--;
						solStart = 0;
					}
				}
			}
			StrandAscendingSorter(inputList, outputList);
		}
	}	
	
	public T[] StrandDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = inputArray.clone();	
		//Convert copyOfArray to LinkedList
        LinkedList<T> inputList = new LinkedList<T>(Arrays.asList(copyOfArray));
        LinkedList<T> outputList = new LinkedList<T>();
        StrandDescendingSorter(inputList, outputList);
        for(int i=0; i<outputList.size(); i++) {
        	copyOfArray[i] = outputList.get(i);
        }
        return copyOfArray; 
	}
	private int d = 0;
	private void StrandDescendingSorter(LinkedList<T> inputList, LinkedList<T> outputList) {
		//Base Case:
		if (inputList.isEmpty()) { return; }
		//Recursive Case:
		else {
			//Create a Strand/subList and add first element to it. Then remove the first element from inputList.
			LinkedList<T> subList = new LinkedList<T>();
			subList.add(inputList.getFirst());
			inputList.removeFirst();
			//Iterate through the inputList, comparing all elements with element in the subList:
			int index = 0;
			for (int j=0; j<inputList.size(); j++) {
				if (inputList.get(j).compareTo(subList.get(index)) < 0) {
					subList.add(inputList.get(j));
					inputList.remove(j);
					j = j - 1;
					index = index + 1;
				}
			}
			//Case 1: The Adding Phase: Adding all of the elements to the solution list in sequential order.
			if (d == 0) {
				for (int i = 0; i < subList.size(); i++) {
					outputList.add(subList.get(i));
					d = d + 1;
				}
			}
			//Case 2: The Merging Phase: Merging sub-list with the solution list.
			else {
				int subEnd = subList.size() - 1;
				int solStart = 0;
				while (!subList.isEmpty()) {
					if (subList.get(subEnd).compareTo(outputList.get(solStart)) < 0) { solStart++; } 
					else {
						outputList.add(solStart, subList.get(subEnd));
						subList.remove(subEnd);
						subEnd--;
						solStart = 0;
					}
				}
			}
			StrandDescendingSorter(inputList, outputList);
		}
	}	
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}
