package competetive;
import java.util.HashMap;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    boolean valid = true;
    Stack<Character> tracker = new Stack<>();
    HashMap<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');

    if(s.length() != 0 || s.length() % 2 != 0){
      for(int i = 0; i < s.length(); i++){
        if(map.containsKey(s.charAt(i))){
          tracker.push(map.get(s.charAt(i)));
        }
        else {
          if(tracker.empty() || (tracker.pop() != s.charAt(i))){
            valid = false;
            break;
          }
        }
      }
      if(!tracker.empty()){ valid = false; }
    }
    else {
      valid = false;
    }
    return valid;
  }

  public static void main(String[] args){
    var solution = new Solution();
//    System.out.println(solution.isValid("()()[[[(){}]]]"));
    System.out.println(solution.isValid("()(("));
  }
}
