package world;

import world.pois.*;

public class POIBuilder {
    int pois = 3;
    public BasePOI getPOI() {
        int rand = (int)(Math.random() * pois);
        if((int)(Math.random() * 100) > 90) {
            switch (rand) {
                case 0:
                    return new House();
                case 1:
                    return new Garage();
                case 2:
                    return new Police();
            }
        }
        return new BasePOI();
    }
}
