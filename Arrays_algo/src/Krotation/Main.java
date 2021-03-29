package Krotation;

public class Main {
    public static void kRotateLeft(int[] nums,int k){
        if(nums.length==0) return;
        int n = nums.length;
        for(int i=0;i<k;i++){
            leftRotateOne(nums,n);
        }
    }
    private static void leftRotateOne(int[] nums,int n){
        int last = nums[0];
        int i=0;
        for(i=0;i<n-1;i++){
            nums[i] = nums[i+1];
        }
        nums[i] = last;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        kRotateLeft(nums,4);
        for(int x:nums){
            System.out.print(x+" ");
        }

        /*
        *  1 2 3 4
        *  5 6 7 8
        *  9 0 1 2
         */
    }
}
