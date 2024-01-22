import java.sql.Array;

public class TransportManager {
    public static ITruck[] getTrucks (int containersCount) {
        ITruck[] trucks = new Truck[(int) Math.ceil(containersCount / 12.0)];
        for (var i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(i, 12);
        }

        return  trucks;
    }

    public static IContainer[] getContainers (int boxCount) {
        IContainer[] containers = new Container[(int) Math.ceil(boxCount / 27.0)];
        for (var i = 0; i < containers.length; i++) {
            containers[i] = new Container(i, 27);
        }

        return  containers;
    }

    public static void placeBoxToContainers (IContainer[] containers, IBox[] boxes) {
        var containerId = 0;
        for (var i = 0; i < boxes.length; i++) {
            if (containers[containerId].freePlaceCount() <= 0) {
                containerId++;
            }
            try {
                containers[containerId].addBox(boxes[i]);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void placeContainersToTrucks (ITruck[] trucks, IContainer[] containers) {
        var truckId = 0;
        for (var i = 0; i < containers.length; i++) {
            if (trucks[truckId].freePlaceCount() <= 0) {
                truckId++;
            }
            try {
                trucks[truckId].addContainer(containers[i]);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
