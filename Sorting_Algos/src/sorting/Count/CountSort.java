package sorting.Count;

import java.util.Arrays;
// Counting sort is a stable sorting technique, which is used to sort objects according to the keys that are small numbers.
// It counts the number of keys whose key values are same.
// This sorting technique is effective when the difference between different keys are not so big,
// otherwise, it can increase the space complexity.

// Worst Case Complexity: O(n+k)
// Best Case Complexity: O(n+k)
// Average Case Complexity: O(n+k)
public class CountSort {
    private int findMax(int arr[]){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max = arr[i];
        }
        return max;
    }
    public void countSort(int arr[],int size){
        int max = findMax(arr);
        int[] countArr = new int[max+1];
        int[] output = new  int[size+1];
        // fill the countArr with 0
        Arrays.fill(countArr,0);

        //count each element occurrence  and store it into countArr
        for(int i=0;i<size;i++)
            countArr[arr[i]]++;
        // store commutative count of each element
        for(int j=1;j<=max;j++)
            countArr[j] += countArr[j-1];

        // Find the index of each element of the original array in the count array.
        // This gives the cumulative count.
        for(int k=size-1;k>=0;k--){
            output[countArr[arr[k]] - 1] = arr[k];
            countArr[arr[k]]--;
        }
        // copy sorted output to original array
        for(int l=0;l<size;l++)
            arr[l]=output[l];

    }
    public void printArray(int arr[]){
        for(int x:arr){
            System.out.print(" "+x);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,6,10,8,3,0,4,7,3,6,7,2,1};
        int size = arr.length;
        CountSort cs = new CountSort();
        cs.countSort(arr,size);
        cs.printArray(arr);
    }
}
