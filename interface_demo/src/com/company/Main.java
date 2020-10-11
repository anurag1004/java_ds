package com.company;

  ///////////////////////////////////////
//  class     ------------> class       //
//               extends                //
//  class     ------------> interface   //
//              implements              //
//  interface ------------> interface   //
//                extends               //
 ///////////////////////////////////////

// Interface //
// It is used to achieve abstraction.
// By interface, we can support the functionality of multiple inheritance.
// all methods are abstract(function with no body)

// Abstract Class //
//class which is declared with the abstract keyword is known as an abstract class in Java.
// It can have abstract and non-abstract methods
//An abstract class must be declared with an abstract keyword.
//        It can have abstract and non-abstract methods.
//        It cannot be instantiated.
//        It can have constructors and static methods also.
//        It can have final methods which will force the subclass not to change the body of the method.
interface Vehicle{
    // by default all members are public,static and final
    // since variables are by default final... they must be initialized with some value
    public void horn();
    public void viewModel();
}
class Car implements Vehicle{
    private String model;
    public Car(String model){
        this.model = model;
    }
    protected void test(){
        System.out.println("protected func");
    }
    public Car(Car c){
        this.model = c.model;
        // The access modifiers work on class level, and not on object level.
        // That is, two objects of the same class can access each others private data.
    }
    public static void staticFunction(){
        System.out.println("You are accessing me without an instance of my class :)");
    }
    @Override
    public void horn() {
        System.out.println("Ping Pong");
    }

    @Override
    public void viewModel() {
        System.out.printf("Model : %s\n",this.model);
    }
}
public class Main {

    public static void main(String[] args) {
        Car c1 = new Car("MX990i");
        Car c2 = c1; // c2 is pointing to c1.  or c2 is a reference to (any)object of class Car
        Car c3 = new Car(c1); // deep copy or copying value by value
        c1.viewModel();
        c1.horn();
        System.out.println(c1==c2);
        System.out.println(c3==c1);
        // calling static methods
        Car.staticFunction();
        c1.test();
    }
}
