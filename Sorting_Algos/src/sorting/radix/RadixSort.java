package sorting.radix;

import java.util.Arrays;
//For the radix sort that uses counting sort as an intermediate stable sort, the time complexity is O(d(n+k)).
public class RadixSort {
    private int getMax(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    private void countSort(int[] arr,int size,int place){
        int[] output = new int[size+1];
        int[] count = new int[10];

        Arrays.fill(count,0);

        //count the occurrence of digit of a particular place in count array
        for(int i=0;i<size;i++)
            count[(arr[i]/place)%10]++;
        // calculate the cumulative count between 1 to 10
        // since we'r sorting each individual digit
        for(int i=1;i<10;i++)
            count[i]+=count[i-1];
        // Find the index of each element of the original array in the count array.
        for(int i=size-1;i>=0;i--){
            output[count[(arr[i]/place)%10] -1] = arr[i];
            count[(arr[i]/place)%10]--;
        }
        // copy contents of output to array
        for (int i=0;i<size;i++){
            arr[i] = output[i];
        }

    }
    public void radixSort(int[] arr){
        int max = getMax(arr);
        int size = arr.length;
        for(int place = 1;max/place>0;place *= 10){
            countSort(arr,size,place);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,23,112,67,98,23,113,114,127,120,90,0,1,89};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr);
        for(int x:arr){
            System.out.print(" "+x);
        }
    }
}
