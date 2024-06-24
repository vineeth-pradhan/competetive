// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
package competetive;
import com.list.*;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0){ return head; }
        if(head == null) { return null; }
        if(head.next == null) { return head; }

        ListNode last = head;
        int len = 1;
        while(last != null && last.next != null && last.next.next != null){
            last = last.next.next;
            len += 2;
        }
        if(last.next != null){
            last = last.next;
            len += 1;
        }
        int rotate = k % len;
        ListNode newHead = head;
        if(rotate > 0){
            ListNode fast = head;
            int fastCounter = 0;
            ListNode slow = new ListNode(0, head);
            int slowCounter = 0;
            while(fast != null){
                fast = fast.next;
                fastCounter += 1;
                if(fastCounter - slowCounter - 1 == rotate){
                    slow = slow.next;
                    slowCounter += 1;
                }
            }
            newHead = slow.next;
            slow.next = null;
            ListNode node = newHead;
            while(node != null && node.next != null){ node = node.next; }
            node.next = head;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = new int[] { 1,2,3 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        System.out.println(ListNode.printLinkedList(head));
        head = solution.rotateRight(head, 1);
        System.out.println(ListNode.printLinkedList(head));
    }
}