package main.java.nonComparisonBasedSortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
RADIX SORTING ALGORITHM:
	It is a Non-Comparison-Based Sorting Algorithm. There are no comparisons. 
	Radix Sort makes assumptions about the data it is sorting. The data must have the same radix and width.
	Radix sort can be used to sort integers and strings (not for floating point numbers).
	It can be very efficient. Running Time Complexity can reach O(N).
	Running Time O(k*N); where k is the number of digits in the input number.
		If we want to sort a 32-bit integer, then k = 32, because there are 32 bits in the integer. 
	We sort the elements according to individual characters.
	It is a Stable Sorting Algorithm.
	It is NOT In-place Algorithm.
	
	There are two types of Radix Sort: A String can be a string of characters or a string of digits.
		1. LSD String Sorting:
			Least-Significant-Digit first String Sorting.
			We consider characters from Right to Left.
			We can use it to fixed length Strings or fixed length numbers like integers.
			We sort the characters at the last column ... then keep going left and sort the columns independently.
		
		2. MSD String Sort:
			Most-Significant-Digit first String Sorting.
			We consider characters from Left to Right.
			Disadvantage: It is sensitive to ASCII and Unicode representations.
			Advantages: MSD examines just enough characters to sort the Key. Therefore, it can be O(N).
		MSD access memory randomly ... not so efficient.
		Solution: We should combine it with Quick Sort ... This is called the 3-Way Radix Quick Sort.
	
	It is important to use a Stable sort algorithm at each stage. 
	In Radix sort, we will use counting sort with a modification to make it a Stable Algorithm. 
	Although it can achieve linear time O(n). It often runs slower than O(n.logn) algorithms because of the overhead involved (because of isolating each individual digit or letter at each phase). 
	Radix sort can be or cannot be in-place algorithm depending on the sorting implementation. 
	
	The Radix: is the number of unique digits or values in the case of characters that a numbering system or an alphabet has.
		Radix for decimal system is 10 (from 0 to 9).  
		Radix for binary system is 2 (0 and 1).
		Radix for English Alphabet is 26 (from a to z).
	The width: the number of digits or letters.
		Width for number 5321 is 4.
		Width for number 10 is 2.
		Width for the string “Hello” is 5.
*/	

public class RadixSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("RADIX SORT:");
		RadixSortingAlgorithm<Integer> radixSortingAlgorithm = new RadixSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("RADIX SORT - LDS - WITH INTEGERS:");
		System.out.println("Array Before Radix Sorting:");
		radixSortingAlgorithm.printNumberArray(inputArray);
		
		//ASCENDING RADIX SORT:
		sortedArray =  radixSortingAlgorithm.RadixAscendingSortIntegers(inputArray);
		System.out.println("\n\nArray After Radix Ascending Sort:");
		radixSortingAlgorithm.printNumberArray(sortedArray);
		
		//DESCENDING RADIX SORT:		
		sortedArray =  radixSortingAlgorithm.RadixDescendingSortIntegers(inputArray);
		System.out.println("\n\nArray After Radix Descending Sort:");
		radixSortingAlgorithm.printNumberArray(sortedArray);				
		
		System.out.println("\n\nRADIX SORT - LDS - WITH STRINGS:");
		String[] inputArrayForRadixSortStrings = {"n", "o", "p", "q", "r", "w", "x", "y", "f", "t", "u", "v", "g", "h", "i", "a", "b", "c", "d", "e", "j", "z", "k", "l", "m" ,"s"};
		String[] sortedArrayForRadixSortStrings;
		System.out.println("Array Before Radix Sorting:");
		radixSortingAlgorithm.printStringArray(inputArrayForRadixSortStrings);
		
		//ASCENDING RADIX SORT:
		sortedArrayForRadixSortStrings = radixSortingAlgorithm.RadixAscendingSortStrings(inputArrayForRadixSortStrings);
		System.out.println("\n\nArray After Radix Ascending Sort:");
		radixSortingAlgorithm.printStringArray(sortedArrayForRadixSortStrings);
		
		//DESCENDING RADIX SORT:		
		sortedArrayForRadixSortStrings = radixSortingAlgorithm.RadixDescendingSortStrings(inputArrayForRadixSortStrings);
		System.out.println("\n\nArray After Radix Descending Sort:");
		radixSortingAlgorithm.printStringArray(sortedArrayForRadixSortStrings);
	}

	
	
	//THE RADIX SORTING IMPLEMENTATION FOR INTEGERS: 	
	public Integer[] RadixAscendingSortIntegers(Integer[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Integer[] copyOfArray = inputArray.clone();			
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
		List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { positiveIntegers.add(copyOfArray[i]); }
			//Converting Negative integers to positive integers.
			else { negativeIntegers.add( -1*copyOfArray[i]); }	
		}
		//Calling RadixSorterForIntegers on both positiveIntegers and negativeIntegers: 
		ascendingRadixSorterIntegers(positiveIntegers, 10, 4);
		ascendingRadixSorterIntegers(negativeIntegers, 10, 4);
		//Reversing the order of negativeIntegers Array:
		Collections.reverse(negativeIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i] = -1*negativeIntegers.get(i); }
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i+negativeIntegers.size()] = positiveIntegers.get(i); }
		return copyOfArray; 
	}	
	//The Radix LSD Implementation: We consider integers from Right to Left.
	private void ascendingRadixSorterIntegers(List<Integer> inputArray, int radix, int width) {
		for (int i = 0; i < width; i++) {	
			//i will be from 0 to 3, representing the one's, ten's, hundred's and thousand's positions:
			//Calling radixSingleSort for each digit-position in our values:
			radixSingleSortAscendingIntegers(inputArray, i, radix);
		}
	}
	private void radixSingleSortAscendingIntegers(List<Integer> inputArray, int position, int radix) {
		int numberOfItems = inputArray.size();	
		//Filling the count array:
		int[] countArray = new int[radix];
		for (int numberValue : inputArray) {
			//getDigitIntegers method returns a single digit between 0 to 9
			countArray[getDigitIntegers(position, numberValue, radix)]++;	
		}
		//Adjusting the count array: By storing how many numbers have a specific digit or less.  
		for (int j = 1; j < radix; j++) {	
			//j starts from 1, skipping first index that represents how many numbers have zero at the position in question: 
			countArray[j] += countArray[j - 1];
		}
		//Creating a temporary array and copy the values into it:
		int[] tempArray = new int[numberOfItems];
		//Starting from right to left:
		for (int tempIndex = numberOfItems - 1; tempIndex >= 0; tempIndex--) {
			tempArray[--countArray[getDigitIntegers(position, inputArray.get(tempIndex), radix)]] = inputArray.get(tempIndex);
		}
		//Writing values back into the input array:
		for (int tempIndex = 0; tempIndex < numberOfItems; tempIndex++) {
			inputArray.set(tempIndex, tempArray[tempIndex]);
		}
	}

	public Integer[] RadixDescendingSortIntegers(Integer[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Integer[] copyOfArray = inputArray.clone();			
		//Counting number of positive/negative integers:
		int numOfPositiveIntegers = 0;
		int numOfNegativeIntegers = 0;
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { numOfPositiveIntegers++; }
			else { numOfNegativeIntegers++; }
		}
		//Splitting Positive Values from Negative Values:
		List<Integer> positiveIntegers = new ArrayList<Integer>(numOfPositiveIntegers);
		List<Integer> negativeIntegers = new ArrayList<Integer>(numOfNegativeIntegers);
		//Filling the Positive and Negative Arrays from Original Input Array:
		for(int i=0; i<copyOfArray.length; i++) {
			if(copyOfArray[i] >= 0) { positiveIntegers.add(copyOfArray[i]); }
			//Converting Negative integers to positive integers.
			else { negativeIntegers.add( -1*copyOfArray[i]); }	
		}
		//Calling RadixSorterForIntegers on both positiveIntegers and negativeIntegers: 
		descendingRadixSorterIntegers(positiveIntegers, 10, 4);
		descendingRadixSorterIntegers(negativeIntegers, 10, 4);
		//Reversing the order of positiveIntegers Array:
		Collections.reverse(positiveIntegers);
		//Joining both arrays into one final sorted Array:
		for(int i=0; i<positiveIntegers.size(); i++) { copyOfArray[i] = positiveIntegers.get(i); }
		for(int i=0; i<negativeIntegers.size(); i++) { copyOfArray[i+positiveIntegers.size()] = -1*negativeIntegers.get(i); }
		return copyOfArray; 
	}	
	//The Radix LSD Implementation: We consider integers from Right to Left.
	private void descendingRadixSorterIntegers(List<Integer> inputArray, int radix, int width) {
		for (int i = 0; i < width; i++) {	
			//i will be from 0 to 3, representing the one's, ten's, hundred's and thousand's positions:
			//Calling radixSingleSort for each digit-position in our values:
			radixSingleSortDescendingIntegers(inputArray, i, radix);
		}
	}
	private void radixSingleSortDescendingIntegers(List<Integer> inputArray, int position, int radix) {
		int numberOfItems = inputArray.size();	
		//Filling the count array:
		int[] countArray = new int[radix];
		for (int numberValue : inputArray) {
			//getDigitIntegers method returns a single digit between 0 to 9:
			countArray[getDigitIntegers(position, numberValue, radix)]++;	
		}
		//Adjusting the count array: By storing how many numbers have a specific digit or less.  
		for (int j = 1; j < radix; j++) {	
			//j starts from 1, skipping first index that represents how many numbers have zero at the position in question:
			countArray[j] += countArray[j - 1];
		}
		//Creating a temporary array and copy the values into it:
		int[] tempArray = new int[numberOfItems];
		//Starting from left to right:
		for (int tempIndex = 0; tempIndex < numberOfItems; tempIndex++) {
			tempArray[--countArray[getDigitIntegers(position, inputArray.get(tempIndex), radix)]] = inputArray.get(tempIndex);
		}
		//Writing values back into the input array:
		for (int tempIndex = 0; tempIndex < numberOfItems; tempIndex++) {
			inputArray.set(tempIndex, tempArray[tempIndex]);
		}
	}
	    
	//A method for Extracting the digit in case of sorting Integers:
	private int getDigitIntegers(int position, int numberValue, int radix) {
		return numberValue / (int) Math.pow(radix, position) % radix;	
	}
	    
	    
	    
	    
	    
	//THE RADIX SORTING IMPLEMENTATION FOR STRINGS:
	public String[] RadixAscendingSortStrings(String[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		String[] copyOfArray = inputArray.clone();
		int radix = 26;	//Radix for Alphabet
		int widthOfString = copyOfArray[0].length();
		//Making the Strings LowerCase:
		for(int i=0; i<copyOfArray.length; i++) { copyOfArray[i] = copyOfArray[i].toLowerCase(); }
		ascendingRadixSorterStrings(copyOfArray, radix, widthOfString);
		return copyOfArray;
	}
	//The Radix LSD Implementation: We consider characters from Right to Left.
	private void ascendingRadixSorterStrings(String[] inputArray, int radix, int width) {
		for (int i = width-1 ; i >= 0 ; i--) {	
			//i will be from 4 to 0, representing various positions in a String:
			//Calling radixSingleSort for each digit-position in our values:
			radixSingleSortAscendingStrings(inputArray, i, radix);
		}
	}
	private void radixSingleSortAscendingStrings(String[] inputArray, int position, int radix) {
		int numberOfItems = inputArray.length;	//It will have all zeros in the beginning
		//Filling the Counting Array:
		int[] countArray = new int[radix];
		for (String stringValue : inputArray) {
			//getIndexStrings method returns a single digit between 0 to 25
			countArray[getIndexStrings(position, stringValue)]++;	
		}
		//Adjusting the count array: By storing how many numbers have a specific digit or less.  
		for (int j = 1; j < radix; j++) {	
			//j starts from 1, skipping first index that represents how many numbers have zero at the position in question:
			countArray[j] += countArray[j - 1];
		}
		//Creating a temporary array and copy the values into it:
		String[] tempArray = new String[numberOfItems];
		//Starting from right to left:
		for (int tempIndex = numberOfItems - 1; tempIndex >= 0; tempIndex--) {
			tempArray[--countArray[getIndexStrings(position, inputArray[tempIndex])]] = inputArray[tempIndex];
		}
		//Writing values back into the input array:
		for (int tempIndex = 0; tempIndex < numberOfItems; tempIndex++) {
			inputArray[tempIndex] = tempArray[tempIndex];
		}
	}

	  //The Radix LSD Implementation: We consider characters from Right to Left.
	public String[] RadixDescendingSortStrings(String[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		String[] copyOfArray = inputArray.clone();
		int radix = 26;	//Radix for Alphabet
		int widthOfString = copyOfArray[0].length();
		//Making the Strings LowerCase:
		for(int i=0; i<copyOfArray.length; i++) { copyOfArray[i] = copyOfArray[i].toLowerCase(); }
		descendingRadixSorterStrings(copyOfArray, radix, widthOfString);
		return copyOfArray;
	}
    private void descendingRadixSorterStrings(String[] inputArray, int radix, int width) {
    	for (int i = width-1 ; i >= 0 ; i--) {	
    		//i will be from 4 to 0, representing various positions in a String:
    		//Calling radixSingleSort for each digit-position in our values:
    		radixSingleSortDescendingStrings(inputArray, i, radix);
    	}
    }
    private void radixSingleSortDescendingStrings(String[] inputArray, int position, int radix) {
    	int numberOfItems = inputArray.length;	//It will have all zeros in the beginning
    	//Filling the count array:
    	int[] countArray = new int[radix];
    	for (String stringValue : inputArray) {
    		//getIndexStrings method returns a single digit between 0 to 25
    		countArray[radix - 1 - getIndexStrings(position, stringValue)]++;	
    	}
    	//Adjusting the count array: By storing how many numbers have a specific digit or less.  
    	for (int j = 1; j < radix; j++) {	
    		//j starts from 1, skipping first index that represents how many numbers have zero at the position in question:
    		countArray[j] += countArray[j - 1];
    	}
    	//Creating a temporary array and copy the values into it:
    	String[] tempArray = new String[numberOfItems];
    	//Starting from left to right:
    	for (int tempIndex = 0; tempIndex < numberOfItems; tempIndex++) {
    		tempArray[--countArray[getIndexStrings(position, inputArray[tempIndex])]] = inputArray[tempIndex];
    	}
    	//Writing values back into the input array:
    	for (int tempIndex = 0; tempIndex < numberOfItems; tempIndex++) {
    		inputArray[numberOfItems - tempIndex - 1] = tempArray[tempIndex];
    	}
    }  
	
    //A method for Extracting the digit in case of sorting Strings:
	private int getIndexStrings(int position, String stringValue) {
		//This will return the alphabetical order of the letter. 
		//'a' will be at position zero in the counting array, 'b' will be at position one and so on ...
		return stringValue.charAt(position) - 'a';		
	}
	
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printStringArray(String[] stringArray) {
		for (int i = 0; i < stringArray.length; ++i) {
			System.out.print(stringArray[i] + "\t");
		}
	}
	
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
	}
}
