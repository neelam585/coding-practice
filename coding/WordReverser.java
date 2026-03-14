import java.util.*;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
import java.util.function.*;
//import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordReverser {
    public static boolean isPrime(int n){
        //if n=11; i = 2,3,4,5,6,7,8,9,10;
        return IntStream.range(2,n).noneMatch(i->n%i == 0);
    }
    public static String reverseWords(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        Collections.reverse(words);
        //return words.stream().collect(Collectors.joining(" "));

        return words.stream()
          .map(word -> word.equalsIgnoreCase
          ("Patel") ? word.toUpperCase() : word.toLowerCase())
          .collect(Collectors.joining(" "));
        // o/p: PATEL neelam;
    }
    private static Character firstNonRepeatChar(String string){
        Map<Character, Long> mapToLength = string.chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        Character firstNonRChar = mapToLength.entrySet().stream()
                .filter(entry->entry.getValue()==1).map(Map.Entry::getKey)
                .findFirst().get();
        return firstNonRChar;
    }
    public static void main(String[] args) {
        String str = "Neelam Patel";
        String result = reverseWords(str);
        System.out.println(result); // Output: Patel Neelam

        Function<Integer, Integer> data = (b)->b;
        BiFunction<Integer, Integer, Integer> data2 = (a, b)->a+b;

        System.out.println(data.apply(10));
        System.out.println(data2.apply(10,20));
        //-------------------------------------------------------------------------------------
        String[] strArr = {"array", "Python", "React"};
        List<Character> chars = Arrays.stream(strArr).map(WordReverser::firstNonRepeatChar).collect(Collectors.toList());
        System.out.println(chars);
        //--------------------------------------------------------------------------------
        // reverse string
        String str1 = "Abc";
        String str1Reverse = str1.chars().mapToObj(i->(char)i)
                .map(String::valueOf)
                .reduce(" ",(a,b)->b+a);
        System.out.println(str1Reverse); // cbA

        //find prime number
        List<Integer> list1 = Arrays.asList(2,4,6,7,9,11,13);
        List<Integer> prime = list1.stream().filter(WordReverser::isPrime).collect(Collectors.toList());
        //List<Integer> prime = Arrays.stream(n).boxed().filter(Main::isPrime).toList();

        System.out.println("Prime : "+prime);

        String string = "Neelam Patel";
        //o/p: eelam atel , remove upper case;
        String string1 = string.chars().mapToObj(i->(char)i).filter(n->!n.isUpperCase(n))
                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(string1);

        //--------------------------------------
        List<String> l1 = Arrays.asList("apple:2","banana:3","orange:1","apple:5","banana:6");
        // apple:7, banana:9, orange:1
       Map<String,Integer> collection = l1.stream().map(s->s.split(":"))
               .collect(Collectors.groupingBy(a->a[0],
                       Collectors.summingInt(a->Integer.parseInt(a[1]))));
       System.out.println(collection);

    }
}
