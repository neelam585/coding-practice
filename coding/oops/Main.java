package oops;

public class Main {
    public static void main(String[] args){
        Parent1 p = new Child1();
        //p.display();  // wrong
        p.show();
    }
}

class Parent1 {
    void show(){
        System.out.println("Parent method");
    }
}

class Child1 extends Parent1{
    void display(){
        System.out.println("Child method");
    }

}