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
        System.out.println(list.toString());
        list.swapEveryAdjNodes();
        System.out.println(list.toString());
    }
}
