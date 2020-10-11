package com.company;

public class Main {
    static int a = 10;
    int b = 20;
    public static void staticMethod(){
        System.out.println("HALOO");
    }
    public void nonStaticMethod(){
        System.out.println("BOI BOII");
    }
    public static void main(String[] args) {
    // Static Methods can access class variables(static variables) without using object(instance) of the class,
    // however non-static methods and non-static variables can only be accessed using objects.
    // Static methods can be accessed directly in static and non-static methods.
        System.out.printf("Static var : %d\n",a);
    // System.out.println(b); //this will throw error
        // java: non-static variable b cannot be referenced from a static context
        // crate a instance of Main
        Main m1 = new Main();
        System.out.printf("Non-static var from static method using object :%d\n",m1.b);
        Main.staticMethod();
        //or
        staticMethod();
        // calling non static method using object
        m1.nonStaticMethod();
    }
}
