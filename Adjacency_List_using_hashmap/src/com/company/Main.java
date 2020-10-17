package com.company;

import java.util.*;

class Graph{
    private int V;
    private HashMap<Integer,LinkedList<Integer>> adj;
    public Graph(int v){
        this.V = v+1;
        adj = new HashMap<Integer, LinkedList<Integer>>(); // adjacency list
        for(int i=0;i<V;i++) // since hashmap supports null keys
            adj.put(i,new LinkedList<Integer>());
    }
    public void addEdgeDirected(int i,int j){
        // i---->j
        LinkedList<Integer> list = adj.get(i);
//        if(list==null){
//            list = new LinkedList<Integer>();
//            adj.put(i,list);
//        }
        list.add(j);
    }
    public void addEdgeUndirected(int i,int j){
        // i<--->j
        LinkedList<Integer> l1 = adj.get(i);
        LinkedList<Integer> l2 = adj.get(j);
//        if(l1==null){
//            l1 = new LinkedList<Integer>();
//            adj.put(i,l1);
//        }
//        if(l2==null){
//            l2 = new LinkedList<Integer>();
//            adj.put(j,l2);
//        }
        l1.add(j); // i--->j
        l2.add(i); // j--->i
    }
    public void bfs(int s){
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[this.V];

        // mask s as visited
        visited[s]  = true;
        // enqueue the vertex
        queue.add(s);

        while (queue.size()!=0){
            // explore the vertex s
            s = queue.poll();
            System.out.print(s+" ");
            ListIterator it = adj.get(s).listIterator(); // key = [...]
            while(it.hasNext()){
                int n = (int)it.next();
                if(!visited[n]){ // if not visited
                    // visit and enqueue it
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(10);
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
        Graph g2 = new Graph(4);
        g2.addEdgeDirected(0, 1);
        g2.addEdgeDirected(0, 2);
        g2.addEdgeDirected(1, 2);
        g2.addEdgeDirected(2, 0);
        g2.addEdgeDirected(2, 3);
        g2.addEdgeDirected(3, 3);

        g2.bfs(2);
    }
}
