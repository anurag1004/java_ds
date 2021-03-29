package Main;

import java.util.Arrays;

class Rank{
    private double[] ranks;
    private int[][] graph;
    private int pages;
    public Rank(int[][] graph){
        this.graph = graph;
        this.pages = graph.length;
        ranks = new double[this.pages];
        double val = 1.0/this.pages;
        Arrays.fill(ranks, val);
    }
    public void calcRank(int itr){
        if(itr==0) return;
        for(int i=0;i<pages;i++){
            double rank = 0;
            for(int j=0;j<pages;j++){
                if(graph[i][j]!=0){
                    int count = 0;

                    for(int k=0;k<pages;k++){
                        if(graph[k][j]==1) count++;
                    }
                    rank += ranks[j]/count;
                }
            }
            ranks[i] = rank;
        }
        calcRank(--itr);
    }
    public double[] getRanks(){
        return this.ranks;
    }
}
public class PR {
    public static void main(String[] args) {
        int[][] graph = {{0,1,0,0},
                        {0,0,0,0},
                        {1,1,0,1},
                        {1,0,1,0}};
        Rank r = new Rank(graph);
        r.calcRank(1);
        System.out.println(Arrays.toString(r.getRanks()));
    }
}
