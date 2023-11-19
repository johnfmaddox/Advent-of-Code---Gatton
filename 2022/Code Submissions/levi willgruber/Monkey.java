package ChristmasCode.Day11;

import java.util.Scanner;
import java.util.ArrayList;

public class Monkey {
   
   long inspect;
   ArrayList<Long> items = new ArrayList<Long>();
   String op;
   int opValue;
   int testValue;
   int trueMonkey;
   int falseMonkey;
   boolean square = false;
   
   public Monkey() {
      
   }
   public void setFalseMonkey(int falseMonkey) {
      this.falseMonkey = falseMonkey;
   }
   public void setTrueMonkey(int trueMonkey) {
      this.trueMonkey = trueMonkey;
   }
   public int getFalseMonkey() {
      return falseMonkey;
   }
   public int getTrueMonkey() {
      return trueMonkey;
   }
   
   public void addInspect() {
      inspect++;
   }
   public long getInspect() {
      return inspect;
   }
   public void setOp(String op) {
      this.op = op;
   }
   public void setOpValue(String opVal) {
      
      if (opVal.equals("old")) {
         square = true;
      } else {
         opValue = Integer.parseInt(opVal);
      }
      
   }
   public String getOp() {
      return op;
   }
   public int getOpValue() {
      
      if (square) {
         return 0;
      } else {
         return opValue;
      }
   }
   public ArrayList<Long> getItems() {
      return items;
   }
   public void setTestValue(int testValue) {
      this.testValue = testValue;
   }
   public int getTestValue() {
      return testValue;
   }
   public boolean getSquare() {
      return square;
   }
}
