package LeatCode;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Sorted {
    public static boolean isSorted(int[] arr){
        if(arr.length <= 1){
            return true;
        }
        for (int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    //remove duplicate
    // rotate
    public static void main(String[] args){
        int[] num = {1,2,3,4,5};
        //int n = 5;
        boolean result = isSorted(num);
        System.out.println(result);

        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();
        HashMap<Integer,String> maps = new HashMap<>();
        Runnable task = (()->{
           for(int i=0; i<5; i++){
             maps.put(i, "Value" +i);
           }
        });
        new Thread(task).start();
        new Thread(task).start();
    }
}
