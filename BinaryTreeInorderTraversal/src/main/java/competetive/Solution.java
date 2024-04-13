// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
/* Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
*/

package competetive;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
  private TreeNode head = new TreeNode();
  List<Integer> list = new ArrayList<Integer>();
  LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

  public static void main(String[] args){
    Solution sol = new Solution();
    Object[] rawData = new Object[] { 1, null, 2, 3 };
    // Object[] rawData = new Objec {  0  1   2  3  4   5   6 }
    // i = 0; rawData[i] = 10; 2i+1=1; 2i+2=2
    // i = 1; rawData[i] = 4; 2i+1=3; 2i+2=4
    // i = 2; rawData[i] = 17; 2i+1=5; 2i+2=6
    // 1. Queue = { 10 }
    // 2. Queue = { 4, 17 }
    // 3. Queue = { 17, 1, 5 }
    // 4. Queue = { 1, 5, 16, 21 }
    // 5. Queue = { 5, 16, 21 }
    // 6. Queue = { 16, 21 }
    // 7. Queue = { 21 }
    // 7. Queue = {}
    // TreeNode node = new TreeNode(1, new TreeNode(1, new TreeNode(3)), new TreeNode(2));
    // System.out.println(Arrays.toString(rawData));
    if(rawData.length > 0){
      sol.head.left = new TreeNode();
      sol.queue.add(sol.head.left);
      sol.constructTree(rawData, 0);
      System.out.println(sol.inorderTraversal(sol.head.left));
    }
  }

  private void constructTree(Object[] rawData, int i){
    while(i < rawData.length){
      if(rawData[i] != null){
        TreeNode node = queue.remove();
        node.val = (Integer) rawData[i];
        if(2*i+1 < rawData.length){
          node.left = new TreeNode();
          queue.add(node.left);
        }
        if(2*i+2 < rawData.length){
          node.right = new TreeNode();
          queue.add(node.right);
        }
      }
      i++;
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    if(root != null){
      inorderTraversal(root.left);
      this.list.add(root.val);
      // System.out.println("root.val");
      // System.out.println(root.val);
      inorderTraversal(root.right);
    }
    return list;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
