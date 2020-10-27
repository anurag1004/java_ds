package com.company;

import java.util.Arrays;

// Two pointer approach
// let target be x
// i -> left
// j-> right
// if nums[i]+nums[j] < x
//   Means all pair from i to j is a valid combination i.e (i,i+1),(i,i+2)...(i,j)
//   so total combinations = j-i
// Time Complexity O(n)
// Space Complexity O(1)
class Main {
    static int twoSumSmaller(int[] nums,int target){
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        int j=n-1;
        int count = 0;
        while (i<j){
            int sum = nums[i]+nums[j];
            if(sum<target){
                count+= j-i;
                i++;
            }else j--;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 9, 10, 11};
        System.out.println(twoSumSmaller(nums,7));
    }
}
