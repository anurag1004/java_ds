package com.company;
class Rectangle{
    int length;
    int breadth;
    public Rectangle(int l,int b){
        this.length = l;
        this.breadth = b;
    }
    public int getArea(){ return length*breadth; }
}
public class Main {

    public static void main(String[] args) {
        Rectangle r1,r2;
        // r1 and r2 are to reference vars
        // which can refer to address containing object of class Rectangle
        r1 = new Rectangle(10,12);
        r2 = r1;
        // r2 is referring to r1, means r1 and r2 are both referring to same object
        System.out.println(r1.toString()); // will return a unique object id
        System.out.println(r2.toString()); // same as above
    }
}
