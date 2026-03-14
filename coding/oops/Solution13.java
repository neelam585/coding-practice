package oops;
import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd() {
        return i -> {
            return i % 2 != 0 ? true : false;
        };
    }

    public PerformOperation isPrime() {
        return i -> {
            if (i == 2) return true;
            if (i <= 1 || i % 2 == 0) return false;

            int numberSqrt = (int)Math.sqrt(i);

            for (int j=3; j<=numberSqrt; j+=2) {
                if (i % j == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return i -> {
            String numberStr = String.valueOf(i);
            String reversedStr = "";

            for (int j=numberStr.length()-1; j>=0; j--) {
                reversedStr += numberStr.charAt(j);
            }

            return numberStr.equals(reversedStr);
        };
    }
}

public class Solution13 {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

//5
//1 4
//2 5
//3 898
//1 3
//2 12
//Sample Output
//
//EVEN
//PRIME
//PALINDROME
//ODD
//COMPOSITE