package LeatCode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer1 {
    public static void asteroid(int[] arr) {
       Stack<Integer> st = new Stack<>();
       boolean destroy = false;
       for (int a: arr){
           while (!st.empty() && a<0 && st.peek() >0){
               if (Math.abs(a) > Math.abs(st.peek())){
                   st.pop();
                   continue;
               } else if (Math.abs(a) == Math.abs(st.peek())) {
                   st.pop();
               }
               destroy =true;
               break;
           }
           if(!destroy){
               st.push(a);
           }
       }
       while (!st.empty()){
           System.out.println(st.pop());
       }
    }
    public static void main(String[] args){
    int[] num = {5,2,-3};
    asteroid(num);

    }
}
