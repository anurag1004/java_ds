package sorting.bubble;

import java.util.ArrayList;

public class BubbleSort{
    // Worst Case O(n^2) [if array is in descending order and we want ascending order or vice versa]
    // Best case (if already sorted) O(n)
    // Average case O(n^2) [If array elements are all jumbled i.e neither ascending nor descending]
    public static void sort(int[] arr){
        boolean swapped;
        for(int i=0;i<arr.length-1;i++){
            swapped = false;
            for(int j=0;j< arr.length -1 -i;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp =  arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped==false) break;
        }
    }
    public static void main(String[] args){
      int[] arr = {1,2,3,4,5};
      sort(arr);
      for(int e:arr){
          System.out.print(" "+e);
      }
    }
}
