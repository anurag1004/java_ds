package com.Sodoku;

class Sudoku{
    static int N=9;
    static public boolean solve(int row,int col,int[][] board){
        // if we reached las row and last col
        if(row==N-1 && col==N){
            return true;
        }
        // if we reached last col of row
        if(col==N){
            row++;
            col=0;
        }
        if(board[row][col]!=0)
            return solve(row,col+1,board);

        for(int value=1;value<=9;value++){
                if(isSafe(row,col,board,value)) {
                    board[row][col] = value;
                    if(solve(row, col + 1, board))
                       return true;
                }
                board[row][col] = 0; //backtrack
            }
        return false;
    }
    static private boolean isSafe(int r,int c,int[][] board,int value){
        int i,j;
        // check for row
        for(i=0;i<N;i++){
            if(board[r][i]==value) {
                return false;
            }
        }
        // check for col
        for(i=0;i<N;i++){
            if(board[i][c]==value) {
                return false;
            }
        }
        // check in sub-matrix
        int startRow = r - r % 3, startCol = c - c % 3;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(board[i+startRow][j+startCol]==value)
                    return false;
            }
        }
        return true;
    }
    static public void print(int[][] board){
        System.out.println();
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int grid[][] = {{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                        { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        if(!solve(0,0,grid)){
            System.out.println("No solution exist!!");
        }else{
            print(grid);
        }
    }
}
