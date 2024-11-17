package competetive;
import com.list.*;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) { return null; }
        ListNode temp = new ListNode(0, head);
        ListNode next = head.next;
        while(head != null && next != null) {
            if(next.val == head.val){
                head.next = null;
                next = next.next;
            }
            else {
                head.next = next;
                head = next;
                next = next.next;
            }
        }

        return temp.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 1,1,1,1,1 };
        ListNode first = new ListNode(inputArray[0]);
        first.constructLinkedList(inputArray, first, 0);
        System.out.println(ListNode.printLinkedList(first));
        System.out.println(ListNode.printLinkedList(solution.deleteDuplicates(first)));
    }
}
