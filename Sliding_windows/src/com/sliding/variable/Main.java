package com.sliding.variable;

import java.util.HashSet;

//Longest Substring Without Repeating Characters
public class Main {
    static int maxLengthSubstring(String s){
        HashSet<Character> set = new HashSet<Character>();
        int max_window_size = 0;
        int i,j,n;
        i=0;
        j=0;
        n = s.length();
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++; // increase the window size
                max_window_size = Math.max(max_window_size,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max_window_size;
    }

    public static void main(String[] args) {
        String s = "aabcfedkcd";
        System.out.println(maxLengthSubstring(s));
    }
}
