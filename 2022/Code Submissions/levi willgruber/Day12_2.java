package ChristmasCode.Day12;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class Day12_2 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      
      char[][] path = new char[41][64];
      Node start = null;
      Node end = null;
      HashMap<Node,Integer> steps = new HashMap<Node,Integer>();
      int leastSteps = Integer.MAX_VALUE;
      ArrayList<Node> a = new ArrayList<Node>();
      
      for (int i = 0; i < 41; i++) {
         String line = stdin.nextLine();
         for (int j = 0; j < 64; j++) {
            path[i][j] = line.charAt(j);
            if (path[i][j] == 'S') {
               start = new Node(j, i);
            } else if (path[i][j] == 'E') {
               end = new Node(j, i);
            } else if (path[i][j] == 'a'){
               a.add(new Node(j, i));
               steps.put(new Node (j, i), (int)path[i][j] );
            } else {
               steps.put(new Node (j, i), (int)path[i][j] );
            }
         }
      }
      
      steps.put(start, 'a' - 1 );
      steps.put(end, 'z' + 1 );
      
      
          leastSteps = Integer.MAX_VALUE;
          
        for (int i = 0; i < a.size() - 444; i++) {
           Node c = a.get(i);
           int s = where(c, end, steps);
           leastSteps = Math.min(leastSteps, s);
        }
        
       System.out.print(leastSteps);
      
   }
  public static int where(Node start, Node end, HashMap<Node,Integer> steps) {
       HashMap<Node,Integer> up = new HashMap<Node,Integer>();
        HashMap<Node,Node> before = new HashMap<Node,Node>();
        LinkedList<Node> q = new LinkedList<>();
        up.put(start,0);
        q.add(start);
        while(q.size() > 0) {
            Node cur = q.poll();
            if(cur.equals(end)) {
                ArrayList<Node> path = new ArrayList<>();
                while(before.containsKey(cur)) {
                    path.add(cur);
                    cur = before.get(cur);
                }
                return path.size();
            }
            for(Node c : cur.surroudning()) {
                
                if(!steps.containsKey(c) || steps.get(c) > steps.get(cur) + 1)
                    continue;
                int tentativeG = up.get(cur) + 1;
                if(tentativeG < up.getOrDefault(c,Integer.MAX_VALUE)) {
                    up.put(c,tentativeG);
                    before.put(c,cur);
                    q.add(c);
                }
            }
        }
        return Integer.MAX_VALUE;
  }
}
