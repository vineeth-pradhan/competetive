// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
package competetive;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){ return null; }
        ListNode full = head.next.next;
        ListNode half = head;

        while(full != null && full.next != null){
            full = full.next.next;
            half = half.next;
        }

        half.next = half.next.next;
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
        int[] inputArray = { 5 };
        ListNode head = new ListNode(inputArray[0]);
        solution.constructLinkedList(inputArray, head, 0);
        solution.printLinkedList(head);
        System.out.println();
        head = solution.deleteMiddle(head);
        solution.printLinkedList(head);
    }
}
