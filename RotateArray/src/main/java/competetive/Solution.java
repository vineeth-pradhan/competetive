// https://leetcode.com/problems/rotate-array/
package competetive;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int r = k % nums.length;
        int start = nums.length - r;
        int j = nums.length - 2 * r;
        nums = rotateHelper(nums, k, start, j);
        System.out.println(Arrays.toString(nums));
    }

    public int[] rotateHelper(int[] nums, int k, int start, int j){
        if(k == 0){ return nums; }
        for(int i = start; i < nums.length; i++){
            if(j < start && j >= 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        if(j > k){ return rotateHelper(nums, k, start - k, start - 2 * k); }
        else {
            int m = j + k - 1;
            while(m < k){
                int temp = nums[m];
                nums[m] = nums[m+1];
                nums[m+1] = temp;
                m++;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] inputArray = new int[] { 1,2,3,4,5,6 };
        System.out.println(Arrays.toString(inputArray));
        sol.rotate(inputArray, 4);
    }
}
