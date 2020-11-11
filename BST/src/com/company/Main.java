package com.company;

import java.util.*;

class BST{
    private Node root;
    boolean ifn1present;
    boolean ifn2present;
    public int no_of_nodes;
    private class Node{
        int key;
        Node left,right;
        public Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    public BST(){
        root = null;
        ifn1present = false;
        ifn2present = false;
    }

    public void insert(int key){
        root = insert_Recursive(root,key);
    }
    public boolean search(int key){
        Node temp = search_Recursive(root,key);
        if(temp!=null)
            return true;
        return false;
    }
    public void inOrder(){
        if(root!=null){
            System.out.println("InOrder Traversal");
            inOrder_Recursive(root);
            System.out.println();
        }else {
            System.out.println("Tree is empty!!!!");
        }
    }
    public void preOrder(){
        System.out.println("PreOrder Traversal");
        preOrder_Recursive(root);
        System.out.println();
    }
    public void postOrder(){
        System.out.println("PostOrder Traversal");
        postOrder_Recursive(root);
        System.out.println();
    }
    public void deleteKey(int key){
        root = delete_Recursive(root,key);
    }
    private int inOrderSuc(Node root){
        // min of right subtree
        int min = root.key;
        while (root.left!=null) {
            min = root.left.key;
            root = root.left;
        }
        return min;

    }
    private int inOrderPred(Node root){
        // max of left sub-tree
        int max =  root.key;
        while(root.right!=null){
            max = root.right.key;
            root = root.right;
        }
        return max;
    }
    // recursive methods
    private Node delete_Recursive(Node root,int key){
        if(root == null){
            // if tree is empty
            return null;
        }

        if(key>root.key)
            root.right = delete_Recursive(root.right,key);
        else if(key<root.key)
            root.left = delete_Recursive(root.left,key);
        else{ // if root.key is equal to key
            
            // node with only one child or no child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                // 2 children
                // get the inorder successor
//                root.key = inOrderSuc(root.right);
//                //delete the inOrder Successor (min of right subtree)
//                root.right = delete_Recursive(root.right,root.key);

                // OR
                // get the inOrder predecessor (max of left subtree)
                root.key = inOrderPred(root.left);
                //delete the inOrder predecessor
                root.left = delete_Recursive(root.left,root.key);
            }
        }
        return root;

    }
    private Node search_Recursive(Node root,int key){
        if(root == null) return null;
        else{
            if(root.key ==  key)
                return root;
        }
        if(key>root.key)
            return search_Recursive(root.right,key);
        return search_Recursive(root.left,key);
    }
    private Node insert_Recursive(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        if(key > root.key)
            root.right = insert_Recursive(root.right,key);
        else
            root.left = insert_Recursive(root.left,key);
        return root;
    }
    private void inOrder_Recursive(Node root){
        if(root!=null){
            inOrder_Recursive(root.left);
            System.out.printf("%d ",root.key);
            inOrder_Recursive(root.right);
        }
    }
    private void preOrder_Recursive(Node root){
        if(root!=null){
            System.out.printf("%d ",root.key);
            inOrder_Recursive(root.left);
            inOrder_Recursive(root.right);
        }
    }
    private void postOrder_Recursive(Node root){
        if (root!=null){
            inOrder_Recursive(root.left);
            inOrder_Recursive(root.right);
            System.out.printf("%d ",root.key);
        }
    }
    public int height(){
        return heightRec(this.root);
    }
    private int heightRec(Node root){
        if(root==null)
            return 0;
        int lheight = heightRec(root.left);
        int rheight = heightRec(root.right);

        if(lheight>rheight)
            return (lheight+1);
        return (rheight+1);
    }
    public void printLevelOrder(){ // bfs of binary tree
        int h = height();
        for(int i=1;i<=h;i++)
            printGivenOrder(this.root,i);
    }
    private void printGivenOrder(Node root,int level){
        if(root==null)
            return;
        if(level==1){
            System.out.print(root.key+" ");
        }
        else if(level>1){
            printGivenOrder(root.left,level-1);
            printGivenOrder(root.right,level-1);
        }
    }
    public List<List<Integer>> pathToAllLeaf(){
        List<List<Integer>> paths = new LinkedList<>();
        if(this.root==null) return new LinkedList<>();
        pathToAllLeaf_Recur(root, paths, new LinkedList<>());
        return paths;
    }
    // dfs
    private void pathToAllLeaf_Recur(Node root, List<List<Integer>> paths, List<Integer> curr){
        curr.add(root.key);
        if(root.left==null && root.right==null){ // condition for leaf node
            paths.add(new LinkedList<>(curr));
            return;
        }
        if(root.left!=null)
            pathToAllLeaf_Recur(root.left, paths, new LinkedList<>(curr));
        if(root.right!=null)
            pathToAllLeaf_Recur(root.right, paths, new LinkedList<>(curr));
    }
    public List<Integer> pathFromRoot(int dest){
        List<Integer> out = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        if(this.root==null) return out;
        dfsUtil(root, dest, out, curr);
        return out;
    }
    private void dfsUtil(Node root, int dest, List<Integer> out, List<Integer> curr){
        curr.add(root.key);
        if(root.key==dest){
            out.addAll(curr);
            return;
        }
        if(root.left!=null)
            dfsUtil(root.left, dest, out, new LinkedList<>(curr));
        if(root.right!=null)
            dfsUtil(root.right, dest, out, new LinkedList<>(curr));
    }
    // O(n) (for finding lca) + O(n) (for calculating distance between lca node and  n1) + O(n)  (for d2)
    // Time complexity: O(3n) ~ O(n)
    // Space complexity: O(n) (due to recursion)
    public int findDistanceBetweenTwoNodes(int n1, int n2){
        Node lca = LCA(n1, n2);
        if(lca!=null){
            int d1 = distanceBetweenParentToNode(lca, n1,0);
            int d2 = distanceBetweenParentToNode(lca, n2, 0);
            return d1+d2;
        }
        return -1;
    }
    private int distanceBetweenParentToNode(Node rootNode, int destNodeVal, int currDistance){
        if(rootNode==null) return -1;
        if(rootNode.key == destNodeVal){
            return currDistance;
        }
        // go left and increment current distance by 1
        int left_d = distanceBetweenParentToNode(rootNode.left, destNodeVal, currDistance+1);
        // if dest node is found on left subtree then return its distance relative to parent node
        if(left_d!=-1) return left_d;

        // else the desNode must lie on the right subtree as LCA exists only when both child nodes are present
        // go right and increment current distance by 1
        int right_d = distanceBetweenParentToNode(rootNode.right, destNodeVal, currDistance+1);
        return right_d;
    }

    public Node LCA(int n1, int n2){
        Node lca = LCA_Recur(this.root, n1, n2);
        if(ifn1present && ifn2present) {
            System.out.println("LCA of "+n1+" & "+n2+" is "+lca.key);
            return lca;
        }else{
            System.out.println("No LCA exists!");
            return null;
        }
    }
    // Time complexity: O(h)
    // Space : O(h)
    private Node LCA_Recur(Node root, int n1, int n2){
        if(root==null) return null;
        if(root.key == n1){
            ifn1present = true;
            return root;
        } if (root.key == n2){
            ifn2present = true;
            return root;
        }
        Node leftSearch = LCA_Recur(root.left, n1, n2);
        Node rightSearch = LCA_Recur(root.right, n1, n2);
        if(leftSearch!=null && rightSearch!=null) return root;

        return leftSearch!=null?leftSearch:rightSearch;

    }

    // this algo below  is same as for finding height of the tree! :)
    public int longestPathLength(){
        if(this.root==null) return 0;
        return longestPathLenghtRecur(this.root);
    }
    private int longestPathLenghtRecur(Node root){
        if(root==null) return 0;
        int left = longestPathLenghtRecur(root.left);
        int right = longestPathLenghtRecur(root.right);
        if(left>right) return left+1;
        return right+1;
    }
    public List<Integer> longestPathFromRoot(){
        List<Integer> out = longestPathRecur(this.root);
        return out;
    }
    private List<Integer> longestPathRecur(Node root){
        if(root==null) return new ArrayList<>();

        List<Integer> left = longestPathRecur(root.left);
        List<Integer> right = longestPathRecur(root.right);
        if(left.size() > right.size()){
            left.add(root.key);
            return left;
        }
        else {
            right.add(root.key);
            return right;

        }
    }

    // if no of nodes is 'E' then no of edges is 'E-1'
    private int depth(Node root){
        if(root==null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        no_of_nodes = Math.max(no_of_nodes, l+r+1); // keep track of max no of nodes
        return Math.max(l,r)+1; // return current height or depth
    }
    public int diameter(){
        if(this.root==null) return 0;
        no_of_nodes = 1; // since roots exists
        depth(root);
        return no_of_nodes-1; // distance between two nodes is no of nodes between them minus one;
    }
}
public class Main {

    public static void main(String[] args) {
        BST root = new BST();
        root.insert(10);
        root.insert(6);
        root.insert(12);
        root.insert(4);
        root.insert(8);
        root.insert(11);
        root.insert(13);
        root.insert(7);
        root.insert(20);
        root.insert(15);
        root.insert(25);
        root.insert(17);
        root.insert(26);
        root.insert(27);
         /*         10
                 //    \\
                 6      12
               // \\   // \\
               4   8  11   13
                  //        \\
                  7          20
                            // \\
                           15   25
                            \\   \\
                             17   26
                                   \\
                                    27
               Level order: 10 6 12 4 8 11 13 7 20 15 25 17
          */
        System.out.println(root.findDistanceBetweenTwoNodes(11,25));
        List<Integer> longestPathFromRoot = root.longestPathFromRoot();
        // just reversing (as we'r using recursion the root node will be added in last call), not needed actually
        Collections.reverse(longestPathFromRoot);

        System.out.println(longestPathFromRoot);

        System.out.println(root.pathFromRoot(15));
        System.out.println(root.pathToAllLeaf());

        System.out.println(root.longestPathLength());
        System.out.println(root.diameter());
    }
}
