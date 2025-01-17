package items;

public class Wheel extends BaseItem{

    public Wheel() {
        weight = 100;
    }

    @Override
    public void action() {
        super.action();
        System.out.println("Wheel action");
    }

    @Override
    public void modifyAction() {
        System.out.println("Wheel modify action");
    }
}
