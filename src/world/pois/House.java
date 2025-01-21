package world.pois;

import world.pois.rooms.*;

public class House extends BasePOI {

    public House() {
        int size = (int)(Math.random() * 25) + 10;
        floorplan = new char[size][size];
        for(int i = 0; i < floorplan.length; i++) {
            for(int j = 0; j < floorplan[0].length; j++) {
                floorplan[i][j] = '*';
            }
        }
        int officeSize = (int)(Math.random() * (size / 3)) + 3;
        int officeX = (int)(Math.random() * (size - officeSize));
        int officeY = (int)(Math.random() * (size - officeSize));
        rooms.add(new Office(officeX, officeY, officeSize));
    }

    public char[][] getFloorplan() {
        for(BaseRoom room : rooms) {
            char[][] roomplan = room.getRoom();
            System.out.println(room.getX() + " " + room.getY());
            for(int i = 0; i < roomplan.length; i++) {
                for(int j = 0; j < roomplan[i].length; j++) {
                    floorplan
                            [i + room.getY()]
                            [j + room.getX()] = roomplan
                            [i]
                            [j];
                }
            }
        }
        return floorplan;
    }

    @Override
    public String toString() {
        return "H";
    }
}
