package main.java.comparisonBasedSortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
PATIENCE SORTING ALGORITHM:
	Patience Sorting is a Comparison-Based Sorting Algorithm. It has a O(N.log N) time complexity. 
	A variant of the algorithm efficiently computes the Length of a Longest Increasing Subsequence in a given array.
	It is inspired by the Card Game "Patience". This game begins with a shuffled deck of cards. 
	These cards are dealt one by one into a sequence of piles on the table, according to the following rules:
		1. Initially, there are no piles. The first card forms a new pile consisting of the single card.
		2. Each subsequent card is placed on the leftmost existing pile whose top card has a value greater than or equal the new card's value. 
		   or to the right of all of the existing piles, thus forming a new pile.
		3. When there are no more cards remaining to deal, the game ends.
	This card game is turned into a two-phase sorting algorithm, as follows: 
		Given an array of N elements from some totally ordered domain, 
		consider this array as a collection of cards and simulate the patience sorting game. 
		When the game is over, recover the sorted sequence by repeatedly picking off the minimum visible card. 
		In other words, perform a k-way merge of the p piles, each of which is internally sorted.
*/

public class PatienceSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("PATIENCE SORT:");
		PatienceSortingAlgorithm<Integer> patienceSortingAlgorithm = new PatienceSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Patience Sorting:");
		patienceSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING PATIENCE SORT:
		sortedArray = patienceSortingAlgorithm.PatienceAscendingSort(inputArray);
		System.out.println("\n\nArray After Patience Ascending Sort:");
		patienceSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING PATIENCE SORT:		
		sortedArray = patienceSortingAlgorithm.PatienceDescendingSort(inputArray);
		System.out.println("\n\nArray After Patience Descending Sort:");
		patienceSortingAlgorithm.printArray(sortedArray);		
	}

	//THE PATIENCE SORTING IMPLEMENTATION: 
	public T[] PatienceAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		//Creating a List of Stacks:
		List<Pile<T>> piles = new ArrayList<Pile<T>>();
		//Sort elements into piles:
		for (T item : copyOfArray) {
			Pile<T> newPile = new Pile<T>();
			newPile.push(item);
			int i = Collections.binarySearch(piles, newPile);
			if (i < 0) i = ~i;	//Tilda Operator is Bitwise-Not Operation on binary representation of i.
			if (i != piles.size()) { piles.get(i).push(item); }
			else { piles.add(newPile); }
		}
		//PriorityQueue allows us to retrieve The-Least-Pile efficiently:
		PriorityQueue<Pile<T>> heap = new PriorityQueue<Pile<T>>(piles);
		for (int i=0; i<copyOfArray.length; i++) {
			Pile<T> smallPile = heap.poll();
			copyOfArray[i] = smallPile.pop();
			if (!smallPile.isEmpty()) { heap.add(smallPile); }
		}
		assert(heap.isEmpty());
		return copyOfArray; 
	}	

	public T[] PatienceDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();
		//Creating a List of Stacks:
		List<Pile<T>> piles = new ArrayList<Pile<T>>();
		//Sort elements into piles:
		for (T item : copyOfArray) {
			Pile<T> newPile = new Pile<T>();
			newPile.push(item);
			int i = Collections.binarySearch(piles, newPile);
			if (i < 0) i = ~i;	//Tilda Operator is Bitwise-Not Operation on binary representation of i.
			if (i != piles.size()) { piles.get(i).push(item); }
			else { piles.add(newPile); }
		}
		//PriorityQueue allows us to retrieve The-Least-Pile efficiently:
		PriorityQueue<Pile<T>> heap = new PriorityQueue<Pile<T>>(piles);
		for (int i=copyOfArray.length-1; i>=0; i--) {
			Pile<T> smallPile = heap.poll();
			copyOfArray[i] = smallPile.pop();
			if (!smallPile.isEmpty()) { heap.add(smallPile); }
		}
		assert(heap.isEmpty());
		return copyOfArray; 
	}	
	
	@SuppressWarnings("serial")
	private static class Pile<T extends Comparable<? super T>> extends Stack<T> implements Comparable<Pile<T>> {
		public int compareTo(Pile<T> pile) { return peek().compareTo(pile.peek()); }
	}	
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}
