package competetive;
import java.util.Arrays;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    String lcp = "";
    String c = "";
    int i = 0;
    try {
      while(i <= 200) {
        if(strs.length == 1){
          return strs[0];
        }
        for(int j = 0; j < strs.length; j++){
          if(strs[j].equals("")) {
            return lcp;
          }
          if(c.isEmpty()) {
            c = Character.toString(strs[j].charAt(i));
            continue;
          }
          else {
            if(Character.toString(strs[j].charAt(i)).equals(c)) {
              if( j == strs.length - 1) {
                lcp += c;
              }
              continue;
            }
            else {
              return lcp;
            }
          }
        }
        c = "";
        i += 1;
      }
      return lcp;
    }
    catch(StringIndexOutOfBoundsException e){
      return lcp;
    }
  }

  public static void main(String[] args){
    var solution = new Solution();
    System.out.println(solution.longestCommonPrefix(new String[]{ "flower", "fleet", "flow" }));
//    System.out.println(solution.longestCommonPrefix(new String[]{ "" }));
//    System.out.println(solution.longestCommonPrefix(new String[]{ "a" }));
//    System.out.println(solution.longestCommonPrefix(new String[]{ "ab", "ab", "abc" }));
  }
}
