package practiceOops;

import java.util.ArrayList;
import java.util.List;

public class ArrayListLambdaEx {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Graps");

        for(String data: list){
            System.out.println(data);
        }

        list.forEach(System.out::println);

        list.forEach((data)->{System.out.println(data);});
    }

}
