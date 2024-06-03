// https://leetcode.com/problems/remove-element/
package competetive;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = new ListNode(val, head);
        ListNode newHead = prev;
        while(node != null) {
            if(node.val != val){
                prev.next = node;
                prev = prev.next;
            }
            node = node.next;
        }
        prev.next = null;
        return newHead.next;
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
        int[] inputArray = new int[] { 1,2,6,4 };
        ListNode head = new ListNode(inputArray[0]);
        solution.constructLinkedList(inputArray, head, 0);
        solution.printLinkedList(head);
        ListNode newHead = solution.removeElements(head, 6);
        System.out.println();
        solution.printLinkedList(newHead);
    }
}