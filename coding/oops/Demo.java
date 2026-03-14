package oops;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        //String word = "CAPGEMINIINDIA";
        List<Integer> numbers = Arrays.asList(2, 3, 34, 5, 5, 4, 3, 3, 3);
//find duplicate number
        Map<Integer, Long> frequencyMap = numbers.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencyMap);

        Map<Integer, Long> dup = numbers.stream().collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).entrySet().stream().filter(entry->entry.getValue() >1)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        String word = "CAPGEMINIINDIA";
// find frequency of I
        long count = word.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> ch == 'I')
                .count();
        System.out.println(count);
    }
}