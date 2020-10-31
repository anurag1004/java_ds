package com.letterCombination.bfs;

import java.util.*;
// Time complexity and Space Complexity  O(3^N *4^M)
public class Main {

    private static List<String> combinationRecur(String digits,String[] KEYS,int n){
        Queue<String> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        queue.add("");
        while(!queue.isEmpty()){
            String s = queue.poll();
            if(s.length() == n)
                list.add(s);
            else{
                int index = digits.charAt(s.length())-'0';
                String mapped_str = KEYS[index];
                for(int i=0;i<mapped_str.length();i++)
                    queue.add(s+mapped_str.charAt(i));
            }
        }
        return list;
    }
    public static List<String> letterCombination(String digits){
        int n = digits.length();
        String[] KEYS = { "", "","abc","def",
                         "ghi","jkl","mno",
                         "pqrs","tuv","wxyz" };
        return combinationRecur(digits,KEYS,n);
    }
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombination(digits));
    }
}
