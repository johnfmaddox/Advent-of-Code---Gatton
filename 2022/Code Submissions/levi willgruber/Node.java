package ChristmasCode.Day12;
import java.util.ArrayList;
import java.util.Objects;

public class Node {
	public int x = 0;
	public int y = 0;
	
	
	
	public Node(int r, int c) {
		x = r;
		y = c;
	}

	public Node() {
		x = 0;
		y = 0;
	}	


	public int hashCode() {
		return Objects.hash(y,x);
	}


	public boolean equals(Object obj) {
	
		Node other = (Node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
	public ArrayList<Node> surroudning() {
		ArrayList<Node> list = new ArrayList<Node>();
		for(int yOff = -1; yOff < 2; yOff++) {
			for(int xOff = -1; xOff < 2; xOff++) {
				//if not diagonal or self
				if(xOff == 0 ^ yOff == 0) {
					list.add(new Node(x+xOff,y+yOff));
				}
			}
		}
		return list;
	}
	

}
