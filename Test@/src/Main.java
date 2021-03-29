import java.util.*;
public class Main {
    public static void dfsUtil(List<Integer> curr, List<List<Integer>> out, int[][] graph, boolean[] visited, int v, int target){
        curr.add(v);
        if(v==target){
            out.add(new ArrayList<>(curr));
            return;
        }
        visited[v] = true;
        for(int i=0;i<graph.length;i++){
            if(graph[v][i]==1 && !visited[i]){
                dfsUtil(curr, out, graph, visited, i, target);
                curr.remove(curr.size()-1);
            }
        }
        visited[v] = false;
    }
    public static List<List<Integer>> allSrcToTarget(int[][] graph, int src, int target){
        List<List<Integer>> out = new ArrayList<>();
        dfsUtil(new ArrayList<>(), out, graph, new boolean[graph.length], src, target);
        return out;
    }
    public static void main(String[] args) {
        int[][] graph = {{0,1,0,1,0,0},{1,0,1,0,0,0},{0,1,0,0,1,1},{1,0,0,0,1,0},{0,0,1,1,0,1},{0,0,1,0,1,0}};
        List<List<Integer>> out = allSrcToTarget(graph, 0, 5);
        System.out.println(out.toString());
    }
}
