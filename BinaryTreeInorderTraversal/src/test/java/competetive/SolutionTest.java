package competetive;

import competetive.Solution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.LinkedList;

class SolutionTest {
  TreeNode head;
  Solution sol;
  LinkedList<TreeNode> queue;
  Object[] rawData;

  @BeforeEach
  void setup(){
    head = new TreeNode();
    sol = new Solution();
    queue = new LinkedList<TreeNode>();
    head.left = new TreeNode();
    queue.add(head.left);
  }

  @Test
  public void testShortDenerateBinaryTree(){
    rawData = new Object[] { 1, null, 2, 3 };
    sol.constructTree(queue, rawData);
    assertArrayEquals(sol.inorderTraversal(head.left).toArray(), new Object[] { 1, 3, 2 });
  }

  @Test
  public void testMediumShortDegenerateBinaryTree(){
    rawData = new Object[] { 3, 0, 2, 5, 6, 7, 8, null, null, 9, 10 };
    sol.constructTree(queue, rawData);
    assertArrayEquals(sol.inorderTraversal(head.left).toArray(), new Object[] { 5, 0, 9, 6, 10, 3, 7, 2, 8 });
  }

  @Test
  public void testMediumFullBinaryTree(){
    rawData = new Object[] { 10, 4, 17, 1, 5, 16, 21 };
    sol.constructTree(queue, rawData);
    assertArrayEquals(sol.inorderTraversal(head.left).toArray(), new Object[] { 1, 4, 5, 10, 16, 17, 21 });
  }

  @Test
  public void testLeftSkewedBinaryTree(){
    rawData = new Object[] { 10, 8, null, 6, null, 4, null };
    sol.constructTree(queue, rawData);
    assertArrayEquals(sol.inorderTraversal(head.left).toArray(), new Object[] { 4, 6, 8, 10 });
  }

  @Test
  public void testRightSkewedBinaryTree(){
    rawData = new Object[] { 10, null, 8, null, 6, null, 4 };
    sol.constructTree(queue, rawData);
    assertArrayEquals(sol.inorderTraversal(head.left).toArray(), new Object[] { 10, 8, 6, 4 });
  }
}
