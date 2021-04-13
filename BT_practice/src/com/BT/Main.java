package com.BT;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val){
        left = right = null;
        this.val = val;
    }
}
class BST{
    TreeNode root;
    public BST(){
        root = null;
    }
    public void insert(int val){
        root = insertRec(root, val);
    }
    private TreeNode insertRec(TreeNode root, int val){
        if(root==null) return new TreeNode(val);
        if(val > root.val) root.right = insertRec(root.right, val);
        else root.left = insertRec(root.left,val);
        return root;
    }
    public void inOrder(){
        inOrderRec(root);
    }
    public void preOrder(){
        preOrderRec(root);
    }
    public int depth(){
        return depthRecur(root);
    }
    // slower than bfs
    public int minDepthDFS(){
        return minDepthDFS(this.root);
    }
    private int minDepthDFS(TreeNode node){
        if(root==null) return 0;
        int left = minDepthDFS(node.left);
        int right = minDepthDFS(node.right);
        return (left==0 || right==0) ? left+right+1:Math.min(left, right)+1;
    }
    public int minDepthBFS(){
        return minDepthBFS(this.root);
    }
    public int minDepthBFS(TreeNode node){
        if(node==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int min = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(node.left==null && node.right==null) return min+1;
            }
            min++;
        }
        return min;
    }
    // level order traversal
    public void bfs(){
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curr);
        while (!queue.isEmpty()){
            curr = queue.poll();
            System.out.print(" "+curr.val);
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
    }
    private void inOrderRec(TreeNode root){
        if(root!=null){
            inOrderRec(root.left);
            System.out.print(" "+root.val);
            inOrderRec(root.right);
        }
    }
    private void preOrderRec(TreeNode root){
        if(root!=null){
            System.out.print(" "+root.val);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    public void InorderDfsItr(){
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(" "+curr.val);
            curr = curr.right;
        }
    }
    public void PreOrderDfsItr() {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(" " + curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }
    private int depthRecur(TreeNode node){
        if(node==null) return 0;
        int lh = depthRecur(node.left);
        int rh = depthRecur(node.right);
        return Math.max(lh, rh)+1;
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    private boolean validate(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        else if(min!=null && root.val <= min || max!=null && root.val >=max) return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
    public int findDistanceFromParent(TreeNode root, int targetVal, int dist){
        if(root==null) return -1; //target value not found
        if(root.val==targetVal){
            //target value found
            return dist;
        }
        dist++;
        int left_search = findDistanceFromParent(root.left, targetVal, dist);
        if(left_search!=-1) return left_search; //target node found in left subtree
        return findDistanceFromParent(root.right, targetVal, dist);
    }
    TreeNode LCS(int a, int b, TreeNode root){
        if(root==null) return null;
        if(root.val==a || root.val==b) return root;
        TreeNode left = LCS(a,b, root.left);
        TreeNode right = LCS(a,b,root.right);
        if(left!=null && right!=null) return root;
        if(left==null) return right;
        return left;
    }
}
public class Main {
    public static void main(String[] args){
        int[] arr = {5,4,8,11,13,7,2,1,15,25,23,26,14,40,39,50};
        BST bst = new BST();
        for(int x:arr){
            bst.insert(x);
        }
        ////////////////////////////////////
        System.out.println("Inorder");
        bst.inOrder();
        System.out.println();
        bst.InorderDfsItr();
        ////////////////////////////////////
        System.out.println("\nPreOrder");
        bst.preOrder();
        System.out.println();
        bst.PreOrderDfsItr();
        ///////////////////////////////////
        System.out.println();
        System.out.print("Depth "+bst.depth()+"\n");
        //////////////////////////////////
        bst.bfs();
        //////////////////////////////////
        System.out.println();
        System.out.println(bst.findDistanceFromParent(bst.root, 14, 0));
        //////////////////////////////////
        TreeNode lcs = bst.LCS(14,39,bst.root);
        System.out.println(bst.findDistanceFromParent(lcs,14,0)+bst.findDistanceFromParent(lcs,39,0));
    }
}
