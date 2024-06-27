// https://leetcode.com/problems/rotate-array/
package competetive;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int r = k % nums.length;
        int start = nums.length - r;
        int j = 0;
        nums = rotateHelper(nums, r, start, j);
        System.out.println(Arrays.toString(nums));
    }

    public int[] rotateHelper(int[] nums, int k, int start, int j){
        if(k == 0){ return nums; }
        for(int i = start; i < nums.length; i++){
            if(j < start){
                int temp = nums[j];
                nums[j] = nums[i];
                if(j+k < nums.length) {
                    nums[i] = nums[j+k];
                    nums[j+k] = temp;
                }
                else{ nums[i] = temp; }
                j++;
            }
        }
        if(j < nums.length){
            System.out.println(j);nums = rotateHelper(nums, k, nums.length - k, j + k); return nums; }
        else{ return nums; }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] inputArray = new int[] { 1,2,3,4,5,6,7,8,9,10,11 };
        System.out.println(Arrays.toString(inputArray));
        sol.rotate(inputArray, 4);
    }
}
