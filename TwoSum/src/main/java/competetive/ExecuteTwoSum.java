package competetive;
import java.util.Arrays;

class ExecuteTwoSum {
  public static void main(String[] args){
    TwoSum twoSum = new TwoSum(14, new int[]{ 1,3,6,4,18,9,21,13,14,19 });
    System.out.println(Arrays.toString(twoSum.indices()));
  }
}
