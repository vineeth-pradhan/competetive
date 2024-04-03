package competetive;
import competetive.ListNode;

class LinkedList {
  ListNode headNode = new ListNode();
  LinkedList(int[] arr) { convertArrayToLinkedList(arr); }
  LinkedList(ListNode node) { this.headNode.next = node; }

  public void convertArrayToLinkedList(int[] arr) {
    ListNode currentNode = new ListNode();
    this.headNode = new ListNode(0, currentNode);
    for(int i=0; i<arr.length; i++) {
      currentNode.val = arr[i];
      if(i+1 < arr.length) {
        currentNode.next = new ListNode();
        currentNode = currentNode.next;
      }
    }
  }

  public void printList() {
    ListNode node = this.headNode.next;
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
