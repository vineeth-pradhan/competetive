// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
package competetive;
import com.list.*;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        head.next = list1;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                ListNode temp = list1.next;
                list1.next = list2;
                list2 = temp;
            }
            list1 = list1.next;
        }
        return head.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray1 = { 1,5,6 };
        int[] inputArray2 = { 1,2,3 };
        ListNode list1 = new ListNode(inputArray1[0]);
        list1.constructLinkedList(inputArray1, list1, 0);
        System.out.println(ListNode.printLinkedList(list1));
        ListNode list2 = new ListNode(inputArray2[0]);
        list2.constructLinkedList(inputArray2, list2, 0);
        System.out.println(ListNode.printLinkedList(list2));
        System.out.println(ListNode.printLinkedList(solution.mergeTwoLists(list1, list2)));
    }
}
