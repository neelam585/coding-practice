package LeatCode;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '('){
                if(!stack.isEmpty()){
                    result.append(c);
                }
                stack.push(c);
            }else { // c == ')'
                stack.pop();
                if(!stack.isEmpty()){
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        String s = "((()))";
        System.out.println(removeOuterParentheses(s)); // Output: (())
    }
}
