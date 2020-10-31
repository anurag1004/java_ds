package com.letterCombination.dfs.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Time complexity and Space Complexity  O(3^N *4^M)

public class Main {
    static String[] KEYS = {"","","abc","def",
                            "ghi","jkl","mno",
                            "pqrs","tuv","wxyz"};
    private static void letterCombinationRecurDFS(StringBuilder prefix,String digits,int n,List<String > list){
        if(prefix.length() == n) {
            list.add(prefix.toString());
            return;
        }
        int index = digits.charAt(prefix.length())-'0';
        String mapped_str = KEYS[index];
        for(int i=0;i<mapped_str.length();i++)
            letterCombinationRecurDFS(new StringBuilder(prefix.toString()+mapped_str.charAt(i)),digits,n,list);
    }
    public static List<String> letterCombination(String digits){
        if(digits.length()==0) return new ArrayList<>();
        int n = digits.length();
        List<String> list = new ArrayList<>();

        letterCombinationRecurDFS(new StringBuilder(""),digits,n,list);
        return list;
    }
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombination(digits));
    }
}
