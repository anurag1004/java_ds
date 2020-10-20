package com.floydWarshall;

public class AllPairShortest {

    protected static final int INF = 999999999;

    void floydWarshall(int[][] graph){
        int[][] matrix = graph.clone();
        int n = graph.length;
        for(int k=0;k<n;k++){
            for (int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j] > matrix[i][k]+matrix[k][j]){
                        matrix[i][j] = matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }
        printMatrix(matrix,n);
    }
    static void printMatrix(int[][] matrix,int n){
        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<n;j++){
                if(matrix[i][j]==INF){
                    System.out.print(" "+"INF");
                }else{
                    System.out.print(" "+matrix[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph =
                {
                    {0,3,INF,5},
                    {2,0,INF,4},
                    {INF,1,0,INF},
                    {INF,INF,2,0}
                };
        AllPairShortest g = new AllPairShortest();
        g.floydWarshall(graph);
    }
}
