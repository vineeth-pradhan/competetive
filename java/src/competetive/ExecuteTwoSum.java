/**
 * https://leetcode.com/problems/two-sum/description/
 */
package competetive;
import java.util.Map;
import java.util.HashMap;

class TwoSum{
	public int[] findIndicesBruteForce(int[] nums, int target) {
		for(int i = 0; i < nums.length-1; i++) {
			for(int j = 1; j < nums.length; j++) {
				if(nums[i]+nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] findIndicesTwoPass(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++) {
			int rem = target - nums[i];
			if(map.containsKey(rem)) {
				return new int[] { i, map.get(rem) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] findIndicesOnePass(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			int rem = target - nums[i];
			if(map.containsKey(rem)) {
				return new int[] { i, map.get(rem) };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

public class ExecuteTwoSum {
	public static void main(String[] args) {
		int[] nums = { 2, 14, 11, 15, 7 };
		int target = 9;
		TwoSum twoSum = new TwoSum();
		int[] result = twoSum.findIndicesOnePass(nums, target);
		System.out.print("[");
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if(i != (result.length - 1)) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
}
