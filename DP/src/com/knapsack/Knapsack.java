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
    // will return max value within maximum defined weight
    static int dynamicProgramming(int[] wt,  int[] val, int maxWt){
        int n = wt.length;
        int[][] dp = new int[n+1][maxWt+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxWt;j++){
                // ask  two questions
                // if to take this value
                // not to take this value
                // take max of it
                int currMaxWt = j;
                if(currMaxWt >= wt[i-1]){
                    int taken = val[i-1] + dp[i-1][currMaxWt-wt[i-1]];
                    int notTaken = dp[i-1][currMaxWt];
                    dp[i][j] = Math.max(taken, notTaken);
                }else{
                    // weight can't be taken
                    // take from above
                    dp[i][j] = dp[i-1][currMaxWt];
                }
            }
        }
        return dp[n][maxWt];
    }
    public static void main(String[] args) {
//        int[] wt = {12, 2, 1, 1, 4};
//        int[] val = {4, 2, 1, 2, 10};
//         out :- 15
        int[] wt = {2, 5, 1, 3, 4};
        int[] val = {15, 14, 10, 45, 30};
//         out :- 11
        boolean[] seen = new boolean[wt.length];
        helper(seen, wt, val, 0, 0, 7);
        System.out.println(maxVal);
        System.out.println(dynamicProgramming(wt, val, 7));
    }
}
