// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
/* Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
*/

package competetive;
import java.util.LinkedList;
import com.binarytreegenerator.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
  List<Integer> list = new ArrayList<Integer>();

  public static void main(String[] args) throws Exception{
    // Object[] rawData = new Object[] {};
    // Object[] rawData = new Object[] {1};
    Object[] rawData = new Object[] { 1, null, 2, 3 }; // Degenerate binary tree
    // Object[] rawData = new Object[] { 3,0,2,5,6,7,8,null,null,9,10 }; // Degenerate binary tree
    // Object[] rawData = new Object[] { 10,4,17,1,5,16,21 }; // Full binary
    // Object[] rawData = new Object[] { 10,8,null,6,null,4,null }; // left-skewed binary tree
    // Object[] rawData = new Object[] { 10,null,8,null,6,null,4 }; // right-skewed binary tree
    BinaryTree tree = new BinaryTree(rawData);
    Solution sol = new Solution();
    System.out.println(sol.inorderTraversal(tree.getRoot()));
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    if(root != null){
      inorderTraversal(root.getLeft());
      this.list.add(root.getVal());
      inorderTraversal(root.getRight());
    }
    return list;
  }
}
