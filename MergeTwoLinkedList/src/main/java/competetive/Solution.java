// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
package competetive;
import com.list.*;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return list1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray1 = { 1,2,4 };
        int[] inputArray2 = { 1,3,4 };
        ListNode list1 = new ListNode(inputArray1[0]);
        list1.constructLinkedList(inputArray1, list1, 0);
        System.out.println(ListNode.printLinkedList(list1));
        ListNode list2 = new ListNode(inputArray2[0]);
        list2.constructLinkedList(inputArray2, list2, 0);
        System.out.println(ListNode.printLinkedList(list2));
    }
}
