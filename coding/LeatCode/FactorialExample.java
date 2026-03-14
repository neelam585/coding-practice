package LeatCode;

public class FactorialExample {
    public static void main(String[] args){
        int n =5;
        long fact = 1;
        for(int i=1; i<=n; i++){
            fact = fact*i;  //1,1*2,2*3,6*4,24*5  == 120
        }
        System.out.println(fact);
    }
}
