package com.company;

public class Main {

    public static void main(String[] args) {
        Complex c;
	    Complex c1 = new Complex(5,6);
	    // copy constructor
	    Complex c2 = new Complex(c1);
        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println(c1.getClass().getSimpleName());
        System.out.println("a".getClass().getName());

    }
}
