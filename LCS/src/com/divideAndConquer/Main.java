package com.divideAndConquer;
// Time complexity O(m*n)
// m -> length of the largest string
// n-> number of strings
public class Main {
    static private String commonPrefix(String str1,String str2){

        StringBuilder prefix = new StringBuilder();
        int l1 = str1.length();
        int l2 = str2.length();
        int i,j;
        i=0;
        j=0;
        while((i < l1 && j < l2) && str1.charAt(i) == str2.charAt(j)){
            prefix.append(str1.charAt(i));
            i++;
            j++;
        }
        return prefix.toString();
    }
    static public String LCP(String[] strs,int p,int r){
        if(p==r) return strs[p];
        while(p<r){
            int q = (p+r)/2;
            String str1 = LCP(strs,p,q);
            String str2 = LCP(strs,q+1,r);

            return commonPrefix(str1,str2);
        }
        return null;
    }

    public static void main(String[] args) {
        String[] strs = {"l",""};
        System.out.println(LCP(strs,0,strs.length-1));
    }
}
