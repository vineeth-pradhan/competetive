package competetive;
import java.util.TreeMap;

class Solution {
  private TreeMap<Integer, String> rMap = new TreeMap<Integer, String>();
  private String romanNotation = "";
  private int[][] multipliers = new int[][] {{1,0},{5,1},{10,1},{50,10},{100,10},{500,100},{1000,100}};
  private int currentKey = 6;

  Solution(){
    this.constructRMap();
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
    if(this.rMap.containsKey(num)){
      this.romanNotation += rMap.get(num);
    }
    else if(this.rMap.containsKey(num+this.multipliers[this.currentKey][1])){
      this.romanNotation += rMap.get(this.multipliers[this.currentKey][1]);
      this.romanNotation += rMap.get(this.multipliers[this.currentKey][0]);
    }
    else if(this.rMap.containsKey(num-this.multipliers[this.currentKey][1])){
      this.romanNotation += rMap.get(this.multipliers[this.currentKey][0]);
      this.romanNotation += rMap.get(this.multipliers[this.currentKey][1]);
    }
    else if(this.rMap.containsKey((num/this.multipliers[this.currentKey][1])*this.multipliers[this.currentKey][1] + this.multipliers[this.currentKey][1])){
      this.romanNotation += rMap.get(this.multipliers[this.currentKey][1]);
      this.romanNotation += rMap.get(this.multipliers[this.currentKey][0]);
      if(num%this.multipliers[this.currentKey][1] != 0){
        currentKey -= 1;
        intToRoman(num%this.multipliers[this.currentKey][1]);
      }
    }
    return this.romanNotation;
  }

  public static void main(String[] args){
    Solution sol = new Solution();
    int num = 980;
    System.out.println(sol.intToRoman(num));
  }
}
