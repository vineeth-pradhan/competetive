package competetive;
import java.util.TreeMap;

class Solution {
  private TreeMap<Integer, String> rMap = new TreeMap<Integer, String>();
  private TreeMap<Integer, Integer> allowedApproximators = new TreeMap<Integer, Integer>();
  private String romanNotation = "";
  private int remainingNum;
  private int targetNum;

  Solution(){
    this.constructRMap();
    this.constructallowedApproximators();
  }

  private void constructallowedApproximators(){
    this.allowedApproximators.put(1,0);
    this.allowedApproximators.put(5,1);
    this.allowedApproximators.put(10,1);
    this.allowedApproximators.put(50,10);
    this.allowedApproximators.put(100,10);
    this.allowedApproximators.put(500,100);
    this.allowedApproximators.put(1000,100);
  }

  private void constructRMap(){
    this.rMap.put(1,"I");
    this.rMap.put(5, "V");
    this.rMap.put(10, "X");
    this.rMap.put(50, "L");
    this.rMap.put(100, "C");
    this.rMap.put(500, "D");
    this.rMap.put(1000, "M");
  }

  public String intToRoman(int num) {
    if(num < 1000){
      if(rMap.containsKey(num)){
        this.romanNotation += rMap.get(num);
      }
    }
    return this.romanNotation;
  }

  public static void main(String[] args){
    Solution sol = new Solution();
    int num = 2;
    System.out.println(sol.intToRoman(num));
  }
}
