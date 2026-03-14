import java.lang.Integer;
import java.util.*;
import java.util.stream.*;

public class StreamExample {

    public static List<Integer> processNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n % 2 != 0)          // Step 1: Remove even numbers
                      .map(n -> n * n)                  // Step 2: Square the odd numbers
                      .sorted()                         // Step 3: Sort the squared values
                      .limit(3)                         // Step 4: Get the first three
                      .collect(Collectors.toList());    // Collect the result into a list
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = processNumbers(numbers);
        System.out.println(result);
    }
}