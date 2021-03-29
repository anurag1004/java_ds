package com.missingNumbers;
import java.util.*;
public class MissingNumbers {
    static List<Integer> findMissingNumbers(int[] nums){
        // since all the numbers are in the range [1...n], where n is the size of array
        // so, if I iterate over the nums array...and at each index if i subract 1 from its value
        // i'll get the corresponding index of that particular element
        // Mark that index value with a negative one.
        // the index with positive value will be missing element,, just add 1 to it.
        //  [1,4,2,2]
        /*
        *   i=0                    i=1            i=2              i=3
        *   nums[i] = mod(1)       4                2               -2 = mod(-2)=2
        *   j = nums[i]-1=0        4-1=3            2-1=1            2-1=1
        *   nums[j] = -nums[j]     [3]=-[3]=-2      [1]=-[1]=-4      [1] is already marked
        *
        *   [-1,4,2,2]             [-1,4,2,-2]      [-1,-4,2,-2]     [-1,-4,2,-2]
        *
        * From the final array, we can see that the 2nd index is positive, which means 3 is the missing element
        * */
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j = Math.abs(nums[i])-1;
            nums[j] = nums[j]<0?nums[j]:-1*nums[j];
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0) missingNumbers.add(i+1);
        }
        return missingNumbers;
    }
    public static void main(String[] args){
        int[] arr = {1,5,1,1,1};
        System.out.println(findMissingNumbers(arr));
    }
}
