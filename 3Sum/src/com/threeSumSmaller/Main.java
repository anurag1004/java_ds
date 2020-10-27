package com.threeSumSmaller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
        that satisfy the condition nums[i] + nums[j] + nums[k] < target.
        For example, given nums = [-2, 0, 1, 3], and target = 2.
                     Return 2. Because there are two triplets which sums are less than 2:
    [-2, 0, 1]
    [-2, 0, 3]
    Follow up:
    Could you solve it in O(n2) runtime?
    Tags: Array Two Pointers
    Similar Problems:(M) 3Sum, (M) 3Sum Closest
*/
public class Main {
    static int threeSumSmaller(int[] nums,int target){
        if(nums.length < 3) return Integer.MAX_VALUE;
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum<target){
                    count+=r-l;
                    l++;
                }else r--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 4, 7};
//        Below are triplets with sum less than 12
//        (1, 3, 4), (1, 3, 5), (1, 3, 7) and
//        (1, 4, 5)
        System.out.println(threeSumSmaller(nums,12)); // 4
    }
}
