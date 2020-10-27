package com.twoPointerApproach;

import java.util.*;
// Find all unique triplets in the array which gives the sum of zero.
//
// Time Complexity O(n^2)
// SpaceComplexity O(logn) (based on sorting algorithm used)
// Declare a set
// Sort the array
// start with one loop (say i) which selects the first number 'a' from sorted array
// then declare two variables say 'r' and 'j'
// j(left pointer) will point to i+1 index and r(right pointer) will point to last index of the sorted array
// array[j] will denote second number say 'b'
// array[r] will denote third number say 'c'
// start the second while loop and run until j(left pointer) crosses right one i.e j < r
// sum = array[i]+array[j]+array[r]
// if sum equals Zero
//      then store these numbers as list in the set
// else if sum < 0
//      move the left pointer forward i.e j++
// else
//     move the right pointer backward or say towards j i.e r--
//     Since sum > 0 and the array is already sorted(ascending order), so if 'r' moves towards 'j'
//     sum could minimize.
public class Main {
    static List<List<Integer>> threeSum(int[] nums){
        if(nums.length < 3) return new ArrayList<>();

            Set<List<Integer>> set = new HashSet<List<Integer>>();
            Arrays.sort(nums);// Quick sort
            int n = nums.length;
            for(int i=0;i<n-2;i++){
                int left = i+1;
                int right = n-1;
                while (left<right){
                    int sum = nums[i]+nums[left]+nums[right];
                    if(sum==0)
                        set.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                    else if(sum > 0)
                        right--;
                    else
                        left++;
                }
            }

         return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
