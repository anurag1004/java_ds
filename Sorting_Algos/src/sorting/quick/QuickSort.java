package sorting.quick;
// Worst Case O(n^2)
// Best Case O(nlog(n))
// Avg case O(nlog(n))
//The space complexity for quicksort is O(log n).
class QuickSort{
    private int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low-1;
        // put smaller elements to left of the pivot
        // and greater elements to right of the pivot
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i+1);
    }
    public void quickSort(int[] arr,int low,int high){
        if(low<high){
            int j = partition(arr,low,high);
            quickSort(arr,low,j-1);
            quickSort(arr,j+1,high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,0,9,10,90,-100,40,60,79,2,4,4,0};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr,0,arr.length-1);
        for(int x:arr){
            System.out.print(" "+x);
        }
    }
}
