package practiceOops;

public class ArrayLength {
    public static void main(String[] args){
        int[] num = {2,4,5,6,7,7};
        int length = calculateSum(num);
        System.out.println(length);
    }
    public static int calculateSum(int[] array){
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum = sum+array[i];
        }
        return sum;

    }
}

