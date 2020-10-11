package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    static void display(LinkedList<String> linkedList){

        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
            // .size() takes O(n)
            // .get() runs take O(n)[taking worst case for Time Complexity] per iteration
            // one iteration = O(2N)==O(n)
            // for n iterations
            // => O(n^2)
        }
    }
    public static void main(String[] args) {
	    // LinkedList internally uses a doubly linked list to store the elements.
        // Manipulation(add/delete) with LinkedList is faster than ArrayList because it uses a doubly linked list,
        // so no bit shifting is required in memory.
        // LinkedList class can act as a list and queue both because it implements List and Deque interfaces.
        // LinkedList is better for manipulating data.
        LinkedList<String> myLinkedList = new LinkedList<String>(); //constructs an empty list
        myLinkedList.add("Hello");
        myLinkedList.add("World");
        myLinkedList.add(":(");

        display(myLinkedList);
        System.out.println();

        // adding at index
        myLinkedList.add(1,"hahaha");
        display(myLinkedList);
        System.out.println();

        // addFirst
        myLinkedList.addFirst("Meoww");
        // addLast
        myLinkedList.addLast("Meoww");

        display(myLinkedList);

        System.out.println("\nEnhanced For Loop");

        // enhanced for-loop
        for(String temp:myLinkedList){
            System.out.println(temp);
        }

        // For efficiency use iterators in LinkedList
        System.out.println("\nUsing Iterators");
        Iterator<String> iterator = myLinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
