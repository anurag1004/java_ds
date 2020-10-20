package com.fibonacci;

import java.util.ArrayList;

// Top to bottom approach using memoization

public class Main {
    ArrayList<Double> memo = new ArrayList<Double>();

    double fib_memo(int n){
        double result;
        if(memo.get(n)!=null){
            return memo.get(n);
        }
        if(n==1||n==2)
            result = 1;
        else{
            result = fib_memo(n-1)+fib_memo(n-2);
        }
        memo.add(n,result);
        return result;
    }
    double fib(int n){
        memo.ensureCapacity(n+1);
        for(int i=memo.size();i<=n;i++)
            memo.add(i,null);
        return fib_memo(n);
    }
    public static void main(String[] args) {
        int n=8;
        Main main = new Main();
        ///////////////////////////////////////

        long startTime = System.nanoTime();
        System.out.println(main.fib(7));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time Taken(ns): "+totalTime);

        ///////////////////////////////////////

        startTime = System.nanoTime();
        System.out.println(main.fib(480));
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Time Taken(ns): "+totalTime);
    }
}
