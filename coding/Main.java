import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Write a Java program to display numbers b/w 100-200, whose sum of first
        // and third digit is equal to the middle. Ex:- 121,132,143,165,176,...

        //
        List<String> strA = Arrays.asList("a=1", "b=2", "c=3");

        Map<String, Integer> mapToKey = strA.stream().map(s -> s.split("="))
                .collect(Collectors.toMap(
                        i -> i[0],
                        i -> Integer.parseInt(i[1]) + 10
                ));






        Map<String, Integer> result = strA.stream()
                .map(s -> s.split("=")) //s.split("=") splits each string into a key-value pair.
                .collect(Collectors.toMap(
                        arr -> arr[0],                            // key
                        arr -> Integer.parseInt(arr[1]) + 10      // value + 10
                ));

        System.out.println(result);  // Output: {a=11, b=12, c=13}

        // Using Stream.iterate to generate numbers from 100 to 199
         List<Integer> num1 = Stream.iterate(100, num -> num + 1)
                .limit(100) // Limit to numbers between 100 and 199 (inclusive)
                .filter(num -> {
                    // Extract digits: first, middle, and third digit
                    int firstDigit = num / 100; // Hundreds place
                    int middleDigit = (num / 10) % 10; // Tens place
                    int thirdDigit = num % 10; // Ones place

                    // Check if sum of first and third digit equals the middle digit
                    return firstDigit + thirdDigit == middleDigit;
                })
                 .collect(Collectors.toList());  // Collect the results in a List
                //.forEach(System.out::println); // Print numbers that meet the condition
        System.out.println(num1);

        List<String> str = Arrays.asList("5AA", "8BB", "CC", "AA");

        // Filter for strings containing numbers
        List<String> stringsWithNumbers = str.stream()
                .filter(s -> s.matches(".*\\d.*"))  // Check if string contains a digit
                .collect(Collectors.toList());  // Collect into a list

        // Filter for strings containing only letters (no numbers)
        List<String> stringsWithoutNumbers = str.stream()
                .filter(s -> !s.matches(".*\\d.*"))  // Check if string does not contain a digit
                .collect(Collectors.toList());  // Collect into a list

        // Print the results
        System.out.println("Strings with numbers: " + stringsWithNumbers);
        System.out.println("Strings without numbers: " + stringsWithoutNumbers);

        String str3 = "helloworld";

        // Convert the string to a stream of characters and join them with commas
        String result1 = str3.chars()
                .mapToObj(c -> (char) c)  // Convert each char to a Character
                .map(String::valueOf)      // Convert each Character to a String
                .collect(Collectors.joining(","));

        System.out.println(result1);  // Output: h,e,l,l,o,w,o,r,l,d

//find matching element
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 2, 3, 4};

        List<Integer> num = Arrays.stream(arr1)
                .filter(x->Arrays.stream(arr2).anyMatch(y->y ==x))
                .boxed().toList();

        // Convert arr2 to a Set for fast lookup
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());

        // Stream arr1 and filter based on presence in arr2
        List<Integer> commonElements = Arrays.stream(arr1)
                .filter(set2::contains)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Matching elements: " + commonElements);
//--------------------------------------------------------------------
        //Find the first number greater than 50, convert to string, and print

        List<Integer> num3 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Optional<Integer> greaterThen50 = num3.stream()
                .filter(n -> n > 50)
                .findFirst();
        System.out.println("greaterThen50: " +greaterThen50);

      Optional<String> greater50 = num3.stream()
                .filter(n -> n > 50)
                .findFirst()
               .map(n -> "First number > 50: " + n); //convert num into string
       System.out.println("greater50: " +greater50);


    }
}
