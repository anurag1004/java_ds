package com.BT;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val){
        left = right = null;
        this.val = val;
    }
}
// queue obj for vertical order traversing
class Node{
    TreeNode root;
    int level; //vertical level i.e ...-2, -1, 0, 1, 2...
    public Node(TreeNode root, int level){
        this.root = root;
        this.level = level;
    }
}
class BST{
    TreeNode root;
    public BST(){
        root = null;
    }
    public TreeNode getRoot(){ return this.root; }
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
     public List<Integer> longestPathFromRoot(TreeNode root){
        if(root==null) return new ArrayList<>();
        List<Integer> left = longestPathFromRoot(root.left);
        List<Integer> right = longestPathFromRoot(root.right);
        if(left.size()>right.size()){
            left.add(root.val);
            return left;
        }
        right.add(root.val);
        return right;
    }
    public void pathToAllLeafFromRoot(TreeNode root, List<List<Integer>> out, List<Integer> curr){
        if(root==null) return;
        curr.add(root.val);
        if(root.left==null && root.right==null){
            out.add(curr);
            return;
        }
        pathToAllLeafFromRoot(root.left, out, new ArrayList<>(curr));
        pathToAllLeafFromRoot(root.right, out, new ArrayList<>(curr));
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
class BinaryTree{
    TreeNode root;
    public BinaryTree(){
        root = null;
    }
    public TreeNode getRoot(){ return this.root;}
    public void insert(int val){
        TreeNode newNode = new TreeNode(val);
        if(this.root==null){
            this.root = newNode;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        // insert via level order traversal
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode node = queue.poll();
                if(node.left==null){
                    node.left = newNode;
                    return;
                }
                if(node.right==null){
                    node.right = newNode;
                    return;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }
    public void bfs(){
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curr);
        while (!queue.isEmpty()){
            curr = queue.poll();
            System.out.print(curr.val+" ");
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
    }
}
public class Main {
    // vertical order traversing for getting top view
    public static List<Integer> getTopView(TreeNode root){
        Map<Integer, Integer> treeMap = new HashMap<>();
        List<Integer> out = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        treeMap.put(0, root.val);
        out.add(root.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                Node node = queue.poll();
                int level = node.level;
                if(!treeMap.containsKey(level)){
                    if(level<0)
                        out.add(0, node.root.val);
                    else
                        out.add(node.root.val);
                    treeMap.put(level, node.root.val);
                }
                if(node.root.left!=null)
                    queue.add(new Node(node.root.left, level-1));
                if(node.root.right!=null)
                    queue.add(new Node(node.root.right, level+1));
            }
        }
        return out;
    }
    public static List<List<Integer>> getVerticalOrderTraversal(TreeNode root){
        if(root==null) return new ArrayList<>();
        Map<Integer, List<Integer>> treeMap = new HashMap<>();
        int min_key = 0;
        int max_key = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                Node node = queue.poll();
                int level = node.level;
                min_key = Math.min(level, min_key);
                max_key = Math.max(level, max_key);
                if(!treeMap.containsKey(level)){
                    treeMap.put(level, new LinkedList<>(Arrays.asList(node.root.val)));
                }else{
                    List<Integer> temp = treeMap.get(level);
                    temp.add(node.root.val);
                    treeMap.put(level, temp);
                }
                if(node.root.left!=null)
                    queue.add(new Node(node.root.left, level-1));
                if(node.root.right!=null)
                    queue.add(new Node(node.root.right, level+1));
            }
        }
        List<List<Integer>> out = new ArrayList<>();
        while (min_key<=max_key){
            out.add(treeMap.get(min_key++));
        }
        return out;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        BinaryTree bt = new BinaryTree();
        for(int x:arr) bt.insert(x);
        System.out.println("BFS");
        bt.bfs();
        System.out.println();
        List<Integer> out = getTopView(bt.getRoot());
        Iterator<Integer> it = out.iterator();
        System.out.println("Top View");
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println("\nVertical Traversal");
        List<List<Integer>> list = getVerticalOrderTraversal(bt.getRoot());
        System.out.println(list);
    }
}
