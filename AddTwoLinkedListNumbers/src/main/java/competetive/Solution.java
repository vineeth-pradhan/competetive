package competetive;
import competetive.ListNode;
import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    int[] l1_arr = new int[] { 1,2,3 };
    int[] l2_arr = new int[] { 5,6,4,9,9,9,9,90,91,92 };
    ListNode l1 = ListNode.convertArrayToList(l1_arr);
    ListNode l2 = ListNode.convertArrayToList(l2_arr);
    // int[] result = addTwoNumbers(l1, l2);

    ListNode.printList(l1);
    ListNode.printList(l2);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode currentNode = head;
    int carryOver = 0;
    while(l1.next != null && l2.next != null) {
      ListNode nextNode = new ListNode();
      currentNode.val = (l1.val + l2.val + carryOver) % 10;
      carryOver = (l1.val + l2.val + carryOver) / 10;
      l1 = l1.next;
      l2 = l2.next;
      currentNode.next = nextNode;
      currentNode = nextNode;
    }
    if(l1.next != null) {
      ListNode nextNode = new ListNode();
      nextNode.val = (l1.val + carryOver) % 10;
      carryOver = (l1.val + carryOver) / 10;
      currentNode.next = nextNode;
      if(carryOver != 0) {
        ListNode newResult = new ListNode(carryOver);
        newResult.val = carryOver;
        nextNode.next = newResult;
      }
    }
    if(l2.next != null) {
      ListNode nextNode = new ListNode();
      nextNode.val = (l2.val + carryOver) % 10;
      carryOver = (l2.val + carryOver) / 10;
      currentNode.next = nextNode;
      if(carryOver != 0) {
        ListNode newResult = new ListNode(carryOver);
        newResult.val = carryOver;
        nextNode.next = newResult;
      }
    }

    return head;
  }
}
