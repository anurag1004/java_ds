package com.paintProblem;

public class Main {
    static Integer min = null;
    private static void helper(int[][] A, int h,  int prevColor, int cost){
        if(h==A.length){
            if(min==null)
                min = cost;
            else
                min = Math.min(min, cost);
            return;
        }
        for(int c=0;c<3;c++){
            if(c!=prevColor){
                int temp = A[h][c];
                helper(A, h+1, c, cost+temp);
            }
        }
    }
    public static void main(String[] args) {
        int[][] A = {{17,2,17},{16,16,5},{14,3,19}};
        helper(A, 0, -1,0);
        System.out.println(min);
    }
}
