// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
/* Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
*/

package competetive;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

class Solution {
  List<Integer> list = new ArrayList<Integer>();

  public static void main(String[] args) throws Exception{
    TreeNode head = new TreeNode();
    Solution sol = new Solution();
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    // Object[] rawData = new Object[] {};
    // Object[] rawData = new Object[] {1};
    Object[] rawData = new Object[] { 1, null, 2, 3 }; // Degenerate binary tree
    // Object[] rawData = new Object[] { 3,0,2,5,6,7,8,null,null,9,10 }; // Degenerate binary tree
    // Object[] rawData = new Object[] { 10,4,17,1,5,16,21 }; // Full binary
    // Object[] rawData = new Object[] { 10,8,null,6,null,4,null }; // left-skewed binary tree
    // Object[] rawData = new Object[] { 10,null,8,null,6,null,4 }; // right-skewed binary tree
    try {
      if(rawData.length > 0){
        head.left = new TreeNode();
        queue.add(head.left);
        sol.constructTree(queue, rawData);
        System.out.println(sol.inorderTraversal(head.left));
      }
      else{
        head.left = null;
        System.out.println(sol.inorderTraversal(head.left));
      }
    }
    catch(Exception e) { }
    finally { System.out.println("Finished"); }
  }

  private void constructTree(LinkedList<TreeNode> queue, Object[] rawData){
    int x = 0, i = 0;
    while(i < rawData.length){
      if(rawData[i] != null){
        TreeNode node = queue.remove();
        node.val = (Integer) rawData[i];
        if(2*i+1-x < rawData.length && rawData[2*i+1-x] != null){
          node.left = new TreeNode();
          queue.add(node.left);
        }
        else if(2*i+1-x < rawData.length && rawData[2*i+1-x] == null){ node.left = null; }

        if(2*i+2-x < rawData.length && rawData[2*i+2-x] != null){
          node.right = new TreeNode();
          queue.add(node.right);
        }
        else if(2*i+2-x < rawData.length && rawData[2*i+2-x] == null){ node.right = null; }
      }
      else{ x += 2; }
      i++;
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    if(root != null){
      inorderTraversal(root.left);
      this.list.add(root.val);
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
