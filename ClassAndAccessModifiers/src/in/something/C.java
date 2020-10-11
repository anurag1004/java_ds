package in.something;

import com.company.main.B;

public class C extends B {
    private int something;
    public C(int x,int y,int z){
        super(x,y,z);
        this.something = x+y-z;
    }

    public int getSomething() {
        return this.something;
    }
    public void print_protected_member_of_B(){
        System.out.println(super.z); // or this.z
    }
}
