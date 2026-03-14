package oops;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface AdderNum<T>{
    void add(T element);
}
public class AddNumberLambda {
    public static void main(String[] args){
        List<Integer> items = new ArrayList<>();
        AdderNum<Integer> adderNum = items::add;
        adderNum.add(10);
        adderNum.add(20);
        adderNum.add((30));
        System.out.println(items);
        Integer sum = items.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

    }
}
