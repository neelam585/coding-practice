package Multithreading;

public class ThreadDemo {
    public static void main(String[] args){
        Runnable d = new Hi();
        Runnable h = new Hello();
        Thread t  = new Thread(d);
        Thread t2 = new Thread(h);
        t.start();
        t2.start();
    }
}
class Hi implements Runnable{
    public void run(){
        for (int i=1; i<5; i++){
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){};
        }
    }
}
class Hello implements Runnable{
    public void run(){
        for (int i=1; i<5; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){};
        }
    }
}
