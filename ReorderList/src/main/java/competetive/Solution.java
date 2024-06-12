// https://leetcode.com/problems/reorder-list/
package competetive;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode copyNode(){
        ListNode node = this;
        ListNode copy = new ListNode();
        ListNode newHead = copy;
        while(node != null){
            copy.val = node.val;
            node = node.next;
            if(node != null){ copy.next = new ListNode(); copy = copy.next; }
        }
        return newHead;
    }

    public void constructLinkedList(int[] input, ListNode node, int i){
        if(i+1 < input.length){
            ListNode next = new ListNode(input[i+1]);
            node.next = next;
            constructLinkedList(input, next, i+1);
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode node = head;
        ListNode reverse = head;
        if(node.next == null){}
        else if(node != null){ reverse = reverseHelper(node, node.next, node); }
        return reverse;
    }

    public void printLinkedList(ListNode head){
        if (head != null) {
            System.out.print(head.val);
            if(head.next != null)
                System.out.print(" -> ");
            printLinkedList(head.next);
        }
        else{ System.out.println(); }
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
}

class Solution {
    public void reorderList(ListNode head) {
        ListNode half = head;
        ListNode full = head;
        while(full != null && full.next != null){
            full = full.next.next;
            half = half.next;
        }
        ListNode reverse = half.reverseList(half);
        head.printLinkedList(head);
        reverse.printLinkedList(reverse);
        ListNode reorder = reorderHelper(head, reverse);
        reorder.printLinkedList(reorder);
    }

    private ListNode reorderHelper(ListNode a, ListNode b){
        if(a != b){
            ListNode tempA = a.next;
            a.next = b;
            if(b != null){
                ListNode tempB = b.next;
                b.next = tempA;
                if(tempA != tempB){ reorderHelper(tempA, tempB); }
                else{ tempA.next = null; }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 1,2,3,4,5,6,7,8,9,10 };
//        int[] inputArray = { 1,7,2,6,3,5,4 };
//        int[] inputArray = { 1,2,3,4,5,6,7,8 };
//        int[] inputArray = { 1,8,2,7,3,6,4,5 };
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        solution.reorderList(head);
    }
}
