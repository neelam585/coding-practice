package oops;
@FunctionalInterface
interface MyFunction{
    void display();

}
class WithLambdaEx{
    public static void main(String[] args){
        MyFunction myFunction = ()->{
          System.out.println("Interview");
        };
        myFunction.display();
    }
}
