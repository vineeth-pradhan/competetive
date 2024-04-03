package competetive;
import competetive.LinkedList;
import competetive.ListNode;
import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList(new int[] { 2,9,1,9,9,9 });
    LinkedList l2 = new LinkedList(new int[] { 1,3,8});

    l1.printList();
    l2.printList();
    ListNode result = addTwoNumbers(l1.headNode.next, l2.headNode.next);
    LinkedList l3 = new LinkedList(result);
    l3.printList();
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currentNode = new ListNode();
    ListNode l3 = new ListNode(0, currentNode);
    int carryOver = 0;
    while(l1 != null && l2 != null) {
      currentNode.val = (l1.val + l2.val + carryOver) % 10;
      carryOver = (l1.val + l2.val + carryOver) / 10;
      l1 = l1.next;
      l2 = l2.next;
      if(l1 != null && l2 != null){
        currentNode.next = new ListNode();
        currentNode = currentNode.next;
      }
      else if(l1 == null && l2 == null && carryOver != 0) {
        currentNode.next = new ListNode(carryOver);
      }
    }
    while(l1 != null && l2 == null) {
      currentNode.next = new ListNode();
      currentNode = currentNode.next;
      currentNode.val = (l1.val + carryOver) % 10;
      carryOver = (l1.val + carryOver) / 10;
      l1 = l1.next;
    }
    while(l2 != null && l1 == null) {
      currentNode.next = new ListNode();
      currentNode = currentNode.next;
      currentNode.val = (l2.val + carryOver) % 10;
      carryOver = (l2.val + carryOver) / 10;
      l2 = l2.next;
    }

    return l3.next;
  }
}
