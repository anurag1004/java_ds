package com.company.main;
// main and test are subpackage
import in.something.C;
import in.something.D;
public class Main {

    public static void main(String[] args) {
        A a1 = new A(10,20,30);
        B b1 = new B(40,50,60);
        System.out.printf("%d %d %d \n",a1.getX(),a1.y,a1.z);
        System.out.printf("%d %d %d \n",b1.getX(),b1.y,b1.z);

        C c1 = new C(80,90,100);
        System.out.println(c1.getSomething());
        c1.print_protected_member_of_B();
        System.out.println(c1.z); // C(in a different package) is subclass of B
                                  // that's why it can access B's protected member
        D d = new D(1,2,3);
        d.print_protected_member_from_different_package();
    }
}
