// https://leetcode.com/problems/reorder-list/
package competetive;
import com.list.*;

class Solution {
    public void reorderList(ListNode head) {
        ListNode half = head;
        ListNode full = head;
        while(full != null && full.getNext() != null){
            full = full.getNext().getNext();
            half = half.getNext();
        }
        ListNode reverse = half.reverseList(half);
        head.printLinkedList(head);
        reverse.printLinkedList(reverse);
        ListNode reorder = reorderHelper(head, reverse);
        reorder.printLinkedList(reorder);
    }

    private ListNode reorderHelper(ListNode a, ListNode b){
        if(a != b){
            ListNode tempA = a.getNext();
            a.setNext(b);
            if(b != null){
                ListNode tempB = b.getNext();
                b.setNext(tempA);
                if(tempA != tempB){ reorderHelper(tempA, tempB); }
                else{ tempA.setNext(null); }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 1,2,3,4,5,6,7,8,9,10 };
//        int[] inputArray = { 1,7,2,6,3,5,4 };
//        int[] inputArray = { 1,2,3,4,5,6,7,8 };
//        int[] inputArray = { 1,8,2,7,3,6,4,5 };

        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        solution.reorderList(head);
    }
}
