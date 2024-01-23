import java.util.*;

public class CarNumbersSystem {
    public ArrayList<String> numbers = new ArrayList<>();
    public HashSet<String> numbersHash = new HashSet<>();

    public TreeSet<String> numbersTree = new TreeSet<>();

    public CarNumbersSystem() {
        String[] letters = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y"};
        for (var region = 1; region <= 197; region++) {
            for (String firstLetter : letters) {
                for (String secondLetter : letters) {
                    for (String thirdLetter : letters) {
                        for (var number1 = 0; number1 <= 9; number1++) {
                            var number = firstLetter + number1 + number1 + number1 + secondLetter + thirdLetter + region;
                            numbers.add(number);
                        }
                    }
                }
            }
        }
        numbersHash.addAll(numbers);
        numbersTree.addAll(numbers);
        Collections.sort(numbers);
    }

    public boolean isInNumber(String input) {
        return numbers.contains(input);
    }

    public int binarySearch(String input) {
        return Collections.binarySearch(numbers, input);
    }

    public boolean isInHash(String input) {
        return numbersHash.contains(input);
    }

    public boolean isInTree(String input) {
        return numbersTree.contains(input);
    }
}
