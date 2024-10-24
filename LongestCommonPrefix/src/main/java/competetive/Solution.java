package competetive;
import java.util.Arrays;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    int i;
    if(strs.length == 0){
      return "";
    }
    for(i = 0; i < strs[0].length(); i++) {
      for(int j = 1; j < strs.length; j++) {
        if(i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
          return strs[j].substring(0, i);
        }
      }
    }
    return strs[0].substring(0,i);
  }

  public static void main(String[] args){
    var solution = new Solution();
    System.out.println(solution.longestCommonPrefix(new String[]{ "flower", "fleet", "flow" }));
  }
}
