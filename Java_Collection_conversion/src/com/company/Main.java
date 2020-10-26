package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<Integer>();
        List<Integer> myList = new ArrayList<Integer>();
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);

        List<Character> myList2 = Arrays.asList('a','b','c');
        System.out.println(myList2);

        // list elements to string
        StringBuilder str = new StringBuilder();
        for(Character c:myList2)
            str.append(c);
        System.out.println(str.toString());

        // list to array
        Character[] charArr = myList2.toArray(new Character[0]);
//        Note: toArray() method returns an array of type Object(Object[]).
//        We need to typecast it to Integer before using as Integer objects

        // converting array to list
        Integer[] arr = {1,2,2,3,4,5};
        List<Integer> mylist3 = Arrays.asList(arr);
        List<Integer> mylist4  = new ArrayList<>();
        Collections.addAll(mylist4,arr); //copying arr to mylist4
        System.out.println(mylist4.toString());

        // converting list to set
        Set<Integer> set = new HashSet<Integer>(mylist4);
        System.out.println(set);

        // converting set to list
        List<Integer> mylist5 = new ArrayList<Integer>(set);
        System.out.println(mylist5.toString());
        Integer[] arr2 = {5,4,3,2,2,1};
        Set<List<Integer>> set2 = new HashSet<List<Integer>>();
        set2.add(Arrays.asList(arr));
        set2.add(Arrays.asList(arr2));
        System.out.println(set2);
    }
}
