// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
// https://leetcode.com/submissions/detail/1250900802/
package competetive;
import java.util.Arrays;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(Arrays.deepEquals(mat, target)) {
            return true;
        }
        else{
            for(int i = 1; i <= 3; i++){
                transposeMat(mat);
                boolean fits = fitTarget(mat, target);
                if(fits){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fitTarget(int[][] mat, int[][] target){
        boolean fits = false;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length/2; j++){
                int tempValue = mat[i][j];
                mat[i][j] = mat[i][mat[i].length - j - 1];
                mat[i][mat[i].length - j - 1] = tempValue;
            }
        }
        if(Arrays.deepEquals(mat, target)) {
            fits = true;
        }
        return fits;
    }

    public void transposeMat(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = i + 1; j < mat[i].length; j++){
                int tempValue = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tempValue;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean can = sol.findRotation(new int[][]{{0,0,0},{0,1,0},{1,1,1}}, new int[][]{{1,1,1},{0,1,0},{0,0,0}});
        System.out.println(can);
    }
}
