package com.company;

import java.util.*;

public class Main {
   static class The_Comparator implements Comparator<Character> {
        public int compare(Character c1,Character c2){
            return c2.compareTo(c1);
            // highest to lowest
        }
    }
    public static void main(String[] args) {
        // FIFO
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10); //add elements to tail
        queue.add(20);
        queue.add(30);
        System.out.println("Elements contents of queue "+queue);
        // .peek() This method is used to view the head of queue without removing it. It returns Null if the queue is empty.
        System.out.println(queue.peek());
        //remove() This method removes and returns the head of the queue. It throws NoSuchElementException when the queue is empty.
        // .poll This method removes and returns the head of the queue. It returns null when the queue is empty.
        System.out.println(queue.remove());
        System.out.println(queue);

        // Priority Queues
        Queue<String> pqueue = new PriorityQueue<String>();
        pqueue.add("Hello"); //add based on priority
        pqueue.add("There");
        pqueue.add("Arnol");
        System.out.println("Priority Queue "+pqueue);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //poll() This method removes and returns the head of the queue. It returns null if the queue is empty.

        //The PriorityQueue is based on the priority heap

        // PriorityQueue doesn’t permit null.

        //We can’t create PriorityQueue of Objects that are non-comparable

        //PriorityQueue are unbound queues.

        //The head of this queue is the least element with respect to the specified ordering.
        // If multiple elements are tied for least value, the head is one of those elements — ties are broken arbitrarily.

        //Since PriorityQueue is not thread-safe, so java provides PriorityBlockingQueue class that
        // implements the BlockingQueue interface to use in java multithreading environment.

        //The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.

        //It provides O(log(n)) time for add and poll methods.

        //It inherits methods from AbstractQueue, AbstractCollection, Collection and Object class.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        PriorityQueue(int initialCapacity):
//        Creates a PriorityQueue with the specified initial capacity that orders
//        its elements according to their natural ordering.

//        PriorityQueue(int initialCapacity, Comparator<E> comparator):
//        Creates a PriorityQueue with the specified initial capacity that orders
//        its elements according to the specified comparator.

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
        priorityQueue.add('D');
        priorityQueue.add('C');
        priorityQueue.add('B');
        priorityQueue.add('A');
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue);
        System.out.println();
        // iterating over using iterator
        Iterator<Character> it = priorityQueue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        //removing elements
//        System.out.println();
//        while(!priorityQueue.isEmpty()){
//            System.out.println(priorityQueue.poll());
//        }
//        System.out.println(priorityQueue.isEmpty());
        System.out.println("A".compareTo("B")); // A<B => -1
        System.out.println("B".compareTo("A")); // B>A => 1
        PriorityQueue<Character> priorityQueue2 = new PriorityQueue<Character>(new The_Comparator());
        priorityQueue2.add('A');
        priorityQueue2.add('D');
        priorityQueue2.add('C');
        priorityQueue2.add('B');
        System.out.println(priorityQueue2);
        while(!priorityQueue2.isEmpty()){
            System.out.println(priorityQueue2.peek());
            priorityQueue2.poll();
        }
    }
}
