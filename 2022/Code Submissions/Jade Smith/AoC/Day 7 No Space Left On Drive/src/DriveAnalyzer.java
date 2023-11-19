import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Directory{
	List<DriveFile> files;
	List<Directory> subDirectories;
	Directory parent;
	int numOfSubsChecked = 0;
	Directory(Directory parent){
		if(parent!=null) {
			this.parent = parent;
		}
		this.files=new ArrayList<DriveFile>();
		this.subDirectories= new ArrayList<Directory>();
	}
	void addFile(DriveFile file) {
		files.add(file);
	}
	Directory getParent() {
		return parent;
	}
	void addDirectory(Directory directory) {
		subDirectories.add(directory);
	}
	int getSize() {
		int ret = 0;
		for(int i = 0; i<files.size(); i++) {
			ret+=files.get(i).getSize();
		}
		for(int i = 0; i<subDirectories.size(); i++) {
			ret+=subDirectories.get(i).getSize();
		}
		return ret;
	}
	int getNumOfSubs() {
		return subDirectories.size();
	}
	int getNumOfSubsChecked() {
		return numOfSubsChecked;
	}
	Directory getNextSub() {
		return subDirectories.get(numOfSubsChecked++);
	}
}
class DriveFile{
	int size;
	DriveFile(int size){
		this.size=size;
	}
	int getSize() {
		return size;
	}
}
public class DriveAnalyzer {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = new Scanner(new File("input"));
		List<Directory> directories = new ArrayList<Directory>();
		Directory currentDirectory = null;
		Directory parentDirectory = null;
		boolean listing = false;
		Directory outerMost = null;
		while(stdin.hasNextLine()) {
			String cmdInput = stdin.nextLine();
			if(cmdInput.charAt(0)=='$') {
				if(cmdInput.substring(2, 4).equals("cd")) {
					listing = false;
					if(cmdInput.length()<7) {
						parentDirectory = currentDirectory;
						if(parentDirectory==null) {
							outerMost = currentDirectory = new Directory(null);
						}else {
							currentDirectory = parentDirectory.getNextSub();
						}
						directories.add(currentDirectory);
					}else if(cmdInput.substring(5, 7).equals("..")) {
						currentDirectory = currentDirectory.getParent();
						parentDirectory = currentDirectory.getParent();
					}else {
						parentDirectory = currentDirectory;
						if(parentDirectory==null) {
							currentDirectory = new Directory(null);
						}else {
							currentDirectory = parentDirectory.getNextSub();
						}
						directories.add(currentDirectory);
					}
				}else if(cmdInput.substring(2, 4).equals("ls")) {
					listing = true;
				}
			}else if(listing) {
				if(cmdInput.substring(0, 3).equals("dir")) {
					currentDirectory.addDirectory(new Directory(currentDirectory));
					
				}else {
					StringTokenizer sizeGetter = new StringTokenizer(cmdInput);
					int size = Integer.parseInt(sizeGetter.nextToken());
					DriveFile file = new DriveFile(size);
					currentDirectory.addFile(file);
				}
			}
		}
		/*
		int ret = 0;
		for(int i = 0; i<directories.size(); i++) {
			int thisSize = directories.get(i).getSize();
			if(thisSize<=100000) {
				ret+=thisSize;
			}
		}
		System.out.println(ret);
		*/
		int unusedSize=70000000-outerMost.getSize();
		int sizeNeeded=30000000-unusedSize;
		Directory smallestPossibleDirectory = null;
		for(int i = 0; i<directories.size(); i++) {
			int thisSize = directories.get(i).getSize();
			if(smallestPossibleDirectory==null) {
				smallestPossibleDirectory=directories.get(i);
			}else if(smallestPossibleDirectory.getSize()>thisSize && thisSize>=sizeNeeded) {
				System.out.println(thisSize);
				smallestPossibleDirectory=directories.get(i);
			}
		}
		System.out.println(sizeNeeded);
		System.out.println(smallestPossibleDirectory.getSize());
	}
}
