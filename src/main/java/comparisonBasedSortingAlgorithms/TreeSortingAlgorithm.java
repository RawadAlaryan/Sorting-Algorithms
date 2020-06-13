package main.java.comparisonBasedSortingAlgorithms;

/**
TREE SORTING ALGORITHM:
	Tree Sort is a sorting algorithm based on Binary Search Tree BST data structure. 
	It first creates a binary search tree from the elements of the input list or array.
	Then performs an In-Order Traversal on the created Binary Search Tree to get the elements in sorted order.  	
*/

public class TreeSortingAlgorithm <T extends Comparable<T>> {

	public static void main(String[] args) {
		System.out.println("TREE SORT:");
		TreeSortingAlgorithm<Integer> treeSortingAlgorithm = new TreeSortingAlgorithm<Integer>();
		Integer[] inputArray = {34, -3, 4, 25, 60, -77, 91, 0, -59};
		Integer[] sortedArray;
		
		System.out.println("Array Before Tree Sorting:");
		treeSortingAlgorithm.printArray(inputArray);
		
		//ASCENDING TREE SORT:
		sortedArray = treeSortingAlgorithm.TreeAscendingSort(inputArray);
		System.out.println("\n\nArray After Tree Ascending Sort:");
		treeSortingAlgorithm.printArray(sortedArray);
		
		//DESCENDING TREE SORT:		
		sortedArray = treeSortingAlgorithm.TreeDescendingSort(inputArray);
		System.out.println("\n\nArray After Tree Descending Sort:");
		treeSortingAlgorithm.printArray(sortedArray);	
	}

	//THE TREE SORTING IMPLEMENTATION: 	
  	public T[] TreeAscendingSort(T[] inputArray) {  	
  		T[] copyOfArray = (T[]) inputArray.clone();
  		int size = copyOfArray.length;     
  		//First Creating a BST Structure:
  		BinarySearchTreeGeneric<T> BST = new BinarySearchTreeGeneric<T>(); 
  		//Filling the BST with elements:
  		for(int i=0; i<size; i++) { BST.insert(inputArray[i]); }
  		//Traversing the BST In-Order-Traversal and Filling the SortedArray (CopyOfArray).
  		inOrderTraversal(BST, copyOfArray);
  		return copyOfArray;
  	}
  	private void inOrderTraversal(BinarySearchTreeGeneric<T> BST, T[] copyOfArray) { 
  		if (BST.getRoot() != null) { inOrderTraversal(BST.getRoot(), copyOfArray); } 
  	}
  	private int treeNodeCount = 0;
	private void inOrderTraversal(BinarySearchTreeGeneric<T>.Node<T> node, T[] copyOfArray) {
		if (node.getLeftChild() != null) { inOrderTraversal(node.getLeftChild(), copyOfArray); }
		copyOfArray[treeNodeCount++] = node.getData();
		if (node.getRightChild() != null) { inOrderTraversal(node.getRightChild(), copyOfArray); }
	}
  	
	public T[] TreeDescendingSort(T[] inputArray) {  	
  		T[] copyOfArray = (T[]) inputArray.clone();
  		int size = copyOfArray.length;     
  		//First Creating a BST Structure:
  		BinarySearchTreeGeneric<T> BST = new BinarySearchTreeGeneric<T>(); 
  		//Filling the BST with elements:
  		for(int i=0; i<size; i++) { BST.insert(inputArray[i]); }
  		//Traversing the BST In-Order-Traversal and Filling the SortedArray (CopyOfArray).
  		reversedInOrderTraversal(BST, copyOfArray);
  		return copyOfArray;
  	}
  	private void reversedInOrderTraversal(BinarySearchTreeGeneric<T> BST, T[] copyOfArray) { 
  		if (BST.getRoot() != null) { reversedInOrderTraversal(BST.getRoot(), copyOfArray); } 
  	}
  	private int TreeNodeCount = 0;
	private void reversedInOrderTraversal(BinarySearchTreeGeneric<T>.Node<T> node, T[] copyOfArray) {
		if (node.getRightChild() != null) { reversedInOrderTraversal(node.getRightChild(), copyOfArray); }
		copyOfArray[TreeNodeCount++] = node.getData();
		if (node.getLeftChild() != null) { reversedInOrderTraversal(node.getLeftChild(), copyOfArray); }
	}
	
	//METHOD FOR PRINTING ARRAY ELEMENTS: 
	public void printArray(T[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + "\t");
		}
	}
	
	
	@SuppressWarnings("hiding")
	class BinarySearchTreeGeneric<T extends Comparable<T>> {
		//TreeNode Implementation as Generic Type:
		class Node<T extends Comparable<T>> {
			private T data;		//Used as Key
			private Node<T> leftChild;
			private Node<T> rightChild;

			public Node(T data) { this.data = data; }
			
			public T getData() { return data; }
			public void setData(T data) { this.data = data; }
			public Node<T> getLeftChild() { return leftChild; }
			public void setLeftChild(Node<T> leftChild) { this.leftChild = leftChild; }
			public Node<T> getRightChild() { return rightChild; }
			public void setRightChild(Node<T> rightChild) { this.rightChild = rightChild; }
			public String toString() { return this.data.toString(); }
		}
		
	//BinarySearchTreeGeneric Class:
		//Class Members:
		private Node<T> root;
		private int sizeOfTree;
		
		public int getSize() { return this.sizeOfTree; }
		public Node<T> getRoot() { return this.root; }
		public boolean isRoot (T data) { return root.getData().equals(data); }
		public boolean isLeaf(T data) { return isLeaf(root, data); }
		private boolean isLeaf(Node<T> node, T data) {
		    if(node == null) { return false; }
		    return (node.getLeftChild() == null && node.getRightChild() == null); 
		}

		//THE INSERT METHOD:
		public void insert(T data) {
			if (root == null) { root = new Node<T>(data); } 
			else { insertNode(data, root); }
			sizeOfTree++;
		}
		private void insertNode(T newData, Node<T> node) {
			if (newData.compareTo(node.getData()) < 0) {
				if (node.getLeftChild() != null) { insertNode(newData, node.getLeftChild()); } 
				else { 
					Node<T> newNode = new Node<T>(newData);
					node.setLeftChild(newNode);
				}
			} 
			else {
				if (node.getRightChild() != null) { insertNode(newData, node.getRightChild()); } 
				else { 
					Node<T> newNode = new Node<T>(newData); 
					node.setRightChild(newNode);
				}
			}
		}
	}	
}
