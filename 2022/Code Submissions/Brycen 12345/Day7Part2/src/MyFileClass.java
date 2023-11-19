public class MyFileClass {
    private String name;
    private long size;
    public MyFileClass(String name, long size) {
        this.name = name;
        this.size = size;
    }
    public String getName() {
        return this.name;
    }

    public long fsize() {
        return this.size;
    }
}
