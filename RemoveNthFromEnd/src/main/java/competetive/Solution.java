// https://leetcode.com/problems/remove-nth-node-from-end-of-list
package competetive;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int fastCounter = 1;
        int slowCounter = 0;
        ListNode slow = new ListNode(0, head);
        ListNode fast = head;
        while(fast.next != null){
            if((fastCounter - slowCounter) == n){
                slow = slow.next;
                slowCounter++;
            }
            else{
                fast = fast.next;
                fastCounter++;
            }
        }
        if(slow.next == head){ head = head.next; }
        else{ slow.next = slow.next.next; }
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
        int[] inputArray = { 1,2,3,4,5,6 };
        ListNode head = new ListNode(inputArray[0]);
        solution.constructLinkedList(inputArray, head, 0);
        solution.printLinkedList(head);
        System.out.println();
        head = solution.removeNthFromEnd(head, 1);
        solution.printLinkedList(head);
    }
}
