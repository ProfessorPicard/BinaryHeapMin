# Binary Heap Collection
## Introduction
University of Brighton assignment for CI583 - Data Structures and Operating Systems <br>
I have decided for this assignment to use a Binary Heap structure to implement the required specifications. <br>
This codebase is my implementation of it in Java.

## Assignment Objectives
>1. Assess how the choice of data structures and algorithm design
    methods, impacts the performance of programs.
>2. Choose the appropriate data structure and algorithm design
   method for a specified application.
>3. Demonstrate an understanding of the limitations of/merits of an
   operating system as a manager of normally scarce resources.
>4. Describe and propose solutions to issues arising from the
   interactions between system and/ or user level components.
>5. Recognise and address potential security threats to operating
   systems and propose solutions to minimise potentially harmful
   effects.

## Usage

<p>The BinaryHeapMin class is implemented by specifying a type parameter as below. 
Any object that implements the I_NodeElement interface can be used.</p>

> BinaryHeapMin<TYPE> binaryHeap = new BinaryHeapMin<>();


<p>
Objects are automatically sorted from min to max when inserted or removed from the heap. 
The provided key is used for primary sorting and if 2 keys are equal, the objects required createdTimeStamp is used
as secondary sorting.
</p>