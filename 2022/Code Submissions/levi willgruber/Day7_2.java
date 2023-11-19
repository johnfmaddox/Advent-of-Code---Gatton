package ChristmasCode.Day7;

import java.util.Scanner;
import java.util.ArrayList;

public class Day7_2 {

   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int result = 0;

      ArrayList<Directory> dirs = new ArrayList<Directory>();
      ArrayList<String> names = new ArrayList<String>();

      Directory d = new Directory();
      dirs.add(d);
      names.add("/");

      String type = stdin.next();
      String com = stdin.next();
      String name = stdin.next();

      change(name, 0, stdin, dirs, names);

      int delete = 70000000 - dirs.get(0).getSize();
      delete = 30000000 - delete;
      int min = 70000000;
      System.out.println(delete);

      for (int i = 0; i < dirs.size(); i++) {
         System.out.println(dirs.get(i).getSize() + " " + names.get(i));

         if (dirs.get(i).getSize() >= delete && dirs.get(i).getSize() <= min) {
            result = dirs.get(i).getSize();
            min = result;
            System.out.println("MIN: " + min);
         }
      }
      System.out.println("Final Min: " + result);
   }

   public static void change(String name, int index, Scanner stdin, ArrayList<Directory> dirs,
         ArrayList<String> names) {

      String type = stdin.next();
      Directory dir = dirs.get(index);

      boolean two = false;
      if (type.equals("$")) {
         type = stdin.next();
         if (type.equals("cd")) {
            type = stdin.next();
            two = true;
         }
      }
      while (!type.equals("..") && stdin.hasNextLine()) {

         if (two) {
            int i = names.lastIndexOf(type);
            change(type, i, stdin, dirs, names);
            String re = names.get(i) + "FIN";
            names.set(i, re);
            dir = dir.getDirectory();
            if (stdin.hasNext()) {
               type = stdin.next();
            }
            two = false;

         } else if (type.equals("$")) {

            type = stdin.next();
            if (type.equals("ls")) {
               if (stdin.hasNext()) {
                  type = stdin.next();
               }
               continue;
            } else if (type.equals("cd")) {
               type = stdin.next();
               if (!type.equals("..")) {
                  int i = names.lastIndexOf(type);
                  change(type, i, stdin, dirs, names);
                  String re = names.get(i) + "FIN";
                  names.set(i, re);
                  if (stdin.hasNext()) {
                     type = stdin.next();
                  }
               }
            }
         } else if (type.equals("ls")) {
            if (stdin.hasNext()) {
               type = stdin.next();
            }
            continue;
         } else if (type.equals("dir")) {
            type = stdin.next();

            direct(type, dir, dirs, names);
            if (stdin.hasNext()) {
               type = stdin.next();
            }
         } else {

            int size = Integer.parseInt(type);
            file(dir, size);
            type = stdin.next();
            if (stdin.hasNext()) {
               type = stdin.next();
            }
         }

      }

   }

   public static void file(Directory dir, int file) {

      if (dir.getDirectory() != null) {
         dir.addFile(file);
         file(dir.getDirectory(), file);
      } else {
         dir.addFile(file);
      }
   }

   public static void direct(String name, Directory oldDir, ArrayList<Directory> dirs, ArrayList<String> names) {
      Directory dir = new Directory(oldDir, 0);
      dirs.add(dir);
      names.add(name);
   }

}
