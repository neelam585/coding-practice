package LeatCode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SplitStringStream {
    public static void main(String[] args) {
        String s = "hasgsddgsbabaffa";  // [h, as, gsd, dgsb, abaff, a]
        List<Integer> parts = Arrays.asList(1, 2, 3, 4, 5, 1); // chunk sizes

        List<String> result = splitByLengths(s, parts);

        System.out.println(result);
    }

    private static List<String> splitByLengths(String s, List<Integer> sizes) {
        AtomicInteger index = new AtomicInteger(0);
        return sizes.stream()
                .map(size -> {
                    int start = index.getAndAdd(size);
                    int end = Math.min(start + size, s.length());
                    return s.substring(start, end);
                })
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }
}
