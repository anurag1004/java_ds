package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] a; // reference of array is created
        a = new int[10]; // all set to zero by default
        // this reference is now pointing to a memory block of size 10*4=40bytes

        //cloning
        int[] b;
        b = a.clone();
        System.out.println(b==a); //false
        for(int x:a){
            //System.out.println(x);
        }

        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
