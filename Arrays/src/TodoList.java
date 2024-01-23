import java.util.ArrayList;

public class TodoList {
    ArrayList<String> todoList = new ArrayList<>();

    enum Actions {
        ADD,
        LIST,
        DELETE,
        EDIT
    }

    public void addByCommandPartArray(String position, String todo) {
        if (!position.isEmpty()) {
            int intPosition = Integer.parseInt(position);
            add(intPosition, todo);
        } else {
            add(todo);
        }
    }

    public void add(String todo) {
        todoList.add(todo);
    }

    public void add(int position, String todo) {
        if (position > todoList.size()) {
            todoList.add(todo);
        } else {
            todoList.add(position, todo);
        }
    }

    public void edit(int position, String todo) {
        if (todoList.size() <= position) {
            return;
        }
        todoList.remove(position);
        todoList.add(position, todo);
    }

    public void delete(int position) {
        if (todoList.size() <= position) {
            return;
        }
        todoList.remove(position);
    }

    public void printListToConsole() {
        for (var i = 0; i < todoList.size(); i++) {
            System.out.println(i + " - " + todoList.get(i));
        }
    }

    public static String[] getInputParts (String input) {
        String[] res = {"", "", ""};      //0 - action; 1 - position; 2 - body of added item
        input = input.trim();
        int firstSpaceIndex = input.indexOf(" ");

        if (firstSpaceIndex == -1) {
            res[0] = input;
            return res;
        }

        res[0] = input.substring(0, firstSpaceIndex);
        input = input.substring(firstSpaceIndex).trim();
        int secondSpaceIndex = input.indexOf(" ");

        if (secondSpaceIndex == -1 || !input.substring(0, secondSpaceIndex).matches("\\d+")) {
            res[2] = input;
            return res;
        }

        res[1] = input.substring(0, secondSpaceIndex);
        res[2] = input.substring(secondSpaceIndex).trim();

        return res;
    }

    public void addByInputString (String input) {
        input = input.substring(4).trim();
        int spacePosition = input.indexOf(" ");

        if (spacePosition == -1) {
            add(input);
            return;
        }

        String secondArgument = input.substring(0, spacePosition);
        if (secondArgument.matches("\\d+")) {
            add(Integer.parseInt(secondArgument), input.substring(spacePosition).trim());
            return;
        }

        add(input);
    }

    public void editByInputString(String input) throws Exception {
        input = input.replaceAll("^EDIT", "").trim();
        int spaceIndex = input.indexOf(" ");
        try {
            int position = Integer.parseInt(input.substring(0, spaceIndex));
            input = input.substring(spaceIndex);
            edit(position, input);
        } catch (Exception e) {
            throw new Exception("Wrong arguments for EDIT command");
        }
    }

    public void deleteByInputString(String input) throws Exception{
        input = input.replaceAll("^DELETE", "").trim();
        try {
            delete(Integer.parseInt(input));
        } catch (Exception e) {
            throw new Exception("Wrong arguments for DELETE command");
        }
    }

    public static Actions getActionByInput (String input)
    {
        input = input.trim();
        int spaceIndex = input.indexOf(" ");

        String actionString = spaceIndex == -1 ? input : input.substring(0, spaceIndex);
        switch (actionString){
            case "ADD":
                return Actions.ADD;
            case "EDIT":
                return Actions.EDIT;
            case "DELETE":
                return Actions.DELETE;
            case "LIST":
                return Actions.LIST;
        }
        return Actions.LIST;
    }
    public void actionByInput(String input) throws Exception{
        switch (getActionByInput(input)) {
            case ADD:
                addByInputString(input);
                break;
            case EDIT:
                editByInputString(input);
                break;
            case DELETE:
                deleteByInputString(input);
                break;
            case LIST:
                printListToConsole();
                break;
        }
    }
}
