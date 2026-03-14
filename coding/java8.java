import oops.JavaStack;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.time.*;

public class java8 {
    public static void main(String[] args){
        List<String> list1 = Arrays.asList("java 8");
        List<String> list2 = Arrays.asList("explained","through","program");
        // o/p: java 8 explained through program
        String string = Stream.of(list1,list2).flatMap(List::stream).collect(Collectors.joining(" "));
        System.out.println(string);
        // print even number
        Stream.iterate(2, count->count+1).filter(n->n%2 ==0)
                .limit(5)
                .forEach(System.out::println);
        List<Integer> evenNum = Stream.iterate(2,count->count+1).filter(n->n%2==0).limit(5).toList();
        System.out.println(evenNum);
// generate Random number
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);
// LocalDate, LocalTime, LocalDateTime
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        int[] num = {0,1,2,3,4,5,6,7,8};
        // o/p : 6,7,8
        List<Integer> numList = Arrays.stream(num).boxed()
                .sorted((a,b)->Integer.compare(b,a))
                .limit(3).sorted().toList();
        System.out.println(numList);
        List<Integer> integerList1 = Arrays.stream(num).boxed().sorted().skip(6).toList();
        System.out.println(integerList1);
        //---------------------------------------
        //o/p : 0,1,2,3,4,5
        List<Integer> nnumList2 = Arrays.stream(num).sorted().boxed().limit(6).toList();
        System.out.println(nnumList2);
        //-----------------------------------------
        String str = "neelam";
        String rev = str.chars().mapToObj(i->(char)i).map(String::valueOf).reduce(" ",(a,b)->b+a);
        String s = IntStream.range(0,rev.length()).mapToObj(i->(i%2 ==0 )? String.valueOf(Character.toUpperCase(rev.charAt(i)))
                :String.valueOf(Character.toLowerCase(rev.charAt(i)))).collect(Collectors.joining());
        System.out.println(s); // MaLeEn

        //String ss = "Neelam patel";
// 2nd largest string
        // answer should be backend
        String ss = "Santosh is a backend developer";
        List<String> list = Arrays.asList(ss.split(" "));
        List<String> sortedList = list.stream().sorted(Comparator.comparing(String::length)).toList();
        List<String> reverseAccordingToLength = new ArrayList<>(sortedList);
        Collections.reverse(reverseAccordingToLength);
        System.out.println(reverseAccordingToLength); //[developer, backend, Santosh, is, a]
        String secLongestStrAlphabatically = reverseAccordingToLength.stream().skip(1)
                .findFirst().get();
        System.out.println(secLongestStrAlphabatically); //backend


        List<String> ssSortToL = list.stream().sorted(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase))
                .toList();
        System.out.println(ssSortToL); // [a, is, backend, Santosh, developer]
       /* String data = list.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase))
                .skip(1).findFirst().get();*/
         //Collections.reverse(ssSortToL);

         /*List<String> data = ssSortToL.stream().skip(1).toList();
        System.out.println(data); */
        String st = "welcome capgemini";
        String sC = Arrays.asList(st.split(" ")).stream()
                .map(w->w.substring(0,1).toUpperCase()+w.substring(1).toLowerCase())
                .collect(Collectors.joining());
        String sb = "1234567890";
        String ssb = IntStream.range(0,sb.length())
                .mapToObj(i->(i>=4 && i<=7)?"x": String.valueOf(sb.charAt(i)))
                .collect(Collectors.joining());
        System.out.println(ssb);  // 1234xxxx90

        String[] arraydata = {"java","python","sql"};
        List<String> listArr = new ArrayList<>(Arrays.asList(arraydata));
        List<String> firstCaps = listArr.stream().map(w->w.substring(0,1).toUpperCase()+w.substring(1).toLowerCase()).toList();
        System.out.println(firstCaps); //[Java, Python, Sql]

        List<Integer> lists = Arrays.asList(2, 3, 4, 12, 13, 18, 17);
//[2E, 3O, 4E, 12E, 13O, 18E, 17O]
        List<String> result = lists.stream()
                //.map(n -> n + (n % 2 == 0 ? "E" : "O"))
                .map(n->n+(n%2==0?"E":"O"))
                .collect(Collectors.toList());

        System.out.println(result);
        //------------------------------------------------------------
        String s1 = "Happy";
        String s2 = "Happy";
        String s3 = new String("Happy");
        System.out.println(s1==s2); // true
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s3)); //true

        StringBuilder s5 = new StringBuilder("Hello");
        StringBuilder s6 = new StringBuilder("Hello");

       System.out.println("StringBuilder feature "+s5.equals(s6));  //false
        System.out.println(s5 == s6);  //false
//---------------------------------------------------------------------------------
        Optional<String> opt = Optional.of("Neelam");
        System.out.println("Optional---------"+opt.get()); // Output: Neelam
        //Optional<String> opt1 = Optional.of(null); // Throws NullPointerException
        String name = null;
        String secName = "Patel";
        Optional<String> opt2 = Optional.ofNullable(name);
        System.out.println(opt2.isPresent()); // Output: false
        Optional<String> opt3 = Optional.ofNullable(secName);
        System.out.println(opt3.isPresent()); // Output: true
        Optional<String> opt4 = Optional.empty();
        System.out.println(opt4.isPresent()); // Output: false
        String result1 = Optional.ofNullable(name).orElse("Guest");
        System.out.println(result1); // Output: Guest
        // Custom finder method in repository class
        //Optional<Product> findByProductCode(String productCode);

        //---------Find max repeating char
        String s8 ="successes is our life";
        Map<Character,Long> frequency = s8.replace(" ","").chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(frequency);
        Character c = frequency.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println(c); //s

        Optional<Map.Entry<Character, Long>> maxEntry = s8.replace(" ","").chars()
               // .filter(ch -> ch != ' ') // ignore spaces
                .mapToObj(ch -> (char) ch) // convert int → char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // count occurrences
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()); // find max by count
        System.out.println(maxEntry);
        maxEntry.ifPresent(entry -> System.out.println(entry.getKey())); //s


        StringBuilder sbb = new StringBuilder("A");  //mutable object
        String s11 = sbb.toString(); // create new object , immutable object
        sbb.append("B");   // AB
        System.out.println(s11);  // A
//Now memory looks like:
//sbb -> StringBuilder("A")
//s11 -> String("A")

    }
}
