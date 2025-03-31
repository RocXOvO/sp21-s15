package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    public class LinkedListNode {

        private LinkedListNode prev;
        private T item;
        private LinkedListNode next;

        public LinkedListNode(LinkedListNode prev, T item, LinkedListNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        public LinkedListNode() {
            this(null, null, null);
        }

    }
    private int size;
    private LinkedListNode sentinel;

    public LinkedListDeque() {
        sentinel = new LinkedListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

@Override
    public void addFirst(T item) {
        LinkedListNode newnode = new LinkedListNode(sentinel,item,sentinel.next);
        sentinel.next.prev = newnode;
        sentinel.next = newnode;
        size = size + 1;
    }

@Override
    public void addLast(T item) {
        LinkedListNode newnode = new LinkedListNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = newnode;
        sentinel.prev = newnode;
        size = size + 1;

    }

@Override
    public int size() {
        return size;
    }

@Override
    public void printDeque() {
        LinkedListNode reference = sentinel.next;
        while (reference != sentinel) {
            System.out.println(reference.item);
            System.out.println(" ");
            reference = reference.next;
        }
        System.out.println("\n");
    }

@Override
    public T removeFirst() {
        if (!isEmpty()) {
            LinkedListNode RemoveNode = sentinel.next;
            sentinel.next = RemoveNode.next;
            RemoveNode.next.prev = sentinel;
            size--;
            return RemoveNode.item;
        }
        return null;
    }

@Override
    public T removeLast() {
        if (!isEmpty()) {
            LinkedListNode RemoveNode = sentinel.prev;
            sentinel.prev = RemoveNode.prev;
            RemoveNode.prev.next = sentinel;
            size--;
            return RemoveNode.item;
        }
        return null;
    }

@Override
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        LinkedListNode node = sentinel.next;
        while (node.next != sentinel && index != 0) {
            node = node.next;
            index--;
        }
        return node.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    public T getRecursiveHelper(int index, LinkedListNode node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }
    public boolean equals(Object o){
        if (o instanceof LinkedListDeque){
            LinkedListDeque<?> oPointer = (LinkedListDeque<?>) o;
            for (int i = 0;i< size();i++){
                if (oPointer.get(i) != get(i)){
                    return false;
                }
            }
        }
        return false;
    }

    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T>{
        int Pst;
        public LinkedListDequeIterator(){
            Pst = 0;
        }
        public boolean hasNext(){
            return Pst < size;
        }

        public T next(){
            T returnItem = get(Pst);
            Pst += 1;
            return returnItem;
        }
    }
}
