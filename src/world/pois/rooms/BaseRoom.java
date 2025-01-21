package world.pois.rooms;

import java.util.Arrays;

public class BaseRoom {
    char[][] room;
    int x;
    int y;

    public char[][] getRoom() {
        return room;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return Arrays.deepToString(room);
    }
}
