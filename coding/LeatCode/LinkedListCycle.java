package LeatCode;

import java.util.List;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
     ListNode slow = head;
     ListNode fast = head;
     while (fast != null && fast.next !=null){
         slow = slow.next;
         fast = fast.next.next;
         if(slow == fast){
             return true;
         }
     }
     return false;
    }
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        boolean result = hasCycle(n1);
        System.out.println(result);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

}