package com.company;

abstract class Animal {
    String color;
    public Animal(String color){
        this.color = color;
    }
    public abstract void  speak();
    public abstract void intro();
}
