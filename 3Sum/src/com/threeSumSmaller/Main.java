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
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target) break;
                if(sum<target) {
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                }else{
                    k--;
                }
            }
        }
        System.out.println(set);
        return set.size();
    }
    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        System.out.println(threeSumSmaller(nums,2));
    }
}
