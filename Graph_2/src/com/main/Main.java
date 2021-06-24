package com.main;

import java.util.*;
class Node{
    int u; //vertex
    int cost;
    public Node(int u, int cost){
        this.u = u;
        this.cost = cost;
    }
}
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
    // detecting cycle in an undirected graph
    public static boolean isCyclicUndirected(int[][] graph){
        // if v is already visited and there is a adjacent node u which is also visited but not the parent of v
        // then we can say there is a cycle in the graph
        boolean[]  visited = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i] && isCyclicUndirected_helper(graph, i, -1, visited))
                return true;
        }
        return false;
    }
    public static boolean isCyclicUndirected_BFS_helper(int[][] graph, boolean[] visited, int src){
        int V = graph.length;

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()){
            int u = queue.poll();
            for(int v:graph[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                    parent[v] = u;
                }else if(parent[u]!=v){
                    return true;
                }
                // else just skip the node if it is parent of u and visited
            }
        }
        return false;
    }
    public static boolean isCyclicUndirected_BFS(int[][] graph){
        int V = graph.length;
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && isCyclicUndirected_BFS_helper(graph, visited, i))
                return true;
        }
        return false;
    }
    public static boolean isCyclicUndirected_helper(int[][] graph, int v, int parent, boolean[] visited){
        visited[v]  = true;
        for(int u: graph[v]){
            if(!visited[u]){
                if(isCyclicUndirected_helper(graph, u, v, visited))
                    return true;
            }else if(u!=parent){
                return true;
            }
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
        //on back track add vertex v to the front of the list i.e in reverse order
        out.add(0, v);
    }
    // can detect cycles also
    // Khan's Algorithm for Topological Sorting in a DAG
    public static int[] khansAlgorithmForTopoSort(int[][] graph){
        int V = graph.length;
        int[] in_degree = new int[V];
        // queue always contains node with no incoming edges
        Queue<Integer> queue = new LinkedList<>();
        // calculate in-degree for each node
        for(int i=0;i<V;i++){
            for(int neighbor:graph[i]){
                in_degree[neighbor]++;
            }
        }
        // push_back nodes with in_degree as 0 to the queue
        for(int i=0;i<V;i++){
            if(in_degree[i]==0)
                queue.add(i);
        }
        int index = 0; // will keep track of next insertion position in the order array
        int[] order = new int[V]; // will contain final topological order
        while (!queue.isEmpty()){
            int v = queue.poll();
            order[index++] = v;
            // update its neighbor's in_degree
            for(int neighbor:graph[v]){
                in_degree[neighbor]--;
                if(in_degree[neighbor]==0)
                    queue.add(neighbor);
            }
        }
        if(index!=V){
            // cycle detected
            return null;
        }
        return order;
    }
    public static void dijkstra(int[][] graph, int V, int start){
        // overestimating all distances
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[V];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        // add starting vertex to the queue adn mark it as visited
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll(); //extracting least cost vertex
            int u = node.u;
            visited[u] = true;
            for(int v=0; v < graph[u].length; v++){
                if( !visited[v] && graph[u][v] != 0 && ( distance[u] + graph[u][v] ) < distance[v] ) {
                    distance[v] = distance[u] + graph[u][v];
                    // visit it and add it to the queue
                    pq.add(new Node(v, distance[v]));
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", start, i, distance[i]));
        }
    }
    class PQNode{
        int u, parent;
        int wt;
        public PQNode(int u, int parent, int wt){
            this.u = u;
            this.parent = parent;
            this.wt = wt;
        }
    }
    public void prims( Map<Integer, List<int[]>> graph, int V, int start){
        // will store next minimum edge
        PriorityQueue<PQNode> pq  = new PriorityQueue<>((n1, n2)->n1.wt-n2.wt);
        boolean[] visited = new boolean[V];
        // parent of  starting vertex is null or -1 and weight is 0
        pq.add(new PQNode(start, -1, 0));
        while(!pq.isEmpty()){
            PQNode node = pq.poll();
            if(visited[node.u])
                continue;
            visited[node.u] = true;
            if(node.parent!=-1){
                System.out.println(node.parent+"--"+node.u+" "+node.wt);
            }
            List<int[]> neighbors = graph.get(node.u);
            for(int[] edge: neighbors){
                int v =  edge[0];
                int wt = edge[1];
                pq.add(new PQNode(v, node.u, wt));
            }
        }
    }
    public static void main(String[] args){
    // undirected
//        int[][] graph = {{1},{0,2},{1,3,6},{2,4,5},{3,4},{3,5},{2,7,8},{6},{6},{}};
    // directed graph
//        int[][] graph = { {1,2}, {}, {3}, {4,5}, {5}, {} };
//       dfs(graph,0);
//        System.out.println(topologicalSortingDFS(graph));
//        int[] order = khansAlgorithmForTopoSort(graph);
//        if(order==null) System.out.println("Cycle detected");
//        else{
//            for(int x:order){
//                System.out.print(x+" ");
//            }
//        }
//        int[][] graph = {{0,4,0,0,0,4},
//                         {4,0,3,6,1,2},
//                         {0,3,0,2,0,0},
//                         {0,6,2,0,3,0},
//                         {0,1,0,3,0,0},
//                         {4,2,0,0,0,0}};
//        dijkstra(graph, 6,0);
//        System.out.println(isCyclicUndirected(graph));
//        System.out.println(isCyclicUndirected_BFS(graph));
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int V =  6;
        //  undirected connected graph
        int[][] graph = {{0,1,1},{0,4,10},{1,4,2},{1,2,8},{4,3,15},{2,3,12},{2,5,8},{3,5,9}};
        for(int[]  edge: graph){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(!adj.containsKey(u))
                adj.put(u, new ArrayList<int[]>());
            if(!adj.containsKey(v))
                adj.put(v, new ArrayList<int[]>());
            adj.get(u).add(new int[]{v,  wt});
            adj.get(v).add(new int[]{u, wt});
        }
        Main main = new Main();
        main.prims(adj, V, 0);
    }
}
