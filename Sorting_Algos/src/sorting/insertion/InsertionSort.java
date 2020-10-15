package sorting.insertion;

public class InsertionSort {

    private void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i-1;
            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].

            // smaller elements goes to right side
            // larger elements goes to left side
            /* just like arranging cards */
            while(j>=0 && key<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            // Place key at after the element just smaller than it.
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,4,0,10,3,5};
        InsertionSort is = new InsertionSort();
        is.insertionSort(arr);
        for(int x:arr){
            System.out.print(" "+x);
        }
    }
}
