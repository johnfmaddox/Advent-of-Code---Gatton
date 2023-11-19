import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day12/Data.txt";
        File input = new File(fileName);
        try{
            Scanner in = new Scanner(input);
            List<List<Integer>> mountains = new ArrayList();
            while(in.hasNextLine()) {
                List<Integer> line = new ArrayList();
                String[] arr = in.nextLine().split("");
                for(int i = 0; i < arr.length; i++) {
                    String temp = arr[i];
                    char ch = temp.charAt(0);
                    int ascii = ch;
                    line.add(ascii);
                }
                mountains.add(line);
            }

            int ans = shortest(mountains);
            System.out.println(ans);

            }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    public static int shortest(List<List<Integer>> grid) {
        QueueNode start = new QueueNode(0,0,0);
        for(int row = 0; row < grid.size(); row++) {
            for(int column = 0; column < grid.get(row).size(); column++) {
                if(grid.get(row).get(column) == 83 ){
                    start.row = row;
                    start.column = column;
                    start.dis = 0;
                }
            }
        }
        grid.get(start.row).set(start.column,97);
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(start.row, start.column, 0));
        boolean[][] been = new boolean[grid.size()][grid.get(0).size()];
        been[start.row][start.column] = true;
        while(queue.isEmpty() == false) {
            QueueNode position = queue.remove();
            if(grid.get(position.row).get(position.column) == 69) {
                return position.dis;
            }

            if(possible(position.row,position.column + 1,grid,been,position)) {
                queue.add(new QueueNode(position.row,position.column+1,position.dis + 1));
                been[position.row][position.column + 1] = true;
            }

            if(possible(position.row,position.column - 1,grid,been,position)) {
                queue.add(new QueueNode(position.row,position.column-1,position.dis + 1));
                been[position.row][position.column - 1] = true;
            }

            if(possible(position.row + 1,position.column,grid,been,position)) {
                queue.add(new QueueNode(position.row + 1,position.column,position.dis + 1));
                been[position.row + 1][position.column] = true;
            }

            if(possible(position.row - 1,position.column,grid,been,position)) {
                queue.add(new QueueNode(position.row - 1,position.column,position.dis + 1));
                been[position.row - 1][position.column] = true;
            }
        }
        return -1;
    }
    public static boolean possible(int a, int b, List<List<Integer>> grid, boolean[][] been, QueueNode current) {
        //if grid.get(a).get(b) - current <= 1
        int currVal = grid.get(current.row).get(current.column);
        if(!inRange(a,b,grid)) {
            return false;
        }
        int val = grid.get(a).get(b);
        if(val - currVal <= 1 && been[a][b] == false) {
            return true;
        }
        return false;
    }
    public static boolean inRange(int a,int b, List<List<Integer>> grid) {
        if(a >= 0 && b >= 0 && a < grid.size() && b < grid.get(0).size()) {
            return true;
        }
        return false;
    }
}