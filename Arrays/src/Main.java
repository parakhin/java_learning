public class Main {
    public static void main(String[] args) {
        printX();
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