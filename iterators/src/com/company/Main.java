package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    static void display(ArrayList<Integer> arrayList){
//        it points just before the first element in arraylist
        Iterator<Integer> it = arrayList.iterator();
            // Only forward direction iterating is possible.
            // Replacement and addition of new element is not supported by Iterator.
            // .remove() removes the next element
            while(it.hasNext()){
                int i = (Integer) it.next();
                System.out.println(i);
                if(i%3 == 0){
                    it.remove();
                }

            }
    }
    public static void main(String[] args) {
    //It is a universal iterator as we can apply it to any Collection object. By using Iterator, we can perform both read and remove operations.
    // It is improved version of Enumeration with additional functionality of remove-ability of a element.
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            arrayList.add(i*10);
        }
        System.out.println(arrayList);
        display(arrayList);
        System.out.println();
        display(arrayList);

        //  LIST ITERATORS //
        // It is only applicable for List collection implemented classes like arraylist, linkedlist etc.
        // It provides bi-directional iteration.
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        // // Returns true if the iteration has more elements
        //public boolean hasNext();
        //
        //// same as next() method of Iterator
        //public Object next();
        //
        //// Returns the next element index
        //// or list size if the list iterator
        //// is at the end of the list
        //public int nextIndex();
        //
        //// Backward direction
        //
        //// Returns true if the iteration has more elements
        //// while traversing backward
        //public boolean hasPrevious();
        //
        //// Returns the previous element in the iteration
        //// and can throws NoSuchElementException
        //// if no more element present
        //public Object previous();
        //
        //// Returns the previous element index
        ////  or -1 if the list iterator is at the
        //// beginning of the list
        //public int previousIndex();
        //
        //// same as remove() method of Iterator
        //public void remove();
        //
        //// Replaces the last element returned by
        //// next() or previous() with the specified element
        //public void set(Object obj);
        //
        //// Inserts the specified element into the list at
        //// position before the element that would be returned
        //// by next(),
        //public void add(Object obj);
        ListIterator<Integer>  lit  = linkedList.listIterator();
        System.out.println(linkedList);
        while(lit.hasNext()){
            lit.next();
            lit.set(10);
            break;
        }
        System.out.println();
        lit = linkedList.listIterator(); //pointing again to first element
        while(lit.hasNext()){
            System.out.println(lit.next());
        }
    }
}
