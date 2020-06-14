package comparisonBasedSortingAlgorithms;
/**	
CYCLE SORTING ALGORITHM:
	Cycle Sort is an In-Place, Unstable Sorting Algorithm. 
	It is a Comparison-Based Sorting Algorithm that is theoretically optimal in terms of the total number of writes to the original array. 
	It is based on the idea that the permutation to be sorted can be factored into cycles, which can individually be rotated to give a sorted result.
	Items are not written in the array, they are pushed out of the way of the action. 
	Each value is either written zero times, if it's already in its correct position, or written one time to its correct position. 
	This matches the minimal number of overwrites required for a completed In-place Sort.
	Minimizing the number of writes is useful when making writes to some huge data set is very expensive, such as with EEPROMs like Flash memory. 
	Where each write reduces the life-span of the memory.	
*/

public class CycleSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("CYCLE SORT:");
		CycleSortingAlgorithm<Integer> cycleSortingAlgorithm = new CycleSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Cycle Sorting:");
		cycleSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING CYCLE SORT:
		sortedArray = cycleSortingAlgorithm.CycleAscendingSort(inputArray);
		System.out.println("\n\nArray After Cycle Ascending Sort:");
		cycleSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING CYCLE SORT:		
		sortedArray = cycleSortingAlgorithm.CycleDescendingSort(inputArray);
		System.out.println("\n\nArray After Cycle Descending Sort:");
		cycleSortingAlgorithm.printArray(sortedArray);
	}

	//THE CYCLE SORTING IMPLEMENTATION: 	
	public T[] CycleAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		int size = copyOfArray.length;
		//Counting number of memory writes: 
        @SuppressWarnings("unused")
		int writes = 0; 
        //Traverse elements and put them in the right place: 
        for (int cycleStart = 0; cycleStart<=size-2; cycleStart++) { 
            //Initialize item as starting point: 
            T item = copyOfArray[cycleStart]; 
            //Find Position where we put the item. We basically count all smaller elements on right side of item. 
            int position = cycleStart; 
            for (int i = cycleStart+1; i<size; i++) { 
                if (copyOfArray[i].compareTo(item) < 0) { position++; } 
            }
            //If item is already in correct position: 
            if (position == cycleStart) { continue; } 
            //Ignore duplicate elements: 
            while (item.equals(copyOfArray[position])) { position += 1; } 
            //Put item to it's right position: 
            if (position != cycleStart) { 
            	T temp = item; 
                item = copyOfArray[position]; 
                copyOfArray[position] = temp; 
                writes++; 
            } 
            //Rotate rest of the cycle: 
            while (position != cycleStart) { 
                position = cycleStart; 
                //Find position where we to put the element: 
                for (int i=cycleStart+1; i<size; i++) { 
                	if (copyOfArray[i].compareTo(item) < 0) { position += 1; }
                }
                //Ignore duplicate elements: 
                while (item.equals(copyOfArray[position])) { position += 1; } 
                //Put item to it's right position: 
                if (!item.equals(copyOfArray[position])) { 
                 	T temp = item; 
                    item = copyOfArray[position]; 
                    copyOfArray[position] = temp; 
                    writes++; 
                } 
            }
        }
        //System.out.println("\nNumber of Write-Operations needed to Cycle Ascending Sort is:\t" + writes);
        return copyOfArray; 
	}

	public T[] CycleDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		int size = copyOfArray.length;
		//Counting number of memory writes: 
        @SuppressWarnings("unused")
		int writes = 0; 
        //Traverse elements and put them in the right place: 
        for (int cycleStart = 0; cycleStart<=size-2; cycleStart++) { 
            //Initialize item as starting point: 
            T item = copyOfArray[cycleStart]; 
            //Find Position where we put the item. We basically count all smaller elements on right side of item. 
            int position = cycleStart; 
            for (int i = cycleStart+1; i<size; i++) { 
                if (copyOfArray[i].compareTo(item) > 0) { position++; } 
            }
            //If item is already in correct position: 
            if (position == cycleStart) { continue; } 
            //Ignore duplicate elements: 
            while (item.equals(copyOfArray[position])) { position += 1; } 
            //Put item to it's right position: 
            if (position != cycleStart) { 
            	T temp = item; 
                item = copyOfArray[position]; 
                copyOfArray[position] = temp; 
                writes++; 
            } 
            //Rotate rest of the cycle: 
            while (position != cycleStart) { 
                position = cycleStart; 
                //Find position where we to put the element: 
                for (int i=cycleStart+1; i<size; i++) { 
                	if (copyOfArray[i].compareTo(item) > 0) { position += 1; }
                }
                //Ignore duplicate elements: 
                while (item.equals(copyOfArray[position])) { position += 1; } 
                //Put item to it's right position: 
                if (!item.equals(copyOfArray[position])) { 
                 	T temp = item; 
                    item = copyOfArray[position]; 
                    copyOfArray[position] = temp; 
                    writes++; 
                } 
            }
        }
        //System.out.println("\nNumber of Write-Operations needed to Cycle Descending Sort is:\t" + writes);
        return copyOfArray; 
	}
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
}