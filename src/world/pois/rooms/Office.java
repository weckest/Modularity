package world.pois.rooms;

public class Office extends BaseRoom {

    public Office(int x, int y, int size) {
        this.x = x;
        this.y = y;
        room = new char[size][size];
        for(int i = 0; i < size; i++) {
            room[0][i] = '-';
            room[size - 1][i] = '-';
        }
        for(int i = 1; i < size - 1; i++) {
            room[i][0] = '|';
            room[i][size - 1] = '|';
        }
    }



}
