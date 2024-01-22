public class Truck implements ITruck{

    private String id;

    public final int capacity;
    private IContainer[] containers;

    private int position = -1;

    public Truck(String id, int capacity) {
        this.id = id;
        this.capacity = Math.max(1, capacity);
        containers = new Container[capacity];
    }

    public Truck(String id) {
        this(id, 12);
    }
    public Truck (int id) {
        this(String.valueOf(id));
    }
    public Truck (int id, int capacity) {
        this(String.valueOf(id), capacity);
    }

    @Override
    public void addContainer(IContainer container) throws Exception {
        if (current() >= capacity) {
            throw new Exception ("Нет места");
        }
        next();
        containers[position] = container;
    }

    @Override
    public IContainer getLastContainer() throws Exception {
        if (position == 0 && containers[position] == null) {
            throw new Exception("Нет ни одного контейнера");
        }

        return containers[position];
    }

    public IContainer[] getContainers() {
        return containers;
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
        return "Грузовик " + id;
    }

    @Override
    public int freePlaceCount() {
        return capacity - (position + 1);
    }
}
