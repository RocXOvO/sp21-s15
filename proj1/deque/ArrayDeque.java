package deque;

import java.util.Iterator;
public class ArrayDeque<T> implements Deque<T>,Iterable<T> {
    private T[] item;
    private int nextFirst;
    private int nextLast;
    private int size;
    private static final int MIN_DEFAULT_SIZE = 8;

    /**
     * Creat a ArrayDeque with a initialized size of 8.
     * nextFirst = 0 and nextLast = 1;
     */
    public ArrayDeque() {
        item = (T[]) new Object[MIN_DEFAULT_SIZE];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        if (size == item.length) {
            resize();
        }
            item[nextFirst] = x;
            nextFirst = (nextFirst - 1 + item.length) % item.length;
            size++;
    }

    @Override
    public void addLast(T x) {
        if (size == item.length) {
            resize();
        }
            item[nextLast] = x;
            nextLast = (nextLast + 1 + item.length) % item.length;
            size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("\n");
            return;
        }
        int index = (nextFirst + 1 + item.length) % item.length;
        for (int i = 0; i < size; i++) {
            System.out.println(item[index]);
            System.out.println(" ");
            index = (index + 1) % item.length;
        }
        System.out.println("\n");
    }

    @Override
    // Constant time requested.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        resizeRemove();
        nextFirst = (nextFirst + 1 + item.length) % item.length;
        T valueStore = item[nextFirst];
        item[nextFirst] = null;
        size--;
        return valueStore;
    }

    @Override
    // Constant time requested.
    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        resizeRemove();
        nextLast = (nextLast - 1 + item.length) % item.length;
        T valueStore = item[nextLast];
        item[nextLast] = null;
        size--;
        return valueStore;
    }

    @Override
    // Constant time requested.
    // + 1 to get the first item index.
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        int actualIndex = (nextFirst + index + 1 + item.length) % item.length;
        return item[actualIndex];
    }

    /**
     * This function I choose this kind of type to complete.
     * [a, e, f, g, h, d, c, b]nextFirst = 4,nextLast = 5,supposed addFirst i,then it will be:
     * [i, d, c, b, a, e, f, g, h, null, null, null, null, null, null, null].
     */
    private void resize() {
        T[] a = (T[]) new Object[item.length * 2];
        for (int i = 0; i < size; i++) {
            a[i] = item[(i + nextFirst + 1 + item.length) % item.length];
        }
        item = a;
        nextFirst = (item.length - 1) % item.length;
        nextLast = size;
    }

    private void resizeRemove() {
        if (size > 0 && (double) (size - 1) / item.length < 0.25 && item.length >= 16) {
            T[] a = (T[]) new Object[item.length / 2];
            for (int i = 0; i < size; i++) {
                a[i] = item[(i + nextFirst + 1 + item.length) % item.length];
            }
            item = a;
            nextFirst = (item.length - 1) % item.length;
            nextLast = size;
        }
    }

    @Override
    // Supposed Object o isn't null.
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Deque) {
            Deque<?> other = (Deque<?>) o;
            if (other.size() != this.size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                T thisItem = this.get(i);
                Object otherItem = other.get(i);
                if (thisItem == null) {
                    if (otherItem != null) return false;
                } else if (!thisItem.equals(otherItem)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T>{
        private int pst;
        public ArrayDequeIterator() {
            this.pst = 0;
        }
        public boolean hasNext() {
            return pst < size;
        }

        public T next() {
            T returnItem = get(pst);
            pst += 1;
            return returnItem;
        }
    }
}
