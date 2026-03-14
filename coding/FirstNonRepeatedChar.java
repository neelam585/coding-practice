import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

    private static Character firstNonRepeatChar(String input){
        Map<Character, Long> charCount = input.chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        Character firstNonRChar = charCount.entrySet().stream().filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey).findFirst().get();
        return firstNonRChar;

    }
    public static void main(String[] args){
        String[] inputs = {"array", "Python", "React"};
        List<Character> chars = Arrays.stream(inputs).map(FirstNonRepeatedChar::firstNonRepeatChar)
                .collect(Collectors.toList());
        System.out.println(chars);

        //-----------------------------------------------------------

        List<String> items = new ArrayList<>(List.of("Apple", "Banana", "Graps"));
        Iterator<String> iterator = items.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if(item.equals("Banana")){
                iterator.remove();
            }

        }
        System.out.println(items);

        List<Integer> myList = Arrays.asList(12,1333,34510,167,113,51,15,61);
    }

}
