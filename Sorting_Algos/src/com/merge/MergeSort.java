package com.merge;

public class MergeSort {
    // array[p..r]
    // q = (p+r)/2 -> halfway point
    // mergeSort(array,p,q)
    // mergeSort(array,q+1,r)
    public void mergeSort(int[] arr,int p,int r){
        if(p>r) return;
        int q = (p+r)/2;
        mergeSort(arr,p,q); //first half
        mergeSort(arr,q+1,r); // second half

        // divide the sub-arrays until we reached the base case
        //  now merge both sub-arrays
        merge(arr,p,q,r);
    }
    private void merge(int[] arr,int p,int q,int r){
        //copy array elements of first and second sub-array to a new array
        int[] L,M;

        int n1 = q-p+1;
        int n2 = r-q;

        L = new int[n1];
        M = new int[n2];

        for(int i=0;i<n1;i++)
            L[i] = arr[i];
        for(int j=0;j<n2;j++)
            M[j] = arr[j];

        // maintain current index of sub-arrays and main array
        int i,j,k;
        i = 0;
        j = 0;
        k = p; // since main array starts with index p
        // until we reach  the end of either L or M
        // transfer the smallest one to the main array i.e arr[p..r]
        while(i<n1 && j<n2){
            if(L[i]<=M[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = M[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k]=M[j];
            j++;
            k++;
        }

    }
    public static void main(String[] args){
        int[] arr={9,8,0,5,4,34,89,0,-7,60};
        MergeSort ms=new MergeSort();
        ms.mergeSort(arr,0,arr.length-1);
        for(int x:arr){
            System.out.print(" "+x);
        }
    }
}
