// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
package competetive;
import com.list.*;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.getNext() == null){ return null; }
        ListNode full = head.getNext().getNext();
        ListNode half = head;

        while(full != null && full.getNext() != null){
            full = full.getNext().getNext();
            half = half.getNext();
        }

        half.setNext(half.getNext().getNext());
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 5,2,3 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        head.printLinkedList(head);
        System.out.println();
        head = solution.deleteMiddle(head);
        head.printLinkedList(head);
    }
}
