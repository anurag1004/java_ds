package com.company;
class Graph{
    private boolean adjMat[][];
    private int numVertices; // will contain total num of vertices
    public Graph(int numVertices){
        this.numVertices = numVertices;
        this.adjMat = new boolean[numVertices][numVertices];
    }
    public void addEdge(int i,int j){
        adjMat[i][j] = true;
        adjMat[j][i] = true;
    }
    public void removeEdge(int i,int j){
        adjMat[i][j] = false;
        adjMat[j][i] = false;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<numVertices;i++){
            str.append(i+" : ");
            for(boolean j: adjMat[i]){
                str.append((j?1:0)+" ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
public class Main {

    public static void main(String[] args) {
	    Graph G = new Graph(4);
	    // undirected graph
        G.addEdge(0,3);
        G.addEdge(0,2);
        G.addEdge(0,1);
        G.addEdge(1,2);
        System.out.println(G.toString());
    }
}
