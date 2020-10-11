package com.company;

class Dog extends Animal {
    String name;
    public Dog(String name,String color){
        super(color);
        this.name = name;
    }
    @Override
    public void speak(){
        System.out.println("Bhau Bhau");
    }

    @Override
    public void intro() {
     System.out.printf("My name is %s and my color is %s \n",this.name,this.color);
    }
}
