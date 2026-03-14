package Multithreading;

public class VolatileVisibility {
     boolean flag = true;

    public void writerThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        flag = false;
        System.out.println("Writer updated flag");
    }

    public void readerThread() {
        while (flag) {
            System.out.println("Reader Thread");
        }
        System.out.println("Reader stopped");
    }
    public void writerThread1(){
        flag = false;
    }
    public void readerThread1(){
        while (flag){
            System.out.println("Reader Thread 1");
        }
    }
    public static void main(String[] args) {
        VolatileVisibility v = new VolatileVisibility();
           //v.readerThread1();
        new Thread(v::readerThread1).start();
        new Thread(v::writerThread1).start();
    }
}

//❌ Problem without volatile
//
//flag may be cached
//
//Thread may never see false