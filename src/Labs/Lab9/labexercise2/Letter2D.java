package Labs.Lab9.labexercise2;

public class Letter2D {

    private int x, y;
    private char c;

    public Letter2D(int x, int y, char c){
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public String toString() {
        return c +
                "," + x +
                "," + y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public char getC() {
        return this.c;
    }

}
