// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
/* Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
*/

package competetive;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
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
