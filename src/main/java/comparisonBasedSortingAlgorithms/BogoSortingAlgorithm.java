package main.java.comparisonBasedSortingAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
BOGO SORTING ALGORITHM:
Bogo Sort is also known as "Permutation Sort" or "Shotgun Sort" or "Stupid Sort" or "Slow Sort" or "Monkey Sort".
It is an Ineffective Sorting Algorithm. It is based on the Generate and Test Paradigm.
The Algorithm keeps generating permutations of its input until it finds one the that is correctly sorted among the various permuted versions.
It has O((N+1)!) Time Complexity.

Bogo Sorting has Two Variants:
	1. Deterministic Version that enumerates all permutations until it hits the sorted array version.
	2. Non-Deterministic Randomized Version: we randomly permute the input until we find the sorted array version.

Bogo Sorting is really the Most Inefficient Sorting Algorithm:
	For Classical Computers: O((N+1)!) It is inefficient!
	For Quantum Computers:	 O(1) Running Time Complexity is guaranteed! Because of Quantum Entanglement: "We can search for every possible combinations simultaneously".
	Algorithms for Classical Computers differ than Algorithms for Quantum Computers:
	 	Very Efficient Algorithms in Classical Computing are Very Inefficient Algorithms in Quantum Computing.
		Very Inefficient Algorithms in Classical Computing are Very Efficient Algorithms in Quantum Computing.
*/
public class BogoSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("BOGO SORTING:");
		BogoSortingAlgorithm<Integer> bogoSortinglgorithm = new BogoSortingAlgorithm<Integer>();
		
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("\nNON-DETERMINISTIC BOGO SORTING:");
		System.out.println("Array Before Bogo Sorting:");
		bogoSortinglgorithm.printArray(inputArray);
		
		//ASCENDING NON-DETERMINISTIC BOGO SORT:
		sortedArray = bogoSortinglgorithm.BogoNonDeterministicAscendingSort(inputArray);
		System.out.println("\nArray After Bogo Non-Deterministic Ascending Sort:");
		bogoSortinglgorithm.printArray(sortedArray);
		
		//DESCENDING NON-DETERMINISTIC BOGO SORT:		
		sortedArray = bogoSortinglgorithm.BogoNonDeterministicDescendingSort(inputArray);
		System.out.println("\nArray After Bogo Non-Deterministic Descending Sort:");
		bogoSortinglgorithm.printArray(sortedArray);
		
		
		System.out.println("\n\nDETERMINISTIC BOGO SORTING:");
		System.out.println("Array Before Bogo Sorting:");
		bogoSortinglgorithm.printArray(inputArray);
		
		//ASCENDING DETERMINISTIC BOGO SORT:
		sortedArray = bogoSortinglgorithm.BogoDeterministicAscendingSort(inputArray);
		System.out.println("\nArray After Bogo Deterministic Ascending Sort:");
		bogoSortinglgorithm.printArray(sortedArray);
		
		//DESCENDING DETERMINISTIC BOGO SORT:		
		sortedArray = bogoSortinglgorithm.BogoDeterministicDescendingSort(inputArray);
		System.out.println("\nArray After Bogo Deterministic Descending Sort:");
		bogoSortinglgorithm.printArray(sortedArray);
	}

	
	
	//THE NON-DETERMINISTIC BOGO SORTING IMPLEMENTATION: 
	public T[] BogoNonDeterministicAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		List<T> itemsList = Arrays.asList(copyOfArray);
		while(!isAscendingSorted(copyOfArray)){ Collections.shuffle(itemsList); }
		return copyOfArray;
	}
	
	public T[] BogoNonDeterministicDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		List<T> itemsList = Arrays.asList(copyOfArray);
		while(!isDescendingSorted(copyOfArray)){ Collections.shuffle(itemsList); }	
		return copyOfArray;
	}
	
	//THE DETERMINISTIC BOGO SORTING IMPLEMENTATION:
	public T[] BogoDeterministicAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = inputArray.length;
		@SuppressWarnings("unchecked")
		Class<T> classOfItem = (Class<T>) copyOfArray[0].getClass();
		@SuppressWarnings("unchecked")
		T[] permutationArray = (T[]) Array.newInstance(classOfItem, size);
		List<List<T>> permutations = permutationGenerator(copyOfArray);
		for(List<T> list : permutations) {
			permutationArray = toArray(list, permutationArray);
			if(isAscendingSorted(permutationArray)) { return permutationArray; }
		}
		//If matching permutation not found, then return the original inputArray:	
		return inputArray;
	}
	
	public T[] BogoDeterministicDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		int size = inputArray.length;
		@SuppressWarnings("unchecked")
		Class<T> classOfItem = (Class<T>) copyOfArray[0].getClass();
		@SuppressWarnings("unchecked")
		T[] permutationArray = (T[]) Array.newInstance(classOfItem, size);
		List<List<T>> permutations = permutationGenerator(copyOfArray);
		for(List<T> list : permutations) {
			permutationArray = toArray(list, permutationArray);
			if(isDescendingSorted(permutationArray)) { return permutationArray; }
		}
		//If matching permutation not found, then return the original inputArray:	
		return inputArray;
	}
	
	//METHOD FOR CHECKING ASCENDING-SORT:
	private boolean isAscendingSorted(T[] array) {
		for (int i = 0; i<array.length-1; i++){ if (array[i+1].compareTo(array[i]) < 0){ return false; } }
		return true;
	}
	
	//METHOD FOR CHECKING DESCENDING-SORT:
	private boolean isDescendingSorted(T[] deepCopyArray) {
		for (int i = 0; i<deepCopyArray.length-1; i++){ if (deepCopyArray[i+1].compareTo(deepCopyArray[i]) > 0){ return false; } }
		return true;
	}

	
	private List<List<T>> permutationGenerator(T[] copyOfArray) {
	    List<List<T>> listOfPermutations = new ArrayList<>();
	    permutationHelper(0, copyOfArray, listOfPermutations);
	    return listOfPermutations;
	}
	 
	private void permutationHelper(int start, T[] copyOfArray, List<List<T>> listOfPermutations){
	    if(start == copyOfArray.length-1){
	        ArrayList<T> permutation = new ArrayList<>();
	        for(T item : copyOfArray){ permutation.add(item); }
	        listOfPermutations.add(permutation);
	        return;
	    }
	    for(int i=start; i<copyOfArray.length; i++){
	        swap(copyOfArray, i, start);
	        permutationHelper(start+1, copyOfArray, listOfPermutations);
	        swap(copyOfArray, i, start);
	    }
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T[] toArray(Collection<T> list, T[] array) {
	    return list.size()>array.length 
	    		? list.toArray((T[]) Array.newInstance(array.getClass().getComponentType(), list.size())) 
	    		: list.toArray(array);
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
