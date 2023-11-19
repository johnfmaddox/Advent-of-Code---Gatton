package Day15;

public class Cord {

    int x;
    int y;
    Cord c;

    public Cord(int x, int y, Cord c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getMan(Cord c) {
        return Math.abs(x - c.getX()) + Math.abs(y - c.getY());

    }

    public Cord getBec() {
        return c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
