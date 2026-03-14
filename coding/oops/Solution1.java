package oops;

    import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

    public class Solution1 {

        public static void main(String[] args) {
            //int num;
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            List<Integer> data = new ArrayList<>(Arrays.asList(12,0,1,78,12));
            data.add(5, 23);
            data.remove(0);
            for(int num : data){
                System.out.print(num+ " ");
            }

        }
    }

