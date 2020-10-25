package com.binarySearch;
// Time complexity is O(NM log M)
public class Main {
    static private int minLength(String[] strs){
        int min = strs[0].length();
        for(int i=0;i<strs.length;i++){
            if(strs[i].length() < min){
                min = strs[i].length();
            }
        }
        return min;
    }
    static private boolean allContainsPrefix(String[] arr,String str,int n,int start,int end){
        for(int i=0;i<n;i++){
            for(int j=start;j<=end;j++){
                if(arr[i].charAt(j)!=str.charAt(j))
                    return false;
            }
        }
        return true;
    }
    static public String LCP(String[] str){ // binary Search algo
        StringBuilder prefix = new StringBuilder();
        int minLen = minLength(str);
        int low = 0;
        int high = minLen;
        int n = str.length;
        while(low<high){
            int mid = (low + high)/2;
            if(allContainsPrefix(str,str[0],n,low,mid)){
                // If all the strings in the input array contains
                // this prefix then append this substring to
                // our answer
                prefix.append(str[0].substring(low,mid+1));
                // go to the right part
                low=mid+1;
            }else{
                // go to the left part
                high=mid-1;
            }
        }
        return prefix.toString();
    }
    public static void main(String[] args) {
        String[] arr = {"","a"};
        System.out.println(LCP(arr));
    }
}
