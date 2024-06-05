// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
package competetive;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    int count = 0;
    int length = 0;

    public ListNode deleteMiddle(ListNode head) {
        helper(head);
        ListNode node = head;
        count = 0;
        if(node.next == null){ head = null; }
        while(count <= length/2 - 1){
            node = node.next;
            if(node.next == null){ head.next = null; }
            if(count == length/2 - 1 && node != null && node.next != null){
                node.val = node.next.val;
                node.next = node.next.next;
                break;
            }
            count++;
        }
        return head;
    }

    private void helper(ListNode node){
        if(node != null){
            count++;
            helper(node.next);
        }
        else{ length = count; }
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
        int[] inputArray = { 5,1 };
        ListNode head = new ListNode(inputArray[0]);
        solution.constructLinkedList(inputArray, head, 0);
        solution.printLinkedList(head);
        System.out.println();
        solution.deleteMiddle(head);
        solution.printLinkedList(head);
    }
}
