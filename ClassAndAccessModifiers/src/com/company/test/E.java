package com.company.test;
import com.company.main.B;
public class E {
    private B b;
    public E(int x,int y,int z){
        this.b = new B(x,y,z);
    }
    public void print_protected_member(){
        // System.out.println(b.z);
        // compilation error =>
        // java: z has protected access in com.company.main.B

        // Although class E and B are in same package com.company but
        // they are in different sub-package
    }
}
