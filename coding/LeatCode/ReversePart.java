package LeatCode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReversePart {
    public static void main(String[] args) {
        String str = "HelloWorld";  // o/p: HellroWold
        int start = 4;
        int end = 8; // exclusive index

        // Step 1: Split into 3 parts
        String prefix = str.substring(0, start);
        String middle = str.substring(start, end);
        String suffix = str.substring(end);

        // Step 2: Reverse 'middle' using Stream
        String reversed = IntStream.range(0, middle.length())
                .mapToObj(i -> middle.charAt(middle.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
        String rev = middle.chars().mapToObj(i->(char)i).map(String::valueOf)
                .reduce("",(a, b)->b+a);

        // Step 3: Combine all parts
        String result = prefix + rev + suffix;
//  HellroWo ld ,,, HellroWold
        System.out.println(result);
    }
}
