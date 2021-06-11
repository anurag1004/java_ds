package com.next.greatersmaller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static int[] findNextSmallerLeft(int[] a, int n){
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && a[stack.peek()] > a[i])
                map.put(stack.pop(), i);
            stack.push(i);
        }
        int[] out = new int[n];
        for(int i=0;i<n;i++){
            int index = map.getOrDefault(i, -1);
            if(index==-1)
                out[i] = 0;
            else
                out[i] = a[index];
        }
        return out;
    }
    public static int[] findNextSmallerRight(int[] a, int n){
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()] > a[i])
                map.put(stack.pop(), i);
            stack.push(i);
        }
        int[] out = new int[n];
        for(int i=0;i<n;i++){
            int index = map.getOrDefault(i, -1);
            if(index==-1)
                out[i] = 0;
            else
                out[i] = a[index];
        }
        return out;
    }
    public static void nextGreaterRight(int[] a, int n){
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()] < a[i]){
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i=0;i<n;i++){
            int index = map.getOrDefault(i, -1);
            if(index==-1)
                System.out.print(-1+" ");
            else
                System.out.print(a[index]+" ");
        }
    }
    public static void nextGreaterLeft(int[] a, int n){
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && a[stack.peek()] < a[i]){
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i=0;i<n;i++){
            int index = map.getOrDefault(i, -1);
            if(index==-1)
                System.out.print(-1+" ");
            else
                System.out.print(a[index]+" ");
        }
    }
    public static void main(String[] args) {
        int[] a = {5,1,9,2,5,1,7};
        nextGreaterRight(a, a.length);
        nextGreaterLeft(a, a.length);
        int[] LS = findNextSmallerLeft(a, a.length);
        int[] RS = findNextSmallerRight(a, a.length);
        System.out.println(Arrays.toString(LS));
        System.out.println(Arrays.toString(RS));
    }
}
