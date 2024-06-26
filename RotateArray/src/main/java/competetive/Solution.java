// https://leetcode.com/problems/rotate-array/
package competetive;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int r = k % nums.length;
        int start = nums.length - r;
        int j = 0;
        nums = rotateHelper(nums, k, start, j);
        System.out.println(Arrays.toString(nums));
    }

    public int[] rotateHelper(int[] nums, int k, int start, int j){
        for(int i = start; i < nums.length; i++){
            if(j < nums.length){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        if(j < nums.length){ return rotateHelper(nums, k, start, j); }
        else{
            if(nums.length % k == 1){
                int i = nums.length - 2;
                j = nums.length - 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] inputArray = new int[] { 1,2,3,4,5,6,7,8,9,10,11 };
        System.out.println(Arrays.toString(inputArray));
        sol.rotate(inputArray, 3);
    }
}
