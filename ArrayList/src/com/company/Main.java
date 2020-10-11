package com.company;

import java.util.ArrayList;
import java.util.List;
// ArrayLists
// They are un-synchronized i.e multiple threads can access it
// Faster then Vectors
// Only iterators can be used for traversing

public class Main {
    // static variable can not be declared as local var
    static void display(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            System.out.printf("%d, ",arr.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 10;
//        Java ArrayList class uses a dynamic array for storing the elements. It is like an array, but there is no size limit.
//        We can add or remove elements anytime. So, it is much more flexible than the traditional array.
//        It is found in the java.util package. It is like the Vector in C++.
//        It inherits the AbstractList class and implements List interface.
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n);

        for(int i=0;i<10;i++){
            arrayList.add(i);
        }
        display(arrayList);
        arrayList.remove(0); //removes ith index
        display(arrayList);
        // insert at index 1
        arrayList.add(1,10);
        display(arrayList);

        // List //
        System.out.println("LIST");
        // Since List is an interface, it can be used only with a class that implements this interface
        // ArrayList<E>(capacity)
        //  ArrayList capacity is the maximum number of elements it can hold without resizing the internal array.
        //  The size of ArrayList is the number of elements it currently has
        //  default capacity is zero until an element is added
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        //  Changing elements
        arrayList.set(0,112);
        display(arrayList);

//        ArrayList internally uses a dynamic array to store the elements.
//        Manipulation with ArrayList is slow because it internally uses an array.
//        If any element is removed from the array, all the bits are shifted in memory.
//        An ArrayList class can act as a list only because it implements List only.
//        ArrayList is better for storing and accessing data.
    }
}
