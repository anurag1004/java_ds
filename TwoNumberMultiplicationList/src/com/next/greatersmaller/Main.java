package com.next.greatersmaller;
class Node{
    int val;
    Node next =  null;
    public Node(int val){
        this.val = val;
    }
}
class Number{
    Node head =  null;
    Node tail = null;
    int size  = 0;
    public void insert(int num){
        // store in reverse format
        while (num!=0){
            int temp = num%10;
            if(head==null){
                head = new Node(temp);
                tail =  head;
            }else{
                tail.next = new Node(temp);
                tail =  tail.next;
            }
            size++;
            num /= 10;
        }
    }
    public void showNumber(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.val+"-->");
            curr = curr.next;
        }
        System.out.println();
    }
}
public class Main {
    public static Node multiply(Number n1, Number n2){
        // create list of size
        int size = n1.size+ n2.size + 1;
        Node res = null;
        Node tail = null;
        for(int i=0;i<size;i++){
            if(res==null){
                res  = new Node(0);
                tail = res;
            }else{
                tail.next = new Node(0);
                tail  = tail.next;
            }
        }
        //since our numbers are already in  reverse format
        Node p_res = res; // result list pointer
        Node p1 = null;
        Node p2 = n2.head;
        boolean gap = false; // column gap
        while(p2!=null){
            p1 = n1.head;
            Node curr = p_res;
            int carry =  0;
            while(p1!=null){
                int sum = p1.val*p2.val+carry;
                if(gap){
                    sum+= curr.val;
                }
                curr.val = sum%10;
                carry = sum/10;
                p1 = p1.next;
                curr = curr.next;
            }
            if(carry!=0)
                curr.val = carry;
            p_res = p_res.next;
            p2 = p2.next;
            gap = true;
        }
        Node prev = null;
        Node curr = res;
        Node nxt = null;
        while(curr!=null && curr.val!=0){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        n1.insert(33329);
        n2.insert(999999999);

        n1.showNumber();
        n2.showNumber();

        Node res = multiply(n1, n2);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
