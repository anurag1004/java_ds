package com.company;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        Hashtable<Integer,Character> h1 = new Hashtable<Integer, Character>();
        //insertion order is not maintained here
        h1.put(101,'h');
        h1.put(102,'e');
        h1.put(103,'l');
        h1.put(105,'l');
        h1.put(110,'o');
        System.out.println(h1.toString());
        //iterating over Hashtable
//        Enumeration e1 = h1.keys();
//        while(e1.hasMoreElements()){
//            Integer key = (Integer) e1.nextElement();
//            System.out.println(key+" : "+h1.get(key));
//        }

        //checking for a particular key
        if(h1.containsKey(102)){
            System.out.println("Key 102 present!");
        }
        // this method is expensive compared to .containsKey()
        if(h1.containsValue('l')){ // h1.contains()
            System.out.println("l is present!");
        }
        // cloning
        Hashtable<Integer,Character> h2;
        h2 = (Hashtable<Integer, Character>) h1.clone();
        System.out.println(h1==h2);

        System.out.println(h1.get(10)); //null

        Hashtable<Integer,Character> h3 = new Hashtable<Integer,Character>();
        h3.putAll(h1);
        System.out.println(h3==h1); //false

        //removing
        // Object remove(Object key)
        // remove key with its value
        // if no key is found then null is returned
        // else returns the removed value

        Character temp = h3.remove(101); // temp = 'h'
        System.out.println(h3.toString());
        temp = h3.remove(1011); // temp = null
        System.out.println(temp);
        System.out.println(h3.toString());
        try{
            // remove() throws NullPointerException if key is  null or value is null
            // in case of HashMap, value with null key or key as null can be inserted
            h3.put(null,'p');   // here in Hashtable u cannot insert a value with null key
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        System.out.println(h3.get(105));

        // example of HashMap
        // un-synchronized
        // allows null keys or values
        // doesn't maintains order
        HashMap<Integer,Character> hashMap = new HashMap<Integer, Character>();
        hashMap.put(1001,'p');
        hashMap.put(1010,'q');
        hashMap.put(1005,'r');
        hashMap.put(1002,'s');
        System.out.println(hashMap.toString()); // {1010=q, 1001=p, 1002=s, 1005=r}
    }
}
