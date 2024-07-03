// https://leetcode.com/problems/split-linked-list-in-parts/
package competetive;
import com.list.*;

class Solution {
  public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode node = head;
    int len = 0;
    while(node != null && node.next != null){
      node = node.next.next;
      len += 2;
    }
    if(node != null){
      node = node.next;
      len += 1;
    }
    return new ListNode[]{head};
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] inputArray = new int[] { 1,2,3,4,5,6,7,8,9,10 };
    ListNode head = new ListNode(inputArray[0]);
    head.constructLinkedList(inputArray, head, 0);
    solution.splitListToParts(head, 3);
    System.out.println(ListNode.printLinkedList(head));
  }
}
