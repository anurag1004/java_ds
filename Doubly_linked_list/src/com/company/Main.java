package com.company;
class MyDoublyList{
    private Node head;
    private class Node{
        int key;
        Node next,prev;
        public Node(int key){
            this.key = key;
            next = prev = null;
        }
    }
    public void insertFirst(int key){
        Node new_node = new Node(key);

        if(this.head == null){
            this.head = new_node;
            return;
        }

            new_node.next = this.head;
            head.prev = new_node;
            this.head = new_node;

    }
    public void insertBefore(int new_key,int existing_key){
        Node new_node  = new Node(new_key);
        Node currNode = this.head;
        if(currNode != null && currNode.key == existing_key){
            // key found in head
            new_node.next = this.head;
            head.prev = new_node;
            this.head = new_node;
        }
        else{
            while(currNode != null && currNode.key != existing_key){
                currNode = currNode.next;
            }
            if(currNode!=null){
                // key found
                Node prevNode = currNode.prev;

                new_node.next = currNode;
                new_node.prev = prevNode;

                prevNode.next = new_node;
                currNode.prev = new_node;

            }else{
                System.out.println("\nNo such key exist... Skipping node addition!");
            }
        }
    }
    public void display(){
        Node temp = this.head;
        System.out.printf("\n[ ");
        while(temp != null){
            System.out.printf("%d ",temp.key);
            temp=temp.next;
        }
        System.out.printf("] \n");
    }
}
public class Main {

    public static void main(String[] args) {
        MyDoublyList dll = new MyDoublyList();
        dll.display();
        dll.insertFirst(10);
        dll.display();
        dll.insertFirst(20);
        dll.display();
        dll.insertFirst(30);
        dll.display();
        dll.insertFirst(40);
        dll.display();
        dll.insertFirst(50);
        dll.display();

        dll.insertBefore(5,0);
        dll.display();
    }
}
