package com.letterCombination.dfs.iterative;
import java.util.*;
// Time complexity and Space Complexity  O(3^N *4^M)

public class Main {
    private static List<String> letterCombinationIterativeDFS(String digits,String[] KEYS,int n){
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("");
        while (!stack.isEmpty()){
            String s = stack.pop();
            if(s.length() == n) list.add(s);
            else{
                int index = digits.charAt(s.length())-'0';
                String mapped_str = KEYS[index];
                for(int i=0;i<mapped_str.length();i++){
                    stack.push(s+mapped_str.charAt(i));
                }
            }
        }
        return list;

    }
    public static List<String> letterCombination(String digits){
        if(digits.length()==0) return new ArrayList<>();
        int n = digits.length();
        String[] KEYS = {"","","abc","def",
                         "ghi","jkl","mno",
                         "pqrs","tuv","wxyz"};
        return letterCombinationIterativeDFS(digits,KEYS,n);
    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombination(digits));
    }
}
