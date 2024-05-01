// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
package competetive;
import java.util.HashMap;

class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> list = new HashMap<>();
        int excessItems = 0;
        for(int i = 0; i < nums.length; i++) {
            if(list.containsKey(nums[i])) {
                if(list.get(nums[i]) >= 2) { excessItems += 1; }
                else{
                    list.put(nums[i], (list.get(nums[i]) + 1));
                    if(excessItems > 0){ nums[i - excessItems] = nums[i]; }
                }
            }
            else{
                list.put(nums[i], 1);
                if(excessItems > 0){ nums[i - excessItems] = nums[i]; }
            }
        }
        return nums.length - excessItems;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println((sol.removeDuplicates(new int[]{ 1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6,6 })));
    }
}