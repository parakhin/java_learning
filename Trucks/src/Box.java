public class Box implements IBox{
    private String id;
    public Box (String id) {
        this.id = id;
    }

    public Box (int id) {
        this(String.valueOf(id));
    }

    public String toString() {
        return "Коробка " + id;
    }
}
