package LeatCode;

import java.util.Arrays;

public class HighestOccurrenceWithoutMap {
    public static void main(String[] args){
        int[] arr = {2,2,2,1,3,3,2,8,8,9,4,5,2,1};  // 2 : 5
           Arrays.sort(arr); // o(log n)
           int maxCount =1;
           int currentCount =1;
           int mostFrequentNum = arr[0];
           for(int i=0; i<arr.length-1; i++){
               if(arr[i] == arr[i+1]){
                   currentCount++;
               }else{
                   currentCount =1;
               }if(currentCount > maxCount){
                   maxCount = currentCount;
                   mostFrequentNum = arr[i];
               }
           }
           System.out.println(mostFrequentNum);
           System.out.println(maxCount);

    }
}
//Interview-Ready Summary
//
//Time Complexity: O(n log n)
//
//Space Complexity: O(log n)
//
//Reason: Sorting dominates time; in-place sort uses logarithmic stack space.