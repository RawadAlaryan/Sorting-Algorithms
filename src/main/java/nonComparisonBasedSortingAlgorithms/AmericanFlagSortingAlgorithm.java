package main.java.nonComparisonBasedSortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
AMERICAN FLAG SORTING ALGORITHM:
	American Flag Sort is an efficient, In-place variant of Radix Sort. 
	It is a Non-comparative Sorting Algorithm used for sorting integers and Strings. 
	American Flag Sort is used to sort large objects such as Strings.
	American Flag Sort iterates through the bits of the objects, considering several bits of each object at a time. 
	For each set of bits, American flag sort makes two passes through the array of objects: 
		First Pass: To count the number of objects that will fall in each bin. 
		Second Pass: To place each object in its bucket. 
	This works well when sorting a byte at a time, using 256 buckets. 
	With some optimizations, it is twice as fast as Quick Sort for large sets of Strings.
*/

public class AmericanFlagSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("AMERICAN FLAG SORT:");
		AmericanFlagSortingAlgorithm<Integer> americanFlagSortingAlgorithm = new AmericanFlagSortingAlgorithm<Integer>();
		Integer[] integerArrayForAmericanFlagSort = {34, -3, 4, 25, -77, 60, 91, 0, -59};
				
		System.out.println("Array Before American Flag Sorting:");
		americanFlagSortingAlgorithm.printNumberArray(integerArrayForAmericanFlagSort);
		
		//ASCENDING AMERICAN FLAG SORT:
		Integer[] sortedIntegerArrayForAmericanFlagSort = americanFlagSortingAlgorithm.AmericanFlagAscendingSort(integerArrayForAmericanFlagSort);
		System.out.println("\n\nArray After American Flag Ascending Sort:");
		americanFlagSortingAlgorithm.printNumberArray(sortedIntegerArrayForAmericanFlagSort);
		
		//DESCENDING AMERICAN FLAG SORT:		
		sortedIntegerArrayForAmericanFlagSort = americanFlagSortingAlgorithm.AmericanFlagDescendingSort(integerArrayForAmericanFlagSort);
		System.out.println("\n\nArray After American Flag Descending Sort:");
		americanFlagSortingAlgorithm.printNumberArray(sortedIntegerArrayForAmericanFlagSort);
	}

	
	//THE AMERICAN FLAG SORTING IMPLEMENTATION: 	
	//This implementation is enhanced to handle positive and negative integers in the input array.
	private static final int AmericanFlagBuckets = 10; // 10 for base 10 numbers.
	public Integer[] AmericanFlagAscendingSort(Integer[] inputArray) {
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
			else { negativeIntegers.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
		}
		//Calling AmericanFlagSorterIntegers on both positiveIntegers and negativeIntegers: 
		AmericanFlagSorter((ArrayList<Integer>) positiveIntegers);
		AmericanFlagSorter((ArrayList<Integer>) negativeIntegers);
		//Reversing the order of negativeIntegers Array:
		Collections.reverse(negativeIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i] = -1*negativeIntegers.get(i); }
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i+negativeIntegers.size()] = positiveIntegers.get(i); }
		return copyOfArray; 
	}	
	
	public Integer[] AmericanFlagDescendingSort(Integer[] inputArray) {
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
			else { negativeIntegers.add( -1*copyOfArray[i]); }	//Converting Negative integers to positive integers.
		}
		//Calling AmericanFlagSorterIntegers on both positiveIntegers and negativeIntegers: 
		AmericanFlagSorter((ArrayList<Integer>) positiveIntegers);
		AmericanFlagSorter((ArrayList<Integer>) negativeIntegers);
		//Reversing the order of positiveIntegers Array:
		Collections.reverse(positiveIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i] = positiveIntegers.get(i); }
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i+positiveIntegers.size()] = -1*negativeIntegers.get(i); }
		return copyOfArray; 
	}	
	
	private void AmericanFlagSorter(ArrayList<Integer> numberArray) {
        int numberOfDigits = getMaxNumberOfDigits(numberArray); // Max number of digits
        int max = 1;
        for (int i = 0; i < numberOfDigits - 1; i++)
            max *= 10;
        AmericanFlagSortHelper(numberArray, 0, numberArray.size(), max);
    }
    private int getMaxNumberOfDigits(ArrayList<Integer> numberArray) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int number : numberArray) {
            temp = (int) Math.log10(number) + 1;
            if (temp > max) { max = temp; }
        }
        return max;
    }
    private void AmericanFlagSortHelper(ArrayList<Integer> numberArray, int start, int length, int divisor) {
        //First Pass: Finding Counts.
        int[] count = new int[AmericanFlagBuckets];
        int[] offset = new int[AmericanFlagBuckets];
        int digit = 0;
        for (int i = start; i < length; i++) {
            int d = numberArray.get(i);
            digit = getDigit(d, divisor);
            count[digit]++;
        }
        offset[0] = start + 0;
        for (int i=1; i<AmericanFlagBuckets; i++) {
            offset[i] = count[i - 1] + offset[i - 1];
        }
        //Second Pass: Placing into Buckets.
        for (int b=0; b<AmericanFlagBuckets; b++) {
            while (count[b] > 0) {
                int origin = offset[b];
                int from = origin;
                int num = numberArray.get(from);
                numberArray.set(from, -1);
                do {
                    digit = getDigit(num, divisor);
                    int to = offset[digit]++;
                    count[digit]--;
                    int temp = numberArray.get(to);
                    numberArray.set(to, num);
                    num = temp;
                    from = to;
                } while (from != origin);
            }
        }
        if (divisor > 1) {
            // Sort the buckets
            for (int i=0; i<AmericanFlagBuckets; i++) {
                int begin = (i > 0) ? offset[i - 1] : start;
                int end = offset[i];
                if (end - begin > 1) { AmericanFlagSortHelper(numberArray, begin, end, divisor / 10); }
            }
        }
    }
    private int getDigit(int integer, int divisor) { return (integer / divisor) % 10; }
    
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
	}
}
