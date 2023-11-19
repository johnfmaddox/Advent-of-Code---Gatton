import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private Directory parent;
    private List<Directory> children = new ArrayList<Directory>();
    private List<MyFileClass> files = new ArrayList<MyFileClass>();
    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }
    public Directory getParent() {
        return this.parent;
    }

    public String getDirName() {
        return this.name;
    }
    public void addFile(String name, long size) {
        MyFileClass in = new MyFileClass(name, size);
        files.add(in);
    }

    public void addChild(String name, Directory parent) {
        Directory dir = new Directory(name, parent);
        children.add(dir);
    }

    public Directory getCurr(String name) {
        Directory ans = null;
        for(Directory temp : children) {
            if(temp.getDirName().equals(name)) {
                ans = temp;
            }
        }
        return ans;
    }
    public long size() {
        long sum = 0;
        for (MyFileClass f : files) {
            sum += f.fsize();
        }
        for(Directory dir : children) {
            sum += dir.size();
        }
        return sum;
    }
}
