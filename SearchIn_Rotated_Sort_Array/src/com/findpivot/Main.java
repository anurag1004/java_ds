package com.findpivot;
public class Main {
    // nums[] is a rotated sorted array (ascending)
    static int findPivot(int[] nums, int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=nums[right]) return findPivot(nums, mid+1, right);
            return findPivot(nums, left, mid);
        }
        return left==right?left:-1;
    }
    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findPivot(nums,0,nums.length-1));
    }
}
