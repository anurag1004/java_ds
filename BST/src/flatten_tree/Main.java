package flatten_tree;

import java.util.Stack;

class Node{
    int val;
    public Node left, right;
    public Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

public class Main {
    public static void display_inOder(Node root){
        if(root!=null){
            display_inOder(root.left);
            System.out.print(" "+root.val);
            display_inOder(root.right);
        }
    }
    public static void flatten(Node root){
        if(root==null) return;

        if(root.left==null && root.right==null) return;

        if(root.left!=null){
            flatten(root.left);

            Node node = root.right;
            root.right = root.left;
            root.left = null;

            Node curr = root.right;
            // find the pos to insert the rest of right node
            while (curr.right!=null){
                curr = curr.right;
            }
            curr.right = node;
        }
        // call the same for right subtree
        flatten(root.right);
    }
    public static void flatten_iter(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        // top to bottom
        while (!stack.isEmpty()){
            Node currNode = stack.pop(); //  curr root node
            //push right child to stack, if exist
            if(currNode.right!=null)  stack.push(currNode.right);

            // push left child to stack, if exist
            if(currNode.left!=null) stack.push(currNode.left);

            // check if stack is empty or not
            // if stack is non empty, means the currNode has children so the stack[top] will be our left child(as it was pushed last)
            // we want all left nodes of parent to its right
            if(!stack.isEmpty())
                currNode.right = stack.peek();

            currNode.left = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.right = new Node(6);

        /*
        *               1
        *              /  \
        *            2     5
        *          /  \      \
        *        3     4      6
        *
        * */
        display_inOder(root);
        System.out.println();
        flatten_iter(root);
        display_inOder(root);
    }
}
