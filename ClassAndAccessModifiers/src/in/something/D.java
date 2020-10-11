package in.something;
import com.company.main.B;
public class D {
    private B b;
    public D(int x,int y,int z){
        this.b = new B(x,y,z);
    }
    public void print_protected_member_from_different_package(){
        //System.out.println(b.z); // not accessible
        // Compilation error =>
        //       java: z has protected access in com.company.main.B

    }

}
