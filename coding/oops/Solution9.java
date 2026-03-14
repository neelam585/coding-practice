package oops;
import java.util.Scanner;
public class Solution9 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Read the integer input
            int n = scanner.nextInt();

            // Convert the integer to a string
            String s = Integer.toString(n);
 String str = String.valueOf(n);
 System.out.println(s);
            // Validate the conversion
            if (s.equals(String.valueOf(n))) {
                System.out.println(str);
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer");
            }

            scanner.close();
        }
    }


