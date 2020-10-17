package com.dfs;

import java.util.LinkedList;
import java.util.ListIterator;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    private boolean visited[];
    public Graph(int v){
        this.V= v; // the vertices must start from zero, otherwise it'll throw index out of bound exception
        // to fix this just add 1 to v
        visited = new boolean[this.V];
        adj  = new LinkedList[this.V];
        for(int i=0;i<this.V;i++)
            adj[i] = new LinkedList<Integer>();
    }
    public void addEdgeDirected(int i,int j){
        // i--->j
        adj[i].add(j);
    }
    public void addEdgeUndirected(int i,int j){
        // i<--->j
        adj[i].add(j);  // i--->j
        adj[j].add(i);  // j--->i
    }
    public void dfs(int vertex){
        visited[vertex] = true;
        System.out.print(vertex+" ");

        ListIterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()){
            int n = it.next();
            if(!visited[n])
                dfs(n);
        }
    }
    //  All the vertices may not be reachable from a given vertex as in the case of a Disconnected graph.
    //  To do complete DFS traversal of such graphs, run DFS from all unvisited nodes after a DFS.
    public void dfs_all(){
        for(int i=0;i<V;i++){
            if(!visited[i])
                dfs(i);
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);
        // input for a connected directed graph
        g.addEdgeDirected(0,1);
        g.addEdgeDirected(0,2);
        g.addEdgeDirected(1,2);
        g.addEdgeDirected(2,0);
        g.addEdgeDirected(2,3);
        g.addEdgeDirected(3,3);
        g.dfs(1);

        System.out.println();
        // input for a disconnected directed graph
        Graph g2 = new Graph(6);
        // 1st component
        g2.addEdgeDirected(0,1);
        g2.addEdgeDirected(1,0);
        g2.addEdgeDirected(0,2);
        g2.addEdgeDirected(2,1);
        //2nd component
        g2.addEdgeDirected(3,4);
        g2.addEdgeDirected(3,5);
        g2.addEdgeDirected(4,5);

        g2.dfs_all();
    }

}