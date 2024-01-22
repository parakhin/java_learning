public class Container implements IContainer {


    private String id;

    public final int capacity;
    private IBox[] boxes;

    private int position = -1;

    public Container(String id, int capacity) {
        this.id = id;
        this.capacity = Math.max(1, capacity);
        boxes = new Box[capacity];
    }

    public Container(String id) {
        this(id, 12);
    }
    public Container (int id) {
        this(String.valueOf(id));
    }
    public Container (int id, int capacity) {
        this(String.valueOf(id), capacity);
    }

    @Override
    public void addBox(IBox box) throws Exception {
        if (current() >= capacity) {
            throw new Exception ("Нет места");
        }
        next();
        boxes[position] = box;
    }

    @Override
    public IBox getLastBox() throws Exception {
        if (position == 0 && boxes[position] == null) {
            throw new Exception("Нет ни одного контейнера");
        }

        return boxes[position];
    }

    @Override
    public int freePlaceCount() {
        return capacity - (position + 1);
    }

    public IBox[] getBoxes() {
        return boxes;
    }

    public void next() throws Exception {
        if (position >= capacity) {
            throw new Exception("Нет места");
        }
        position ++;
    }

    public int current () {
        return position;
    }

    public String toString () {
        return "Контейнер " + id;
    }
}
