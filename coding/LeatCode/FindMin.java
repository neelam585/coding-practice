package LeatCode;

public class FindMin {
    public static int minElement(int[] arr){
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static int maxElement(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]> max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int secMinElement(int[] arr){
        int max1 = 0;
        int max2 = 0;
        if(arr[0] > arr[1]){
            max1 = arr[0];
            max2 = arr[1];
        }else {
            max2 = arr[0];
            max1 = arr[1];
        }for(int i=2; i<arr.length; i++){   //max1=6, 9, max2=4,,6
            if(arr[i] > max1){  // 2>6 , 9>6 t, 1>9 f
                max2 = max1; //6
                max1 = arr[i]; //9
            }else if(arr[i]> max2){ //2>4 , 9>6 t, 1>6 f
                //max1 = max2;
                max2 = arr[i];
            }
        }
        return  max2;

    }
    public static String reverseWord(String c){
        String reversed = "";
        //char[] c= input.toCharArray();

        for (int i= c.length()-1; i>=0; i--){
            reversed = reversed + c.charAt(i);
        }
        return reversed;
    }
    public static void main(String[] args){
        int[] num = {4, 6, 2, 9, 1, 5,8};
        int result  = minElement(num);
        System.out.println("Min "+result);
        int result2 = maxElement(num);
        System.out.println("Max "+result2);
        int result3 = secMinElement(num);
        System.out.println(result3);
        String s = "Hello";
        String resultStr = reverseWord(s);
        System.out.println(resultStr); //olleH

    }
}

//min  arr[i]   arr[i] < min	min=arr[i]
//4	        6	no		        4
//4	        2	yes		        2
//2	        9	no		        2
//2	        1	yes		        1
//1	        5	no		        1