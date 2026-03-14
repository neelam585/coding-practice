package oops;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Adder<T>{
    void calculate(T element);
}
public class AddElementLambdaExample {
    public static void main(String[] args){
        List<String> items = new ArrayList<>();

        Adder<String> stringAdder = items::add;
        stringAdder.calculate("AAA");
        stringAdder.calculate("BBB");
        stringAdder.calculate("CCC");
        stringAdder.calculate("DDD");
        System.out.println(items);

    }
}
