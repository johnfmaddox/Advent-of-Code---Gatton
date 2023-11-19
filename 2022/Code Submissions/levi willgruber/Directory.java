package ChristmasCode.Day7;

import java.util.Scanner;

public class Directory {
   
   int files;

   Directory dir;
   
   public Directory (Directory dir, int files) {
      this.files = files;
      this.dir = dir;
    
   }

   public Directory  () {
      files = 0;
   }
   
   public void addFile(int x) {
      files += x;
   }
   
   public int getSize() {
      return files;
   }
   
  
   
   
   public void setDirectory (Directory d) {
      dir = d;
   }
   public Directory getDirectory() {
      return dir;
   }
   
}
