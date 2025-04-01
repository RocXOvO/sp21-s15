package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super(); //此处会隐式调用。如果不写也会自动初始化。
        comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    /**
     * Get the maxium element in ArrayDeque.
     * @param c for the convience of comparing.
     * @return return the max element.
     */
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = get(0); //Get the first item.
        for (int i = 1; i < this.size(); i++) {
            T nextItem = this.get(i);
            if (c.compare(maxItem, nextItem) < 0) {
                maxItem = nextItem;
            }
        }
        return maxItem;
    }
}
