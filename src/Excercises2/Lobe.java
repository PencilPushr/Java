package Excercises2;

import java.awt.*;

public class Lobe {

    private String lobeName = null;
    private Color color;
    private int x;
    private int y;
    private int width;
    private int height;


    public Lobe(String lobeName, Color color, int x, int y, int width, int height){
        this.lobeName = lobeName;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return lobeName;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
