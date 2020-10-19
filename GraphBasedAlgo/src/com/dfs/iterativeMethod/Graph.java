package com.dfs.iterativeMethod;
import java.util.*;
public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    public Graph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    public void addEdgeDirected(int src,int dest){
        adj[src].add(dest);
    }
    public void addEdgeUndirected(int i,int j){
        adj[i].add(j); // i--->j
        adj[j].add(i); // j--->i
    }
    public void dfs(int vertex){
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        stack.push(vertex);
        while(!stack.empty()){
            int curr = stack.pop();
            if(!visited[curr]){
                visited[curr] = true;
                System.out.print(" "+curr);
            }
            ListIterator<Integer> it = adj[curr].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    stack.push(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        // input for a connected directed graph
        g.addEdgeDirected(1, 0);
        g.addEdgeDirected(0, 2);
        g.addEdgeDirected(2, 1);
        g.addEdgeDirected(0, 3);
        g.addEdgeDirected(1, 4);
        // output may differ
        g.dfs(0);
    }
}
