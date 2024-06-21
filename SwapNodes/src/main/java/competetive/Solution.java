// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
package competetive;
import com.list.*;

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = new ListNode(0, head);
        ListNode slowest = head;
        int fastCount = 1;
        int slowCount = 0;
        while(fast != null){
            fast = fast.next;
            fastCount += 1;
            if(fastCount == k){ slowest = fast; }
            if(fastCount - slowCount - 1 == k){
                slow = slow.next;
                slowCount += 1;
            }
        }
        int temp = slowest.val;
        slowest.val = slow.val;
        slow.val = temp;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = new int[] { 1,2,3,4,5 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        System.out.println(ListNode.printLinkedList(head));
        head = solution.swapNodes(head, 2);
        System.out.println(ListNode.printLinkedList(head));
    }
}