package items;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseItem {
    private List<BaseItem> connections;
    protected double weight;

    public BaseItem() {
        connections = new ArrayList<BaseItem>();
    }

    public void addConnection(BaseItem newConnection) {
        connections.add(newConnection);
//        weight += newConnection.getWeight();
    }

    public void removeConnection(BaseItem removedConnection) {
        for(BaseItem connection : connections) {
            if(connection.equals(removedConnection)) {
                connections.remove(connection);
//                weight -= connection.getWeight();
                break;
            }
        }
    }

    public List<BaseItem> getConnections() {
        return connections;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateWeight() {
        double totalWeight = weight;
        for(BaseItem connection : connections) {
            totalWeight += connection.calculateWeight();
        }
        return totalWeight;
    }

    public void action() {
        for(BaseItem connection : connections) {
            connection.action();
        }
        System.out.print("Weight: " + calculateWeight() + ", ");
    }
    public abstract void modifyAction();
}
