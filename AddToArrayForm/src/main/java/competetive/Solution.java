// https://leetcode.com/problems/add-to-array-form-of-integer/
package competetive;
import java.util.List;
import java.util.ArrayList;

class Solution {
  List result = new ArrayList<Integer>();
  int[] num;
  int k;

  public Solution(int[] num, int k){
    this.num = num;
    this.k = k;
  }

  public List<Integer> addToArrayForm() {
    int i = this.num.length;
    helper(i, this.k, 0);
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution(new int[]{9}, 23);
    List result = solution.addToArrayForm();
    System.out.println(result.toString());
  }

  private void helper(int i, int k, int carry){
    if(i > 0 || k > 0 || carry > 0){
      int pseudoNumOfI = i > 0 ? num[i-1] : 0;
      int sum = ((k % 10) + pseudoNumOfI + carry);
      this.result.add(0, sum % 10);
      carry = sum / 10;
      i--;
      helper(i,k/10,carry);
    }
  }
}
