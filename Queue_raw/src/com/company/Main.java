package com.company;
class MyQueue<T>{
    private int front,rear,size;
    private int capacity;
    private T[] queue;
    public MyQueue(int capacity){
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity-1;
        queue = (T[])new Object[this.capacity];
    }
    private boolean isEmpty(){
        return (this.size == 0);
    }
    private boolean isFull(){
        return (this.size == this.capacity);
    }
    public void enqueue(T ele){
        if(isFull()){
            System.out.println("\nQueue Full\n");
            return;
        }
        this.rear = (this.rear+1)%this.capacity;
        queue[rear] = ele;
        size++;
    }
    public T dequeue(){
        if(isEmpty()){
            System.out.println("\nQueue Empty!!\n");
            return null;
        }
        T temp = queue[front];
        this.front = (this.front+1)%this.capacity;
        size--;
        return temp;

    }
    public void display(){
        if(!isEmpty()){
            System.out.printf("\n[ ");
            for(int i=front;i<=rear;i++){
                System.out.printf("%s ",queue[i]);
            }
            System.out.printf("]\n");
            showVars();
        }else{
            System.out.println("\nQueue is Empty!!\n");
            showVars();
            return;
        }
    }
    public T getFront(){
        if(isEmpty())
            return null;
        return queue[front];
    }
    public T getRear(){
        if(isEmpty())
            return null;
        return queue[rear];
    }
    private void showVars(){
        System.out.println("Front : "+this.front);
        System.out.println("Rear  : "+this.rear);
        System.out.println("Size  : "+this.size);
    }

}
public class Main {

    public static void main(String[] args) {
        MyQueue<Character> myQueue = new MyQueue<Character>(6);

        myQueue.display();

        myQueue.enqueue('a');
        myQueue.enqueue('b');
        myQueue.enqueue('c');
        myQueue.enqueue('d');
        myQueue.display();

        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.display();

        myQueue.enqueue('e');
        myQueue.display();

        myQueue.dequeue();
        myQueue.display();

        myQueue.enqueue('f');
        myQueue.enqueue('g');
        myQueue.enqueue('h');

        myQueue.display();
//        myQueue.enqueue('f');
//        myQueue.display();
//        myQueue.dequeue();
//        myQueue.display();

//        MyQueue<Integer> myQueue1 = new MyQueue<Integer>(5);
//        myQueue1.enqueue(14);
//        myQueue1.enqueue(22);
//        myQueue1.enqueue(13);
//        myQueue1.enqueue(-6);
//
//        myQueue1.display();
//
//        myQueue1.dequeue();
//        myQueue1.dequeue();
//        myQueue1.display();
//
//        myQueue1.enqueue(9);
////        myQueue1.enqueue(20);
//        myQueue1.display();

    }
}
