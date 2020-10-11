package com.company;

import java.util.Stack;

public class Main {
    // stack class is a direct sub-class of Vector
    // pop(),peek() [returns top element without removing it]
    // push()
    // search()
    // Returns the position of the element if it is successfully found in the stack (taking the count as base 1) else -1 is returned.
    // relative to top position(top position is considered as 1)
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>(); //creates an empty stack
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
//        System.out.println(stack.size()); // to get num of elements
        int len = stack.size();
        System.out.println(stack.search('b')); //3
        for(int i=0;i<len;i++){
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());
    }
}
