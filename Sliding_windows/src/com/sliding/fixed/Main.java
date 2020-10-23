package com.sliding.fixed;
// Given an array of integers of size ‘n’.
// Our aim is to calculate the maximum sum of ‘k’
// consecutive elements in the array.
public class Main {
    static int MaxSum(int[] arr,int n,int k){
        int max_sum = 0;
        // calculate first k element sum
        // This is the first window
        for(int i=0;i<k;i++)
            max_sum+= arr[i];
        int window_sum = max_sum;

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        for(int i=k;i<n;i++){
            window_sum+=arr[i]-arr[i-k];
            max_sum = Math.max(window_sum,max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,-1,8,9,0,2,3};
        System.out.println(MaxSum(arr,arr.length,3));
    }
}
