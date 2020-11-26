package flatten_tree;
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
        flatten(root);
        display_inOder(root);
    }
}
