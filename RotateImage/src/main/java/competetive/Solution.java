package competetive;
import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int index = Math.abs(i-(matrix[i].length-1));
                newMatrix[j][index] = matrix[i][j];
            }
        }
        System.out.print("[");
        for(int i = 0; i < newMatrix.length; i++){
            System.out.print("[");
            for(int j = 0; j < newMatrix[i].length; j++){
                System.out.print(newMatrix[i][j]);
                if(j != newMatrix[i].length-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if(i != newMatrix[i].length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}