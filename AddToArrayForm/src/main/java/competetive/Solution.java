// https://leetcode.com/problems/add-to-array-form-of-integer/
package competetive;
import java.util.List;
import java.util.LinkedList;

class Solution {
  List result = new LinkedList<Integer>();

  public List<Integer> addToArrayForm(int[] num, int k) {
    int i = num.length;
    helper(i, k, 0, num);
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List result = solution.addToArrayForm(new int[]{9,9,9,9}, 23);
    System.out.println(result.toString());
  }

  private void helper(int i, int k, int carry, int[] num){
    if(i > 0 || k > 0 || carry > 0){
      int pseudoNumOfI = i > 0 ? num[i-1] : 0;
      int sum = ((k % 10) + pseudoNumOfI + carry);
      this.result.add(0, sum % 10);
      carry = sum / 10;
      i--;
      helper(i,k/10,carry,num);
    }
  }
}
