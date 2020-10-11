package com.company;

import java.util.SortedMap;

class CircularLinkedList{
    private Node head,tail;
    private class Node{
        int key;
        Node next;
        public Node(int key){
            this.key = key;
            this.next = null;
        }
    }
    public CircularLinkedList(){
        head = tail =  null;
    }
    public void insertLast(int key){
        Node new_node = new Node(key);
        if(head == null){
            head = new_node;
            tail = new_node;
            new_node.next = head;
        }else{
            // traverse until temporary node reaches last node
            Node currNode = head;
            while(currNode.next != head){
                currNode = currNode.next;
            }
            currNode.next = new_node;
            new_node.next = head;
            tail = new_node;
        }
    }
    public void display(){
        if(head == null){
            System.out.println("\nNo elements in the list!\n");
            return;
        }
        Node temp = head;
        System.out.printf("\n[ ");
        do{
            System.out.printf("%d ",temp.key);
            temp = temp.next;
        }while(temp != head);

        System.out.printf("]\n");

    }
    public void deleteKey(int key){
        // find the key node
        Node currNode = head;
        Node prevNode = null;
        while(currNode.key != key){
            if(currNode.next == head){
                // reached end of the list
                System.out.println("\nNode not found !!\n");
                return;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        // element is found

        // chk if its the only node
        if(currNode.next == currNode){
            head = tail = null;
        }else{
            // List has multiple nodes

            // check if it is head
            if(currNode==head){
                head = currNode.next;
                tail.next = head;
            }else if(currNode == tail){
                // if it is a last node
                prevNode.next = head;
                tail = prevNode;
            }else{
                // anywhere between the list
                prevNode.next = currNode.next;
            }
        }

        System.out.println("\n Node found and deleted!! \n");
    }
    public void deleteLast(){
        if(tail==null){
            System.out.println("\nEmpty List!!\n");
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        // chk if the only one node
        if(temp.next == temp){
            head = null;
            tail = null;
        }else{
            // got the previous node of tail
            temp.next = head;
            tail = temp;
            System.out.println("\nNode deleted!\n");
        }

    }
}
public class Main {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
//        cll.insertLast(10);
//        cll.insertLast(20);
//        cll.insertLast(30);
//        cll.insertLast(40);
//        cll.insertLast(50);
//        cll.insertLast(60);
//
//        cll.display();
//        cll.deleteKey(60);
//        cll.display();
//        cll.deleteKey(50);
//        cll.display();
//        cll.deleteKey(10);
//        cll.display();
//        cll.deleteKey(30);
//        cll.display();
//        cll.deleteKey(20);
////        cll.deleteKey(30);
//        cll.display();
//        cll.deleteKey(40);
//        cll.display();
//        cll.display();
//
//        cll.insertLast(10);
//        cll.insertLast(20);
//        cll.insertLast(30);
//        cll.insertLast(40);
//        cll.insertLast(50);
//        cll.insertLast(60);
//        cll.display();
//
//        cll.deleteKey(40);
//        cll.deleteKey(10);
//        cll.deleteKey(60);
//        cll.display();
//        cll.deleteKey(100);
        cll.insertLast(10);
        cll.insertLast(10);
        cll.insertLast(10);
        cll.display();

        cll.deleteLast();
        cll.deleteLast();
        cll.deleteLast();
        cll.deleteLast();

        cll.display();
    }
}
