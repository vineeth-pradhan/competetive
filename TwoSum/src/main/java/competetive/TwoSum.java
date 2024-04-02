package competetive;
import java.util.HashMap;

class TwoSum {
  private int target;
  HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
  private int[] indices = { 0,0 };

  TwoSum(int theTarget, int[] rawList){
    target = theTarget;
    for(int i=0; i < rawList.length; i++) {
      list.put(rawList[i], i);
    }
    findIndices(target, list);
  }

  public int[] indices(){
    return indices;
  }

  public void findIndices(int target, HashMap<Integer, Integer> theList) {
    for(Integer firstItem: theList.keySet()) {
      if(theList.containsKey(target - firstItem)) {
        indices[0] = theList.get(target-firstItem);
        indices[1] = theList.get(firstItem);
      }
    }
  }
}
