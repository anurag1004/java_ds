package com.strings;
import java.util.*;
public class Main {
    private static void generatePermutations(List<String> out, StringBuilder curr, String str, boolean[] set){
        if(curr.length()==str.length()){
            out.add(curr.toString());
            return;
        }
        for(int i=0;i<str.length();i++){
            if(!set[i]){
                set[i] = true;
                curr.append(str.charAt(i));
                generatePermutations(out, curr, str, set);
                set[i] = false;
                curr.deleteCharAt(curr.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        List<String> out = new ArrayList<>();
        generatePermutations(out, new StringBuilder(), str, new boolean[str.length()]);
        System.out.println(out.toString());
    }
}
