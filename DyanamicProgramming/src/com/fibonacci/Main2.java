package com.fibonacci;

public class Main2 {
    long fib(int n){
        if(n==1 || n==2)
            return 1;
        long[] bottom_up = new long[n+1];
        bottom_up[1] = 1;
        bottom_up[2] = 1;
        for(int i=3;i<=n;i++){
            bottom_up[i] = bottom_up[i-1] + bottom_up[i-2];
        }
        return bottom_up[n];
    }
    public static void main(String[] args) {
        Main main = new Main();
        long startTime = System.nanoTime();
        System.out.println(main.fib(100));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
