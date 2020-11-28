package balancedBSTFromArray;

import java.util.Arrays;

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
    public static Node constructBalancedBST(int p, int q, int[] arr){
        if(p<q){
            int mid = (p+q)/2;
            Node root = new Node(arr[mid]);
            root.left = constructBalancedBST(p, mid-1, arr);
            root.right = constructBalancedBST(mid+1, q, arr);
            return root;
        }
        return p==q? new Node(arr[p]): null;
    }
    public static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(" "+root.val);
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        Arrays.sort(arr);
        Node root = constructBalancedBST(0, arr.length-1, arr);
        inOrder(root);
    }
}
