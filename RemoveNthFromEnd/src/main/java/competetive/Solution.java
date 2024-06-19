// https://leetcode.com/problems/remove-nth-node-from-end-of-list
package competetive;
import com.list.*;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int fastCounter = 1;
        int slowCounter = 0;
        ListNode slow = new ListNode(0, head);
        ListNode fast = head;
        while(fast.getNext() != null){
            if((fastCounter - slowCounter) == n){
                slow = slow.getNext();
                slowCounter++;
            }
            else{
                fast = fast.getNext();
                fastCounter++;
            }
        }
        if(slow.getNext() == head){ head = head.getNext(); }
        else slow.setNext(slow.getNext().getNext());
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 1,2,3,4,5,6 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        System.out.println(head.printLinkedList(head));
        head = solution.removeNthFromEnd(head, 1);
        System.out.println(head.printLinkedList(head));
    }
}
