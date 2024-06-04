// https://leetcode.com/problems/remove-linked-list-elements
package competetive;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void deleteNode(ListNode node) {
        if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    private void constructLinkedList(int[] input, ListNode node, int i){
        if(i+1 < input.length){
            ListNode next = new ListNode(input[i+1]);
            node.next = next;
            constructLinkedList(input, next, i+1);
        }
    }

    private ListNode getNode(ListNode node, int val){
        ListNode foundNode = new ListNode();
        if(node != null){
            if(node.val == val){ foundNode = node; }
            else{ getNode(node.next, val); }
        }
        return foundNode;
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
        int[] inputArray = { 5,1,3,4 };
        int itemToBeDeleted = 5;
        ListNode head = new ListNode(inputArray[0]);
        solution.constructLinkedList(inputArray, head, 0);
        solution.printLinkedList(head);
        System.out.println();
        System.out.println(itemToBeDeleted);
        ListNode node = solution.getNode(head, itemToBeDeleted);
        solution.deleteNode(node);
        solution.printLinkedList(head);
    }
}
