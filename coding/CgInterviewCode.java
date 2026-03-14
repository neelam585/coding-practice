import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CgInterviewCode {
    public static void main(String[] args){
    //String str = "welcome capgemini";
    Function<String, Integer> str = (String s)->s.length();
    System.out.println(str.apply("Hello"));
        //Predicate<Boolean> predicate = (String s)-> s.length()>5;

    }
}
