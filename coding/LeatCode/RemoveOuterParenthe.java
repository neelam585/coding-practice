package LeatCode;
import java.util.*;
public class RemoveOuterParenthe {
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) result.append(c);
                depth++;
            } else {
                depth--;
                if (depth > 0) result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //String s = "()(()())(())";
        String s = "((()))";
        System.out.println(removeOuterParentheses(s)); // ✅ (()) Time Complexity: O(n) Space Complexity: O(n)
    }
}
