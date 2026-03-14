import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

     Adder<Integer> num = (a,b)->a+b;
     System.out.println(num.add(4,6));

     MyFunction myFunction = ()->{
         System.out.println("Neelam");
     };
     myFunction.display();;
    }

}

@FunctionalInterface
interface Adder<T>{
    T add(T a, T b);
}

@FunctionalInterface
interface MyFunction{
    void display();
}