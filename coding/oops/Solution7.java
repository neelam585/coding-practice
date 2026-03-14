package oops;
import java.util.*;
public class Solution7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input strings
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        // 1. Sum of lengths
        System.out.println(a.length() + b.length());

        // 2. Lexicographical comparison
        System.out.println(a.compareTo(b) > 0 ? "Yes" : "No");

        // 3. Capitalize first letters and print
        String capitalizedA = a.substring(0, 1).toUpperCase() + a.substring(1);
        String capitalizedB = b.substring(0, 1).toUpperCase() + b.substring(1);
        System.out.println(capitalizedA + " " + capitalizedB);

        scanner.close();
    }
}
