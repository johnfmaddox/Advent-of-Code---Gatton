package ChristmasCode.Day12;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class Day12 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      
      char[][] path = new char[41][64];
      Node start = null;
      Node end = null;
      HashMap<Node,Integer> steps = new HashMap<Node,Integer>();
      int leastSteps = Integer.MAX_VALUE;
      
      for (int i = 0; i < 41; i++) {
         String line = stdin.nextLine();
         for (int j = 0; j < 64; j++) {
            path[i][j] = line.charAt(j);
            if (path[i][j] == 'S') {
               start = new Node(j, i);
            } else if (path[i][j] == 'E') {
               end = new Node(j, i);
            } else {
               steps.put(new Node (j, i), path[i][j] - 96);
            }
         }
      }
      
      steps.put(start, 0 );
      steps.put(end, 27 );
      
       leastSteps = (where(start, end, steps));
       System.out.print(leastSteps);
      
   }
  public static int where(Node start, Node end, HashMap<Node,Integer> steps) {
       HashMap<Node,Integer> gCost = new HashMap<Node,Integer>();
        HashMap<Node,Node> parent = new HashMap<Node,Node>();
        LinkedList<Node> queue = new LinkedList<>();
        gCost.put(start,0);
        queue.add(start);
        while(queue.size() > 0) {
            Node cur = queue.poll();
            if(cur.equals(end)) {
                ArrayList<Node> path = new ArrayList<>();
                while(parent.containsKey(cur)) {
                    path.add(cur);
                    cur = parent.get(cur);
                }
                return path.size();
            }
            for(Node c : cur.surroudning()) {
                
                if(!steps.containsKey(c) || steps.get(c) > steps.get(cur) + 1)
                    continue;
                int tentativeG = gCost.get(cur) + 1;
                if(tentativeG < gCost.getOrDefault(c,Integer.MAX_VALUE)) {
                    gCost.put(c,tentativeG);
                    parent.put(c,cur);
                    queue.add(c);
                }
            }
        }
        return Integer.MAX_VALUE;
  }
}
