import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.util.stream.Nodes.collect;

public class Test1 {
    public static void main(String[] args) {
        String str1 = "ab8cd syz9";
        Map<Character, Long> mapToFrequency = str1.replace(" ", "").chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("mapToFrequency " + mapToFrequency);
//--------------------------------------------------------------------------
        Map<Character, Long> findDigitFrequency = str1.chars().filter(Character::isDigit)
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println("findDigitFrequency: " + findDigitFrequency);
//-----------------------------------------------------------------------------------
        Map<Character, Long> mapToFrequency1 = str1.chars().filter(i -> i != ' ')
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("mapToFrequency1: " + mapToFrequency1);
//-----------------------------------------------------------------------------------
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 2, 3, 4};
        int k = 2;
        Integer nums = Arrays.stream(arr1).boxed().sorted().skip(k - 1).findFirst().get();


        // Convert arr2 to a Set for quick lookups
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());

        // Find common elements using Streams
        List<Integer> commonElements = Arrays.stream(arr1).boxed()
                .filter(set2::contains) // Filter elements that are in set2
                //.boxed()               // Convert int to Integer
                .collect(Collectors.toList()); // Collect as a list

        // Print the common elements
        System.out.println("Common elements: " + commonElements);
//----------------------------------------------------------

        List<Integer> match = Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("match:" + match);


//-----------------------------------------------------------------------------------------------
        //First repeating and first non repeating
        String inputWord = "Java articles are Awesome";
        Map<Character, Long> data = inputWord.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Character firstRepeat = data.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        Character firstNonRepeat = data.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        // ----------------------------------------------------------------------------
        List<Integer> num = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        List<Integer> num1 = num.stream().sorted().toList();
        Integer firstElement = num1.stream().findFirst().get();
        Integer maxElement = num.stream().max(Integer::compare).get();
        List<Integer> reverseOrderNum = num.stream().sorted(Comparator.reverseOrder()).toList();
        // -------------------------------------------------------------------------------------
        //Find duplicate name, longest name
        List<String> fruits = Arrays.asList("Apple", "Banana", "Apple", "Banana", "Orange", "Apple");
        Map<String, Long> nameFrequency = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> repeatFruits = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        //
        List<String> str = Arrays.asList("5AA", "8BB", "CC", "AA", "AA");
        List<String> duplyList = str.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList();


        List<String> stringsWithoutNumbers = str.stream()
                .filter(s -> !s.matches(".*\\d.*"))  // Check if string does not contain a digit
                .collect(Collectors.toList());
        //----------------------------------------------------------------------------------------
        //generate the number and calculate the sum of 1st 20 number
        Integer sum = Stream.iterate(1, n -> n + 1).limit(20)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of 20 num:" + sum);

        // --------------------------------------------------------------------------------------
        String strs = "This this is is a test test test";

        Map<String, Long> wordCount = Arrays.stream(strs.split("\\s+")) // Split by whitespace
                .collect(Collectors.groupingBy(
                        Function.identity(),  // use word itself as key
                        Collectors.counting() // count how many times each appears
                ));

        System.out.println(wordCount);

        //{a=1, this=1, is=2, test=3, This=1}


        //--------------------------------------------------------------------------------------------
        int[] arr3 = {2,3,4,5};
        int[] arr4 = {4,5,6,7,8};
        List<Integer> sortNum = Stream.of(arr3,arr4).flatMapToInt(Arrays::stream).sorted().boxed().toList();
        System.out.println(sortNum);

        //How to merge two unsorted arrays and print the merge one in sorted way by using stream api?
        Integer[] array1 = {5, 2, 8, 1};
        Integer[] array2 = {7, 3, 6, 4};
        List<Integer> assedNum = Stream.of(array1,array2).flatMap(Arrays::stream)
                .sorted().toList();
        // Convert array to list
        //List<Integer> list = Arrays.asList(array1);
        Stream.concat(Arrays.stream(array1), Arrays.stream(array2)) // merge
                .sorted()                                             // sort
                .forEach(System.out::println);                        // print
        // -------------------------------------------------------------------------
        //How to merge two unsorted arrays and print the merge one in sorted way by using stream api?
        List<Integer> list1 = Arrays.asList(5, 2, 8, 1);
        List<Integer> list2 = Arrays.asList(7, 3, 6, 4);
        //List<List<Integer>> listOfLists = Arrays.asList(list1, list2);
        List<Integer> sortedMergedList = Stream.of(list1,list2)
        //listOfLists.stream()

                .flatMap(List::stream)     // flatten the nested lists
                .sorted()                  // sort the elements
                .collect(Collectors.toList()); // collect into a list

        System.out.println(sortedMergedList);
//--------------------------------------------------------------------------------------------

        Map<String, Integer> mapFruit = new HashMap<>();
        mapFruit.put("Apple", 30);
        mapFruit.put("Grape", 10);
        mapFruit.put("PineApple", 40);

        // Sort the map by values
        Map<String, Integer> sortedMap = mapFruit.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Handle duplicate keys
                        LinkedHashMap::new // Preserve order
                ));


        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
        //-------------------------------------------------------------------------------------
        //find the duplicate element and how many it occure
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 5, 6);


        // Find duplicates and their occurrences
        Map<Integer, Long> duplicateCounts = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // Filter only duplicates
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //----------------------------------------------------------------------------------
        Integer smallest = num.stream().sorted().findFirst().get();
        Integer maxElement1 = num.stream().max(Integer::compare).get();
        List<Integer> remove = list.stream().filter(n -> !n.equals(smallest) && !n.equals(maxElement1)).toList();
        //----------------------------------------------------------------------------------
        int[] arr = {-1, 4, 6, -5, -7, 8, -9, 0};


        Map<Boolean, List<Integer>> partition = Arrays.stream(arr).boxed()
                .collect(Collectors.partitioningBy(n -> n > 0));
        System.out.println("partition :" + partition);

        List<Integer> negativeValue = Arrays.stream(arr).boxed().filter(n -> n < 0).collect(Collectors.toList());

        Map<String, List<Integer>> findEvenOdd = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

        int[] arr5 = {3, 4, 3, 4, 5, 6, 9, 7};
        Map<Integer, Long> dupKeyValue = Arrays.stream(arr5).boxed().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //Find second highest number
        int[] array = {4,3,6,5};
Integer max2Num = Arrays.stream(array).boxed().sorted((a,b)->b-a)
        .skip(1).findFirst().get();
Integer maxSecNum = Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).findFirst().get();
System.out.println("Second highest number===: " +maxSecNum);

        List<Integer> num11 = Arrays.asList(3,2,9,0,5,6,4);
        List<Integer> sortedNum = num11.stream()
                .sorted(Comparator.reverseOrder())
                //sorts the elements in reverse order.Comparator controle the order
                .collect(Collectors.toList());
        //---------------------------------------------------------------------------------------------------
        //String input = "2ag3ho5kl";
       // Output: agaghohohoklklklklkl
        // Process the input to get the desired output
        /*String output = IntStream.range(0, input.length())
                .filter(i -> Character.isDigit(input.charAt(i)))
                .mapToObj(i -> repeat(input.charAt(i) - '0', input.substring(i + 1, i + 3)))
                .collect(Collectors.joining());

        System.out.println(output);
        // Output: agaghohohoklklklklkl


        // Helper method to repeat the substring based on the count
    private static String repeat(int count, String str) {
        return IntStream.range(0, count)
                .mapToObj(i -> str)
                .collect(Collectors.joining());
    }
        //-------------------------------------------------------------------------------

//Write a logic to achieve the below out put for a given input
    /*Input: "f1e2d4c3d0ba5"
    Output: "abcdef012345"*/
        String inputD = "f1e2d4c3d0ba5";
        List<Character> letter = inputD.chars().mapToObj(i->(char)i).filter(Character::isLetter)
                .sorted().toList();

        List<Character> digit = inputD.chars().mapToObj(i->(char)i)
                .filter(Character::isDigit).sorted().toList();
        System.out.println(digit);

// Use flatMap to combine the two lists into a single stream and join them
        List<Character> result1 = Stream.of(letter, digit)
                .flatMap(List::stream) // Flatten the stream of lists into a single stream
                //.map(String::valueOf) // Convert each Character to a String
                .collect(Collectors.toList()); // Join the elements into a single string
        System.out.println("========"+result1);
        //output========[a, b, c, d, d, e, f, 0, 1, 2, 3, 4, 5]
        String result3 = Stream.of(letter, digit)
                .flatMap(List::stream) // Flatten the stream of lists into a single stream
                .map(String::valueOf) // Convert each Character to a String
                .collect(Collectors.joining()); // Join the elements into a single string
        System.out.println("========"+result3);
        // Use Stream.concat to combine the two streams and join them
        String result2 = Stream.concat(letter.stream(), digit.stream())
                .map(String::valueOf) // Convert each Character to a String
                .collect(Collectors.joining()); // Join the elements into a single string
        System.out.println(result2);
        //--------------------------------------------------------------------------
        Map<String, Integer> map = new HashMap<>();
        map.put("aa", 10);
        map.put("bb", 20);
        map.put("cc", 30);
        map.put("dd", 20);
        map.put("ee", 30);
        map.put("ff", 20);
        map.put("jj", 50);
        //find the key of 2nd highest value
        Integer secondHighestValue = map.values().stream().distinct().sorted(Comparator.reverseOrder())
                .skip(1).findFirst().get();
        System.out.println("secondHighestValue " +secondHighestValue);

        List<String> secondHighestkeys = map.entrySet().stream()
                .filter(entry->entry.getValue() == secondHighestValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("secondHighestKeys " +secondHighestkeys);




        //------------------------------------------------------------
        Integer[] array11 = {1, 2, 3, 4, 5};
        Integer[] array22 = {1, 2, 3, 6, 7};

        // Convert arrays to sets for easier comparison
        Set<Integer> set1 = Arrays.stream(array11).collect(Collectors.toSet());
        Set<Integer> set22 = Arrays.stream(array22).collect(Collectors.toSet());

        // Find elements in array1 but not in array2
        Set<Integer> onlyInArray1 = set1.stream()
                .filter(e -> !set22.contains(e))
                //.filter(Set22::contains)
                .collect(Collectors.toSet());

        // Find elements in array2 but not in array1
        Set<Integer> onlyInArray2 = set2.stream()
                .filter(e -> !set1.contains(e))
                .collect(Collectors.toSet());

        // Output the differences
        System.out.println("Elements only in array1: " + onlyInArray1);
        System.out.println("Elements only in array2: " + onlyInArray2);

        //-----------------------------------------------------------------------------------------
        List<Integer> numsd = Arrays.asList(1,2,3,4);

        Map<Boolean, List<Integer>> datas = numsd.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));

        System.out.println(datas);

        Map<String, List<Integer>> data2 = num.stream()
                .collect(Collectors.groupingBy(n->n%2==0 ? "Even" : "Odd"));

        System.out.println(data2);

        List<Integer> even = num.stream().filter(n->n%2==0).collect(Collectors.toList());
        List<Integer> odd = num.stream().filter(n->n%2==1).collect(Collectors.toList());

        List<Integer> combine = Stream.of(even,odd).flatMap(List::stream).toList();
        System.out.println(combine);

        //2,4,1,3
        //---------------------------------------------------------------------------------------------
        //find common
        Integer[] numb1 = {2,3,4,5};
        Integer[] num2 = {2,4,6,7};
        Set<Integer> dataaa = Arrays.stream(numb1).collect(Collectors.toSet());

        List<Integer> dataa2 = Arrays.stream(num2).filter(dataaa::contains).toList();
        System.out.println(data2);

        //[2, 4]
        List<Integer> lists = Arrays.asList(2,4,5,6,7,8);
// multiply by 2 then filter >10;

        List<Integer> numss = lists.stream().map(n->n*2).filter(n->n>10).toList();
        //List<Integer> filter = numss.stream().filter(n->n>10).toList();
        System.out.println("==="+numss);
    }
}

