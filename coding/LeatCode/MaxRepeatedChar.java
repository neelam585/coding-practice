package LeatCode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxRepeatedChar {
    public static Character maxRC(String input){
        Map<Character,Integer> charCoutnt = new LinkedHashMap<>();
        for(char c: input.toCharArray()){
            charCoutnt.put(c, charCoutnt.getOrDefault(c,0)+1);
        }
        int maxValue = 0;
        Character maxChar = null;
        for(Map.Entry<Character,Integer> entry: charCoutnt.entrySet()){
            if(entry.getValue()>maxValue){
                maxValue = entry.getValue();
                maxChar = entry.getKey();

            }
        }
        return maxChar;
    }

    public static void main(String[] args){
        String s = "java is a programming language";
        Character maxC = maxRC(s);
        System.out.println(maxC);

        Map<Character, Long> frequency = s.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Character maxChar = frequency.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        List<Integer> num = Arrays.asList(1,1,1,1,2,2,3,4,4,4);
        int k = 2; // top kth element
        Map<Integer,Long> frq = num.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println(frq); //{1=4, 2=2, 3=1, 4=3}
        List<Integer> top2ele = frq.entrySet().stream().sorted((a,b)->Long.compare(b.getValue(),a.getValue())).skip(k)
                .map(Map.Entry::getKey).toList();
        System.out.println(top2ele); //[2, 3]
        //2nd most frequent element
        Integer c = frq.entrySet().stream().sorted((a,b)->Long.compare(b.getValue(),a.getValue())).skip(1).findFirst().map(Map.Entry::getKey).get();
        System.out.println(c); // 4

    }
}
