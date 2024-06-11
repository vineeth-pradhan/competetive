// https://leetcode.com/problems/reverse-linked-list/
package competetive;

class ListNode{
  int val;
  ListNode next;

  public ListNode(){}

  public ListNode(int val){ this.val = val; }

  public ListNode(int val, ListNode next){
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null) { head = null; }
    else if(head.next == null) { head = head; }
    else{ head = helper(head, head.next, head); }
    return head;
  }

  public ListNode helper(ListNode current, ListNode next, ListNode head) {
    if(next != null){
      ListNode temp = next.next;
      next.next = current;
      if(current == head){ current.next = null; }
      head = helper(next, temp, head);
    }
    else{ head = current; }
    return head;
  }

  private void constructLinkedList(int[] input, ListNode node, int i){
    if(i+1 < input.length){
      ListNode next = new ListNode(input[i+1]);
      node.next = next;
      constructLinkedList(input, next, i+1);
    }
  }

  private void printLinkedList(ListNode head){
    if (head != null) {
      System.out.print(head.val);
      if(head.next != null)
        System.out.print(" -> ");
      printLinkedList(head.next);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] inputArray = { 1,2,3,4,5,6,7,8,9,10,11,12,13 };
    if(inputArray.length > 0){
      ListNode head = new ListNode(inputArray[0]);
      solution.constructLinkedList(inputArray, head, 0);
      solution.printLinkedList(head);
      head = solution.reverseList(head);
      System.out.println();
      solution.printLinkedList(head);
    }
    else{ System.out.println("[]"); }
  }
}
