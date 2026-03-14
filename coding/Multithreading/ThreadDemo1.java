package Multithreading;

public class ThreadDemo1 {
    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            for (int i=1; i<5; i++ ){
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){}
    }
        });

        Thread t2 = new Thread(()->{
            for (int i=1; i<5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        });
        t1.start();
        try{Thread.sleep(10);}catch (InterruptedException e){}
        t2.start();
        System.out.println("Bye");
    }

}
//Hi
//Bye
//Hello
//Hi
//Hello
//Hi
//Hello
//Hi
//Hello