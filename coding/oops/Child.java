package oops;

public class Child extends Parent{
    //@Override
    public void m3(){};
   // @Override
    public void m1(){
        System.out.println("child m1");
    }

    public  void m2(){
        System.out.println("Child static m2");
    }

    public static void main(String[] args){
        Parent child = new Child();
        Parent parent = new Parent();
        child.m1();
        child.m2();
        parent.m1();
        parent.m2();
    }
}

//child m1
//Child static m2
//Parent m1
//Parent static m2
