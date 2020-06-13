# Sorting-Algorithms

### Table of Contents:
- [Description](#description)
- [Technologies](#technologies)
- [Fundamentals of Sorting Algorithms](#fundamentals-of-Sorting-Algorithms)
- [Implementations of Sorting Algorithms](#implementations-of-Sorting-Algorithms)
- [Test Cases For Sorting Algorithms:](#test-cases-For-Sorting-Algorithms)
- [Author Info](#author-info)


### Description:
This repository contains info about Sorting Algorithms Fundamentals and their Implementation in Java Programming Language.<br/>
All code is implemented using Java with Steps and Comments included inside the source classes.<br/>
All code is Tested and Benchmarked using a Testing Framework inside the test package.

### Technologies:
- Programming Language: Java SE API
- Development IDE: Eclipse IDE
- Packaging and Building: Apache Maven
- Testing Environment: JUnit 5 Jupiter

### Fundamentals of Sorting Algorithms:
#### Definition of a Sorting Algorithm:
A Sorting Algorithm is an algorithm that puts elements of a Collection (Array, List, Set etc...) in a certain order.
<ul>
    <li>If they are Numbers, then we do numerical ordering.</li>
    <li>If they are Strings, Characters, then we do alphabetical ordering.</li>
</ul>


#### Types of Sorting Algorithms:
**Comparison Based Sorting Algorithms:**<br/> 
They use comparison to sort the items.<br/> 
<b><i>Examples:</i></b> Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort.<br/>

**Non-Comparison Based Sorting Algorithms:**<br/>
They do not use comparison to sort the items.<br/> 
<b><i>Examples:</i></b> Radix Sort, Bucket Sort.<br/>

**Hybrid Based Sorting Algorithms:**<br/>
They use both types to sort the items.<br/> 
<b><i>Examples:</i></b> Intro Sort, Tim Sort.<br/>

#### Sorting Algorithms Terms:
**Time complexity:**<br/>
It quantifies the amount of time taken by an algorithm to run as a function of the length of the input.<br/>


**Space Complexity:**<br/>
It quantifies the amount of space or memory taken by an algorithm to run as a function of the length of the input.<br/>


**Inplace Sorting Algorithm:**<br/> 
An In-place sorting algorithm needs only O(1) space/memory beyond the items being sorted. So an in place algorithm does not need any extra memory. An Inplace algorithm will not allocate any extra memory like a temporary array in order to make the sorting.<br/>
<b><i>Example of In-place Sorting Algorithms:</i></b> Bubble Sort, Comb Sort, Selection Sort, Insertion Sort, Heap Sort and Shell Sort.<br/>
<b><i>Example of Out-of-place Sorting Algorithms:</i></b> Merge Sort: We need some extra memory to sort the items.<br/>	
	
	
**Recursive Sorting Algorithms:**<br/> 
Some Sorting Algorithms are implemented in a recursive manner - especially: Divide and Conquer Recursive Algorithms.<br/>
<b><i>Example:</i></b> Merge Sort and Quick Sort.


**Stable Sorting Algorithms:**<br/> 
A Stable Sorting Algorithm maintains the relative order of items whose values are equal.<br/>
<b><i>Example of Stable Algorithms:</i></b> Merge Sort.<br/>


**Unstable Sorting Algorithms:**<br/> 
An Unstable Sorting AlgorithmÂ does not maintain the relative order of items whose values are equal.<br/>
<b><i>Example of Unstable Algorithms:</i></b> Quick Sort.<br/>


**Adaptive Sorting Algorithms:**<br/>
An Adaptive Algorithm is an algorithm that changes its behavior based on information available at runtime. 
Adaptive Algorithms are used heavily in Numerical Methods. 
They take advantage of existing order in its input and perform better if the input is partially sorted.<br/>
<b><i>Example of Adaptive Sorting Algorithms:</i></b> Bubble Sort, Insertion Sort, Quick Sort, Shell Sort.<br/>
<b><i>Example of Non-Adaptive Sorting Algorithms:</i></b> Heap Sort, Merge Sort, Selection Sort.<br/>
	

**Deterministic and Non-Deterministic Algorithms:**<br/>
<b>Deterministic Algorithm:</b> It has in every step only one choice, how to progress.<br/>
<b>Non-deterministic Algorithm:</b> It has more possible choices. As an example can serve the deterministic and the non-deterministic finite automaton.<br/>


**Serial, Parallel and Distributed Algorithms:**<br/>
<b><i>Serial Algorithm:</i></b> Performs all its steps one by one.<br/>
<b><i>Parallel Algorithm:</i></b> Performs more steps at the same time.<br/>
<b><i>Distributed Algorithm:</i></b> Performs more steps at the same time on different machines.<br/>


**Hybrid Sorting Algorithms:**<br/>
A Hybrid Sorting Algorithm combines more sorting algorithms to solve a given problem. 
It chooses one algorithm depending on the data or switching between them over the course of the algorithm.
It combines desired features of each algorithm, so that the overall algorithm is better than the individual algorithms.<br/>


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
- [Binary Insertion Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BinaryInsertionSortingAlgorithm.java)<br/>
- [Shell Sort.](/src/main/java/comparisonBasedSortingAlgorithms/ShellSortingAlgorithm.java)<br/>
- [Quick Sort.](/src/main/java/comparisonBasedSortingAlgorithms/QuickSortingAlgorithm.java)<br/>
- [Merge Sort.](/src/main/java/comparisonBasedSortingAlgorithms/MergeSortingAlgorithm.java)<br/>
- [Heap Sort.](/src/main/java/comparisonBasedSortingAlgorithms/HeapSortingAlgorithm.java)<br/>
- [Patience Sort.](/src/main/java/comparisonBasedSortingAlgorithms/PatienceSortingAlgorithm.java)<br/>
- [Cycle Sort.](/src/main/java/comparisonBasedSortingAlgorithms/CycleSortingAlgorithm.java)<br/>
- [Strand Sort.](/src/main/java/comparisonBasedSortingAlgorithms/StrandSortingAlgorithm.java)<br/>
- [Bitonic Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BitonicSortingAlgorithm.java)<br/>
- [Pancake Sort.](/src/main/java/comparisonBasedSortingAlgorithms/PancakeSortingAlgorithm.java)<br/>
- [Gnome Sort.](/src/main/java/comparisonBasedSortingAlgorithms/GnomeSortingAlgorithm.java)<br/>
- [Tree Sort.](/src/main/java/comparisonBasedSortingAlgorithms/TreeSortingAlgorithm.java)<br/>

[Back To The Top](#Sorting-Algorithms)
      
      
      
#### Non-Comparison-Based Sorting Algorithms:
- [Counting Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/CountingSortingAlgorithm.java)<br/>
- [PigeonHole Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/PigeonHoleSortingAlgorithm.java)<br/>
- [Radix Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/RadixSortingAlgorithm.java)<br/>
- [Bucket Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/BucketSortingAlgorithm.java)<br/>
- [AmericanFlag Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/AmericanFlagSortingAlgorithm.java)<br/>
- [Bead Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/BeadSortingAlgorithm.java)<br/>

[Back To The Top](#Sorting-Algorithms)



#### Hybrid-Based Sorting Algorithms:
- [Intro Sort.](/src/main/java/hybridBasedSortingAlgorithms/IntroSortingAlgorithm.java)<br/>
- [Tim Sort.](/src/main/java/hybridBasedSortingAlgorithms/TimSortingAlgorithm.java)<br/>

[Back To The Top](#Sorting-Algorithms)



#### Test Cases For Sorting Algorithms:
- [Bogo Sort Test.](/src/test/java/BogoSortingAlgorithmTest.java)<br/>
- [Stooge Sort Test.](/src/test/java/StoogeSortingAlgorithmTest.java)<br/>
- [Sleep Sort Test.](/src/test/java/SleepSortingAlgorithmTest.java)<br/>
- [Bubble Sort Test.](/src/test/java/BubbleSortingAlgorithmTest.java)<br/>
- [Odd-Even Sort Test.](/src/test/java/OddEvenSortingAlgorithmTest.java)<br/>
- [Comb Sort Test.](/src/test/java/CombSortingAlgorithmTest.java)<br/>
- [Cocktail Sort Test.](/src/test/java/CocktailSortingAlgorithmTest.java)<br/>
- [Slection Sort Test.](/src/test/java/SlectionSortingAlgorithmTest.java)<br/>
- [Insertion Sort Test.](/src/test/java/InsertionSortingAlgorithmTest.java)<br/>
- [Binary Insertion Sort Test.](/src/test/java/BinaryInsertionSortingAlgorithmTest.java)<br/>
- [Shell Sort Test.](/src/test/java/ShellSortingAlgorithmTest.java)<br/>
- [Quick Sort Test.](/src/test/java/QuickSortingAlgorithmTest.java)<br/>
- [Merge Sort Test.](/src/test/java/MergeSortingAlgorithmTest.java)<br/>
- [Heap Sort Test.](/src/test/java/HeapSortingAlgorithmTest.java)<br/>
- [Patience Sort Test.](/src/test/java/PatienceSortingAlgorithmTest.java)<br/>
- [Cycle Sort Test.](/src/test/java/CycleSortingAlgorithmTest.java)<br/>
- [Strand Sort Test.](/src/test/java/StrandSortingAlgorithmTest.java)<br/>
- [Bitonic Sort Test.](/src/test/java/BitonicSortingAlgorithmTest.java)<br/>
- [Pancake Sort Test.](/src/test/java/PancakeSortingAlgorithmTest.java)<br/>
- [Gnome Sort Test.](/src/test/java/GnomeSortingAlgorithmTest.java)<br/>
- [Tree Sort Test.](/src/test/java/TreeSortingAlgorithmTest.java)<br/>

[Back To The Top](#Sorting-Algorithms)



### Author Info:
- [My LinkedIn](https://www.linkedin.com/in/rawad-alaryan-26a816131/)
- [My Github](https://github.com/RawadAlaryan)

[Back To The Top](#Sorting-Algorithms)
