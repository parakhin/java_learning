import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXWZ";

        for(var i = 0; i < alphabet.length(); i++) {
            System.out.println((int) alphabet.charAt(i));
        }

        System.out.println("Введите ФИО");
        String input = (new Scanner(System.in)).nextLine();

        String[] fio = {"", "", ""};

        for (var i = 0; i < 3; i++) {
            var spacePosition = input.indexOf(" ");
            if (spacePosition == -1 || i == 2) {
                fio[i] = input;
                break;
            }

            fio[i] = input.substring(0, spacePosition).trim();
            input = input.substring(spacePosition).trim();
        }

        System.out.println("Фамилия: " + fio[0]);
        System.out.println("Имя: " + fio[1]);
        System.out.println("Отчество: " + fio[2]);
    }
}