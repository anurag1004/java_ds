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
    public static void dfsRecur(int[][] graph, int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+"->");
        for(int n: graph[v]){
            if(!visited[n]) dfsRecur(graph, n, visited);
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
    private static boolean isCyclic_recu(int[][] graph, boolean[] visited, boolean[] recStack, int v){
        if(recStack[v]){
            // if already in the recursion stack, means we reached the previously visited node again
            // cycle exists
            return true;
        }
        if(visited[v]) // if already visited, no need to visit it again
            return false;

        visited[v] = true;
        recStack[v] = true;
        for(int n: graph[v]){
                if(isCyclic_recu(graph, visited,recStack, n)) return true;
        }
        recStack[v] = false;
        return false;
    }
    public static boolean isCyclic(int[][] graph){
        boolean[] recStack = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(isCyclic_recu(graph, visited, recStack,i)) return true;
        }
        return false;
    }
    public static void main(String[] args){
    // undirected
//        int[][] graph = {{1,2},{0,2},{0,1,3},{2,4,5},{3,5,6},{3,4,6},{5,4}};
    // directed graph
       int[][] graph = { {1,2}, {2}, {3}, {4,5}, {5}, {1} };
//       dfs(graph,0);
        System.out.println(isCyclic(graph));
    }
}
