package com.recursive;
// Time Complexity : O(n)
class LinkedList {
    Node head;
    private int length;
    private Node last;
    class Node{
        int val;
        Node next;
        public Node(){};
        public Node(int val){this.val=val;}
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
    public LinkedList(){
        head = null;
        last  = null;
        length = 0;
    }
    public void insert(int value){
        Node new_node =  new Node(value,null);
        if(head==null){
            head = new_node;
            last =  head;
        }
        else{
            last.next = new_node;
            last = new_node;
        }
        this.length++;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        Node temp = head;
        while (temp!=null){
            str.append(temp.val+" ");
            temp=temp.next;
        }
        str.append("]");
        return str.toString();
    }
    public int getLength(){return this.length;}
    public void swapEveryAdjNodes(){
        Node dummy =  new Node(-1,this.head);
        Node curr = head;

        swapEveryAdjNodesRecur(dummy,curr);
        head = dummy.next;
    }
    public void reverse(){
        reverseUtil(this.head);
    }
    public void reverseUtil(Node node){
        Node prev = null;
        Node curr = node;
        Node next = null;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }
    public void reverse_Till_Kth_Node(int k){
        /*
            First traverse the list till kth node,
            and reverse this k length list.
            Pick the first node of this reversed list and join with (k+1)th node
        */
        // maintain four pointers
        Node prev = null;
        Node curr = head;

        // this node will be used in last step when joining first node to the (k+1)th node
        Node dummy = new Node(-1,head);
        Node new_head = dummy;
        int i=0;
        // traverse till kth node
        while(i<k && new_head!=null){
            new_head = new_head.next;
            i++;
        }
        // if k exceeds the length of the whole list
        if(new_head==null) return;

        // start reversing k length list
        Node temp = curr.next;
        while (curr!=new_head){
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        curr.next = prev;
        new_head = curr;

       // Pick the first node of this reversed list and join with (k+1)th node
        dummy.next.next = temp;

        this.head = new_head;
    }
    private void swapEveryAdjNodesRecur(Node prev,Node curr){
        if(curr==null || curr.next==null) return;
        Node first = curr;
        Node second = curr.next;
        // swap first and second node
        Node new_curr = second.next;
        second.next = first;
        first.next = new_curr;
        // update prev.next
        prev.next = second;
        // point prev to first node as they are swaped
        prev = first;

        swapEveryAdjNodesRecur(prev,new_curr);
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());
    }
}
