import java.lang.Integer;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args){
        //Count the Occurrences of Each Word in a List  //Not thread-safe
        // Convert a List of Strings to Uppercase  //Thread-safe
        // Sort a List of Integers in Descending Order //Thread-safe
        //Find the Average of Numbers in a List // Thread-safe
        //Sort a List of Integers in Ascending Order
        //Remove Duplicates from a List   //Thread-safe
        //Concatenate a List of Strings  //Thread-safe
        //Partition a List of Integers into Even and Odd Numbers  //Thread-safe
        //Convert a List of Integers to a List of Their Squares
        //Check if Any Element in a List is Even  ////Not Thread-safe
        //Find the First Element in a List   //Thread-safe
        //Skip First N Elements and Take Rest    //Thread-safe
        //Convert a List of Strings to a Set (Remove Duplicates)  //Thread-safe
        //Group Strings by Their Length
        //Sum of Squares of All Elements
        // Find the Longest String
        // Convert a List of Integers to a List of Their Squares   // Thread-safe
        //Find the Maximum Element in a List  // Thread-safe
        //Check if All Elements in a List are Positive
        //Concatenate All Strings in a List into One String with Separator
        //Flatten a List of Lists  //Not Thread-safe
        //Filter Even Numbers from a List  //Not thread-safe
        //find Duplicate number

            List<String> words = Arrays.asList("Apple", "Banana", "Apple", "Banana", "Orange", "Apple");
           Map<String, Long> countWords = words.stream()
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
           System.out.println(countWords);

           List<String> words1 = Arrays.asList("Apple", "Banana" , "Orange");
           List<String> capsWords1 = words1.stream()
                   .map(String::toUpperCase) //map() applies a transformation to each element in the stream.
                   .collect(Collectors.toList());//String::toUpperCase to convert each string to uppercase
           System.out.println(capsWords1);

           List<Integer> num = Arrays.asList(3,2,9,0,5,6,4);
           List<Integer> sortedNum = num.stream()
                   .sorted(Comparator.reverseOrder()) //sorts the elements in reverse order.Comparator controle the order
                   .collect(Collectors.toList()); //collects the sorted elements into a list.
           System.out.println("Descending order"+sortedNum);

           List<Integer> numAscce = num.stream().sorted().toList();
           System.out.println(numAscce);

           List<Integer> num1 = Arrays.asList(1,3,5,9,4,2,3,1,9);
           List<Integer> distinctNum = num1.stream().distinct().toList();
           System.out.println(distinctNum);

           List<String> words2 = Arrays.asList("Hello", "World" , "from" , "java");
           String concatWords2 = words2.stream()
                   .collect(Collectors.joining("")); //Collectors.joining(" ") joins the strings with a space separator.
           System.out.println(concatWords2);
           List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,9);
           Map<Boolean, List<Integer>> partitioned = number.stream()
                   .collect(Collectors.partitioningBy(n->n%2 == 0));
           System.out.println(partitioned);

           List<Integer> squire = number.stream() //map()function is used to transform each element of the stream into another form
                   .map(n->n*n).collect(Collectors.toList());
           System.out.println(squire);

           boolean hasEven = number.stream().anyMatch(n->n%2 == 0);
           System.out.println(hasEven);

           Optional<String> firstWord = words2.stream()
                   .findFirst(); //findFirst() returns an Optional containing the first element in the stream.
           System.out.println(firstWord);
           List<Integer> skipFirst = number.stream().skip(4).collect(Collectors.toList());
           System.out.println(skipFirst);
        List<String> words3 = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        //set is Thread-safe
        Set<String> uniqueWords = words3.stream()
                                .collect(Collectors.toSet());//automatically removing duplicates.
        System.out.println(uniqueWords);

        Map<Integer, List<String>> groupedByLength = words3.stream()
                                  .collect(Collectors.groupingBy(String::length));
        System.out.println("groupedByLength===" +groupedByLength);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfSquares = numbers.stream()
                .mapToInt(n -> n * n)//mapToInt() converts each element to an int stream
                .sum();
        System.out.println(sumOfSquares);

        List<String> words5 = Arrays.asList("apple", "banana", "kiwi", "strawberry");
        Optional<String> longestWord = words5.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println("longestWord " +longestWord.get());

        //without using Optional
        String longestWord1 = words5.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("No words in the list");
        System.out.println("longestWord1 " +longestWord1);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        // Using orElse to provide a default value in case max() returns an empty Optional
        Integer maxNumber = numbers2.stream()
                .max(Integer::compare).get();
                  // Default value if the stream is empty

        System.out.println("Maximum number: " +maxNumber);  // Output: 5

        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5);

        // Using reduce to find the sum of all integers
        int sum = numbers6.stream()
                .reduce(0, (a, b) -> a + b); // a is the accumulator, b is the current element
//for non primitive
        /*Integer suma = numbers6.stream()
                .reduce(Integer.ZERO, (a, b) -> a + b);
        System.out.println("Sum: " + sum);*/ // Output: Sum: 15

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        boolean allPositive = numbers3.stream().allMatch(n -> n > 0);
        System.out.println(allPositive);

        List<String> words6 = Arrays.asList("Java", "is", "fun");
        String concatenated = words6.stream()
                .collect(Collectors.joining(" - "));
        System.out.println(concatenated);

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6)
        );
        List<Integer> flattenedList = listOfLists.stream()
                //flatMap() is used to flatten a stream of collections into a single stream.
                .flatMap(List::stream)//
                .collect(Collectors.toList());  //o/p [1, 2, 3, 4, 5, 6]

        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers5.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers); // [2, 4, 6, 8, 10]

        List<Integer> num4 = Arrays.asList(1, 4, 9, 0, 3, 5, 2, 5, 5);
        //Set<Integer> seen = new HashSet<>(num4);
        //System.out.println("unique element: " +seen); //unique element: [0, 1, 2, 3, 4, 5, 9]
        Set<Integer> seen = new HashSet<>(); //HashSet() store the unique element in sorted order
        List<Integer> duplicate = num4.stream().filter(n->!seen.add(n)).collect(Collectors.toList());
        System.out.println("Duplicate :" +duplicate);



    }
}
