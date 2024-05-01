// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
package competetive;

class Solution {
    public int removeDuplicates(int[] nums) {
        int excessItems = 0;
        for(int i = 0; i < nums.length; i++) {
            if(excessItems > 0) {
                nums[i - excessItems] = nums[i];
            }
            if(i+2 < nums.length && nums[i+2] == nums[i]) {
                int j = i+2;
                while(j<nums.length && nums[j] == nums[i]) {
                    excessItems += 1;
                    i = j-1;
                    j++;
                }
            }
        }
        return nums.length - excessItems;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(new int[]{ 1,2,2,3,3,3,4,4,4,4,5,5,5,5,5 }));
    }
}