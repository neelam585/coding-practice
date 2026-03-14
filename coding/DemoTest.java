import java.lang.Integer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest {
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
        //find last element
        //1st highest salary
        //2nd highest salary

        List<Integer> num = Arrays.asList(9,4,2,8,5,10);
        Integer lastElement = num.stream().reduce(0,(a,b)->b);
        Integer min = num.stream().sorted().findFirst().get();
        Integer max = num.stream().reduce(Integer.MIN_VALUE,(a,b)-> a>b ? b:a);
        Integer minNumber = num.stream().reduce(Integer.MAX_VALUE,(a,b)->a>b ?a:b);

        List<Integer> filter = num.stream().filter(n->!n.equals(min) && !n.equals(max)).toList();

        List<String> str = Arrays.asList("java","Spring", "Spring Boot", "Kafka","AWS");

        List<String> strUpper = str.stream().map(String::toUpperCase).toList();

        String joinword = str.stream().collect(Collectors.joining(" "));

        List<Integer> lengthofWord = str.stream().map(String::length).toList();
        //OR
        List<Integer> lengthofWord1 = str.stream().map(n->n.length()).toList();

List<Integer> lengthofWord4 = str.stream().map(String::length).toList();

        String longestWord = str.stream().max(Comparator.comparing(String::length)).get();
        Integer numm = longestWord.length();
        System.out.println("Longest word length : " + numm);

        List<String> filterWord = str.stream().filter(n->n.contains("Spring")).toList();

        List<String> length = str.stream().filter(n->n.length()>= 4).toList();

        /*Employee maxSalary = emp.stream().max((a,b)->Double.compare(a.getSalary(), b.getSalary())).get();
        Employee sndHighSalary = emp.stream().sorted((a,b)->Double.compare(b.getSalary(),a.getSalary()))
        skip(1).findFirst().get();*/





    }
}





