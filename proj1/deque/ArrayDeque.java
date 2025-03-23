package deque;
import java.util.Iterator;
public class ArrayDeque<Anytype> implements Deque<Anytype> {
    private Anytype[] item;
    private int nextFirst;
    private int nextLast;
    private int size;
    public static int MIN_DEFAULT_SIZE = 8;

    /**Creat a ArrayDeque with a initialized size of 8.
     * nextFirst = 0 and nextLast = 1;
     */
    public ArrayDeque(){
        item = (Anytype[]) new Object[MIN_DEFAULT_SIZE];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public ArrayDeque(int capacity){
        item = (Anytype[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

@Override
    public void addFirst(Anytype x){
        if (size == item.length) {
            resize();
        }
            item[nextFirst] = x;
            nextFirst = (nextFirst - 1 + item.length) % item.length;
            size++;
    }

@Override
    public void addLast(Anytype x){
        if (size == item.length) {
            resize();
        }
            item[nextLast] = x;
            nextLast = (nextLast + 1 + item.length) % item.length;
            size++;
    }

@Override
    public int size(){
        return size;
    }

@Override
    public void printDeque(){
        for (int i = 0;i < item.length;i++){
            System.out.println(item[i]);
            System.out.println(" ");
        }
        System.out.println("\n");
    }

@Override
    //Constant time requested.
    public Anytype removeFirst(){
        if (isEmpty()){
            return null;
        }
        resizeRemove();
        nextFirst = (nextFirst + 1 + item.length) % item.length;
        Anytype valueStore = item[nextFirst];
        item[nextFirst] = null;
        size--;
        return valueStore;
    }

@Override
    //Constant time requested.
    public Anytype removeLast(){
        if (isEmpty()){
            return null;
        }
        resizeRemove();
        nextLast = (nextLast - 1 + item.length) % item.length;
        Anytype valueStore = item[nextLast];
        item[nextLast] = null;
        size--;
        return valueStore;
    }

@Override
    //Constant time requested.
    //+ 1 to get the first item index.
    public Anytype get(int index){
        if (index < 0 || index > item.length - 1) {
            return null;
        }
        int ActualIndex = (nextFirst + index + 1 + item.length) % item.length;
        return item[ActualIndex];
    }

    /**This function I choose this kind of type to complete.
     * [a,e,f,g,h,d,c,b]nextFirst = 4,nextLast = 5,supposed addFirst i,then it will be:
     * [i,d,c,b,a,e,f,g,h,null,null,null,null,null,null,null].
     */
    public void resize(){
        Anytype[] a = (Anytype[]) new Object[item.length * 2];
        for (int i = 0;i < item.length; i++){
            a[i] = item[(i + nextFirst + 1 + item.length) % item.length];
        }
        item = a;
        nextFirst = (item.length - 1) % item.length;
        nextLast = size;
    }

    public void resizeRemove(){
        if ((double) (size - 1) / item.length < 0.25 && item.length >= 16) {
            Anytype[] a = (Anytype[]) new Object[item.length / 2];
            for (int i = 0;i < item.length; i++){
                a[i] = item[(i + nextFirst + 1 + item.length) % item.length];
            }
            item = a;
            nextFirst = (item.length - 1) % item.length;
            nextLast = size;
        }
    }

    //Supposed Object o isn't null.
    public boolean equals(Object o){
        if (o instanceof ArrayDeque){
            if (((ArrayDeque<?>) o).nextLast == nextLast && ((ArrayDeque<?>) o).nextFirst == nextFirst){
                for (int i = 0;i < size;i++){
                    if (((ArrayDeque<?>) o).get(i) != this.get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    /*
    public Iterator<Anytype> Iterator(){
        return
    }
    */
}
