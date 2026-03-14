import java.util.*;
import java.lang.Integer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

public class TestInteger {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(123, 456, 101, 900, 150, 1001, 1234);
        List<Integer> num1 = numbers.stream().map(String::valueOf).filter(n->n.startsWith("1"))
                .map(Integer::valueOf).toList();
        List<String> name = Arrays.asList("Neelam", "Neelam", "Neha", "Geeta");
   //name.forEach(System.out::println);
        List<String> dupName = name.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue() >1)
                .map(Map.Entry::getKey)
                .toList();

        String input = "Java articles are Awesome";
        //String input = "Jabc";
        Map<Character, Long> str = input.chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(str);

        Optional<Character> firstNonRepeat = str.entrySet().stream()
                .filter(entry->entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        Optional<Character> firstRepeat = str.entrySet().stream()
                .filter(entry->entry.getValue() >1)
                .map(Map.Entry::getKey)
                .findFirst();
System.out.println("========" +firstRepeat);
//Fibonacci generator ,
        Stream.iterate(new int[]{0,1}, t->new int[]{t[1],t[0]+t[1]}).limit(10)
                .map(t->t[0])
                .forEach(System.out::println);

        List<String> words5 = Arrays.asList("apple", "banana", "kiwi", "strawberry");
        String longestWord = words5.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(longestWord);
        // find length of largest string
        Integer lengthOfLargestWord = longestWord.length(); // strawberry
        System.out.println("lengthOfLargestWord "+lengthOfLargestWord); //o/p: 10
        List<Integer> mapWithLength = words5.stream().map(String::length).toList();
        System.out.println("mapWithLength "+mapWithLength); // [5, 6, 4, 10]



//remove space and find frequency of each char
        String str1 = "ab8cd syz9";
        Map<Character, Long> replaceSpace = str1.replace(" ", "").chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Map<Character, Long> data1 = str1.chars().filter(i->i !=' ').mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println("replaceSpace: " + replaceSpace);
        System.out.println("data1: " + data1);

        Map<Character, Long> digitFrequency = str1.chars().filter(Character::isDigit).mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("digitFrequency: " + digitFrequency);

//filter the digit
        String digitsOnly = str1.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("Digits: " + digitsOnly);

  String digitOnly1 = str1.chars().mapToObj(i->(char)i)
                  .filter(Character::isDigit)
                  .map(String::valueOf).collect(Collectors.joining());
  System.out.println("Digit1 "+ digitOnly1);

        String isLetter = str1.chars().mapToObj(i->(char)i)
                .filter(Character::isLetter)
                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(isLetter);
        //-------------------------------------------------------------------------------------------
        String strname = "My name is Neelam. I am from delhi";

        List<Character> vowel = strname.chars().mapToObj(i->(char)i).map(Character::toLowerCase)
                .filter(ch->"aeiou".indexOf(ch) !=-1).distinct().toList();
        System.out.println("vowel :" +vowel);
// o/p: [a,e,i,o]
        Map<Character, Long> frequency = strname.chars()
                .mapToObj(i->(char)i)
                .filter(i->i != ' ')
                .map(Character::toLowerCase).collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));

        System.out.println(frequency);
        //{a=3, d=1, e=4, f=1, h=1, i=3, l=2, m=5, .=1, n=2, o=1, r=1, s=1, y=1}

        // Check for vowels using Stream API
        boolean hasVowel = strname.toLowerCase()
                .chars() // Convert string to IntStream of character codes
                .mapToObj(c -> (char) c) // Convert character codes to characters
                .anyMatch(ch -> "aeiou".indexOf(ch) != -1); // Check if the character is a vowel

        Boolean status = strname.chars().mapToObj(i->(char)i)
                .map(Character::toLowerCase)
                .anyMatch(ch->"aeiou".indexOf(ch) != -1);
        System.out.println(status);

        System.out.println("Does the string contain any vowels? " + hasVowel);
        //true
//---------------------------------------------------------------------------------
        String nameStr = "Neelam";

        Map<Character, Long> data = nameStr
                .chars()
                .mapToObj(i -> (char) i)
                .filter(c -> !c.isUpperCase(c)) // Exclude capital letters
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("Letter frequencies (excluding capital letters): " + data);
       // ------------------------------------------------------------------
            String string = "Neelam Patel";
            //o/p: eelam atel , remove upper case;
            String string1 = string.chars().mapToObj(i->(char)i)
                    .filter(n->!n.isUpperCase(n))
                    .map(String::valueOf).collect(Collectors.joining());
            System.out.println(string1);
//-----------------------------------------------------------------------------------------------
        List<String> fruits = Arrays.asList("apple", "Pomegranate", "Raspberry", "raspberry", " ", null, "Apple", "Cherry");
        //"apple", "Pomegranate", "Raspberry", "raspberry", " ", null, "Apple", "Cherry"
        //output: "Apple", "Cherry","Pomegranate", "Raspberry"
        Map<String, String> lastOccurrenceMap = fruits.stream()
                .filter(Objects::nonNull)
                //.filter(s->s != null)
                //.filter(s->s !=" ")
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toMap(
                        s -> s.toLowerCase(), // key: lowercase for case-insensitive comparison
                        s -> s,               // value: original string
                        (oldVal, newVal) -> newVal, // merge function: keep the last occurrence
                        LinkedHashMap::new         // preserve insertion order
                ));
System.out.println(lastOccurrenceMap);
        List<String> result = lastOccurrenceMap.values().stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);

        //---------------------------------------------

        List<String> str2 = Arrays.asList("Mango","Banana","Bottel");
        Map<String, Integer> mapStrWithLength = str2.stream().collect(Collectors.toMap(
                s->s,
                s->s.length(),
                (e1,e2)->e1,
                LinkedHashMap::new

        ));
        System.out.println(mapStrWithLength);
        //----------------------------------------------------
        List<String> list = Arrays.asList("A", "a", "B");
        long countA = list.stream().filter(c->"A".equalsIgnoreCase(c)).count();

        System.out.println(countA);

        //Filter the below List who’s name started with J and then sort it in Reverse Order
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "James", "Julie");
        List<String> startwithJ = names.stream().filter(n->n.startsWith("J")).toList();
                //.sorted(Comparator.comparing(String::))

        /*Java 8 program to print all even numbers and count from 1 to 200
        java 8 program to number start with one*/
        List<String> monthsList	=List.of("janvary","febrary","march");
        List<String> endwithYmonthList=monthsList.stream()
                .filter(m->m.endsWith("y")).collect(Collectors.toList());
        System.out.println(endwithYmonthList);
//


        Function<String, Integer> stringLengthFunction = (String s) -> s.length();
        System.out.println(stringLengthFunction.apply("hello"));  // Output: 5
            BiFunction<Integer,Integer,Integer> sum = (a,b)->a+b;
            System.out.println(sum.apply(2,5));


        Predicate<String> predicate = (String s) -> s.length() > 5;
        System.out.println(predicate.test("hello"));  // Output: false

            String s="welcome capgemini";
            //output: W, C should be capital.
        String firstLeterInCapital = Arrays.asList(s.split(" ")).stream()
                .map(word->word.substring(0,1).toUpperCase()+word.substring(1)
                        .toLowerCase())
                .collect(Collectors.joining(" "));
            System.out.println(firstLeterInCapital);
// Input: s = "4193 with words" , o/p: 4193, Input: s = " -12345" //Output: -12345
        String input1 ="1337c0d3";
        String ii = input1.chars().mapToObj(i->(char)i).filter(Character::isDigit)
                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(ii);
        // ------------------------------------------------------------------------------------------



    }
}
