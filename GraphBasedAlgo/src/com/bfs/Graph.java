package com.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
class Graph {
    private int V;  // number of vertices
    private LinkedList<Integer> adj[]; // for making adjacency List
    public Graph(int v){
        this.V = v+1;
        adj = new LinkedList[this.V]; // rows = V
        for(int i=0;i<this.V;i++)
            adj[i] = new LinkedList<Integer>();
    }
    public void addEdgeDirected(int i,int j){
        adj[i].add(j);
    }
    public void addEdgeUndirected(int i,int j){
        adj[i].add(j);
        adj[j].add(i);
    }
    public void bfs(int s){ // s is the starting vertex
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[V];

        //add starting vertex to queue
        queue.add(s);
        // mark it visited
        visited[s] = true;

        while (queue.size()!=0){

            // start exploring vertex s
            s = queue.poll();
            System.out.print(s+" ");

            Iterator it = adj[s].listIterator();
            // iterating over all adjacent nodes to vertex s
            while (it.hasNext()){
                int n = (int) it.next();
                if(!visited[n]){ // if not visited
                    // visit it
                    visited[n] = true;
                    queue.add(n); // enqueue visited node
                }
            }

        }

    }
//    private static void bfsAdjMat(int v,int[][] graph){
//        boolean[] visited = new boolean[graph.length];
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.add(v);
//        visited[v] = true;
//        while (!queue.isEmpty()){
//            int n = queue.poll();
//            System.out.println(" "+n);
//            for(int i=0;i<graph.length;i++){
//                if(!visited[i] && graph[n][i]==1){
//                    visited[i] = true;
//                    queue.add(i);
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        Graph g = new Graph(10);
        Graph g2 = new Graph(4);
        g.addEdgeUndirected(1,2);
        g.addEdgeUndirected(1,4);

        g.addEdgeUndirected(2,5);
        g.addEdgeUndirected(2,7);
        g.addEdgeUndirected(2,8);
        g.addEdgeUndirected(2,3);

        g.addEdgeUndirected(3,4);
        g.addEdgeUndirected(3,10);
        g.addEdgeUndirected(3,9);

        g.addEdgeUndirected(5,6);
        g.addEdgeUndirected(5,8);
        g.addEdgeUndirected(5,7);

        g.addEdgeUndirected(7,8);

        g.bfs(1);

        System.out.println();
        g2.addEdgeDirected(0, 1);
        g2.addEdgeDirected(0, 2);
        g2.addEdgeDirected(1, 2);
        g2.addEdgeDirected(2, 0);
        g2.addEdgeDirected(2, 3);
        g2.addEdgeDirected(3, 3);

        g2.bfs(2);
    }
}

