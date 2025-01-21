package world.pois;

import world.pois.rooms.*;

import java.util.ArrayList;
import java.util.List;

public class BasePOI {
    char[][] floorplan;
    List<BaseRoom> rooms;

    public BasePOI() {
        rooms = new ArrayList<BaseRoom>();
    }

    public String toString() {
        return " ";
    }
}
