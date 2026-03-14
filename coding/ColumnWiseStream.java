import java.util.stream.IntStream;

public class ColumnWiseStream {
    public static void main(String[] args) {
        String s = "Neelam Patel";
        String[] words = s.split(" ");

        String w1 = words[0];
        String w2 = words[1];

        int maxLen = Math.max(w1.length(), w2.length());

        IntStream.range(0, maxLen)
                .mapToObj(i -> {
                    String c1 = i < w1.length() ? String.valueOf(w1.charAt(i)) : "";
                    String c2 = i < w2.length() ? String.valueOf(w2.charAt(i)) : "";
                    return c1 + (c2.isEmpty() ? "" : " " + c2);
                })
                .forEach(System.out::println);
    }
}
//N P
//e a
//e t
//l e
//a l
//m
