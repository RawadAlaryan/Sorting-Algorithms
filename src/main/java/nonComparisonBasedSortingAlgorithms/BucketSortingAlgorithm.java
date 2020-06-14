package nonComparisonBasedSortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
BUCKET SORTING ALGORITHM:
	Bucket Sort is a Non-Comparison-Based Sorting Algorithm. Also known as "Bin Sort".
	It is used only for sorting integers. 
	It uses Hashing Functions and it makes assumptions about the data like Radix-Sorting and Counting-Sorting. 
	Bucket Sort can achieve Linear Time O(n). 
	The algorithm performs best when the hashed values of items being sorted are evenly distributed, so there aren’t any collisions. 
	In Bucket Sort, we are hashing the values that we are sorting. 
		1. The Scattering Phase: We distribute the items that we want to sort into buckets based on their hashed values. 
								 After that, we sort the items in each bucket and after each bucket has been sorted, 
		2. The Gathering/Merging Phase: We merge the buckets like concatenating them one after the other. 
		3. The Last Phase: We will be copying the items in the bucket into the original array. 
	Bucket Sort is a generalization of Counting Sort. 
			Values in bucket x must all be greater than the values in bucket x-1, and less than the values in bucket x+1. 
			This means that the hash function we will use must give us hashed values that meet this requirement.
	Bucket sort is NOT an in-place algorithm. Stability depends on the sorting algorithm used to sort the buckets. 
	Ideally: We want a stable sort. Insertion sort is usually used to sort the buckets, because it is fast when the number of items is small. 
			 But we still can use any sorting method from the Collections class. To achieve O(N), we must have only one item per bucket.
	Bucket Sort is O(N + k) ; where k is the number of buckets.		 	
*/

public class BucketSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		//BUCKET SORT WITH INTEGERS:	
		System.out.println("BUCKET SORT:");
		BucketSortingAlgorithm<Integer> bucketSortingAlgorithm = new BucketSortingAlgorithm<Integer>();
		Integer[] integerArrayForBucketSort = {34, -3, 4, 25, -77, 60, 91, 0, -59};
				
		System.out.println("BUCKET SORTING FOR INTEGERS:");
		System.out.println("Array Before Bucket Sorting:");
		bucketSortingAlgorithm.printNumberArray(integerArrayForBucketSort);
		
		//ASCENDING BUCKET SORT:
		Integer[] sortedIntegerArrayForBucketSort = bucketSortingAlgorithm.BucketAscendingSortIntegers(integerArrayForBucketSort);
		System.out.println("\n\nArray After Bucket Ascending Sort:");
		bucketSortingAlgorithm.printNumberArray(sortedIntegerArrayForBucketSort);
		
		//DESCENDING BUCKET SORT:		
		sortedIntegerArrayForBucketSort = bucketSortingAlgorithm.BucketDescendingSortIntegers(integerArrayForBucketSort);
		System.out.println("\n\nArray After Bucket Descending Sort:");
		bucketSortingAlgorithm.printNumberArray(sortedIntegerArrayForBucketSort);	
		
		//BUCKET SORT WITH DOUBLES:
		Double[] doubleArrayForBucketSort = {-0.007, 0.897, 3.565, -1.656, 0.1234, 2.665, 0.3434};
		System.out.println("\n\n\nBUCKET SORTING FOR DOUBLES:");
		System.out.println("Array Before Bucket Sorting:");
		bucketSortingAlgorithm.printNumberArray(doubleArrayForBucketSort);
		
		//ASCENDING BUCKET SORT:
		Double[] sortedDoubleArrayForBucketSort = bucketSortingAlgorithm.BucketAscendingSortDoubles(doubleArrayForBucketSort);
		System.out.println("\n\nArray After Bucket Ascending Sort:");
		bucketSortingAlgorithm.printNumberArray(sortedDoubleArrayForBucketSort);
		
		//DESCENDING BUCKET SORT:		
		sortedDoubleArrayForBucketSort = bucketSortingAlgorithm.BucketDescendingSortDoubles(doubleArrayForBucketSort);
		System.out.println("\n\nArray After Bucket Descending Sort:");
		bucketSortingAlgorithm.printNumberArray(sortedDoubleArrayForBucketSort);
	}
	
	
	//THE BUCKET SORTING IMPLEMENTATION FOR INTEGERS: 	
	//This implementation is enhanced to handle positive and negative integers in the input array.
	public Integer[] BucketAscendingSortIntegers(Integer[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Integer[] copyOfArray = inputArray.clone();
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
		List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { positiveIntegers.add(copyOfArray[i]); }
			//Converting Negative integers to positive integers.
			else { negativeIntegers.add( -1*copyOfArray[i]); }	
		}
		//Calling RadixSorterForIntegers on both positiveIntegers and negativeIntegers: 
		ascendingBucketSorterIntegers((ArrayList<Integer>) positiveIntegers);
		ascendingBucketSorterIntegers((ArrayList<Integer>) negativeIntegers);
		//Reversing the order of negativeIntegers Array:
		Collections.reverse(negativeIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i] = -1*negativeIntegers.get(i); }
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i+negativeIntegers.size()] = positiveIntegers.get(i); }
		return copyOfArray; 
	}
	private void ascendingBucketSorterIntegers(ArrayList<Integer> numberArray) {	
		int min = (int) Collections.min(numberArray);
		int max = (int) Collections.max(numberArray);
		//In this implementation, we will use an array of ArrayLists as Buckets.
		int numOfBuckets = max - min + 1;
		@SuppressWarnings("unchecked")
		List<Integer>[] arrayOfBuckets = new List[numOfBuckets];
    	//Creating an ArrayList for each bucket.
        for (int i = 0; i < arrayOfBuckets.length; i++) { arrayOfBuckets[i] = new ArrayList<Integer>(); }
        //The Scattering Phase:
        for (int i=0; i<numberArray.size(); i++) { 
        	int hashedIndex = bucketSortHashingFunction(numberArray.get(i), numOfBuckets);
        	arrayOfBuckets[hashedIndex].add(numberArray.get(i)); 
        }
        //Sorting the Buckets/ArrayLists: Using the sort method from the Collections class which is based on Merge-Sort:
        for (List<Integer> bucket: arrayOfBuckets) { Collections.sort(bucket); }
        //The Gathering/Merging Phase:
        int j = 0;	//j will be tracking our position in the input array.
        for (int i = 0; i < arrayOfBuckets.length; i++){	//Traversing the Buckets Array.
            for (Integer item: arrayOfBuckets[i]) { numberArray.set(j++, item); }	//Traversing the Arraylist[i]
        }
	}	
	
	public Integer[] BucketDescendingSortIntegers(Integer[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Integer[] copyOfArray = inputArray.clone();
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
		List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { positiveIntegers.add(copyOfArray[i]); }
			//Converting Negative integers to positive integers.
			else { negativeIntegers.add( -1*copyOfArray[i]); }	
		}
		//Calling RadixSorterForIntegers on both positiveIntegers and negativeIntegers: 
		descendingBucketSorterIntegers((ArrayList<Integer>) positiveIntegers);
		descendingBucketSorterIntegers((ArrayList<Integer>) negativeIntegers);
		//Reversing the order of positiveIntegers Array:
		Collections.reverse(positiveIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i] = positiveIntegers.get(i); }
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i+positiveIntegers.size()] = -1*negativeIntegers.get(i); }
		return copyOfArray;
	}
	private void descendingBucketSorterIntegers(ArrayList<Integer> numberArray) {	
		int min = (int) Collections.min(numberArray);
		int max = (int) Collections.max(numberArray);
		//In this implementation, we will use an array of ArrayLists as Buckets.
		int numOfBuckets = max - min + 1;
		@SuppressWarnings("unchecked")
		List<Integer>[] arrayOfBuckets = new List[numOfBuckets];
    	//Creating an ArrayList for each bucket.
        for (int i = 0; i < arrayOfBuckets.length; i++) { arrayOfBuckets[i] = new ArrayList<Integer>(); }
        //The Scattering Phase:
        for (int i=0; i<numberArray.size(); i++) { 
        	int hashedIndex = bucketSortHashingFunction(numberArray.get(i), numOfBuckets);
        	arrayOfBuckets[hashedIndex].add(numberArray.get(i)); 
        }
        //Sorting the Buckets/ArrayLists: Using the sort method from the Collections class which is based on Merge-Sort:
        for (List<Integer> bucket: arrayOfBuckets) { Collections.sort(bucket); }
        //The Gathering/Merging Phase:
        int j = 0;	//j will be tracking our position in the input array.
        for (int i = 0; i < arrayOfBuckets.length; i++){	//Traversing the Buckets Array.
            for (Integer item: arrayOfBuckets[i]) { numberArray.set(j++, item); }	//Traversing the Arraylist[i]
        }
	}

	
	//THE BUCKET SORTING IMPLEMENTATION FOR DOUBLES: 	
	//This implementation is enhanced to handle positive and negative doubles in the input array.
	public Double[] BucketAscendingSortDoubles(Double[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Double[] copyOfArray = inputArray.clone();
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Double> positiveDoubles = new ArrayList<Double>(numOfPositiveIntegers);
		List<Double> negativeDoubles = new ArrayList<Double>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { positiveDoubles.add(copyOfArray[i]); }
			else { negativeDoubles.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
		}
		//Calling RadixSorterForIntegers on both positiveIntegers and negativeIntegers: 
		ascendingBucketSorterDoubles((ArrayList<Double>) positiveDoubles);
		ascendingBucketSorterDoubles((ArrayList<Double>) negativeDoubles);
		//Reversing the order of negativeIntegers Array:
		Collections.reverse(negativeDoubles);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<negativeDoubles.size(); i++) { copyOfArray[i] = -1*negativeDoubles.get(i); }
		for(int i=0; i<positiveDoubles.size(); i++) { copyOfArray[i+negativeDoubles.size()] = positiveDoubles.get(i); }
		return copyOfArray; 
	}
	private void ascendingBucketSorterDoubles(ArrayList<Double> numberArray) {	
		int min = Collections.min(numberArray).intValue();
		int max = Collections.max(numberArray).intValue();
		//In this implementation, we will use an array of ArrayLists as Buckets.
		int numOfBuckets = max - min + 1;
		@SuppressWarnings("unchecked")
		List<Double>[] arrayOfBuckets = new List[numOfBuckets];
	   	//Creating an ArrayList for each bucket.
	       for (int i = 0; i < arrayOfBuckets.length; i++) { arrayOfBuckets[i] = new ArrayList<Double>(); }
	       //The Scattering Phase:
	       for (int i=0; i<numberArray.size(); i++) { 
	    	   int hashedIndex = bucketSortHashingFunction(numberArray.get(i), numOfBuckets);
	       		arrayOfBuckets[hashedIndex].add(numberArray.get(i)); 
	       }
	       //Sorting the Buckets/ArrayLists: Using the sort method from the Collections class which is based on Merge-Sort:
	       for (List<Double> bucket: arrayOfBuckets) { Collections.sort(bucket); }
	       //The Gathering/Merging Phase:
	       int j = 0;	//j will be tracking our position in the input array.
	       for (int i = 0; i < arrayOfBuckets.length; i++){	//Traversing the Buckets Array.
	    	   for (Double item: arrayOfBuckets[i]) { numberArray.set(j++, item); }	//Traversing the Arraylist[i]
	       }
	}
	
	public Double[] BucketDescendingSortDoubles(Double[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Double[] copyOfArray = inputArray.clone();
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Double> positiveDoubles = new ArrayList<Double>(numOfPositiveIntegers);
		List<Double> negativeDoubles = new ArrayList<Double>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i].intValue() >= 0) { positiveDoubles.add(copyOfArray[i]); }
			else { negativeDoubles.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
		}
		//Calling RadixSorterForIntegers on both positiveIntegers and negativeIntegers: 
		descendingBucketSorterDoubles((ArrayList<Double>) positiveDoubles);
		descendingBucketSorterDoubles((ArrayList<Double>) negativeDoubles);
		//Reversing the order of positiveIntegers Array:
		Collections.reverse(positiveDoubles);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<positiveDoubles.size(); i++) { copyOfArray[i] = positiveDoubles.get(i); }
		for(int i=0; i<negativeDoubles.size(); i++) { copyOfArray[i+positiveDoubles.size()] = -1*negativeDoubles.get(i); }
		return copyOfArray;
	}
	private void descendingBucketSorterDoubles(ArrayList<Double> numberArray) {	
		int min = Collections.min(numberArray).intValue();
		int max = Collections.max(numberArray).intValue();
		//In this implementation, we will use an array of ArrayLists as Buckets.
		int numOfBuckets = max - min + 1;
		@SuppressWarnings("unchecked")
		List<Double>[] arrayOfBuckets = new List[numOfBuckets];
	   	//Creating an ArrayList for each bucket.
	       for (int i = 0; i < arrayOfBuckets.length; i++) { arrayOfBuckets[i] = new ArrayList<Double>(); }
	       //The Scattering Phase:
	       for (int i=0; i<numberArray.size(); i++) { 
	    	   int hashedIndex = bucketSortHashingFunction(numberArray.get(i), numOfBuckets);
	       		arrayOfBuckets[hashedIndex].add(numberArray.get(i)); 
	       }
	       //Sorting the Buckets/ArrayLists: Using the sort method from the Collections class which is based on Merge-Sort:
	       for (List<Double> bucket: arrayOfBuckets) { Collections.sort(bucket); }
	       //The Gathering/Merging Phase:
	       int j = 0;	//j will be tracking our position in the input array.
	       for (int i = 0; i < arrayOfBuckets.length; i++){	//Traversing the Buckets Array.
	    	   for (Double item: arrayOfBuckets[i]) { numberArray.set(j++, item); }	//Traversing the Arraylist[i]
	       }
	}
	
	private int bucketSortHashingFunction(Number item, int numOfBuckets){
		int number = item.intValue();
        return (number / 10 % numOfBuckets);
    } 	
	
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
	}
}
