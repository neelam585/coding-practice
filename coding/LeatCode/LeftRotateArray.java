package LeatCode;

import java.util.Arrays;

public class LeftRotateArray {
    public static void rotateLeft(int[] arr, int k){
        int n= arr.length;  // {1,2,3,4,5,6,7}
        reverse(arr, 0, k-1); // [3, 2, 1, 4, 5, 6, 7]
        reverse(arr,k, n-1); //[3, 2, 1, 7, 6, 5, 4]
        reverse(arr,0, n-1); //[4, 5, 6, 7, 1, 2, 3]

    }
    public static void reverse(int[] arr, int start, int end){
        while (start<end){
           int temp = arr[start]; //1
           arr[start] = arr[end]; //3
           arr[end] = temp; //1
           start++;
           end--;
        }
    }
    public static void main(String[] args){
        int[] num = {1,2,3,4,5,6,7}; // [4,5,6,7,1,2,3] => [3214567], [3217654] [4567123]
        int k = 3;
        rotateLeft(num,k);
        System.out.println(Arrays.toString(num));
    }
}
