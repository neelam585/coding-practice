package LeatCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

     final int b;
     static int a;
    public FirstNonRepeatingChar(int b, int a) {
        this.b = 5;
        this.a = 5;
    }

    public static Character firstNonRepeatingChar(String s){
        Map<Character,Integer> charCount = new LinkedHashMap<>();
        //count frequency of each char
        for(char c: s.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0) +1);
        }
        //find first character with count 1;
        for(Map.Entry<Character,Integer> entry : charCount.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return null;
    }
    public static void main(String[] args){
        String str = "aabbcddee";
        Character result = firstNonRepeatingChar(str); 
    }
}
