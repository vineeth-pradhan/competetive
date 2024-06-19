// https://leetcode.com/problems/remove-linked-list-elements
package competetive;
import com.list.*;

class Solution {
    public void deleteNode(ListNode node) {
        if(node.getNext() != null){
            node.setVal(node.getNext().getVal());
            node.setNext(node.getNext().getNext());
        }
    }

    private ListNode getNode(ListNode node, int val){
        ListNode foundNode = new ListNode();
        if(node != null){
            if(node.getVal() == val){ foundNode = node; }
            else{ getNode(node.getNext(), val); }
        }
        return foundNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputArray = { 5,1,3,4 };
        int itemToBeDeleted = 5;
        ListNode head = new ListNode(inputArray[0]);
        head.constructLinkedList(inputArray, head, 0);
        System.out.println(ListNode.printLinkedList(head));
        System.out.println(itemToBeDeleted);
        ListNode node = solution.getNode(head, itemToBeDeleted);
        solution.deleteNode(node);
        System.out.println(ListNode.printLinkedList(head));
    }
}
