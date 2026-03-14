import java.lang.Integer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PracticeThree {

    public static void main(String[] args){

        //number in ascending order
        //number in descending order
        //find first number //Thread-safe
        //count number of element
        //find even number
        //find odd number
        //squire of each element  Thread-safe
        //sum of each element  Thread-safe
        //squire + sum
        //find unique element   //Thread-safe
        //find duplicate element
        //if any number is even return true
        //flatMap

        //find the max number in the list
        List<Integer> num = Arrays.asList(1,2,6,4,5,9);
        List<Integer> Asce = num.stream().sorted().toList();

        List<Integer> Desc = num.stream().sorted(Comparator.reverseOrder()).toList();

        Integer intn = num.stream().findFirst().orElse(Integer.valueOf("0"));

        Long countNum = num.stream().count();

        List<Integer> odd = num.stream().filter(n->n%2 == 1).toList();

        List<Integer> even = num.stream().filter(n->n%2 == 0).toList();

        List<Integer> squire = num.stream().map(n->n*n).toList();

        Integer sum = num.stream().reduce(0,(a,b)-> (a+b));

        Integer squireSum = num.stream().map(n->n*n).reduce(0,(a,b)->(a+b));

        List<Integer> unique = num.stream().distinct().toList();

        boolean hasEven = num.stream().anyMatch(n->n%2 == 0);
        System.out.println(hasEven);


    }

}
