# Sorting-Algorithms

### Table of Contents:
- [Description](#description)
- [Technologies](#technologies)
- [Fundamentals of Sorting Algorithms](#fundamentals-of-Sorting-Algorithms)
- [Implementations of Sorting Algorithms](#implementations-of-Sorting-Algorithms)
- [Test Cases For Sorting Algorithms](#test-cases-For-Sorting-Algorithms)
- [Author Info](#author-info)
- [License](LICENSE.md)


### Description:
This repository contains info about Sorting Algorithms Fundamentals and their Implementation in Java Programming Language.<br/>
All code is implemented using Java with Steps and Comments included inside the source classes.<br/>
All code is Tested and Benchmarked using a Testing Framework inside the test package.<br/>
All code is Documented using JavaDoc inside the target package.

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
They combine both types of sorting algorithms to sort the items.<br/> 
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



### Implementations of Sorting Algorithms:     
#### Comparison-Based Sorting Algorithms:
- [Bogo Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BogoSortingAlgorithm.java)
- [Stooge Sort.](/src/main/java/comparisonBasedSortingAlgorithms/StoogeSortingAlgorithm.java)
- [Sleep Sort.](/src/main/java/comparisonBasedSortingAlgorithms/SleepSortingAlgorithm.java)
- [Bubble Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BubbleSortingAlgorithm.java)
- [Odd-Even Sort.](/src/main/java/comparisonBasedSortingAlgorithms/OddEvenSortingAlgorithm.java)
- [Comb Sort.](/src/main/java/comparisonBasedSortingAlgorithms/CombSortingAlgorithm.java)
- [Cocktail Sort.](/src/main/java/comparisonBasedSortingAlgorithms/CocktailSortingAlgorithm.java)
- [Selection Sort.](/src/main/java/comparisonBasedSortingAlgorithms/SelectionSortingAlgorithm.java)
- [Insertion Sort.](/src/main/java/comparisonBasedSortingAlgorithms/InsertionSortingAlgorithm.java)
- [Binary Insertion Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BinaryInsertionSortingAlgorithm.java)
- [Shell Sort.](/src/main/java/comparisonBasedSortingAlgorithms/ShellSortingAlgorithm.java)
- [Quick Sort.](/src/main/java/comparisonBasedSortingAlgorithms/QuickSortingAlgorithm.java)
- [Merge Sort.](/src/main/java/comparisonBasedSortingAlgorithms/MergeSortingAlgorithm.java)
- [Heap Sort.](/src/main/java/comparisonBasedSortingAlgorithms/HeapSortingAlgorithm.java)
- [Patience Sort.](/src/main/java/comparisonBasedSortingAlgorithms/PatienceSortingAlgorithm.java)
- [Cycle Sort.](/src/main/java/comparisonBasedSortingAlgorithms/CycleSortingAlgorithm.java)
- [Strand Sort.](/src/main/java/comparisonBasedSortingAlgorithms/StrandSortingAlgorithm.java)
- [Bitonic Sort.](/src/main/java/comparisonBasedSortingAlgorithms/BitonicSortingAlgorithm.java)
- [Pancake Sort.](/src/main/java/comparisonBasedSortingAlgorithms/PancakeSortingAlgorithm.java)
- [Gnome Sort.](/src/main/java/comparisonBasedSortingAlgorithms/GnomeSortingAlgorithm.java)
- [Tree Sort.](/src/main/java/comparisonBasedSortingAlgorithms/TreeSortingAlgorithm.java)

[Back To The Top](#Sorting-Algorithms)
      
      
      
#### Non-Comparison-Based Sorting Algorithms:
- [Counting Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/CountingSortingAlgorithm.java)
- [Pigeon-Hole Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/PigeonHoleSortingAlgorithm.java)
- [Radix Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/RadixSortingAlgorithm.java)
- [Bucket Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/BucketSortingAlgorithm.java)
- [American-Flag Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/AmericanFlagSortingAlgorithm.java)<br/>
- [Bead Sort.](/src/main/java/nonComparisonBasedSortingAlgorithms/BeadSortingAlgorithm.java)

[Back To The Top](#Sorting-Algorithms)



#### Hybrid-Based Sorting Algorithms:
- [Intro Sort.](/src/main/java/hybridBasedSortingAlgorithms/IntroSortingAlgorithm.java)
- [Tim Sort.](/src/main/java/hybridBasedSortingAlgorithms/TimSortingAlgorithm.java)

[Back To The Top](#Sorting-Algorithms)



#### Test Cases For Sorting Algorithms:
</b>Comparison-Based Sorting Algorithms Testing:</b>
- [Bogo Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/BogoSortingAlgorithmTest.java)
- [Stooge Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/StoogeSortingAlgorithmTest.java)
- [Sleep Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/SleepSortingAlgorithmTest.java)
- [Bubble Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/BubbleSortingAlgorithmTest.java)
- [Odd-Even Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/OddEvenSortingAlgorithmTest.java)
- [Comb Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/CombSortingAlgorithmTest.java)
- [Cocktail Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/CocktailSortingAlgorithmTest.java)
- [Selection Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/SelectionSortingAlgorithmTest.java)
- [Insertion Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/InsertionSortingAlgorithmTest.java)
- [Binary Insertion Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/BinaryInsertionSortingAlgorithmTest.java)
- [Shell Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/ShellSortingAlgorithmTest.java)
- [Quick Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/QuickSortingAlgorithmTest.java)
- [Merge Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/MergeSortingAlgorithmTest.java)
- [Heap Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/HeapSortingAlgorithmTest.java)
- [Patience Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/PatienceSortingAlgorithmTest.java)
- [Cycle Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/CycleSortingAlgorithmTest.java)
- [Strand Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/StrandSortingAlgorithmTest.java)
- [Bitonic Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/BitonicSortingAlgorithmTest.java)
- [Pancake Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/PancakeSortingAlgorithmTest.java)
- [Gnome Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/GnomeSortingAlgorithmTest.java)
- [Tree Sort Test.](/src/test/java/comparisonBasedSortingAlgorithmsTests/TreeSortingAlgorithmTest.java)

</b>Non-Comparison-Based Sorting Algorithms Testing:</b>
- [Counting Sort Test.](/src/test/java/nonComparisonBasedSortingAlgorithmsTests/CountingSortingAlgorithmTest.java)
- [Pigeon-Hole Sort Test.](/src/test/java/nonComparisonBasedSortingAlgorithmsTests/PigeonHoleSortingAlgorithmTest.java)
- [Radix Sort.](/src/test/java/nonComparisonBasedSortingAlgorithmsTests/RadixSortingAlgorithmTest.java)
- [Bucket Sort Test.](/src/test/java/nonComparisonBasedSortingAlgorithmsTests/BucketSortingAlgorithmTest.java)
- [American-Flag Sort Test.](/src/test/java/nonComparisonBasedSortingAlgorithmsTests/AmericanFlagSortingAlgorithmTest.java)
- [Bead Sort Test.](/src/test/java/nonComparisonBasedSortingAlgorithmsTests/BeadSortingAlgorithmTest.java)

</b>Hybrid-Based Sorting Algorithms Testing:</b>
- [Intro Sort Test.](/src/test/java/hybridBasedSortingAlgorithmsTests/IntroSortingAlgorithmTest.java)
- [Tim Sort Test.](/src/test/java/hybridBasedSortingAlgorithmsTests/TimSortingAlgorithmTest.java)	

[Back To The Top](#Sorting-Algorithms)



### Author Info:
- [My LinkedIn](https://www.linkedin.com/in/rawad-alaryan-26a816131/)
- [My Github](https://github.com/RawadAlaryan)

[Back To The Top](#Sorting-Algorithms)
