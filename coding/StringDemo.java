import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDemo {
    public static void main(String[] args){
//count NO. of repetition of the world
        //convert each word in uppercase.
        // join all word
        //find unique word
        //find the lenth of each word
        //find the longest word
        //Print the words that contain spring
        //Print the words that contain at least 4 letters.
        //find the length of each courses
        //Sort the string in Alphabetical order
        //sort the courses according to length of each course.
// convert each word in to reverse order

        List<String> words = Arrays.asList("Apple", "Banana", "Apple", "Banana", "Orange", "Apple");
        Map<String, Long> countWord = words.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Count Words: " +countWord);

        List<String> uppercase = words.stream().map(String::toUpperCase).toList();
        System.out.println("uppercase: " +uppercase);

        String concatWords = words.stream().collect(Collectors.joining(" "));
        System.out.println("Join all words: " +concatWords);

        List<String> words3 = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        List<String> unique = words3.stream().distinct().toList(); // OR
        System.out.println("unique words: " +unique);

        Set<String> unique2 = words3.stream().collect(Collectors.toSet());
        System.out.println("unique words: " +unique2);

        List<String> words5 = Arrays.asList("apple", "banana", "kiwi", "strawberry");
        //Map<Integer, List<String>> groupedByLength = words5.stream().collect(Collectors.groupingBy(String::length));
        //System.out.println("groupedByLength: " +groupedByLength);


        String longestWord = words5.stream().max(Comparator.comparing(String::length)).orElse("There is no word in the list");
        String longestWordd = words5.stream().max(String::compareTo).get();
        System.out.println("longestWordd: "+longestWordd); //strawberry
        //String longestWord = words5.stream().max(Comparator.comparing(String::length)).get(); //strawberry
        System.out.println("longestWord: " +longestWord); //strawberry
//----------------------------------------------------------------------------------------------------
 List<String> courses = Arrays.asList("API","Spring", "Spring Boot", "AWS","KAFKA" , "Java","Kubernetes");
        courses.stream().forEach(System.out::println);
 //Print the words that contain spring

        List<String> springWord = courses.stream().filter(n->n.contains("Spring")).toList();
System.out.println("Words that contain Spring " +springWord );
//Print the words that contain at least 4 letters.
List<String> filterCourse = courses.stream().filter(n->n.length()>=4).toList();
        System.out.println("Courses that contain at least 4 words " +filterCourse);
//find the length of each courses
        //List<Integer> length = courses.stream().map(n->n.length()).toList();
        //System.out.println("Length of each courses "+length);

        List<String> lengthOfCourses = courses.stream().map(n->n +" "+ n.length()).toList();
        System.out.println("Length of each courses "+lengthOfCourses);
//[API 3, Spring 6, Spring Boot 11, AWS 3, KAFKA 5, Java 4, Kubernetes 10]
        //-----------------------------------------------------------------------------
//Sort the string in Alphabetical order
        List<String> sortCourses = courses.stream().sorted().toList();
        System.out.println("Courses in sorted(Alphabetical) order:" +sortCourses);
//Sort the string in reverse Alphabetical order
        List<String> reverseCourses = courses.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Courses in sorted(reverse Alphabetical) order:" +reverseCourses);
        //[Spring Boot, Spring, Kubernetes, KAFKA, Java, AWS, API]
        //sort the courses according to length of each course.

        List<String> coursesAccordingToLength = courses.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();

        System.out.println("coursesAccordingToLength "+coursesAccordingToLength);

//Print the courses in uppercase
        List<String> coursesInToUppercase = courses.stream().map(String::toUpperCase).toList();
        System.out.println("Print the courses in uppercase "+coursesInToUppercase);

        List<String> courses2 = Arrays.asList("API","Spring", "AWS","KAFKA" , "Java","Kubernetes");
        //Map<Integer,List<String>> data = courses2.stream().collect(Collectors.groupingBy(String::length));
        //System.out.println(data);

        List<String> data1 = courses2.stream().filter(n->n.length()>4).toList();
        System.out.println(data1);

        /*Map<Integer, List<String>> data2 = courses2.stream().filter(n->n.length()>4)
                .collect(Collectors.groupingBy(String::length));*/
        //System.out.println(data2);

        List<String> name = Arrays.asList("Amit", "Amanan","Ankit","Anjau");
        //find the name that start with A middle in n and last in n
        String inputString = "Hello world this is java";
       //convert each word in to reverse order
        String[] word = inputString.split("");
        String revOr = inputString.chars().mapToObj(i->(char)i).map(String::valueOf).reduce(" ",(a,b)->b+a);
        //List<String> word2 = Arrays.stream(word).sorted(Comparator.reverseOrder()).toList();
        /*List<String> word2 = Arrays.stream(word).map((n)->new StringBuilder(n).reverse().toString())
                .collect(Collectors.toList()); */
        System.out.println("reverse word: " +revOr); //avaj si siht dlrow olleH


    }
}
