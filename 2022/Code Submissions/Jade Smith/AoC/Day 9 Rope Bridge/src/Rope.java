import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
class Plane{
	private List<Point> rope;
	private List<Point> pointsVisited;
	Plane(){
		pointsVisited = new ArrayList<Point>();
		rope = new ArrayList<Point>();
		for(int i = 0; i<10; i++) {
			rope.add(new Point(0, 0));
		}
		pointsVisited.add(rope.get(9));
	}
	int numVisited() {
		return pointsVisited.size();
	}
	/*
	 * 0 Right
	 * 1 Up
	 * 2 Left
	 * 3 Down
	 */
	void move(int direction) {
		if(direction==0) {
			rope.get(0).x++;
		}else if(direction==1) {
			rope.get(0).y++;
		}else if(direction==2) {
			rope.get(0).x--;
		}else if(direction==3) {
			rope.get(0).y--;
		}
		moveNext(1);
	}
	void moveNext(int i) {
		
		long nextX=rope.get(i).x;
		long nextY=rope.get(i).y;
		long xOffset = rope.get(i-1).x-nextX;
		long yOffset = rope.get(i-1).y-nextY;
		System.out.println("xOffset: "+ xOffset + ". nextX: " + nextX + ". i: "+ i +"." );
		System.out.println("yOffset: "+ yOffset + ". nextY: " + nextY + ". i: "+ i +"." );
		if(xOffset==2) {
			nextX++;
			nextY+=yOffset;
		}
		if(xOffset==-2) {
			nextX--;
			nextY+=yOffset;
		}
		if(yOffset==2 && xOffset!=2 && xOffset!=-2 ) {
			nextY++;
			nextX+=xOffset;
		}
		if(yOffset==-2 && xOffset!=2 && xOffset!=-2) {
			nextY--;
			nextX+=xOffset;
		}
		if(xOffset==3) {
			nextX+=2;
			if(yOffset==3) {
				nextY+=2;
			}
			if(yOffset==-3) {
				nextY-=2;
			}
		}else if(xOffset==-3) {
			nextX-=2;
			if(yOffset==3) {
				nextY+=2;
			}
			if(yOffset==-3) {
				nextY-=2;
			}
		}else if(yOffset==3) {
			nextY+=2;
		}else if(yOffset==-3) {
			nextY-=2;
		}
		System.out.println(nextX + " " + nextY);
		rope.remove(i);
		rope.add(i, new Point(nextX, nextY));
		if(i==9) {
			System.out.println(nextX+ " " + nextY);
			for(int j = 0; j<numVisited(); j++) {
				if((rope.get(i)).equals(pointsVisited.get(j))) {
					return;
				}
			}
			System.out.println("new");
			pointsVisited.add(rope.get(i));
		}else {
			moveNext(i+1);
		}
		
	}
}
class Point{
	long x;
	long y;
	Point(long x, long y){
		this.x=x;
		this.y=y;
	}
	boolean equals(Point p) {
		if (this.x==p.x && this.y==p.y) {
			return true;
		}else {
			return false;
		}
	}
}
public class Rope {
	static Plane plane = new Plane();
	public static void move(String direction, int amount) {
		for(int i = 0; i<amount; i++) {
			if(direction.equals("R")) {
				plane.move(0);
			}else if(direction.equals("U")) {
				plane.move(1);
			}else if(direction.equals("L")) {
				plane.move(2);
			}else if(direction.equals("D")) {
				plane.move(3);
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner stdin = new Scanner(new File("input"));
		int cnt=0;
		while(stdin.hasNextLine()) {
			String direction = stdin.next();
			int amount = stdin.nextInt();
			System.out.println(direction);
			cnt+=amount;
			move(direction, amount);
		}
		System.out.println(plane.numVisited());
		System.out.println(cnt);
	}
}
