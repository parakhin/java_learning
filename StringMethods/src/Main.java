import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        birthday.set(1986, Calendar.AUGUST, 14);
        printAllBirthdaysDayNameInWeek(birthday);
    }

    public static void printAllBirthdaysDayNameInWeek (Calendar date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy E");
        var yearsDif = Calendar.getInstance().get(Calendar.YEAR) - date.get(Calendar.YEAR);

        while (date.get(Calendar.YEAR) <= Calendar.getInstance().get(Calendar.YEAR)) {
            System.out.println(dateFormat.format(date.getTime()));
            date.add(Calendar.YEAR, 1);
        }
    }

    public static String phoneConverter (String phone) throws Exception {
        phone = phone.trim()
                .replaceAll("[^0-9]", "")
                .replaceAll("^89|^79|^9", "+7(9");

        if (phone.length() != 13) {
            throw new Exception("Wrong phone number");
        }



        return phone.substring(0, 6)
                + ")"
                + phone.substring(6, 9)
                + "-"
                + phone.substring(9, 11)
                + "-"
                + phone.substring(11);
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