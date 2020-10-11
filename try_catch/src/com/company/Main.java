package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        for(int x:arr){
            System.out.printf("%d, ",x);
        }
        System.out.println();
        try{
            for(int i=0;i<10;i++){
                System.out.printf("%d, ",arr[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println();
            System.out.println(e.getStackTrace());
        }finally {
            System.out.println("This will always run!");
        }
    }
}
