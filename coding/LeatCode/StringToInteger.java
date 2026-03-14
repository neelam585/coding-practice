package LeatCode;
import java.lang.String;
public class StringToInteger {
    public static int convert(String input){
        input = input.trim();
        if(input.isEmpty()){
            return 0;
        }
        int i = 0;
        int sign = 1;
        if(input.charAt(i)== '-' || input.charAt(i)== '+'){
            sign = (input.charAt(i) == '-')? -1 : 1;
            i++;

        }
        return sign;

    }
    public static void main(String[] args){
        String s = "4193 with words";
        int result = convert(s);
        System.out.println(result);
    }
}
