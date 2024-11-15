package competetive;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i;
        for(i = 0; nums[i] <= target; i++) {
            if(nums[i] == target) { return i; }
            if(i == nums.length - 1) { return nums.length; }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[] { 1 }, 1));
    }
}
