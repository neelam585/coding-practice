package LeatCode;

public class ReverseLinkedList {
    public static ListNode1 reverseList(ListNode1 head){
       ListNode1 prev = null;
       ListNode1 curr = head;
       while (curr != null){
           ListNode1 nextNode = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextNode;
       }
       return prev;
    }
public static void main(String[] args){
          ListNode1 n1 = new ListNode1(1);
          ListNode1 n2 = new ListNode1(2);
          ListNode1 n3 = new ListNode1(3);
           n1.next = n2;
           n2.next = n3;
           ListNode1 newHead = reverseList(n1);
           System.out.println(newHead.val);
           newHead = newHead.next;

}
}
class ListNode1{
    int val;
    ListNode1 next;
    ListNode1(int val){
        this.val = val;
    }

}