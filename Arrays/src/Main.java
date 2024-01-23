import java.util.*;

public class Main {
    public static void main(String[] args) {
        CarNumbersSystem nums = new CarNumbersSystem();

        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер машины для поиска");
            var input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            long start;
            boolean isFind;
            int index = 0;
            long duration;

            start = System.currentTimeMillis();
            isFind = nums.isInNumber(input);
            duration = System.currentTimeMillis() - start;
            System.out.println("isInNumber duration " + duration + " and result is " + isFind);

            start = System.currentTimeMillis();
            isFind = nums.isInTree(input);
            duration = System.currentTimeMillis() - start;
            System.out.println("isInTree duration " + duration + " and result is " + isFind);

            start = System.currentTimeMillis();
            isFind = nums.isInHash(input);
            duration = System.currentTimeMillis() - start;
            System.out.println("isInHash duration " + duration + " and result is " + isFind);

            start = System.currentTimeMillis();
            index = nums.binarySearch(input);
            duration = System.currentTimeMillis() - start;
            System.out.println("binarySearch duration " + duration + " and result is index " + index);
        }
    }

    public static void phone () {
        TreeMap<String, String> phoneBook= new TreeMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                break;
            }

            if (input.equals("LIST")) {
                for (String name: phoneBook.keySet()) {
                    System.out.println("name: " + name + "; phone: " + phoneBook.get(name));
                }
                continue;
            }

            int spacePosition = input.indexOf(" ");
            String name = "";
            String phone = "";

            //if input has name and phone number we just add/update name
            if (spacePosition != -1) {
                name = input.substring(0, spacePosition);
                phone = input.substring(spacePosition).trim();
                phoneBook.put(name, phone);
                continue;
            }
            //If input is phone number
            if (input.matches(".+\\d+.+")) {
                if (phoneBook.containsValue(input)) {
                    for (String key: phoneBook.keySet()) {
                        if (phoneBook.get(key).equals(input)) {
                            System.out.println("name: " + key + "; phone: " + phoneBook.get(key));
                            break;
                        }
                    }
                } else {
                    System.out.println("Введите имя:");
                    name = scanner.nextLine();
                    phoneBook.put(name, input);
                }

                continue;
            }

            if (phoneBook.containsKey(input)) {
                System.out.println("name: " + input + "; phone: " + phoneBook.get(input));
            } else {
                System.out.println("Введите номер телефона:");
                phone = scanner.nextLine();
                phoneBook.put(input, phone);
            }

        }
    }

    public static void hashAndTreeMap () {
        HashMap<String, Integer> products = new HashMap<String, Integer>();
        products.put("1Колбаса", 500);
        products.put("2Ветчина", 600);
        products.put("3Сыр", 300);
        System.out.println(products.get("1Колбаса"));

        TreeMap<String, Integer> sortedProducts = new TreeMap<>();
        sortedProducts.put("1Колбаса", 500);
        sortedProducts.put("2Ветчина", 600);
        sortedProducts.put("3Сыр", 300);
        System.out.println(sortedProducts.get("2Ветчина"));

        System.out.println("=================HashMap==================");
        for (var key: products.keySet()) {
            System.out.println(key + " => " + products.get(key));
        }
        System.out.println("=================TreeMap==================");
        for (var key: sortedProducts.keySet()) {
            System.out.println(key + " => " + products.get(key));
        }

        Set<String> allKeysOfHashOrTreMap = products.keySet();

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