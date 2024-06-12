// https://leetcode.com/problems/reorder-list/
package competetive;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        ListNode node = head;
        ListNode reverse = reverseList(copyNode(head));
        this.printLinkedList(head);
        this.printLinkedList(reverse);
        ListNode reorder = reorderHelper(head, reverse);
        this.printLinkedList(reorder);
    }

    private ListNode copyNode(ListNode head){
        ListNode node = head;
        ListNode copy = new ListNode();
        ListNode newHead = copy;
        while(node != null){
            copy.val = node.val;
            node = node.next;
            if(node != null){ copy.next = new ListNode(); copy = copy.next; }
        }
        return newHead;
    }

    private ListNode reorderHelper(ListNode a, ListNode b){
        if(a.next != b.next){
            ListNode tempA = a.next;
            a.next = b;
            ListNode tempB = b.next;
            b.next = tempA;
            if(tempA.val != tempB.val){ reorderHelper(tempA, tempB); }
            else{ tempA.next = null; }
        }
        return a;
    }

    private ListNode reverseHelper(ListNode current, ListNode next, ListNode newHead){
        if(next != null){
            ListNode temp = next.next;
            next.next = current;
            if(current == newHead) { current.next = null; }
            newHead = reverseHelper(next, temp, newHead);
        }
        else{ newHead = current; }
        return newHead;
    }

    private ListNode reverseList(ListNode head){
        ListNode node = head;
        ListNode reverse = head;
        if(node.next == null){}
        else if(node != null){ reverse = reverseHelper(node, node.next, node); }
        return reverse;
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
        else{ System.out.println(); }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 1,2,3,4,5,6,7 };
//        int[] inputArray = { 1,7,2,6,3,5,4 };
//        int[] inputArray = { 1,2,3,4,5,6,7,8 };
//        int[] inputArray = { 1,8,2,7,3,6,4,5 };
        ListNode head = new ListNode(inputArray[0]);
        solution.constructLinkedList(inputArray, head, 0);
        solution.reorderList(head);
    }
}
