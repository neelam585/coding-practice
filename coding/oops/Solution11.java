package oops;

import java.util.Scanner;

public class Solution11 {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);

        String largest = s.substring(0, k);

        int length = s.length();
        // Complete the function

        for (int i=0; i<=length-k; i++){
            // -k because bc you will go out of bounds if you keep looping past the length of the string itself

            if(s.substring(i, i+k).compareTo(smallest) <= 0){
                smallest = s.substring(i, i+k);
            }

            if(s.substring(i, i+k).compareTo(largest) >= 0){
                largest = s.substring(i, i+k);
            }
        }

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

//Sample Input 0
//
//welcometojava
//3
//Sample Output 0
//
//ava
//wel