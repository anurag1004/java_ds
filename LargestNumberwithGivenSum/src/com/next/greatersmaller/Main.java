package com.next.greatersmaller;

public class Main {
    // n-> max  digits
    // sum-> digits sum
    static String largestNumber(int n, int sum)
    {
        if(9*n < sum)
            return "-1";
        StringBuilder sb = new StringBuilder();
        // greedy
        for(int i=0;i<n;i++){
            if(sum > 9){ // if current required sum is greater then 9, just add 9 in the current ith place
                sb.append("9");
                sum -= 9; // subtract 9 from the current sum
            }else{ // if current required is less then equal to 9 then just add
                sb.append(sum);
                sum = 0;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(largestNumber(12,89));
    }
}
