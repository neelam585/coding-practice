import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequency {
    public static void main(String[] args){
        List<Integer> num = Arrays.asList(1,1,1,1,2,2,3,4,4,4);
        int k = 2;
        //count frequency
        Map<Integer,Long> frequency = num.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer> result = frequency.entrySet().stream()
                .sorted((a,b)->Long.compare(b.getValue(),a.getValue()))
                .limit(k).map(Map.Entry::getKey).toList();
        System.out.println(result); //[1, 4]

    }
}
