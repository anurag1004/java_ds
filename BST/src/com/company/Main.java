package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BST{
    private Node root;
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
    public List<Integer> pathFromRoot(int dest){
        List<Integer> out = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        curr.add(root.key);
        dfsUtil(this.root, dest, out,curr);
        return out;
    }
    public void dfsUtil(Node root, int dest, List<Integer> out, List<Integer> curr){
        if(root.key==dest){
            out.addAll(curr);
            return;
        }
        if(root==null) return;
        // check left
        if(root.left!=null) {
            curr.add(root.left.key);
            dfsUtil(root.left, dest, out, curr);
            curr.remove(curr.size() - 1); // backtrack
        }
        // check right
        if(root.right!=null) {
            curr.add(root.right.key);
            dfsUtil(root.right, dest, out, curr);
            curr.remove(curr.size() - 1); // backtrack
        }
    }
    public int LCA(int n1, int n2){
        Node lca = LCA_Recur(this.root, n1, n2);
        return lca==null?-1:lca.key;
    }
    // Time complexity: O(h)
    // Space : O(h)
    private Node LCA_Recur(Node root, int n1, int n2){
        if(root==null) return null;
        if(root.key == n1 || root.key == n2)
            return root;
        Node leftSearch = LCA_Recur(root.left, n1, n2);
        Node rightSearch = LCA_Recur(root.right, n1, n2);
        if(leftSearch!=null && rightSearch!=null) return root;
        if(leftSearch==null&&rightSearch==null) return null;

        if(leftSearch==null) return rightSearch;
        else return leftSearch;

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
         /*        10
                 //  \\
                 6    12
               // \\
               4   8
               Level order: 10 6 12 4 8
          */
        System.out.println("Level Order: ");
        root.printLevelOrder();
        System.out.println();
        System.out.println("Lowest Common ancestor of 4 and 8 is "+root.LCA(14, 18));
        root.inOrder();
        root.preOrder();
        root.postOrder();
//
        System.out.println("Key 6 found : "+root.search(6));
//        System.out.println("Deleting key 10...");
//        root.deleteKey(10);
//        root.inOrder();
        System.out.println("Height : "+root.height());
        System.out.println(root.pathFromRoot(17));
    }
}
