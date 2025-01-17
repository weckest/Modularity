package items;

public class Oven extends BaseItem{

    public Oven() {
        weight = 15;
    }

    @Override
    public void action() {
        super.action();
        System.out.println("Oven action");
    }

    @Override
    public void modifyAction() {
        System.out.println("Oven modify action");
    }
}
