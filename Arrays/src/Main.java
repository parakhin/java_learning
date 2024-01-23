import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mail();
    }

    public static void mail() {
        HashSet<String> emails = new HashSet<>();
        var scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("exit")) {
            input = scanner.nextLine().trim();
            if (input.matches("^(.+)@(\\S+)$")) {
                emails.add(input);
            }

            if (input.equals("list")) {
                for (var email: emails) {
                    System.out.println(email);
                }
            }
        }
    }

    public static void todoList () {
        var todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        String input = "";

        while(!input.equals("exit")) {
            System.out.println("Введите команду");
            input = scanner.nextLine();
            try {
                todoList.actionByInput(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    public static void learningLists() {
        ArrayList<String> todoList = new ArrayList<>(){{
            add("Нулевой элемент");
            add("0.1");
        }};
        todoList.add("Изучть списки");
        todoList.add("Изучть списки2");
        todoList.add("Изучть списки3");
        todoList.add("Изучть списки4");
        todoList.remove(2);
        todoList.add(2, "Изучть списки5");

        for (var item: todoList){
            System.out.println(item);
        }
    }

    public static void printX() {
        String[][] arr = {
            {"X", " "," "," "," "," ", "X"},
            {" ", "X"," "," "," ","X", " "},
            {" ", " ","X"," ","X"," ", " "},
            {" ", " "," ","X"," "," ", " "},
            {" ", " ","X"," ","X"," ", " "},
            {" ", "X"," "," "," ","X ", ""},
            {"X", " "," "," "," "," ", "X"},
        };

        for(var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void patientsTemperature() {
        var ANSI_GREEN = "\u001B[32m";
        var ANSI_RESET = "\u001B[0m";
        double[] patientsTemperature = new double[30];

        for (var i = 0; i < patientsTemperature.length; i++) {
            patientsTemperature[i] = (double) Math.round(Math.random() * 100) / 10.0 + 32;
        }

        var sumTemperature = 0.0;
        var healthyCount = 0;
        for (double temp : patientsTemperature) {

            sumTemperature += temp;
            if (temp <= 36.9 && temp >= 36.1) {
                healthyCount++;
                System.out.print(ANSI_GREEN + temp + ANSI_RESET + " " );
            } else {
                System.out.print(temp + " " );
            }
        }
        System.out.println();
        System.out.println("Средняя температура: " + (sumTemperature / patientsTemperature.length));
        System.out.println("Количество здоровых пациентов: " + healthyCount);

    }

    public static String reverseString(String str) {
        String[] strArr = str.split("\\s+");
        String[] strArrRev = new String[strArr.length];

        for (var i = 0; i < strArr.length; i++) {
            strArrRev[strArrRev.length - i - 1] = strArr[i];
        }
        return String.join(" ", strArrRev);
    }
}