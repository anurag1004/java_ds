package com.backTracking;

import java.util.Arrays;
// Time Complexity 2^n (backtracking)
// for BruteForce approach worst case (n^n)
public class NQueen {
    static int N;
    /* A function to check if a queen can
      be placed on board[row][col]. Note that this
      function is called when "col" queens are already
      placeed in columns from 0 to col -1. So we need
      to check only left side for attacking queens */
    private static boolean isAttacked(int board[][],int row,int col){
        int i,j;
        for(i=0;i<col;i++) {
            if (board[row][i] == 1) return true;
        }
        for(i=0;i<N;i++){
            if(board[i][col]==1) return true;
        }
        for(i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1) return true;
        }
        for(i=row,j=col;i<N && j>=0;i++,j--){
            if(board[i][j]==1) return true;
        }
        return false;
    }
    /* A recursive utility function to solve NQueen problem */
    private static boolean nQueenUtil(int board[][],int col){
        // if all queen are placed
        if(col>=N)
            return true;
        // Take this col and try placing this queen in all rows one by one without being attacked
        for(int row=0;row<N;row++){
            // if the queen is safe or not attacked
            // place the queen in the board[i][col]
            if(isAttacked(board,row,col)==false){
                board[row][col] = 1;
                // recur to place rest of the queen
                if(nQueenUtil(board,col+1)==true)
                    return true;
                // if placing queen at {i,col} doesn't lead to solution
                // remove the queen from that position
                else
                    board[row][col] = 0; //backtrack
            }
        }
        // if queen cannot be placed in any row of this col, then return false
        return false;
    }
    public static boolean solve(){
        int board[][] = new int[N][N];
        for(int[] arr:board){ // fill all the array with 0
            Arrays.fill(arr,0);
        }
        if(nQueenUtil(board,0)==false){
            System.out.println("Solution doesn't exist!");
            return false;
        }
        // print the board if a solution exists
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.printf(" %d",board[i][j]);
            }
            System.out.println();
        }
        return true;
    }
    public static void main(String[] args) {
        NQueen.N = 4;
        NQueen.solve();
    }
}
