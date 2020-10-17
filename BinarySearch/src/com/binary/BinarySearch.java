package com.binary;

public class BinarySearch {
    private static int search(int[] arr,int low,int high,int key){
        if(low>high) return -1;
        else{
            int mid = (low+high)/2;
            if(arr[mid] == key)
                return mid;
            else if(key<arr[mid])
                return search(arr,low,mid-1,key);
            else
                return search(arr,mid+1,high,key);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,10};
        System.out.println(search(arr,0,arr.length,-7));
    }
}
