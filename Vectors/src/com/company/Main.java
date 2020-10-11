package com.company;

import java.util.Vector;

public class Main {
    // Vector
    // They are synchronized i.e only one thread can access it at a time
    // Slower then ArrayLists
    // Enumerators and iterators can be used for traversing


    public static void main(String[] args) {
//	    It extends AbstractList and implements List interfaces.
//      It implements Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess interfaces.
//      The directly known subclass is Stack.
        // Creation //
        // Vector<E> v = new Vector<E>(); //creates a default vector of init cap of 10
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);
        System.out.println(vector.size());
        for(Integer x : vector){
            System.out.println(x);
        }
        System.out.println(vector.get(0).compareTo(-10)); // 1(smaller),0(equal),-1(greater)
    }
}
