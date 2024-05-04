package competetive;
import java.util.Arrays;

class Solution {
  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i+1; j < matrix[i].length; j++) {
          int tempValue = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = tempValue;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length / 2; j++) {
        int index = matrix[i].length - 1 - j;
        int tempValue = matrix[i][j];
        matrix[i][j] = matrix[i][index];
        matrix[i][index] = tempValue;
      }
    }
    System.out.println(Arrays.deepToString(matrix));
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.rotate(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
  }
}