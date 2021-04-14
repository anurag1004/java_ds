package com.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void bfs(int[][] graph, int src){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        visited[src] = true;
        queue.add(src);
        while (queue.size()!=0){
            int v = queue.poll();
            System.out.print(v+"->");
            int[] neighbors = graph[v];
            for(int neighbor :  neighbors){
                if(!visited[neighbor]){
                    //visit it
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public static void dfs(int[][] graph, int src){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        stack.push(src);
        while (!stack.isEmpty()){
            int v = stack.pop();
            if(!visited[v]){
                visited[v] = true;
                System.out.print(v+"->");
            }
            int[] neighbors = graph[v];
            for(int neighbor: neighbors){
                if(!visited[neighbor]){
                    stack.push(neighbor);
                }
            }
        }
    }
    public static void main(String[] args){
    // undirected
        int[][] graph = {{1,2},{0,2},{0,1,3},{2,4,5},{3,5,6},{3,4,6},{5,4}};
    // directed graph
    //   int[][] graph = { {1,2}, {2}, {3}, {4,5}, {5}, {} };
        bfs(graph, 0);
        System.out.println();
        dfs(graph, 0);
    }
}
