// https://leetcode.com/problems/swap-nodes-in-pairs/
package competetive;
import com.list.*;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null){
            int tempVal = node.val;
            node.val = node.next.val;
            node.next.val = tempVal;
            if(node.next != null)
                node = node.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = new int[] { 1,2,3,4,5,6 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        System.out.println(ListNode.printLinkedList(head));
        head = solution.swapPairs(head);
        System.out.println(ListNode.printLinkedList(head));
    }
}
