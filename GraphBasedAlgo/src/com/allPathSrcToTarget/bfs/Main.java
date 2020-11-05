package com.allPathSrcToTarget.bfs;

import java.util.*;

public class Main {
    static void bfsUtil(int vertex, int dest,
                        int[][] graph,
                        List<List<Integer>> out){

        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(vertex)); // add it to the queue

        while (!queue.isEmpty()){
            // explore the vertex
            List<Integer> path = queue.poll();
            int last = path.get(path.size()-1);
            if(last == dest){
                out.add(new LinkedList<>(path));
            }
            else {
                int[] neighbors = graph[last];
                for(int neighbor:neighbors){
                    List<Integer> list = new LinkedList<>(path);
                    list.add(neighbor);
                    queue.add(list);
                }
            }
        }
    }
    static void allPathFromSrcToTarget(int[][] graph, int src, int dest){
        List<List<Integer>> out = new LinkedList<>();
        bfsUtil(src,dest,graph,out);
        System.out.println(out.toString());
    }

    public static void main(String[] args) {
        // Only for Directed Acyclic graph
        /*
        *      0---->1
        *      |     |
        *      |     v
        *      |     2
        *      |    / \
        *      |   /   \
        *      |  /     \
        *      V V       V
        *       3------->4
        * */
        int[][] graph = {{1,3},{2},{3,4},{4},{}};
        allPathFromSrcToTarget(graph,0,3);
    }
}
