package oops;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String revrseString = new StringBuilder(A).reverse().toString();
        if(A.equals(revrseString)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

