package LeatCode;

import java.util.Arrays;
import java.util.List;

public class ArrayRotateByOne {
    //public static List<Integer> leftRotateByOne(int[] arr){
    public static int[] leftRotateByOne(int[] arr){
        //1 : move arr[i+1] to i[0]
        //2: move arr[0] to arr[arr.length-1]
        if(arr.length <= 1){
            return null;
        }
        int firstElement = arr[0];
        for(int i=0; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = firstElement;
        //return Arrays.stream(arr).boxed().toList();
        return arr;
    }

    public static void main(String[] args){
      int [] num = {1,2,3,4,5};
        //Output: 2,3,4,5,1
          /*List<Integer> list = leftRotateByOne(num);
      System.out.println(list);*/
        int[] result = leftRotateByOne(num);
        System.out.println(Arrays.toString(result));

    }
}
