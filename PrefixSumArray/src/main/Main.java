package main;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,4,-2,4,5,-6,9,10};
        int[] prefix = new int[arr.length];
        // building prefix sum array
        prefix[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i] = arr[i]+prefix[i-1];
        }
        for(int x:prefix)
            System.out.print(x+" ");
        System.out.println();

        // finding sum of sub array from [1,6]
        System.out.println(prefix[6]-prefix[1-1]); // O(1)s
    }
}
