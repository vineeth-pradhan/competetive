// https://leetcode.com/problems/remove-element/
package competetive;
import com.list.*;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = new ListNode(val, head);
        ListNode newHead = prev;
        while(node != null) {
            if(node.getVal() != val){
                prev.setNext(node);
                prev = prev.getNext();
            }
            node = node.getNext();
        }
        prev.setNext(null);
        return newHead.getNext();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = new int[] { 1,2,6,4 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        head.printLinkedList(head);
        ListNode newHead = solution.removeElements(head, 6);
        System.out.println();
        newHead.printLinkedList(newHead);
    }
}