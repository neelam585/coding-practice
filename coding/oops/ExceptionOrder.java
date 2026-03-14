package oops;

public class ExceptionOrder {
    public static void main(String[] args){
        try {
            System.out.println(10 / 0);

        }catch (ArithmeticException ae){
            System.out.println("infinite"+ae.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("finally block");
        }
    }
}
//Exception is the parent class and ArithmeticException is a child of Exception class.
//parent class will never be a first statement in your catch block
//mutable class: stringBuilder, stringBuffer(thread safe);