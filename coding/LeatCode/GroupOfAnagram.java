package LeatCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupOfAnagram {
    public static String anagramGroup(String input){
        char[] characters = input.toCharArray();
        Arrays.sort(characters);
        //System.out.println(characters);
        return new String(characters);

    }

    public  static void main(String[] args){
        List<String> strings = Arrays.asList("bat","tan","tea","tab","eat","bta");
        /*String[] strings1 = {"bat","tan","tea","tab","eat","bta"};
        List<String> strings2 = new ArrayList<>(Arrays.asList(strings1));*/
        Map<String,List<String>> anagrams = strings.stream().collect(Collectors.groupingBy(GroupOfAnagram::anagramGroup));
        List<List<String>> anagramList = anagrams.values().stream().toList();
        anagramList.forEach(System.out::println);
        System.out.println(anagrams);
        //{aet=[tea, eat], abt=[bat, tab, bta], ant=[tan]}
//[tea, eat]
//[bat, tab, bta]
//[tan]
        //-------------------------------------------------------------------

    }
}
