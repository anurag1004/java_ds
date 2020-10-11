package com.company;

class Cat extends Animal {
    String name;
    public Cat(String name,String color) {
        super(color);
        this.name = name;
    }
    @Override
    public void speak(){
        System.out.println("Meow Meow");
    }

    @Override
    public void intro() {
        System.out.printf("My name is %s and my color is %s \n",this.name,this.color);
    }
}
