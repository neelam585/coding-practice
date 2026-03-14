package LeatCode;

import oops.Child;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                char top = stack.pop();
                if((top != '(' && c==')') ||
                        (top != '{' && c=='}') ||
                        (top !='[' && c == ']'))
                    {return false;}


            }
        }
        return stack.isEmpty();
    }
    public static boolean duplicate(int[] arr){
        // using java 8
        return Arrays.stream(arr).distinct().count() != arr.length;
       /* Set<Integer> set = new HashSet<>();
        for (int a: arr){
            if (set.contains(a)){
                return true;
            }else {
                set.add(a);
            }
        }return false;*/
    }
    public static void main(String[] args){
        String s = "({[]})";
        String s1 = "({[})";
        boolean result = isValid(s);
        System.out.println(result);

        int[] num1 = {1,2,3,4,1}; // if duplicate return true;
        int[] num2 = {1,2,3,4};
        boolean result1 = duplicate(num1);
        System.out.println(result1);
    }
}
//Time Complexity: O(n)
//
//Space Complexity: O(n)
// toCharArray() creates a char array of size n
//Reason: Single traversal of the string and stack can grow up to size n.

//Stack operations
//
//push() → O(1)
//
//pop() → O(1)
//
//peek() → O(1)
//
//Each character is:
//
//Pushed once (if opening bracket)
//
//Popped once (if closing bracket)
//
//So total stack operations = O(n)  TC= O(n)