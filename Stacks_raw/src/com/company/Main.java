package com.company;

class MyStack<T> {
    private T[] stack;
    private int top;
    private int max_size;
    public MyStack(int size){
        stack = (T[])new Object[size];
        max_size = size-1;
        top = -1;
    }
    public void push(T element){
        if(top >= max_size){
            System.out.println("\nStack OverFlow\n");
            return;
        }
        top++;
        stack[top] = element;
    }
    public T pop(){
        if(top == -1){
            System.out.println("\nStack UnderFlow\n");
            return null;
        }
        return stack[top--];
    }
    public void display(){
        if(top == -1){
            System.out.println("\nStack empty!!\n");
            return;
        }
        System.out.printf("\n[ ");
        for(int i=0;i<=top;i++){
            System.out.printf("%s ",stack[i]);
        }
        System.out.printf("]\n");

    }
    public T peek(){
        if(top == -1){
            System.out.println("\nStack empty!!\n");
            return null;
        }
        return stack[top];
    }
}
public class Main {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
//        stack.display();
//        System.out.println(stack.pop());
//        stack.display();
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//
//        stack.display();

        MyStack<Integer> stack1 = new MyStack<Integer>(2);
        stack1.push(70);
        stack1.push(80);
//        stack1.display();
//        stack1.push(100);
//        stack1.display();

        MyStack<Character> stack2 = new MyStack<Character>(2);
        stack2.push('a');
        stack2.push('d');
        stack2.push('c');
        stack2.push('e');
        stack2.display();
    }
}
