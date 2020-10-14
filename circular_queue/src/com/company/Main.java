package com.company;

import java.util.ArrayList;
// another approach
//https://www.programiz.com/dsa/circular-queue
class CircularQueue{
    private int front,rear,size;
    private ArrayList<Integer> queue;
    public CircularQueue(int size){
        this.size = size;
        this.front = this.rear = -1;
        queue = new ArrayList<Integer>();
    }
    private boolean isEmpty(){
        return  (front == -1);
    }
    private boolean isFull(){
        // if front starts from zero and rear is at last index
        // OR
        // if rear is just before front
        return ( (front == 0 && ( rear == (size-1) ) ) || rear == (front-1)%(size-1) );
    }
    public void enqueue(int key){
        if(isFull()){
            System.out.println("\nQueue Full!!\n");
            return;
        }
        if(front == -1){
            // queue is empty
            front = 0;
            rear = 0;
            queue.add(rear,key);
        }
        else if(front !=0 && rear == size-1){
            // front is somewhere other than index 0 and rear is at last index
            // since it is circular queue, the rear will just go back to starting
            rear = 0;
            // update  element at index 0
            queue.set(rear,key);
        }else{
            // rear has not reached last index
            rear++;
            if(front<=rear){
                // adding a new element since rear has not reached last
                queue.add(rear,key);
            }else{
                // front is ahead of rear
                // we'll just update the value at index rear
                queue.set(rear,key);
            }
        }
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("\nQueue is Empty!!\n");
        }
        int temp = queue.get(front);
        if(front == size-1){
          front = 0;
        }else if(front == rear){
            // condition for only one element
            front = -1;
            rear = -1;
        }else{
            // front > rear or front < rear
            front++;
        }
        return temp;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("\nQueue Empty\n");
            return;
        }
        int i;
            System.out.printf("\n[ ");
            for(i=front;i!=rear;i=(i+1)%size){
                System.out.printf("%d ",queue.get(i));
            }
            System.out.printf("%d ",queue.get(i));
            System.out.printf("]\n");
            showVars();
    }
    private void showVars(){
        System.out.println("Front : "+ this.front);
        System.out.println("Rear  : "+ this.rear);
//        System.out.println("Size  : "+ this.size);
    }
}
public class Main {

    public static void main(String[] args) {
	    CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);

        cq.display();

        cq.dequeue();
        cq.dequeue();
        cq.display();

        cq.enqueue(50);
        cq.enqueue(60);
        cq.enqueue(70);
        cq.display();

        cq.enqueue(80);
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.display();

        cq.enqueue(10);
        cq.display();
    }
}
