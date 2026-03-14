package LeatCode;

public class LargestPalindrome {
    int max =0; int start =0; int end=0;
    public boolean isPalindrome(String str, int i, int j){
        while (i <j){
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
                i++;
                j--;
        }
        return true;
    }
    public String longestPalindrome(String str){
           for(int i=0; i<str.length(); i++){
               for(int j=i; j<str.length(); j++){
                   if(isPalindrome(str, i, j) == true){
                       if((j-i+1) > max){
                           max = j-i+1;
                           start = i;
                           end = j;
                       }
                   }
               }
           }
           return str.substring(start, end+1);
    }
    public static void main(String[] args){
        LargestPalindrome palindrome = new LargestPalindrome();
        String s = "abacddcag"; // o/p : acddca
        String result = palindrome.longestPalindrome(s);
        System.out.println(result);
    }
}
//Palindrome	i	j	Length	Updated?
//aba	        0	2	3	Yes (first)
//cddc	        3	6	4	Yes
//acddca	    2	7	6	Yes (largest)
//g	8	8	1	No