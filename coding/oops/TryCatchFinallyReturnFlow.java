package oops;

public class TryCatchFinallyReturnFlow {
    public static int m1(){
        try{
            System.out.println(10/0);
            return 1;
        }catch (Exception ex){
            System.out.println("catch block");
            return 2;
        }finally {
            //System.exit(0);
            return 3;
        }
    }
    public static void main(String[] args){
        //TryCatchFinallyReturnFlow.m1();
        System.out.println(m1());
    }
}
