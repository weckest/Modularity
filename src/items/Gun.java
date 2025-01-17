package items;

public class Gun extends BaseItem{

    public Gun() {
        super.weight = 5;
    }

    @Override
    public void action() {
        super.action();
        System.out.println("Gun action");
    }

    @Override
    public void modifyAction() {
        System.out.println("Gun modify action");
    }
}
