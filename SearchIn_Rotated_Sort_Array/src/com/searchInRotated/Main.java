package com.searchInRotated;

public class Main {
    static int findPivot(int[] nums, int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]) return findPivot(nums, mid+1,right);
            return findPivot(nums, left, mid);
        }
        return left==right?left:-1;
    }
    static int search(int[] nums, int start, int end, int target){
        if(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target) return mid;
            if(target<nums[mid]) return search(nums, start, mid-1,target);
            return search(nums,mid+1,end,target);
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {5,6,7,0,1,2,4};
        int n = nums.length;
        int target = 7;
        int pivot = findPivot(nums, 0, n-1);
        int i;
        if(pivot!=-1){
            if(target>=nums[pivot] && target<=nums[n-1]) i = search(nums,pivot,n-1,target);
            else {
                i = search(nums,0,pivot,target);
            }
            System.out.println("Index "+i);
        }
    }
}
