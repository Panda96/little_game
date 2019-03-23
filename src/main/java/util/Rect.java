package util;

/**
 * Created by PandaLin on 2019/3/23.
 */
public class Rect {
    public int x;
    public int y;
    public int width;
    public int height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isOverlap(Rect rect) {
        //(p2.y>p3.y)∧(p1.y<p4.y)∧(p2.x>p3.x)∧(p1.x<p4.x)
        int p1_x = this.x;
        int p1_y = this.y;
        int p2_x = this.x + this.width;
        int p2_y = this.y + this.height;
        int p3_x = rect.getX();
        int p3_y = rect.getY();
        int p4_x = p3_x + rect.getWidth();
        int p4_y = p3_y + rect.getHeight();

        return p2_y > p3_y && p1_y < p4_y && p2_x > p3_x && p1_x < p4_x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
