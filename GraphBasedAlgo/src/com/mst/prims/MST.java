package com.mst.prims;

public class MST {
    private int V; // number of vertices
    private int[][] adj; //adjacency matrix
    public MST(int V){
        this.V = V;
        adj = new int[V][V];
    }
    public void addEdge(int i,int j,int weight){
        // undirected connect graph
        adj[i][j] = weight;
        adj[j][i] = weight;
    }
    // Made with Adjacency Matrix
    // Time Complexity O(n^2)
    // Can be reduce to { O( E*log(V) } by using Adjacency List
    public void prim(){
        int INF = Integer.MAX_VALUE;
        int no_of_edge; // number of edge of the spanning tree

        // create a array to track selected vertex
        // selected will become true otherwise false
        boolean[] selected = new boolean[V];

        selected[0] = true; // choose the zero vertex and make it true
        no_of_edge = 0; // set no of edge to zero

        // the number of egde in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in
        // graph
        // the loop will terminate when E = V-1

        System.out.println(" Edge    Weight");

        while (no_of_edge<V-1){
            // if the vertex is selected already, say i
            // traverse through all of its adjacent vertices which are not selected
            // and select the vertex with minimum cost

            int min = INF;
            int x = 0; // ROW number
            int y = 0; // COL number
            for(int i=0;i<V;i++){
                if(selected[i]){
                    for(int j=0;j<V;j++){
                        if(!selected[j] && adj[i][j]!=0){
                            // not in selected and there is an edge(with weight >0)
                            if(min>adj[i][j]) {
                                min = adj[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x+" -- "+y+"     "+adj[x][y]);
            selected[y] = true;
            no_of_edge++;
        }
    }
    public static void main(String[] args) {
        MST mst = new MST(9);
        mst.addEdge(0,1,4);
        mst.addEdge(0,7,8);
        mst.addEdge(1,7,11);
        mst.addEdge(1,2,8);
        mst.addEdge(2,8,2);
        mst.addEdge(8,7,7);
        mst.addEdge(7,6,1);
        mst.addEdge(8,6,6);
        mst.addEdge(2,5,4);
        mst.addEdge(6,5,2);
        mst.addEdge(3,5,14);
        mst.addEdge(2,3,7);
        mst.addEdge(5,4,10);
        mst.addEdge(3,4,9);

        mst.prim();
    }
}
