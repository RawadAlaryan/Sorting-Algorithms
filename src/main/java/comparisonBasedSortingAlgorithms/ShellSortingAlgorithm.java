package comparisonBasedSortingAlgorithms;
/**
SHELL SORTING ALGORITHM:	
	Shell Sort is a quadratic O(N^2) running time sorting algorithm.
	It is the generalization form of the Insertion Sort.
	With Insertion Sort, we sometimes make lots of shifts/swaps. 
	This feature is not so good, thats why Shell Sort came to be as an enhanced Insertion Sort
	The method starts by sorting pairs of elements far apart from each other.
	Then progressively reducing the gap between elements to be compared.
	Starting with far-apart elements can move some out-of-place elements into position faster than a simple nearest neighbor exchange.
	Shell Sort is heavily dependent on the gap sequence it uses.
	Consider every h-th element in the array, Such a SubArray is said to be h-sorted.
	We use Insertion Sort as a SubProcedure, the only difference is that we start sorting items far away from each other.
	This rearrangement allows elements to move long distances in the original list 		reducing large amounts of disorder quickly
	It is an Unstable Algorithm, it changes the relative order of elements with equal value.
	Because Shell Sort relies heavily on Insertion Sort, It is also an Adaptive Algorithm so runs faster on partially sorted input.
	It is Not a so popular algorithm nowadays.
	There are a lots of articles and models on how to choose the gaps for the best efficiency.
*/	

public class ShellSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("SHELL SORT:");
		ShellSortingAlgorithm<Integer> shellSortingAlgorithm = new ShellSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Shell Sorting:");
		shellSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING SHELL SORT:
		sortedArray = shellSortingAlgorithm.ShellAscendingSort(inputArray);
		System.out.println("\n\nArray After Shell Ascending Sort:");
		shellSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING SHELL SORT:		
		sortedArray = shellSortingAlgorithm.ShellDescendingSort(inputArray);
		System.out.println("\n\nArray After Shell Descending Sort:");
		shellSortingAlgorithm.printArray(sortedArray);	
	}

	//THE SHELL SORTING IMPLEMENTATION: 	
	public T[] ShellAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		//We define the gap (based on size of Input) and reduce it after each iteration. 
		//When gap = 1. It becomes the Insertion Sort.
		//For each SubArray of gap-spaced items, we sort them separately by Insertion Sort. 
		//Last Step: We do Insertion Sort on all the array together, with a few needed swaps.  
		for (int gap=copyOfArray.length/2; gap>0; gap/=2) {
			for (int i=gap; i<copyOfArray.length; i++) {
				T item = copyOfArray[i];
                int j = i;
                //We do a simple Insertion Sort on the SubArray.
                while ((j >= gap) && (copyOfArray[j - gap].compareTo(item) > 0)) {
                	copyOfArray[j] = copyOfArray[j - gap];
                    j = j - gap;
                }
                copyOfArray[j] = item;
            }
        }
		return copyOfArray; 
	}
	
	public T[] ShellDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();		
		//We define the gap and reduce it after each iteration.
		//When gap = 1. It becomes the Insertion Sort. 
		for (int gap=copyOfArray.length/2; gap>0; gap/=2) {
			for (int i=gap; i<copyOfArray.length; i++) {
				T item = copyOfArray[i];
                int j = i;
                //We do a simple Insertion Sort on the SubArray.
                while ((j >= gap) && (copyOfArray[j - gap].compareTo(item) < 0)) {
                	copyOfArray[j] = copyOfArray[j - gap];
                    j = j - gap;
                }
                copyOfArray[j] = item;
            }
        }
		return copyOfArray; 
	}
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}
