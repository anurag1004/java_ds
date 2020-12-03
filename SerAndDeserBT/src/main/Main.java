package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left, right;
    public Node(int val){
        this.val = val;
        left = right = null;
    }
}
class BTree{
    Node root;
    public BTree(){
        root = null;
    }

    public void inOrder(){
        System.out.println("InOrder Traversal");
        inOrderRecur(this.root);
        System.out.println();
    }
    private void inOrderRecur(Node root){
        if(root!=null){
            inOrderRecur(root.left);
            System.out.print(root.val+" ");
            inOrderRecur(root.right);
        }
    }
}
public class Main {
    public static String serialize(Node root){
        if(root==null) return "X";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val+","+left+","+right;
    }
    public static Node deserialize(String sezStr){
        Queue<String> queue = new LinkedList<>(Arrays.asList(sezStr.split(",")));
        return deserializeHelper(queue);
    }
    private static Node deserializeHelper(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("X")) return null;
        Node node = new Node(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
    public static void main(String[] args) {
        BTree tree = new BTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(7);
        tree.root.right.right = new Node(5);
        tree.root.right.right.left = new Node(8);
        tree.root.right.right.right = new Node(10);
        tree.root.right.right.left.right = new Node(4);
        tree.root.right.right.right.left = new Node(2);

        tree.inOrder();
        System.out.println(serialize(tree.root));
        BTree tree1 = new BTree();
        tree1.root = deserialize(serialize(tree.root));
        tree1.inOrder();
    }
}
