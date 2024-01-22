import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printSumFromText("Вася заработал 5000, петя - 500. Ну а маша 150");
    }

    public static String phoneConverter (String phone) {
        phone = phone.trim()
                .replaceAll("[^0-9]", "")
                .replaceAll("^8|^7", "+7")
                .replaceAll("^9", "+79")

        ;

        return phone;
    }

    public static void printSumFromText (String strWithIntNumbers) {
        String str = strWithIntNumbers.replaceAll("[^0-9]", " ");
        String[] items = str.trim().split("\\s+");
        int res = 0;
        for (var i = 0; i < items.length; i++ ) {
            res += Integer.parseInt(items[i]);
        }
        System.out.println(res);
    }

    public static void stringBuilder () {
        var str1 = "ааа";
        var str2 = "ббб";

        StringBuilder builder = new StringBuilder();

        builder.append(str1);

        long start = System.currentTimeMillis();
        for (var i = 0; i < 100000; i++) {
            builder.append(str2);
        }
        System.out.println(builder.length());
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void printCharCodes () {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXWZ";

        for(var i = 0; i < alphabet.length(); i++) {
            System.out.println((int) alphabet.charAt(i));
        }
    }

    public static void fioFromConsole () {
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