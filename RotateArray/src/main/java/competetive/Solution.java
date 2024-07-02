// https://leetcode.com/problems/rotate-array

package competetive;
import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        nums = reverse(nums, 0, nums.length - 1);
        nums = reverse(nums, 0, k-1);
        nums = reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public int[] reverse(int[] nums, int start, int end){
        if(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            nums = reverse(nums, start+1, end-1);
        }
        return nums;
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        int[] inputArray = new int[] { 1,2,3,4,5 };
        System.out.println(Arrays.toString(inputArray));
        solution.rotate(inputArray, 3);
    }
}