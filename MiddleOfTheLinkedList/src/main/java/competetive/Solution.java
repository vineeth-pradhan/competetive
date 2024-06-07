// https://leetcode.com/problems/middle-of-the-linked-list/
package competetive;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode half = head;
        ListNode full = head;
        while(full != null && full.next != null){
            full = full.next.next;
            half = half.next;
        }
        return half;
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
        int[] inputArray = { 1,2,3,4,5,6 };
        ListNode head = new ListNode(inputArray[0]);
        solution.constructLinkedList(inputArray, head, 0);
        solution.printLinkedList(head);
        System.out.println();
        ListNode mid = solution.middleNode(head);
        System.out.println(mid.val);
    }
}
