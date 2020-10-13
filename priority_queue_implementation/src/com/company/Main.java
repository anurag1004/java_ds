package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
class myClass{
    private char key;
    private int priority;
    public myClass(char key,int priority){
        this.key = key;
        this.priority = priority;
    }
    public int getKey(){ return this.key; }
    public int getPriority(){ return this.priority; }
}
public class Main {
    static class  myComparator implements Comparator<myClass> {

        public int compare(myClass o1, myClass o2) {
            Integer p1 = o1.getPriority();
            Integer p2 = o2.getPriority();
            return p2.compareTo(p1);
            // high to low [max heap]
            // p1.compareTo(p1) => low to high [min heap]
        }
    }
    public static void main(String[] args) {
        PriorityQueue<myClass> pq = new PriorityQueue<myClass>(new myComparator());
        pq.add(new myClass('X',10));
        pq.add(new myClass('E',4));
        pq.add(new myClass('O',9));
        pq.add(new myClass('N',7));

        // iterating over pq
        Iterator<myClass> it = pq.iterator();
        System.out.println();
        while(it.hasNext()){
            myClass temp = it.next();
            System.out.printf("%c ",temp.getKey());
        }
        System.out.println();
    }
}
