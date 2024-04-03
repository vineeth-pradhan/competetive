package competetive;

class ListNode{
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  static ListNode convertArrayToList(int[] arr) {
    ListNode currentNode = new ListNode();
    ListNode head = new ListNode(0, currentNode);
    for(int i=0; i<arr.length; i++) {
      currentNode.val = arr[i];
      if(i+1 < arr.length) {
        currentNode.next = new ListNode();
        currentNode = currentNode.next;
      }
    }
    return head.next;
  }

  static void printList(ListNode node) {
    System.out.print("[");
    while(node != null) {
      System.out.print(node.val);
      if(node.next != null)
        System.out.print(",");
      node = node.next;
    }
    System.out.println("]");
  }
}
