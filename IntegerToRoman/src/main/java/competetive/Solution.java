package competetive;
import java.util.TreeMap;

class Solution {
  private TreeMap<Integer, String> rMap = new TreeMap<Integer, String>();
  private TreeMap<Integer, Integer> allowedApproximators = new TreeMap<Integer, Integer>();
  private String romanNotation = "";
  private int currentKey = 0;
  private int remainingTarget = 0;

  Solution(){
    this.constructRMap();
    this.constructAllowedApproximators();
  }

  private void constructAllowedApproximators(){
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
    this.currentKey = this.getCurrentKey(num);
    if(hasNativeKey(num)) {
      int repeat = num / this.currentKey;
      for(int i = 0; i < repeat; i++){
        this.romanNotation += rMap.get(this.currentKey);
      }
    }
    else if (num > 1000){
      int repeat = num / 1000;
      for(int i = 0; i < repeat; i++){
        this.romanNotation += rMap.get(this.currentKey);
      }
      remainingTarget = num % 1000;
      if(remainingTarget != 0){
        intToRoman(remainingTarget);
      }
    }
    else if(this.hasYoungerSiblingKey(this.getRoundOffTarget(num))){
      // 900 || 400 || 40 | 4
      this.romanNotation += this.rMap.get(this.allowedApproximators.get(this.currentKey));
      this.romanNotation += this.rMap.get(this.currentKey);
      remainingTarget = this.getRemainingTarget(num, this.getRoundOffTarget(num));
      if(remainingTarget != 0){
        intToRoman(remainingTarget);
      }
    }
    else if(this.hasElderSiblingKey(this.getRoundOffTarget(num))){
      // 1100
      this.romanNotation += this.rMap.get(this.currentKey);
      this.romanNotation += this.rMap.get(this.allowedApproximators.get(this.currentKey));
      remainingTarget = this.getRemainingTarget(num, this.getRoundOffTarget(num));
      if(remainingTarget != 0){
        intToRoman(remainingTarget);
      }
    }
    else if(this.hasCousinKey(this.getRoundOffTarget(num))){
      // 700 || 800 || 70 || 80 || 7 || 8
      this.romanNotation += rMap.get(this.currentKey);
      remainingTarget = this.getRemainingTarget(num, this.currentKey);
      if(remainingTarget != 0){
        intToRoman(remainingTarget);
      }
    }
    else if((remainingTarget = this.getRemainingTarget(num, this.currentKey)) != 0){
      // 19 || 29 || 39. Anything less than 50
      this.romanNotation += this.rMap.get(this.currentKey);
      intToRoman(remainingTarget);
    }
    return this.romanNotation;
  }

  public int getCurrentKey(int remainingTarget){
    int returnValue = 0;
    if(remainingTarget >= 900){
      returnValue = 1000;
    }
    else if(remainingTarget < 900 && remainingTarget >= 400){
      returnValue = 500;
    }
    else if(remainingTarget < 400 && remainingTarget >= 90){
      returnValue = 100;
    }
    else if(remainingTarget < 90 && remainingTarget >= 40){
      returnValue = 50;
    }
    else if(remainingTarget < 40 && remainingTarget >= 9){
      returnValue = 10;
    }
    else if(remainingTarget < 9 && remainingTarget >= 4){
      returnValue = 5;
    }
    else {
      returnValue = 1;
    }
    return returnValue;
  }

  public int getRemainingTarget(int num, int roundOffTarget){
    return num - roundOffTarget;
  }

  public int getRoundOffTarget(int num){
    int returnValue = 0;
    if(num % this.currentKey == 0){
      returnValue = num;
    }
    else{
      if(num >= 1000){
        returnValue = num / 1000 * 1000;
      }
      else if(num == 4 || num == 9){
        returnValue = num;
      }
      else if(num < 1000 && num > 100){
        returnValue = num / 100 * 100;
      }
      else if(num < 100 && num > 10){
        returnValue = num / 10 * 10;
      }
      else if(num < 10 && num > 5){
        returnValue = num / 5 * 5;
      }
      else {
        returnValue = 1;
      }
    }

    return returnValue;
  }

  public boolean hasNativeKey(int num){
    if(num/this.currentKey != 0 && num % this.currentKey == 0) {
      return true;
    } else {
      return false;
    }
  }

  // 900
  public boolean hasYoungerSiblingKey(int roundedOffNumber){
    if(roundedOffNumber != 0 && rMap.containsKey(roundedOffNumber+allowedApproximators.get(this.currentKey))){ return true; }
    else { return false; }
  }

  // 1100
  public boolean hasElderSiblingKey(int roundedOffNumber){
    if(roundedOffNumber != 0 && rMap.containsKey(roundedOffNumber-allowedApproximators.get(this.currentKey))){ return true; }
    else { return false; }
  }

  public boolean hasCousinKey(int num){
    if(num/this.currentKey == 1){ return true; } else { return false; }
  }

  public static void main(String[] args){
    Solution sol = new Solution();
    int num = 921;
    System.out.println(sol.intToRoman(num));
  }
}
