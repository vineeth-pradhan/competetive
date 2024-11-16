package competetive;
import com.list.*;

class Solution {
    public ListNode deleteDuplicates(ListNode first) {
        ListNode head = new ListNode(0, first);
        ListNode currentNode = first;
        while(first != null) {
            if(first.next != null && first.next.val != currentNode.val) {
                currentNode.next = first.next;
                currentNode = first;
            }
            first = first.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 1, 1 };
        ListNode first = new ListNode(inputArray[0]);
        first.constructLinkedList(inputArray, first, 0);
        System.out.println(ListNode.printLinkedList(first));
        System.out.println(ListNode.printLinkedList(solution.deleteDuplicates(first)));
    }
}
