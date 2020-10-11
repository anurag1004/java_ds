package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter something..");
        String str = sc.nextLine();
        System.out.println("Is this what u have typed!!! " + str);

        System.out.println("Enter a number...");
        int num = sc.nextInt();
        System.out.printf("This number -_- ?? %d\n",num);

        System.out.println("Enter character....");
        char ch = sc.next().charAt(0);
        System.out.println(ch);
    }
}
