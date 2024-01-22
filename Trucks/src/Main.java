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

        int containersCount = (int) Math.ceil(boxCount / 27.0);
        int trucksCount =  (int) Math.ceil(containersCount / 12.0);

        for (var i = 0; i < trucksCount; i++) {
            System.out.println("Грузовик " + i);
            for (var j = i * 12; j < (i * 12 + 12) && j < containersCount; j++) {
                System.out.println("\tКонтейнер " + (j));
                for (var k = j * 27; k < (j * 27 + 27) && k < boxCount; k++) {
                    System.out.println("\t\tЯщик " + (k));
                }
            }
        }
    }
}