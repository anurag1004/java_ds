package com.company;
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
//                //delete the inOrder Successor
//                root.right = delete_Recursive(root.right,root.key);

                // OR
                // get the inOrder predecessor
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
}
public class Main {

    public static void main(String[] args) {
        BST root = new BST();
        root.insert(10);
        root.insert(6);
        root.insert(12);
        root.insert(4);
        root.insert(8);
         /*        10
                 //  \\
                 6    12
               // \\
               4   8
               Level order: 10 6 12 4 8
          */
        root.inOrder();
        root.preOrder();
        root.postOrder();

        System.out.println("Key 6 found : "+root.search(6));
        root.deleteKey(10);
        root.inOrder();
    }
}
