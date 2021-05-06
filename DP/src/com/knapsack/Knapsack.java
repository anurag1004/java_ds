package com.knapsack;

import com.paintProblem.Main;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {
    static int maxVal = Integer.MIN_VALUE;
    // recursion or exhaustive search
    static void helper(boolean[] seen, int wt[], int[] val, int w, int currVal, int maxWt){
        if(w>maxWt)
            return;
        maxVal = Math.max(currVal, maxVal);
        for(int i=0;i<wt.length;i++){
            if(!seen[i]){
                seen[i] = true;
                helper(seen, wt, val, w+wt[i], currVal+val[i], maxWt);
                seen[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] wt = {10,20,30};
        int[] val = {60,100,120};
        boolean[] seen = new boolean[wt.length];
//        helper(seen, wt, val, 0, 0, 1500);
//        System.out.println(maxVal);

        // for top to down
        Map<Integer, Integer> map = new HashMap<>();
    }
}
