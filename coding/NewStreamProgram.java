import java.lang.Integer;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class NewStreamProgram {
    public static void main(String[] args) {
        // find out all the numbers starting with 1 using Stream functions?
        //find the duplicate
        //generate faboaccini series
        //find max number
        // Find the first non-repeated character

        List<Integer> numbers = Arrays.asList(123, 456, 101, 900, 150, 1001, 1234);
        List<Integer> num = numbers.stream().map(String::valueOf).filter(s->s.startsWith("1"))
                        .map(Integer::valueOf).toList();
        System.out.println("number start with 1" + num);

        List<String> name = Arrays.asList("Neelam", "Neelam", "Neha", "Geeta");
        List<String> dupName = name.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry->entry.getValue() > 1)
                        .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("Duplicate Name" + dupName);

        List<String> names = name.stream().filter(s->s.startsWith("N")).toList();
        System.out.println("name that start with N" +names);
       Stream.iterate(new int[]{0,1}, t->new int[]{t[1],t[0]+t[1]})
               .limit(10).map(t->t[0]).forEach(System.out::println);


        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
List<Integer> dupList = myList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        .entrySet().stream()
        .filter(entry -> entry.getValue()>1)
        .map(Map.Entry::getKey).toList();
       System.out.println("Duplicate number" +dupList);

        List<Integer> num1 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Integer maxNum1 = num1.stream().max(Integer::compare).get();
        System.out.println("max number" +maxNum1);

        String input = "Java articles are Awesome";
        Map<Character, Long> charCount = input.replace(" ","").chars() // Convert string to stream of characters

                .mapToObj(i->(char)i) // Convert int stream to Character stream
         .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
          System.out.println("Count char" +charCount);
//Count char{J=1, a=4, v=1,  =3, r=2, t=1, i=1, c=1, l=1, e=4, s=2, A=1, w=1, o=1, m=1}
       Optional<Character> firstNonRepeat = charCount.entrySet().stream()
               .filter(entry->entry.getValue() ==1)
               .map(Map.Entry::getKey).findFirst();

       Optional<Character> firstRepeat = charCount.entrySet().stream()
               .filter(entry->entry.getValue() >1)
               .map(Map.Entry::getKey)
               .findFirst();
       if(firstNonRepeat.isPresent()){
           System.out.println("First non repeating charater" +firstNonRepeat);
       }else {
           System.out.println("First repeating charater" +firstRepeat);
       }

    }
}
