package com.company;
//Since the tree satisfies Max-Heap property, then the largest item is stored at the root node.
//        Swap: Remove the root element and put at the end of the array (nth position) Put the last item of the tree (heap) at the vacant place.
//        Remove: Reduce the size of the heap by 1.
//        Heapify: Heapify the root element again so that we have the highest element at root.
//        The process is repeated until all the items of the list are sorted.
class HeapSort{
    public void sort(int[] arr){
        int n = arr.length;
        //All other nodes other than leaf nodes
        for(int i=n/2-1;i>=0;i--)
            heapify(arr,n,i);
        // Time Complexity : O(Nlog(N))
        // How?
        // For one insertion heapify takes logN time, so for n insertion O(NlogN)
        for(int i=n-1;i>=0;i--){
            int temp = arr[0];
            arr[0]= arr[i];
            arr[i] = temp;

            //heapify root element
            // everytime this func is called, heap size is reduced by one.
            // starting from n to 0
            heapify(arr,i,0);
        }

    }
    private void heapify(int[] arr,int n,int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<n && arr[l]>arr[largest])
            largest = l;
        if(r<n && arr[r]>arr[largest])
            largest = r;
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }
    private void swap(int[] arr,int fpos,int spos){
        int temp = arr[fpos];
        arr[fpos] = arr[spos];
        arr[spos] = temp;
    }
}
public class Main {

    public static void main(String[] args) {
        int[] arr = {2,10,0,8,6,4,1,-90,70,0,7,8,5,3,6};
        HeapSort obj = new HeapSort();
        obj.sort(arr);
        for(int x: arr){
            System.out.printf("%d ",x);
        }
    }
}
