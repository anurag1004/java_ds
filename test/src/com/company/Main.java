package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.printf("Hello there %d \n",2020);
        int a = 20;
        short b = 10;
        char ch = 'p';
        String str="abcd";
        short c = (short) (a+b);
        String[] array= {"Taifoor","bandar","bc"};
        char[] array1={'a','b','c','d'};
        for(String x:array){
            System.out.println(x);
        }
        for(char x:array1){
            System.out.print(x+" ");
        }
        System.out.println("\n");
            //cannot iterate over string
            // you declare a variable that is the same type as the base type of the array
            //        for(char x:str){
            //          //this will not work
            //        }
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println(c);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
