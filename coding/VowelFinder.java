import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

public class VowelFinder {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Neelam", "Patel", "Spring", "Boot");
        Map<String, List<Character>> vowelsMap = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word1 -> word1.toLowerCase().chars()
                                .mapToObj(c -> (char) c)
                                .filter(ch -> "aeiou".indexOf(ch) >= 0)

                                .collect(Collectors.toList())
                ));

System.out.println(vowelsMap);

        vowelsMap.forEach((word, vowels) ->
                System.out.println(word + " -> " + vowels.stream().count()));

        for(Map.Entry<String ,List<Character>> entry: vowelsMap.entrySet()){
            System.out.println(entry.getKey() +" " + entry.getValue().stream().count());
        }
    }
}
//Neelam -> [e, e, a]
//Patel -> [a, e]
//Spring -> [i]
//Boot -> [o, o]

//Neelam -> 3
//Spring -> 1
//Boot -> 2
//Patel -> 2