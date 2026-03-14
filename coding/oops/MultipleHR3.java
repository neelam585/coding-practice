package oops;
import java.util.Scanner;

public class    MultipleHR3 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int result;
        for(int i=1;i<=10;i++)
        {
            result = n*i;
            System.out.println(n+" "+"x"+" "+i+" "+"="+" "+result);
        }
    }
}
