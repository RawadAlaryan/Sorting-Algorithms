# Sorting-Algorithms

### Table of Contents:
- [Description](#description)
- [Technologies](#technologies)
- [Fundamentals of Sorting Algorithms](#fundamentals-of-Sorting-Algorithms)
- [Implementations of Sorting Algorithms](#implementations-of-Sorting-Algorithms)
- [Test Cases For Sorting Algorithms:](#test-cases-For-Sorting-Algorithms)
- [Author Info](#author-info)


### Description:
This repository contains info about Sorting Algorithms Fundamentals and their Implementation in Java Programming Language.


### Technologies:
- Oracle Java SE API
- Apache Maven
- Eclipse IDE


### Fundamentals of Sorting Algorithms:
#### Definition of a Sorting Algorithm:
A Sorting Algorithm is an algorithm that puts elements of a Collection (array, list, ...) in a certain order.
<ul>
    <li>If they are Numbers, then we do numerical ordering.</li>
    <li>If they are Strings, Characters, then we do alphabetical ordering.</li>
</ul>


#### Types of Sorting Algorithms:
**1. Comparison Based Sorting Algorithms:**<br/> 
We use comparison to sort the items. <i>Examples:</i> Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort.<br/>
**2. Non-Comparison Based Sorting Algorithms:**<br/><br/> 
We do not use comparison to sort the items. <i>Examples:</i> Radix Sort, Bucket Sort.<br/>


#### Sorting Algorithms Terms:
**Time complexity:**<br/>
It quantifies the amount of time taken by an algorithm to run as a function of the length of the input.<br/>


**Space Complexity:**<br/>
It quantifies the amount of space or memory taken by an algorithm to run as a function of the length of the input.<br/>


**Inplace Sorting Algorithm:**<br/> 
An In-place sorting algorithm needs only O(1) space/memory beyond the items being sorted. So an in place algorithm does not need any extra memory. An Inplace algorithm will not allocate any extra memory like a temporary array in order to make the sorting.<br/>
<i>Example of In-place Sorting Algorithms:</i> Bubble Sort, Comb Sort, Selection Sort, Insertion Sort, Heap Sort and Shell Sort.<br/>
<i>Example of Out-of-place Sorting Algorithms:</i> Merge Sort: We need some extra memory to sort the items.<br/>	
	
	
**Recursive Sorting Algorithms:**<br/> 
Some Sorting Algorithms are implemented in a recursive manner - especially: Divide and Conquer Recursive Algorithms.<br/>
<i>Example:</i> Merge Sort and Quick Sort.


**Stable Sorting Algorithms:**<br/> 
A Stable Sorting Algorithm maintains the relative order of items whose values are equal.<br/>
<i>Example of Stable Algorithms:</i> Merge Sort.<br/>


**Unstable Sorting Algorithms:**<br/> 
An Unstable Sorting Algorithm does not maintain the relative order of items whose values are equal.<br/>
<i>Example of Unstable Algorithms:</i> Quick Sort.<br/>


**Adaptive Sorting Algorithms:**<br/>
An Adaptive Algorithm is an algorithm that changes its behavior based on information available at runtime. Adaptive Algorithms are used in Numerical Methods. They take advantage of existing order in its input and perform better if the input is partially sorted!
It benefits from local ordering when an unsorted array contains sequences "sorted subArray" that are sorted by default. The algorithms will sort faster! We can modify an existing Sorting Algorithms to make it an Adaptive Sorting Algorithms. Adaptive Algorithms can be used in Comparison-Based-Sorting Algorithms to improve running time complexity from O(N log N) to reach O(N).
The more pre-sorted the input is, the faster it should be sorted using Adaptive Sorting.<br/>
<i>Example of Adaptive Sorting Algorithms:</i> Bubble Sort, Insertion Sort, Quick Sort, Shell Sort.
<i>Example of Non-Adaptive Sorting Algorithms:/<i> Heap Sort, Merge Sort, Selection Sort.
	

**Deterministic and Non-Deterministic Algorithms:**<br/>
Deterministic Algorithm: It has in every step only one choice, how to progress. 
Non-deterministic Algorithm: It has more possible choices. As an example can serve the deterministic and the non-deterministic finite automaton.


**Serial, Parallel and Distributed Algorithms:**<br/>
<b>Serial Algorithm:</b> Performs all its steps one by one. 
<b>Parallel Algorithm:</b> Performs more steps at the same time.
<b>Distributed Algorithm:</b> Performs more steps at the same time on different machines.


**Hybrid Sorting Algorithms:**<br/>
A Hybrid Sorting Algorithm combines more sorting algorithms to solve a given problem. 
It chooses one algorithm depending on the data or switching between them over the course of the algorithm.
It combines desired features of each algorithm, so that the overall algorithm is better than the individual algorithms.


### Implementations of Sorting Algorithms:     
#### Comparison-Based Sorting Algorithms:
- [Bogo Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BogoSortingAlgorithm.java)<br/>
- [Stooge Sort.](/src/main/java/comparisonBasedSortingAlgorithms/StoogeSortingAlgorithm.java)<br/>
- [Sleep Sort.](/src/main/java/comparisonBasedSortingAlgorithms/SleepSortingAlgorithm.java)<br/>
- [Bubble Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BubbleSortingAlgorithm.java)<br/>
- [Odd-Even Sort.](/src/main/java/comparisonBasedSortingAlgorithms/OddEvenSortingAlgorithm.java)<br/>
- [Comb Sort.](/src/main/java/comparisonBasedSortingAlgorithms/CombSortingAlgorithm.java)<br/>
- [Cocktail Sort.](/src/main/java/comparisonBasedSortingAlgorithms/CocktailSortingAlgorithm.java)<br/>
- [Slection Sort.](/src/main/java/comparisonBasedSortingAlgorithms/SlectionSortingAlgorithm.java)<br/>
- [Insertion Sort.](/src/main/java/comparisonBasedSortingAlgorithms/InsertionSortingAlgorithm.java)<br/>
- [Binary Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BinarySortingAlgorithm.java)<br/>
- [Shell Sort.](/src/main/java/comparisonBasedSortingAlgorithms/ShellSortingAlgorithm.java)<br/>
- [Quick Sort.](/src/main/java/comparisonBasedSortingAlgorithms/QuickSortingAlgorithm.java)<br/>
- [Merge Sort.](/src/main/java/comparisonBasedSortingAlgorithms/MergeSortingAlgorithm.java)<br/>
- [Heap Sort.](/src/main/java/comparisonBasedSortingAlgorithms/HeapSortingAlgorithm.java)<br/>

[Back To The Top](#Sorting-Algorithms)
      
      
      
#### Non-Comparison-Based Sorting Algorithms:


[Back To The Top](#Sorting-Algorithms)



#### Test Cases For Sorting Algorithms:
- [Bogo Sort Test.](/src/test/java/BogoSortingAlgorithmTest.java)<br/>
- [Stooge Sort Test.](/src/test/java/StoogeSortingAlgorithmTest.java)<br/>


[Back To The Top](#Sorting-Algorithms)



### Author Info:
- [My LinkedIn](https://www.linkedin.com/in/rawad-alaryan-26a816131/)
- [My Github](https://github.com/RawadAlaryan)

[Back To The Top](#Sorting-Algorithms)
