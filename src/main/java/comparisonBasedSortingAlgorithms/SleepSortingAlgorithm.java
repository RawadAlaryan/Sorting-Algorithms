package comparisonBasedSortingAlgorithms;

import java.util.concurrent.CountDownLatch;

/**
SLEEP SORTING ALGORITHM:	
	Sleep Sort only works on Positive Numerical Values: integers, floats and doubles. Not on Strings and characters.
	Sleep Sort assigns a distinct Thread for every item/number in the input array.
	It uses thread.sleep(long milliseconds) on the threads to control the sorting and yielding with the numerical ordering.
	It uses the numerical value of each item as a sleeping duration for the item's thread.
	Items with lower numerical values are going to wake up first.
	It is not a deterministic algorithm, we because we do not know how the OS is going to schedule these threads with the OS optimization methods.
	It is very Inefficient and slow. It has no practical use in sorting.
*/
public class SleepSortingAlgorithm {

	public static void main(String[] args) throws Exception {
		System.out.println("SLEEP SORT:");
		SleepSortingAlgorithm sleepSortingAlgorithm = new SleepSortingAlgorithm();
		
		Number[] inputArrayForSleepSort = {34, 3, 150, 25, 77, 60, 0, 41, 17};
		System.out.println("Array Before Sleep Sorting:");
		sleepSortingAlgorithm.printNumberArray(inputArrayForSleepSort);
		
		//ASCENDING SLEEP SORT:
		Number[] sortedNumberArray = sleepSortingAlgorithm.SleepAscendingSort(inputArrayForSleepSort);
		Thread.sleep(9000);	//Sleeping the Main Method Thread to finish sorting.
		System.out.println("\n\nArray After Sleep Ascending Sort:");
		sleepSortingAlgorithm.printNumberArray(sortedNumberArray);
		
		//DESCENDING SLEEP SORT:
		sortedNumberArray = sleepSortingAlgorithm.SleepDescendingSort(inputArrayForSleepSort);
		Thread.sleep(9000);	//Sleeping the Main Method Thread to finish sorting.
		System.out.println("\n\nArray After Sleep Descending Sort:");
		sleepSortingAlgorithm.printNumberArray(sortedNumberArray);
	}

	private int index;
	//THE SLEEP SORTING IMPLEMENTATION: 	
	public Number[] SleepAscendingSort(Number[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Number[] copyOfArray = inputArray.clone();
		Number[] tempArray = new Number[copyOfArray.length];
		index = 0;
		//Making a CountDownLatch to manage synchronization between Threads.
		final CountDownLatch threadManager = new CountDownLatch(inputArray.length);
		for (Number item : copyOfArray) {
			new Thread(new Runnable() {
				public void run() {
					threadManager.countDown();
					try {
						threadManager.await();
						long itemValue = item.longValue();
						//We multiply itemValue by 50 to use it as sleepingValue for accurate results.
						Thread.sleep(itemValue * 50);
						//Once Thread awakes from sleeping, then add item to sorted array.
						tempArray[index++] = item;
					} catch (InterruptedException ie) { ie.getMessage(); }
				}
			}).start();
		}
		copyOfArray = tempArray;
		return copyOfArray; 
	}	
	
	public Number[] SleepDescendingSort(Number[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		Number[] copyOfArray = inputArray.clone();
		Number[] tempArray = new Number[copyOfArray.length];
		index = 0;
		//Making a CountDownLatch to manage Synchronization between Threads.
		final CountDownLatch threadManager = new CountDownLatch(inputArray.length);
		for (Number item : copyOfArray) {
			new Thread(new Runnable() {
				public void run() {
					threadManager.countDown();
					try {
						threadManager.await();
						long itemValue = item.longValue();
						if(itemValue == 0) { tempArray[tempArray.length-1] = item; }
						else {
							//We multiply by (500/itemValue) to use it as sleepingValue for accurate results.
							Thread.sleep(500/itemValue);
							//Once Thread awakes from sleeping, then add item to sorted array.
							tempArray[index++] = item;
						}
					} catch (InterruptedException ie) { ie.getMessage(); }
				}
			}).start();
		}
		copyOfArray = tempArray;
		return copyOfArray; 
	}
	
	//METHOD FOR PRINTING NUMERICAL ARRAY ELEMENTS: 
	public void printNumberArray(Number[] numberArray) {
		for (int i = 0; i < numberArray.length; ++i) {
			System.out.print(numberArray[i] + "\t");
		}
	}	
}
