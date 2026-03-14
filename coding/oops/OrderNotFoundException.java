package oops;

public class OrderNotFoundException extends Exception{

    String message = "This is custom exception";
    public OrderNotFoundException(String message){
        super(message);
    }
}
