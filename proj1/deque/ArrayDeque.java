package deque;
public class ArrayDeque<Anytype> {
    private Anytype[] item;
    private int nextFirst;
    private int nextLast;
    private int size;
    public static int MIN_DEFAULT_SIZE = 8;

    public ArrayDeque(){
        item = (Anytype[]) new Object[MIN_DEFAULT_SIZE];
        nextFirst = 0;
        nextLast = 0;
        size = 0;
    }

    public void addFirst(Anytype x){
        if (size == item.length) {
            resize();
        }
            item[nextFirst] = x;
            nextFirst = (nextFirst - 1 + item.length) % item.length;
            size++;
    }

    public void addLast(Anytype x){
        if (size != item.length) {
            item[nextLast] = x;
            nextLast = (nextLast + 1 + item.length) % item.length;
            size++;
        }
    }

    public boolean isEmpty(){
        for (int i = 0;i < item.length;i++){
            if (item[i] != null){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0;i < item.length;i++){
            System.out.println(item[i]);
            System.out.println(" ");
        }
        System.out.println("\n");
    }

    public Anytype removeFirst(){
        nextFirst = (nextFirst + 1 + item.length) % item.length;
        Anytype valueStore = item[nextFirst];
        item[nextFirst] = null;
        size--;
        return valueStore;
    }

    public Anytype removeLast(){
        nextLast = (nextLast - 1 + item.length) % item.length;
        Anytype valueStore = item[nextLast];
        item[nextLast] = null;
        size--;
        return valueStore;
    }

    public Anytype get(int index){
        if (index < 0 || index > size -1){
            return null;
        }
        return item[(index + nextFirst + item.length) % item.length];
    }

    public void resize(ArrayDeque<Anytype> ArrayList){
        Anytype[] a = (Anytype[]) new Object[item.length * 2];
        for (int i = 0;i < item.length; i++){
            a[i] = item[(i + nextFirst + item.length) % item.length];
        }
        nextFirst = item.length * 2 - 1;
        nextLast = item.length + 1;
    }
}
