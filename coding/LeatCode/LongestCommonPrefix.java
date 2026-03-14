package LeatCode;

public class LongestCommonPrefix {
    /*Input : str = ["flowers" , "flow" , "fly", "flight" ]
    Output : "fl"*/
    public static String findPrefix(String[] input){
        if(input == null || input.length==0){ return " "; }
        String prefix = input[0];
        for(int i = 1; i<input.length; i++){
            //We use while instead of if because we need to
            // repeatedly trim the prefix until it matches the beginning of the current string.
            while (!input[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
    public static void main(String[] args){
        String[] str = {"flowers" , "flow" , "fly", "flight" };
        String result = findPrefix(str);
        System.out.println("Longest common prefix:" +result);
    }

}
//Time: O(n × m)
//
//Space: O(1)