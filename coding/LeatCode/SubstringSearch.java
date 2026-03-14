package LeatCode;

public class SubstringSearch {
    public static String findOccurrences(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= n - m; i++) {
            // Extract substring of length m
            String sub = text.substring(i, i + m);

            if (sub.equals(pattern)) {
                result.append(i).append(" ");
            }
        }
        return result.toString().trim();
    }
    public static void main(String[] args) {
        String text = "xyzabxyzabxyz";
        String pattern = "xyz";
        String result =  findOccurrences(text, pattern); // Output: 0 5 10
        System.out.println(result);
    }
}
