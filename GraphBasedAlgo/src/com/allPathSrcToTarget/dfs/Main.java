package com.allPathSrcToTarget.dfs;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void dfsUtil(int v, int dest, int[][] graph, boolean[] visited, List<Integer> path, List<List<Integer>> out){
        if(v==dest){
            out.add(new ArrayList<>(path)); // copying the path
            return;
        }
        visited[v] = true;
        for(int i=0;i<graph[v].length;i++){
            if(!visited[i] && graph[v][i]==1){
                path.add(i);
                dfsUtil(i, dest, graph, visited, path, out);
                path.remove(path.size()-1); // backtrack
            }
        }
        visited[v]  =  false; // backtrack
        return;
    }
    public static void allPathsFromSrcToTarget(int[][] graph,int src,int goal){
        boolean[] visited = new boolean[graph.length];
//        int goal = graph.length-1;
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(src); // adding starting point
        dfsUtil(src,goal,graph,visited,path,out);

        System.out.println(out.toString());
    }

    public static void main(String[] args) {
        int[][] graph = {{0,1,1,0,0,0},
                        {1,0,0,1,0,0},
                        {1,0,0,1,1,0},
                        {0,1,1,0,1,0},
                        {0,0,1,1,0,1},
                        {0,0,0,0,1,0}};
        allPathsFromSrcToTarget(graph,0,1);
    }
}
