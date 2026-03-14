package oops;
import java.util.*;
public class Solution4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String[] words = s.split("[^a-zA-Z]+");

        System.out.println(words.length);
        for(String word : words){
            if(word.contains("'")){
                word = word.replace("'", "");
            }
            System.out.println(word);
        }
        scan.close();
    }
}

//Sample Input
//
//He is a very very good boy, isn't he?
//Sample Output
//
//10
//He
//is
//a
//very
//very
//good
//boy
//isn
//t
//he