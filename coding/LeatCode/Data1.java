package LeatCode;

import builder.A;

import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Data1{
public static ListNode2 reverse(ListNode2 head){
    ListNode2 pre = null;
    ListNode2 curr = head;
    while (curr !=null){
        ListNode2 nextNode = curr.next;
        curr.next = pre;
        pre = curr;
        curr = nextNode;
    }
    return pre;
}
public static int[][] mergedShift(int[][] shift){
    Arrays.sort(shift,(a,b)->a[0]-b[1]); //{2,4} {3,6}{3,10} {12,15}
    List<int[]> result = new ArrayList<>();
    int start = shift[0][0];
    int end = shift[0][1];
    for (int i=1; i<shift.length; i++){
        if (shift[i][0] <end){
            end = Math.max(end, shift[i][1]);

        }else {
            result.add(new int[]{start,end});
            start = shift[i][0];
            end = shift[i][1];
        }
    }
    result.add(new int[]{start,end});
    return result.toArray(new int[result.size()][]);
}
   public static void main(String[] args){
       //int[] num = {1,2,3,4,5,6,7}; // [4,5,6,7,1,2,3]  321,4567  321, 7654,  4567123
       int k = 3;
          //rotateLeft(num,k);
//System.out.println(Arrays.toString(num));
       int[] bills1 = {5,5,5,10,20};
       int[] bills2 = {5,5,10,10,20};
               // System.out.println(findBills(bills1));
       int[][] shifts = {{12,15},{2,4},{3,6},{3,10}};
       int[][] merged = mergedShift(shifts);
       for (int[] m: merged){
           System.out.println(Arrays.toString(m));
       }
       int[] height = {1,8,6,2,5,4,8,3,7}; //49
       // int result = waterContain(height);
       // System.out.println(result);
       //String[] strings1 = {"bat","tan","tea","tab","eat","bta"};

       String str = "aabbcddeeee";
       /*Character result = firstNonRChar(str);
       System.out.println(result);*/
       //int[] num = {4, 6, 2,1, 9, 5,8};
       //int result  = min(num);
       //int result  = secL(num);
       //System.out.println("Sec"+result);
       int[] nums = {6,7,1,2,3,4,5};
       int target = 2;
       /*int result = search(nums, target);
       System.out.println(result);*/

       int[] asteroids = {3,5,-6,2,-1,4}; // -6,2,4
      //int [] asteroids = {5,10,-5};  //  5,10
       //int [] asteroids = {5,2,-3};  // 5
       /*int[] result = asteroid(asteroids);
       System.out.println(Arrays.toString(result));*/
       String s = "({[]})";
       String s1 = "({[})";
       /*boolean result = isValid(s1);
       System.out.println("NN"+result);*/

       ListNode2 n1 = new ListNode2(1);
       ListNode2 n2 = new ListNode2(2);
       ListNode2 n3 = new ListNode2(3);
       n1.next = n2;
       n2.next = n3;
       ListNode2 value = reverse(n1);
       System.out.println(value.val);

   }


}
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int val){
        this.val = val;
    }
}