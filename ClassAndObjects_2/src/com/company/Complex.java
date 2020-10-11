package com.company;

public class Complex{
    int re,im;
    public Complex(int re,int im){
        this.re = re;
        this.im = im;
    }
    public Complex(Complex c){
        this.re = c.re;
        this.im = c.im;
    }
    public String toString(){
        return "[ "+this.re+" + "+this.im+"i ]";
    }
}