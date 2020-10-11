package com.company;

class MyLinkedList{
    private Node head;

//    In general, you can (access private fields on inner classes and vice-versa)
    private class Node{
        int key;
        Node next;
        public Node(int key){
            this.key = key;
            next = null;
        }
    }
    public void insert(int key){ //insert last
        Node new_node = new Node(key);
        if(this.head ==  null){
            this.head = new_node;
        }
        else{
            // traverse till last node
            Node last = this.head;
            while(last.next != null){
                last =  last.next;
            }
            last.next = new_node;
        }
    }
    public int removeLast(){
        Node temp = head,prev=null;
        while(temp.next != null){
            prev = temp;
            temp =  temp.next;
        }
        int deleted = temp.key;
        prev.next=null;
        return deleted;
    }
    public void removeKey(int key){
        Node currNode = this.head, prev = null;
        // 1st case: key can be head
        if(currNode != null && currNode.key == key){
            this.head = currNode.next;
            // since currNode is not pointed by any reference, gc will take care of it
            System.out.println("\nKey found and removed !!");
        }
        // 2nd case : key can be anywhere other than head
        while(currNode != null && currNode.key != key){
            prev = currNode;
            currNode = currNode.next;
        }
        // if currNode is null means key is not found
        if(currNode != null){
            prev.next = currNode.next;
            currNode.next = null; // it is not necessary though
            System.out.println("\nKey found and removed !!");
        }
        else{
            System.out.println("\nKey not found int the list :( \n");
        }
    }
    public void display(){
        Node temp = this.head;
        System.out.println();
        while(temp != null){
            System.out.printf("%d, ",temp.key);
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(10);
        myLinkedList.insert(20);
        myLinkedList.insert(30);
        myLinkedList.insert(40);
        myLinkedList.insert(50);
        myLinkedList.insert(60);
        myLinkedList.insert(70);

        myLinkedList.display();
//        myLinkedList.removeLast();
//        myLinkedList.removeLast();
//        myLinkedList.removeLast();
//        myLinkedList.display();
        myLinkedList.removeKey(20);
        myLinkedList.display();
        myLinkedList.removeKey(60);
        myLinkedList.display();
        myLinkedList.removeKey(90);
        myLinkedList.display();
    }
}
