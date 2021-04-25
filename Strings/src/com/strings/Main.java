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
    private static String minWindow(String s, String t){
        if(s.length()==0 || t.length()==0) return "";
        Map<Character, Integer>  tfreq = new HashMap<>();
        for(char x:t.toCharArray()) tfreq.put(x, tfreq.getOrDefault(x,0)+1);
        int left = 0;
        int right = 0;
        int counter = 0;
        int target = tfreq.size();
        Map<Character, Integer> windowCount = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while (right<s.length()){
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c,0)+1);
            if(tfreq.containsKey(c) && tfreq.get(c).intValue()==windowCount.get(c).intValue()){
                counter++;
            }
            while(left<=right && counter==target){
                c = s.charAt(left);
                if(ans[0]==-1 || (right-left+1)<ans[0]){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCount.put(c, windowCount.get(c)-1);
                if(tfreq.containsKey(c) && tfreq.get(c).intValue() >  windowCount.get(c).intValue()){
                    counter--;
                }
                left++;
            }
            right++;
        }
        return ans[0]==-1?"":s.substring(ans[1], ans[2]+1);
    }
    private static boolean hasAllUniqueChars(String s){
        if(s.length()>256) return false;
        boolean[] set = new boolean[256];
        for(char x:s.toCharArray()){
            if(set[x]) return false;
            set[x] = true;
        }
        return true;
    }
    private static boolean arePermutation(String s, String t){
        int n1 = s.length();
        int n2 = t.length();
        if(n1!=n2) return false;
        int[] map = new int[256];
        for(char x:s.toCharArray()) map[x]++;
        for(char x:t.toCharArray()){
            if(map[x]<0) return false;
            map[x]--;
        }
        return true;
    }
    private static String URLify(String s){
        s = s.trim();
        return s.replaceAll("\\s","%20");
    }
    private static boolean palindromePermutation(String s){
        // to be palindrome the string must have chars with even counts and at most one count(in case of odd length string)
        boolean foundOdd = false;
        int[] map = new int[256];
        for(char x:s.toCharArray()) map[x]++;
        for(int count:map){
            if(count%2==0)
                continue;
            if(foundOdd) return false;
            foundOdd = true;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abc";
        String s ="ADOBECODEBANC";
        String t = "ABC";
        System.out.println(hasAllUniqueChars("abcdefssghijk"));
        System.out.println(arePermutation("aabcd","abacd"));
        System.out.println(URLify("This is John Smith    "));
        System.out.println(palindromePermutation("tactcoap"));
    }
}
