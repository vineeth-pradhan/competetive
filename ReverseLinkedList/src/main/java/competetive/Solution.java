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
  public void reverseList(ListNode head) {
    if (head == null) {
      head = null;
    }
    else if(head != null && head.next == null) {
      helper(head, head.next, head);
    }
  }

  public void helper(ListNode current, ListNode next, ListNode head) {
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
  }
}
