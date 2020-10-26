package com.bruteForce;

import java.util.*;

// O(n^3)
// Unique triplet
// a+b+c=0
public class Main {
    static public List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length -1;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if( (nums[i]+nums[j]+nums[k]) == 0){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums).toString());
    }
}
