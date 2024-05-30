// https://leetcode.com/problems/remove-element/
package competetive;
import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[k++]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{ 0,1,2,2,3,0,4,2 }, 2));
    }
}
