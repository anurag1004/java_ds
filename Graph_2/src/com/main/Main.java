package com.main;

import java.util.*;

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
            // if already in the recursion stack, means we reached the previously explored node again
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
    public static boolean routeBetweenNodesRec(int[][] graph, int vertex, int target, boolean[] visited, List<Integer> path){
        path.add(vertex);
        visited[vertex]=true;
        if(vertex==target)
            return true;
        int[] neighbors = graph[vertex];
        for(int neighbor: neighbors){
            if(!visited[neighbor]) {
                if(routeBetweenNodesRec(graph, neighbor, target, visited, path))
                    return true;
            }
        }
        path.remove(path.size()-1);
        return false;
    }
    public static boolean routeBetweenNodes(int[][] graph, int src, int target){
        Stack<Integer> stack = new Stack<>();
        boolean[]  visited  = new boolean[graph.length];
        stack.push(src);
        while (!stack.isEmpty()){
            int vertex = stack.pop();
            if(vertex==target)
                return true;
            if(!visited[vertex]){
                visited[vertex]=true;
            }
            int[] neighbors = graph[vertex];
            for(int neighbor:neighbors){
                if(!visited[neighbor])
                    stack.push(neighbor);
            }
        }
        return false;
    }
    public static boolean routeBetweenNodesBFS(int[][] graph, int src, int target){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            if(vertex==target)
                return true;
            for(int neighbor:graph[vertex]){
                if(!visited[neighbor]){
                    //visit it
                    visited[neighbor] = true;
                    // add this to the queue
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
    public static List<Integer> topologicalSortingDFS(int[][] graph){
        // valid for only DAG
        boolean[] visited = new boolean[graph.length];
        List<Integer> out = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(!visited[i])
                dfsUtil(i, graph, visited, out);
        }
        return out;
    }
    private static void dfsUtil(int v, int[][] graph, boolean[] visited, List<Integer> out){
        visited[v] = true;
        for(int neighbor: graph[v]){
            if(!visited[neighbor])
                dfsUtil(neighbor, graph, visited, out);
        }
        //on back track add vertex v to the stack
        out.add(0, v);
    }
    public static void main(String[] args){
    // undirected
//        int[][] graph = {{1,2},{0,2},{0,1,3},{2,4,5},{3,5,6},{3,4,6},{5,4}};
    // directed graph
        int[][] graph = { {}, {}, {3}, {1}, {0}, {0} };
//       dfs(graph,0);
        System.out.println(topologicalSortingDFS(graph));
    }
}
