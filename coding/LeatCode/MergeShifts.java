package LeatCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeShifts {
    public static int[][] mergeShifts(int[][] shifts){
        Arrays.sort(shifts, (a,b)->a[0]-b[0]); // {2,4},{3,6}{3,10}{12,15}
        List<int[]> result = new ArrayList<>();
        int start = shifts[0][0];
        int end = shifts[0][1];
        for (int i=1; i<shifts.length; i++){
            if (shifts[i][0] <= end){  // 3<4
                end = Math.max(end, shifts[i][1]); // (4,6) = 6
            }else {
                result.add(new int[]{start,end});
                start = shifts[i][0];
                end = shifts[i][1];
            }

        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]); //converts a List of int arrays into a
        // 2D int array by providing a correctly typed and sized array for Java to populate.
    }
    public static void main(String[] args){
        int[][] shifts = {{12,15},{2,4},{3,6},{3,10}}; // {2,10} {12,15}
        int[][] shifts1 = {{1,3},{2,6},{8,10},{15,18}}; //[[1,6],[8,10],[15,18]]
        int[][] merge = mergeShifts(shifts1);
        for (int[] s : merge){
            //Because arrays do not override toString().
            //Arrays.toString() converts an array into a readable string representation of its elements
            System.out.println(Arrays.toString(s));
        }
    }
}
