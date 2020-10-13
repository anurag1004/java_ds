package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // HashSet //

        // HashSet doesn’t maintain any order, the elements would be returned in any random order.
        // HashSet doesn’t allow duplicates. If you try to add a duplicate element in HashSet, the old value would be overwritten.
        // HashSet allows null values however if you insert more than one nulls it would still return only one null value.
        // HashSet is non-synchronized.
        // The iterator returned by this class is fail-fast which means iterator would throw ConcurrentModificationException
        // if HashSet has been modified after creation of iterator, by any means except iterator’s own remove method.
        // The add, remove, and contains methods has constant time complexity O(1)

        // TreeSet //

        //TreeSet is similar to HashSet except that it sorts the elements in the ascending order while HashSet doesn’t maintain any order
        // non-synchronized
        // doesn't allow null element
        // TreeSet is implemented using a tree structure
        // The elements in a set are sorted, but the add, remove, and contains methods has  time complexity of O(log (n))

        // LinkedHashset //
        // LinkedHashSet is between HashSet and TreeSet. It is implemented as a hash table with a linked list running through it,
        // so it provides the order of insertion. The time complexity of basic methods is O(1).
        // LinkedHashSet maintains the insertion order.
        // Elements gets sorted in the same sequence in which they have been added to the Set.


        HashSet<String> fruits = new HashSet<String>();
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("WaterMelon");
        fruits.add("Mango");
        //add duplicate values
        fruits.add("Apple");

        //add null values
        fruits.add(null);
        fruits.add(null);

        System.out.println(fruits.toString());

        // .clear() //removes all elements
        //  Object clone() //shallow copy
        HashSet<String> fcopy = new HashSet<String>();
        fcopy = (HashSet<String>) fruits.clone();
        System.out.println(fcopy.toString());

        //contains(Object o) // returns tru if obj is present
        System.out.println(fruits.contains("Hello"));

        //deleting
        fcopy.remove("Apple");
        System.out.println(fcopy.toString());

        // iterating
        System.out.println("=================");
        Iterator it = fruits.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=================");
        // for each
        for(String temp : fruits){
            System.out.println(temp);
        }
        fcopy.remove(null);

        //TreeSet
        TreeSet<String> treeSet = new TreeSet<String>();
        for(String temp:fcopy){
            treeSet.add(temp);
        }
        System.out.println(treeSet.toString());// [Mango, Pineapple, WaterMelon]
        treeSet.add("Apple");
        // TreeSet does not preserve the insertion order of elements but elements are sorted by keys.
        System.out.println(treeSet.toString());
        System.out.println(treeSet.first()); // returns first element i.e Apple
        System.out.println(treeSet.last()); // returns last element i.e Watermelon

        //LinkedHashSet
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        linkedHashSet.add(10);
        linkedHashSet.add(12);
        linkedHashSet.add(1);
        linkedHashSet.add(40);
        System.out.println(linkedHashSet.toString()); // [10, 12, 1, 40]

    }
}
