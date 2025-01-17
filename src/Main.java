import items.*;

public class Main {
    public static void main(String[] args) {
        BaseItem g = new Gun();
        BaseItem o = new Oven();
        o.addConnection(g);
//        o.action();
        BaseItem w = new Wheel();
        w.addConnection(o);
        w.action();
        o.removeConnection(g);
        w.action();
    }
}