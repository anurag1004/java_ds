package com.main;

/*
* A Disjoint Set Data Structure (often referred to as a "Union-Find" data structure) is a data structure
* that maintains a collection of disjoint sets
* and provides efficient operations to determine whether two elements belong
* to the same set (connected or not connected)
* and to unite (merge) two sets into a single set
*
* What are disjoint set in general?
* Collections of non-overlapping sets such that there is no common elements between them
* or intersection of all this set is an empty set
* DisjointSet DS maintains a collection of disjoint sets
* */
public class DisjointSet {
    int[] parent, rank, size;
    // parent[i] gives the ultimate parent/representative element of the set it belongs to
    // rank[i] gives the distance between this node to the farthest leaf node
    // size[i] The size array will be storing the size for each particular node
    // i.e size[i] will be the size of the component starting from node i.
    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    // almost constant time
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        int representativeX = find(parent[x]);
        parent[x] = representativeX; // path compression, helps to achieve near constant time
        return  representativeX;
    }
    public void unionByRank(int x, int y){
        int representativeX = find(x);
        int representativeY = find(y);
        if(representativeX==representativeY) return;
        // attach lower rank representative to higher rank
        /*
        * This optimization aims to keep the tree relatively balanced (approx logn height),
        * preventing it from becoming skewed and ensuring that the depth of the tree remains relatively small.
        */
        if(rank[representativeX]<rank[representativeY]){
            parent[representativeX] = representativeY;
        }else if(rank[representativeX]>rank[representativeY]){
            parent[representativeY] = representativeX;
        }else{
            // ranks are equal
            // attach any of them
            parent[representativeX] = representativeY;
            // and the increase the rank of the new parent
            rank[representativeY]++;
        }
    }
    public void unionBySize(int x, int y){
        int representativeX = find(x);
        int representativeY = find(y);
        if(representativeX==representativeY) return;
        // attach lower size representative to higher size
        // same logic as discussed in unionByRank, but here, we need to update size every time we union
        if(size[representativeX]<size[representativeY]){
            parent[representativeX] = representativeY;
            size[representativeY]+=size[representativeX];
        }
//        we dont need this "else if" condition its redundant
//        else if(size[representativeY]<size[representativeX]){
//            parent[representativeY] = representativeX;
//            size[representativeX]+=size[representativeY];
//        }
        else{
            // both the sets have same size or size of Y < size of X
            parent[representativeY] = representativeX;
            size[representativeX]+=size[representativeY];
        }
    }
}
