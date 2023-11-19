import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
class LinkedNode<T>{
	private LinkedNode<T> next;
	private T val;
	public LinkedNode(T element){
		val = element;
		next = null;
	}
	public LinkedNode<T> getNext(){
		return next;
	}
	public T getVal() {
		return val;
	}
	public void setNext(LinkedNode<T> node) {
		next = node;
	}
	public void setVal(T element) {
		val = element;
	}
}
class LinkedQueue<T>{
	LinkedNode<T> front;
	LinkedNode<T> rear;
	int numOfElements;
	public LinkedQueue(){
		front = rear = null;
		numOfElements=0;
	}
	public void enqueue(T element) {
		LinkedNode<T> newNode = new LinkedNode<T>(element);
		if(numOfElements==0) {
			front = rear = newNode;
			numOfElements++;
			return;
		}
		rear.setNext(newNode);
		rear=newNode;
		numOfElements++;
	}
	public T dequeue() throws NoSuchElementException{
		if(numOfElements==0) {
			throw new NoSuchElementException();
		}
		T ret = front.getVal();
		front=front.getNext();
		numOfElements--;
		return ret;
	}
	public int size() {
		return numOfElements;
	}
	
}
public class TuningTrouble {
	public static boolean unique(LinkedQueue<Character> queue) {
		List<Character> list = new ArrayList<Character>();
		boolean ret = true;
		while(queue.size()>0) {
			list.add(queue.dequeue());
		}
		for(int i = 0; i<list.size(); i++) {
			queue.enqueue(list.get(i));
		}
		for(int i = 0; i<list.size(); i++) {
			for(int j = i+1; j<list.size(); j++) {
				if(list.get(i).equals(list.get(j))) {
					ret = false;
				}
			}
		}
		
		return ret;
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner stdin = new Scanner(new File("input"));
		LinkedQueue<Character> queue = new LinkedQueue<Character>();
		int cnt = 0;
		String input = stdin.next();
		char[] chars = input.toCharArray();
		for(int i = 0; i<chars.length; i++) {
			Character currentChar = chars[i];
			//if(queue.size()==4) {
			if(queue.size()==14) {
				if(unique(queue)) {
					break;
				}else {
					queue.dequeue();
					queue.enqueue(currentChar);
					cnt++;
				}
			}else {
				queue.enqueue(currentChar);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
