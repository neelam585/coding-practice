import java.lang.Integer;
import java.util.*;
import java.util.stream.*;

public class MapExample {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Use map to convert each word to its length
        List<Integer> wordLengths = words.stream()
                .map(String::length)  // Applying map to get length of each word
                .collect(Collectors.toList()).reversed();

        System.out.println(wordLengths);  // Output: [5, 6, 6]*/

        List<Integer> num = Arrays.asList(9,0,2,5,6,10);
        Integer findFirst = num.stream().sorted().findFirst().get();
        System.out.println("findFirst" +findFirst);

        Integer max = num.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b ? a:b);
        System.out.println("max" +max);

        Integer min = num.stream().reduce(Integer.MAX_VALUE,(a,b)->a>b ? b:a);
        System.out.println("min" +min);

        List<Integer> filterNum = num.stream().filter(n->!n.equals(max) && !n.equals(min)).toList();
        System.out.println("filterNum" +filterNum);

//---------------------------------------------------------------------------------------
        List<String> str = Arrays.asList("java","Spring", "Spring Boot", "Kafka","AWS");
        List<String> uppercase = str.stream().map(String::toUpperCase).toList();
        System.out.println("uppercase" +uppercase);

        List<Integer> strLength = str.stream().map(String::length).toList();
        System.out.println("strLength" +strLength);
        List<Integer> strLength1 = str.stream().map(n->n.length()).toList();
        System.out.println("strLength1" +strLength1);
        Map<Integer, List<String>> length = str.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Length of words" +length);

        String longestWord = str.stream().max(Comparator.comparing(String::length)).get();
        System.out.println("longestWord" +longestWord);

    //Employee MaxSalary = emp.stream().max((a,b)->Double.compare(a.getSalary(), b.getSalary())).get();
    //Employee secondHighestSalary = emp.stream().sorted((a,b)->Double.compare(b.getSalary(), a.getSalary())).get();
    }
}