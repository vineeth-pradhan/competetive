// https://leetcode.com/problems/move-zeroes/
package competetive;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != 0){ nums[count++] = nums[i]; }
        }
        while(count < nums.length){ nums[count++] = 0; }
        System.out.println(Arrays.toString(nums));
    }
//    public void moveZeroes(int[] nums) {
//        int count = 0;
//        for(int i=0; i < nums.length; i++){
//            if(nums[i] == 0){ count+=1; }
//            else{
//                int temp = nums[i-count];
//                nums[i-count] = nums[i];
//                nums[i] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.moveZeroes(new int[] { 0,0,0,0,1 });
        // nums[i - count]
    }
}
