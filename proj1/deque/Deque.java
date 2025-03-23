package deque;

public interface Deque<Anytype> {

    public void addFirst(Anytype item);
    public void addLast(Anytype item);
    public int size();
    public void printDeque();
    public Anytype removeFirst();
    public Anytype removeLast();
    public Anytype get(int index);

    default public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
}
