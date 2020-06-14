package comparisonBasedSortingAlgorithms;
/**	
HEAP SORTING ALGORITHM:
	Heap Sort Algorithm is a Comparison-based Sorting Algorithm.
	It uses the Heap Data Structure to find the maximum item.
	Heap Sort is slower than Quick Sort, but it has a favorable worst-case O(N.log N) runtime complexity.
	Heap Sort is an In-Place Algorithm (Does not need additional memory), but it is NOT a Stable Sort Algorithm.
	First, we have to construct the Heap itself from the numbers we want to sort, that is O(N) time complexity.
	Then, we keep swapping the root with the last element and maintain the Heap property.
		In case of Max-Heap, the Root is the item with greatest value in the Heap.
		In case of Min-Heap, the Root is the item with smallest value in the Heap.
	After swapping with the Root:
  		We consider the last item to be sorted, no longer part of the Heap Tree.
  		Check whether it is a Valid Heap or not.
	Total Running Time Complexity: O(N.log N) we have to consider N items; and for item we may make some swapping if necessary.	
*/

public class HeapSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("HEAP SORT:");
		HeapSortingAlgorithm<Integer> heapSortingAlgorithm = new HeapSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Heap Sorting:");
		heapSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING HEAP SORT:
		sortedArray = heapSortingAlgorithm.HeapAscendingSort(inputArray);
		System.out.println("\n\nArray After Heap Ascending Sort:");
		heapSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING HEAP SORT:		
		sortedArray = heapSortingAlgorithm.HeapDescendingSort(inputArray);
		System.out.println("\n\nArray After Heap Descending Sort:");
		heapSortingAlgorithm.printArray(sortedArray);	
	}

	//THE HEAP SORTING IMPLEMENTATION: 	
	//For Heap Ascending Sort, We use a Minimum Heap:
	public T[] HeapAscendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		//We Insert the Elements into a Minimum Heap
		MinHeapGeneric<T> minHeap = new MinHeapGeneric<T>(copyOfArray.length); 
		for(int i=0; i<copyOfArray.length; i++) { minHeap.insert(copyOfArray[i]); }
		for (int i=0; i <= minHeap.getCurrentPosition(); i++) {
			@SuppressWarnings("unchecked")
			T tempItem = (T) minHeap.getHeapArray()[0]; 
			copyOfArray[i] = tempItem;
			minHeap.getHeapArray()[0] = minHeap.getHeapArray()[minHeap.getCurrentPosition()-i];
			minHeap.getHeapArray()[minHeap.getCurrentPosition()-i] = tempItem;
			minHeap.fixHeapDown(0, minHeap.getCurrentPosition()-i-1);
		}
		return copyOfArray; 
	}
	 
	//For Heap Descending Sort, We use a Maximum Heap:
	public T[] HeapDescendingSort(T[] inputArray) {
		//Making a Copy of Input Array, so that we Return the Sorted One.
		T[] copyOfArray = (T[]) inputArray.clone();	
		//We Insert the Elements into a Maximum Heap
		MaxHeapGeneric<T> maxHeap = new MaxHeapGeneric<T>(copyOfArray.length); 
		for(int i=0; i<copyOfArray.length; i++) { maxHeap.insert(copyOfArray[i]); }
		for (int i=0; i <= maxHeap.getCurrentPosition(); i++) {
			@SuppressWarnings("unchecked")
			T tempItem = (T) maxHeap.getHeapArray()[0]; 
			copyOfArray[i] = tempItem;
			maxHeap.getHeapArray()[0] = maxHeap.getHeapArray()[maxHeap.getCurrentPosition()-i];
			maxHeap.getHeapArray()[maxHeap.getCurrentPosition()-i] = tempItem;
			maxHeap.fixHeapDown(0, maxHeap.getCurrentPosition()-i-1);
		}
		return copyOfArray; 
	}
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
	
	
	
	@SuppressWarnings("hiding")
	class MaxHeapGeneric <T extends Comparable<T>>{
		//Class Field Members:
		private Object[] heapArray;
		private int currentPosition =  -1;
		private int sizeOfHeap = 0;
		
		//Constructor:
		public MaxHeapGeneric(int size){ this.heapArray = new Object[size]; }
		
		//Getter Methods:
		public Object[] getHeapArray() { return this.heapArray; }
		public int getCurrentPosition() { return this.currentPosition; }	
		
		//THE SIZE METHOD:
		public int getSize() { return this.sizeOfHeap; }
		
		//THE INSERT METHOD:
		public void insert(T item){
			if( isFull() ){ throw new RuntimeException("Heap is Full!"); }
			this.heapArray[++currentPosition] = item;
			fixHeapUp(currentPosition);
			sizeOfHeap++;
		}
		
		//GET MAX ITEM METHOD: Max Item is always in Root which is heapArray[0]
		public T removeMaxItem(){
			@SuppressWarnings("unchecked")
			T maxItem = (T)heapArray[0];
			this.heapArray[0] = heapArray[currentPosition--];
			this.heapArray[currentPosition+1] = null;
			fixHeapDown(0,-1);
			sizeOfHeap--;
			return maxItem;
		}
		
		//THE HEAPSORT METHOD:
		public void descendingHeapSort() {
			for (int i=0; i <= currentPosition; i++) {
				@SuppressWarnings("unchecked")
				T temp = (T)heapArray[0]; 
				System.out.print(temp + ", ");
				this.heapArray[0] = this.heapArray[currentPosition-i];
				this.heapArray[currentPosition-i] = temp;
				fixHeapDown(0, currentPosition-i-1);
			}
		}
		
		//THE FIX-HEAP-UP METHOD:
		@SuppressWarnings("unchecked")
		public void fixHeapUp(int currentIndex) {
			int parentIndex = (currentIndex-1)/2;
			T parentItem = (T)heapArray[parentIndex];
			T currentItem = (T)heapArray[currentIndex];
			while( parentIndex >= 0 && (parentItem.compareTo(currentItem) < 0)){
				T temp = currentItem;
				heapArray[currentIndex] = heapArray[parentIndex];
				heapArray[parentIndex] = temp;
				currentIndex = parentIndex;
				parentIndex = (currentIndex-1)/2;
				//Updating Items for Next Comparison:
				parentItem = (T)heapArray[parentIndex];
				currentItem = (T)heapArray[currentIndex];
			}
		}
			
		//THE FIX-HEAP-DOWN METHOD:
		@SuppressWarnings("unchecked")
		public void fixHeapDown(int index, int uptoIndex) {
			if( uptoIndex < 0 ) { uptoIndex = currentPosition; }
			while( index <= uptoIndex ){
				int leftChildIndex = 2*index+1;
				int rightChildIndex = 2*index+2;
				int childToSwapIndex;
				if(leftChildIndex <= uptoIndex) {
					if( rightChildIndex > uptoIndex ){ childToSwapIndex = leftChildIndex; }
					else{ 
						T leftChildItem = (T)heapArray[leftChildIndex];
						T rightChildItem = (T)heapArray[rightChildIndex];
						if(leftChildItem.compareTo(rightChildItem) > 0) { childToSwapIndex = leftChildIndex; }
						else { childToSwapIndex = rightChildIndex; }
					}
					T currentItem = (T)heapArray[index];
					T childToSwapItem = (T)heapArray[childToSwapIndex];
					if(currentItem.compareTo(childToSwapItem) < 0){
						T temp = (T)heapArray[index];
						heapArray[index] = heapArray[childToSwapIndex];
						heapArray[childToSwapIndex] = temp;
					}
					else { break; }
					index = childToSwapIndex;
				}
				else { break; }
			}
		}
		
		//THE ISFULL METHOD:
		private boolean isFull() { return this.currentPosition == this.heapArray.length; }
	}
	
	
	
	
	@SuppressWarnings("hiding")
	class MinHeapGeneric <T extends Comparable<T>>{
		//Class Field Members:
		private Object[] heapArray;
		private int currentPosition =  -1;
		private int sizeOfHeap = 0;
			
		//Constructor:
		public MinHeapGeneric(int size){ this.heapArray = new Object[size]; }

		//Getter Methods:
		public Object[] getHeapArray() { return this.heapArray; }
		public int getCurrentPosition() { return this.currentPosition; }
		
		//THE SIZE METHOD:
		public int getSize() { return this.sizeOfHeap; }
			
		//THE INSERT METHOD:
		public void insert(T item){
			if( isFull() ){ throw new RuntimeException("Heap is Full!"); }
			heapArray[++currentPosition] = item;
			fixHeapUp(currentPosition);
			sizeOfHeap++;
		}
			
		//GET MAX ITEM METHOD: Max Item is always in Root which is heapArray[0]
		public T removeMinItem(){
			@SuppressWarnings("unchecked")
			T minItem = (T)heapArray[0];
			heapArray[0] = heapArray[currentPosition--];
			heapArray[currentPosition+1] = null;
			fixHeapDown(0,-1);
			sizeOfHeap--;
			return minItem;
		}
			
		//THE HEAPSORT METHOD:
		public void ascendingHeapSort() {
			for (int i=0; i <= currentPosition; i++) {
				@SuppressWarnings("unchecked")
				T tempItem = (T) heapArray[0]; 
				System.out.print(tempItem + ", ");
				heapArray[0] = heapArray[currentPosition-i];
				heapArray[currentPosition-i] = tempItem;
				fixHeapDown(0, currentPosition-i-1);
			}
		}
		
		//THE FIX-HEAP-UP METHOD:
		@SuppressWarnings("unchecked")
		public void fixHeapUp(int currentIndex) {
			int parentIndex = (currentIndex-1)/2;
			T parentItem = (T)heapArray[parentIndex];
			T currentItem = (T)heapArray[currentIndex];
			while( parentIndex >= 0 && (parentItem.compareTo(currentItem) > 0)){
				T temp = currentItem;
				heapArray[currentIndex] = heapArray[parentIndex];
				heapArray[parentIndex] = temp;
				currentIndex = parentIndex;
				parentIndex = (currentIndex-1)/2;
				//Updating Items for Next Comparison:
				parentItem = (T)heapArray[parentIndex];
				currentItem = (T)heapArray[currentIndex];
			}
		}
				
		//THE FIX-HEAP-DOWN METHOD:
		@SuppressWarnings("unchecked")
		public void fixHeapDown(int index, int uptoIndex) {
			if( uptoIndex < 0 ) { uptoIndex = currentPosition; }
			while( index <= uptoIndex ){
				int leftChildIndex = 2*index+1;
				int rightChildIndex = 2*index+2;
				int childToSwapIndex;
				if(leftChildIndex <= uptoIndex) {
					if( rightChildIndex > uptoIndex ){ childToSwapIndex = leftChildIndex; }
					else{ 
						T leftChildItem = (T)heapArray[leftChildIndex];
						T rightChildItem = (T)heapArray[rightChildIndex];
						if(leftChildItem.compareTo(rightChildItem) < 0) { childToSwapIndex = leftChildIndex; }
						else { childToSwapIndex = rightChildIndex; }
					}
					T currentItem = (T)heapArray[index];
					T childToSwapItem = (T)heapArray[childToSwapIndex];
					if(currentItem.compareTo(childToSwapItem) > 0){
						T temp = (T)heapArray[index];
						heapArray[index] = heapArray[childToSwapIndex];
						heapArray[childToSwapIndex] = temp;
					}
					else { break; }
					index = childToSwapIndex;
				}
				else { break; }
			}
		}

		private boolean isFull() { return this.currentPosition == this.heapArray.length; }	
	}
}
