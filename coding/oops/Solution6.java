package oops;
import java.util.*;
public class Solution6 {



    public static void main(String[] args) {
 Scanner s = new Scanner(System.in);
 int t = s.nextInt();
 String[] pair_left = new String[t];
 String[] pair_right = new String[t];

 for (int i = 0; i < t; i++) {
 pair_left[i] = s.next();
 pair_right[i] = s.next();
 }

 // Write your code here
        HashSet<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String first = pair_left[i];
            String second = pair_right[i];

            // Ensure consistent ordering to treat unordered pairs as the same
            String pair = first.compareTo(second) <= 0 ? first + " " + second : second + " " + first;

            uniquePairs.add(pair);
            System.out.println(uniquePairs.size());
        }

        s.close();

    }
 }











//Sample Input
//
//5
//john tom
//john mary
//john tom
//mary anna
//mary anna
//Sample Output
//
//1
//2
//2
//3
//3

