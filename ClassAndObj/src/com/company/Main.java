package com.company;
import com.company.Dog;
class  Test{
    public Test(){
        System.out.println("Test object created");
    }
}
public class Main {

    public static void main(String[] args) {
        Test t = new Test();
        Dog myDog = new Dog("Brio","Black");
        Cat myCat = new Cat("Tom","White");
        myDog.speak();
        myDog.intro();

        myCat.speak();
        myCat.intro();
    }
}
