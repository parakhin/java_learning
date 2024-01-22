import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество ящиков");
        var scanner = new Scanner(System.in);
        int boxCount = 0;

        while (boxCount < 1) {
            try {
                boxCount = scanner.nextInt();
            } catch (Exception e)
            {
                System.out.println("Введите корректное число. Количество ящиков должно быть целое число больше 0");
            }
        }

        IContainer[] containers = TransportManager.getContainers(boxCount);
        ITruck[] trucks = TransportManager.getTrucks(containers.length);
        IBox[] boxes = new Box[boxCount];

        for (var i = 0; i < boxCount; i++) {
            boxes[i] = new Box(i);
        }

        TransportManager.placeBoxToContainers(containers, boxes);
        TransportManager.placeContainersToTrucks(trucks, containers);


        for (var i = 0; i < trucks.length; i++) {
            System.out.println(trucks[i]);
            var containersInTruck = trucks[i].getContainers();
            for (var j = 0; j < containersInTruck.length; j++) {
                if (containersInTruck[j] == null) {
                    break;
                }
                System.out.println("\t" + containersInTruck[j]);
                var boxInContainer = containersInTruck[j].getBoxes();
                for (var k = 0; k < boxInContainer.length; k++){
                    if (boxInContainer[k] == null) {
                        break;
                    }
                    System.out.println("\t\t" + boxInContainer[k]);
                }
            }
        }
    }
}