import items.*;
import world.World;

public class Main {
    public static void main(String[] args) {
        testWorld();
    }

    public static void testWorld() {
        World w = new World(100, 100);
        w.generateWorld();
        GUI gui = new GUI(w);
        Camera c = new Camera(25, 25);
        gui.setCamera(c);
        gui.displayWorld();
    }

    public static void testItems() {
        BaseItem g = new Gun();
        BaseItem o = new Oven();
        o.addConnection(g);
//        o.action();
        BaseItem w = new Wheel();
        w.addConnection(o);
//        w.action();
        o.removeConnection(g);
//        w.action();
        w.addConnection(g);
//        w.action();
        g.addConnection(o);
        w.action();
    }
}