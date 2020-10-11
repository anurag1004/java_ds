package com.company.main;
// if no access modifier is provided then its called "default access modifier".
// If its class then this class can be accessed within the same package and cannot be imported to another package
// If its data members then it can be accessed within the same package or same class or sub-class of same package
// but not accessible outside the package.
public class A { // public means this class and be imported or can be used in diff package also
    private int x; // can be accessed within the class
    public int  y; // can be access in the same and different package
    protected int z; // can be access within the same package and subclass but cannot be access from different package
                     // except from a sub-class
    public A(int x,int y,int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getX(){
        return this.x;
    }

}
