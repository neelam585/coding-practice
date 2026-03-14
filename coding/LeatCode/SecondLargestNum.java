package LeatCode;

public class SecondLargestNum {
    public static int secLar(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(largest < arr[i]){
                secondLargest = largest;
                largest = arr[i];
            }else if (arr[i]> secondLargest && arr[i] != largest){
                secondLargest  = arr[i];
            }
        }
        return secondLargest;
    }
    public static void main(String[] args){
        int[] array = { 10, 7, 23, 45, 8};
        int result = secLar(array);
        System.out.println(result);
    }
}
//Time Complexity: O(n)
//
//Space Complexity: O(1)