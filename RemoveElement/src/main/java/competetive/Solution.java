// https://leetcode.com/problems/remove-element/
package competetive;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                k++;
                if(queue.size() != 0){
                    nums[queue.remove()] = nums[i];
                    nums[i] = val;
                    i--;
                }
            }
            else if(nums[i] == val){ queue.add(i); }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{ 0,1,2,2,3,0,4,2 }, 2));
    }
}
