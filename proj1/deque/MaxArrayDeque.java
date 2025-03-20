package deque;

import java.util.Comparator;

public class MaxArrayDeque<Anytype> extends ArrayDeque<Anytype> {
    private Comparator<Anytype> comparator;
    public MaxArrayDeque(Comparator<Anytype> c){
        super();
        comparator = c;
    }

    public Anytype max(){
        return max(comparator);
    }

    public Anytype max(Comparator<Anytype> c){
        if (isEmpty()){
            return null;
        }
        Anytype maxItem = get(0);//Get the first item.
        for (int i = 1;i < size();i++){
            Anytype nextItem = get(1);
            if (c.compare(maxItem, nextItem) < 0){
                maxItem = nextItem;
            }
        }
        return maxItem;
    }


}
