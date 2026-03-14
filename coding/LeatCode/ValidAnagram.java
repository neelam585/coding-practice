package LeatCode;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s,  String t){
        //1. check length of both string are equal or not.
        //2. convert string into char array.
        //3. sort array.
        //4. compare the sorted array using equals().
        if(s.length() != t.length()) {
            return false;
        }
        // convert to char array
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        //sort both array;
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        //compare sorted array
        return Arrays.equals(sArr,tArr);

    }
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s,t);
        System.out.println(result); // true*/
        System.out.println(isAnagram("rat", "car")); // false
    }
}
