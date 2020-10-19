package com.shortestpath.dijkstra;

import java.util.Arrays;

public class Graph {
    private int V;
    private int[][] adj;
    public Graph(int V){
        this.V = V;
        adj = new int[V][V]; //  weighted adjacency matrix
    }
    public void addEdgeUndirected(int i,int j,int weight){
        adj[i][j] = weight;
        adj[j][i] = weight;
    }
    public void addEdgeDirected(int src,int dest,int weight) {
        adj[src][dest] = weight;
    }
    public void show_matrix(){
        for(int i=0;i<V;i++){
            System.out.println();
            for (int j=0;j<V;j++){
                System.out.print(" "+adj[i][j]);
            }
        }
        System.out.println();
    }
    public void dijkstra(int src){
        int[] distance = new int[V];
        boolean[] visitedVertex = new boolean[V];

        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[src] = 0;
        for(int i=0;i<V;i++){
            int u = findMinimum(visitedVertex,distance);
            visitedVertex[u] = true;

            for (int v=0;v<distance.length;v++){
                if(!visitedVertex[v] && adj[u][v]!=0 && (distance[u]+adj[u][v] < distance[v])){
                    distance[v] = distance[u]+adj[u][v];
                }
            }
        }
        for(int j=0;j<distance.length;j++){
            System.out.println(" "+src+" to "+j+"   "+distance[j]);
        }
    }
    private int findMinimum(boolean[] visitedVertex,int[] distance){
        int min = Integer.MAX_VALUE;
        int minVertex = -1;
        for(int i=0;i<distance.length;i++){
            if(!visitedVertex[i] && distance[i] < min){
                min = distance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdgeDirected(0,1,2);
        g.addEdgeDirected(0,2,4);
        g.addEdgeDirected(1,2,5);
        g.addEdgeDirected(1,3,6);
        g.addEdgeDirected(2,3,1);
        g.addEdgeDirected(2,4,2);
        g.addEdgeDirected(3,1,6);
        g.addEdgeDirected(3,4,7);
        g.addEdgeDirected(4,3,7);

        g.dijkstra(0);
    }
}
