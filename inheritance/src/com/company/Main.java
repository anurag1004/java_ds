package com.company;
interface blueprint{
    public void something();
}
class A{
    public int x;
    public A(int x) {
        this.x = x;
    }
}
class B extends A{
    public B(int x){
        super(x);
    }
}
// multiple inheritance achieved using interface
class C extends A implements blueprint{
    public C(int x){
        super(x);
    }
    @Override
    public void something(){
        System.out.println("Something from interface \"blueprint\" ");
    }
}
public class Main {

    public static void main(String[] args) {
        C c = new C(10);
        c.something();
    }
}
