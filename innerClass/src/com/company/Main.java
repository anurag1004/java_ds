package com.company;
//If the inner class defined as private and protected, can outer class access the members of inner class?
//
//        Yes. These qualifiers will only affect the visibility of the inner class in classes that derive from the outer class.
//
//        Can inner class access members of outer class?
//
//        Yes, including the ones declared private, just as any instance method can.
// In general, You can access both an inner class member from outer class, and vice-versa(irrespective of the access modifier)
class A{
    private int x;
    private B b;
    public A(int x){
        this.x = x;
    }
    public int getX(){ return x;}
    class B{ //inner class have access to outer class members(including private members)
        int y;
        public B(int y){
            this.y = y;
        }
        public int getY(){ return this.y;}
        public int getX(){return x;}
    }
}
public class Main {

    public static void main(String[] args) {
        A obj1 = new A(10);
        A.B obj2 = obj1.new B(20);
        System.out.println(obj1.getX());
        System.out.println(obj2.getY());
        System.out.println(obj2.getX());
    }
}
