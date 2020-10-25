package com.charBychar;

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
    static public String LCS(String[] strs){
        int minLen = minLength(strs);
        StringBuilder prefix = new StringBuilder();
        for(int i=0;i<minLen;i++){
            char curr = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=curr){
                    return prefix.toString();
                }
            }
            prefix.append(curr);
        }
        return prefix.toString();
    }
    public static void main(String[] args) {
        String[] strs = {"","a"};
        System.out.println(LCS(strs));
    }
}
