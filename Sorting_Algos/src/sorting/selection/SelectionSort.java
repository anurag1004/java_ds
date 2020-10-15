package sorting.selection;

public class SelectionSort {
    public void selectionSort(int[] arr){
        int pos = 0;
        int n = arr.length;
        int min; // to store minimum element's index
        while(pos<n-1){
            // pos is first index of unsortedList
            min = pos;
            for(int i=pos+1;i<n;i++){
                if(arr[i]<arr[min])
                    min = i;
            }
            // swap min with pos
            int temp = arr[pos];
            arr[pos] = arr[min];
            arr[min] = temp;

            pos++;
        }
    }
    public static void main(String[] args){
        int[] arr = {4,5,6,0,2,10,90,-90,234,5,0,45};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);
        for(int x:arr){
            System.out.print(" "+x);
        }
    }
}
