import java.lang.Integer;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Practice {
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
        //even , squire then sum
        //find manx and min number
        //find unique element   //Thread-safe
        //find duplicate element
        //if any number is even return true
        //flatMap
        //find the even number then squire of each number
        //distinct then sorted

        //find the max number in the list
        List<Integer> num = Arrays.asList(1,4,9,0,3,5,2,5);
        List<Integer> numAscending = num.stream().sorted().toList();
        System.out.println("Ascending order: " + numAscending);

        //List<Integer> numDes = num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> numDes = num.stream().sorted(Comparator.reverseOrder()).toList();
System.out.println("Descending Order: "+numDes);

        Optional<Integer> first = num.stream().findFirst(); //Thread-safe
        //because there is no modification in the shared state.
        Integer first1 = num.stream().findFirst().orElse(Integer.valueOf("0"));
        System.out.println("Find first number: " +first);

        long countNum= num.stream().count();
        System.out.println("number of element" +countNum);

        //For sequential streams: num.stream() The below code is thread-safe.
        //For parallel streams: The code is not thread-safe because Collectors.toList() is not thread-safe
        //List<Integer> even = num.stream().filter(n->n%2 == 0).collect(Collectors.toList());//Thread-safe
        List<Integer> even = num.stream().filter(n->n%2 == 0).toList();
        System.out.println("Find even number " +even);

        //List<Integer> odd= num.stream().filter(n->n%2  ==1).collect(Collectors.toList()); OR
        List<Integer> odd= num.stream().filter(n->n%2  ==1).toList();
        System.out.println("Odd number: " +odd);

        //List<Integer> squire = num.stream().map(n->n*n).collect(Collectors.toList()); //Thread-safe
        List<Integer> squire1 = num.stream().map(n->n*n).toList();
        System.out.println("Squire: "+squire1);

        Integer sum = num.stream().reduce(0,(a,b)-> (a+b)); //Thread-safe
        System.out.println("Sum of each element:" +sum);

        Integer squireSum = num.stream().map(n->n*n).reduce(0,(a,b)->(a+b));
        System.out.println("Some of squire of each element " +squireSum); //Thread-safe

        List<Integer> num2 = Arrays.asList(1,4,9,0,3,5,2,5,5);
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicate = num2.stream().filter(n->!seen.add(n)).collect(Collectors.toList());
        System.out.println("Duplicate element: " +duplicate);

        List<Integer> num3 = Arrays.asList(1,2,3,4,5,5,3);
        List<Integer> unique2 = num3.stream().distinct().toList();  //thread safe
        System.out.println("Remove duplicate element: " +unique2);

       Integer maxNum = num3.stream().max(Integer::compare).get();
        System.out.println("Max number: " +maxNum);

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6)
        );
        List<Integer> singleStream = listOfLists.stream().flatMap(List::stream).toList();
        System.out.println("singleStream: " +singleStream);
//------------------------------------------------------------------------------------------------------//
        List<Integer> num5 = Arrays.asList(5,8,39,3,19,14,17);
        List<Integer> numAsce = num5.stream().sorted().toList();
        Integer firstNum = numAsce.stream().findFirst().orElse(Integer.valueOf("0"));
        Integer lastNum = numAsce.stream().reduce(0,(a,b)-> b);
        List<Integer> diff = num5.stream().filter(n->!n.equals(firstNum) && !n.equals(lastNum)).toList();

        System.out.println("difference" +diff);

        //find the even number then squire of each number
        List<Integer> evenSquire = num5.stream().filter(n->n%2 == 0).map(n->n*n).toList();
        System.out.println("Filter the even number then squire of each "+evenSquire);

        Integer maxNumber = num5.stream().reduce(0,(a,b)-> a>b ? a:b);
        System.out.println("Max number " + maxNumber);

        Integer maxNumber1 = num5.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b ? a:b);
        System.out.println("max number " +maxNumber1);

        Integer minumumValue = num5.stream().reduce(Integer.MAX_VALUE,(a,b)->a>b ? b:a);
        System.out.println("Min Value "+minumumValue);

        Integer evenSquireSum = num5.stream().filter(n->n%2 == 0).map(n->n*n)
                .reduce(0,(a,b)->a+b);
        System.out.println("Even squire the sum " +evenSquireSum);

        List<Integer> distinctSorted = num5.stream().distinct().sorted().toList();
        System.out.println("Print unique Number in ASC order: " +distinctSorted);




    }

}
