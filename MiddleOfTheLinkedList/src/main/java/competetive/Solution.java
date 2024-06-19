// https://leetcode.com/problems/middle-of-the-linked-list/
package competetive;
import com.list.*;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode half = head;
        ListNode full = head;
        while(full != null && full.getNext() != null){
            full = full.getNext().getNext();
            half = half.getNext();
        }
        return half;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 1,2,3 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        System.out.println(ListNode.printLinkedList(head));
        ListNode mid = solution.middleNode(head);
        System.out.println(mid.getVal());
    }
}
