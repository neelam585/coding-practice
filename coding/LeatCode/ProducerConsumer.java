package LeatCode;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    Queue<Integer> queue = new LinkedList<>();
    int capacity;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {

        while (queue.size() == capacity) {
            wait();
        }
        //System.out.println();
        queue.add(value);
        System.out.println("producer" + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }
        //System.out.println();
        int value = queue.poll();
        System.out.println("Consumer" + value);
        notifyAll();
        return value;
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer(5);

        Thread producerthread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        });


        Thread consumerThread = new Thread(() -> {
            try {
           /* for (int i = 0; i < 10; i++) {
                pc.consume();
                Thread.sleep(150);
            }*/
                while(true){
                    int value=pc.consume();
                    if(value==-1){
                        break;
                    }

                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        });

        producerthread.start();
        consumerThread.start();

    }
}
