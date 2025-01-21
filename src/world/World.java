package world;

public class World {

    private Object[][] world;
    private POIBuilder builder;

    public World(int x, int y) {
        world = new Object[y][x];
        builder = new POIBuilder();
    }

    public void generateWorld() {
        for(int i = 0; i < world.length; i++) {
            for(int j = 0; j < world[i].length; j++) {
                world[i][j] = builder.getPOI();
            }
        }
    }

    public Object[][] getWorld() {
        return world;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                output += world[i][j] + "";
            }
            output += "\n";
        }
        return output;
    }
}
