package com.company;

import java.util.*;
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}
class LinkedList{
    Node root;
    public LinkedList(){ root = null; }
    public void addNode(int val){
        if(root==null){
            root = new Node(val,  null);
        }else{
            Node curr = root;
            while(curr.next!=null) curr = curr.next;
            curr.next = new Node(val, null);
        }
    }
}
public class Main {
    public static void printNodes(Node root){
        Node temp = root;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node reverse(Node root){
        Node prev = null;
        Node curr = root;
        Node nxt = null;
        while (curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public static Node reverseKgroups(Node root, int k){
        Node prev = null;
        Node curr = root;
        Node nxt;
        int count = k;
        while (count-->0 && curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        if(curr!=null){
            root.next = reverseKgroups(curr, k);
        }
        return prev;
    }
    public static Node removeDuplicates(Node root){
        Node dummy = new Node(-1, null);
        Node prev = dummy;
        Node nxt = root;
        //build a set
        Set<Integer> set = new HashSet<>();
        while (nxt!=null){
            if(!set.contains(nxt.val)){
                prev.next = nxt;
                prev = nxt;
                set.add(nxt.val);
            }
            nxt = nxt.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
	// write your code here
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(4);
        list.addNode(2);
        list.addNode(6);
        list.addNode(2);
        list.addNode(4);
        list.addNode(10);
        // printNodes(list.root);
        //  list.root = reverseKgroups(list.root, 3);
        printNodes(list.root);
        printNodes(removeDuplicates(list.root));
    }
}
