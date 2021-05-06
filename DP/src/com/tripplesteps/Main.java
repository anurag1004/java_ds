package com.tripplesteps;

public class Main {
    static int count = 0;
    // brute force
    public static void helper(int n){
        if(n<0)
            return;
        if(n==0){
            count++;
            return;
        }
        helper(n-1);
        helper(n-2);
        helper(n-3);
    }
    public static int greedy(int n, int[] memo){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(memo[n]!=0)
            return memo[n];
        memo[n] = greedy(n-1, memo)+greedy(n-2,memo)+greedy(n-3, memo);
        return memo[n];
    }
    public static void main(String[] args) {
        int n = 3;
        helper(n);
        System.out.println(count);
        int[] memo = new int[n+1];
        System.out.println(greedy(n, memo));
    }
}
