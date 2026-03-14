package practiceOops;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<T> {
    public boolean areEqual(T value1, T value2){
        return value1 == value2;
    }
    public boolean notEqual(T value1, T value2){
        return value1 != value2;
    }
    public static void main(String[] args){
        GenericClass<Integer> intComp = new GenericClass<>();
        boolean intResult = intComp.areEqual(10,10);
        System.out.println(intResult);

        GenericClass<String> strComp = new GenericClass<>();
        boolean strResult = strComp.notEqual("ab", "ad");
        System.out.println(strResult);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        for(Integer num: numbers){
            System.out.println("numbers" +num);
        }

        numbers.forEach(item->System.out.println(item));
        List<String> strings = new ArrayList<>();
        strings.add("adad");
        strings.add("aaaaaaa");
        strings.forEach(System.out::println);

    }
}
