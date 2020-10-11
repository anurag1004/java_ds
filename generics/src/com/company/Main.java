package com.company;
class A<T>{ // primitive types are not permitted here
    // Integer,Character,Double,String,Classes
    T obj;
    public A(T obj){
        this.obj = obj;
    }
    public void display(){
        System.out.println(this.obj);
    }
}
public class Main {

    public static void main(String[] args) {
	    A<String> a = new A("Hello");
	    a.display();
    }
}
