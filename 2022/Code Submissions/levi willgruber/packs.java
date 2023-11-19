package ChristmasCode.Day13;

import java.util.ArrayList;

public class packs {
  
  
  ArrayList<packs> kids;
  int val;
  boolean hasVal = false;
  
  public packs() {
   kids = new ArrayList<packs>();
  }
  public packs (int val) {
     this.val = val;
     hasVal = true;
  }
 
  public int getVal() {
     return val;
  }
  
  public void addKid (packs v) {
     kids.add(v);
  }
  public packs getKid(int index) {
    return kids.get(index);
  }
  public ArrayList<packs> getChildren() {
     return kids;
  }
  public boolean getHasValue() {
     return hasVal;
  }
  
  
}
