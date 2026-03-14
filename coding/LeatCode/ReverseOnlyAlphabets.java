package LeatCode;

public class ReverseOnlyAlphabets {
    // Method to reverse only alphabets, keeping special characters in place
    public static String reverseOnlyLetters(String input) {
        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else {
                // Swap only letters
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "ABC$ED&F";
        String result = reverseOnlyLetters(input);
        System.out.println("Input:  " + input);
        System.out.println("Output: " + result);
    }
}
//left	right	chars[left]	chars[right]	Action
//0	        7	A	            F	swap → F B C $ E D & A
//1	        6	B	            &	skip right– → right=5
//1	        5	B	            D	swap → F D C $ E B & A
//2	        4	C	            E	swap → F D E $ C B & A
//3	        3	$	            $	left < right stops