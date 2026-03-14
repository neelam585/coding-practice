package LeatCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySumNum {
    public static void main(String[] args){
        //List<Integer> num = Arrays.asList(4,6,3,2,5,9,3,7);
        int[] num = {4,6,3,2,5,9,3,7}; // [10, 5, 14, 10]
        List<Integer> sum = new ArrayList<>();
        for(int i=0; i<num.length; i++){
            if(i%2==0){   // 1,3,5...   0%2 = 0,1%2=1
                //sum.add(num[i-1]+num[i]);
                sum.add(num[i]+num[i+1]);
            }
        }
        System.out.println(sum);
    }
}
