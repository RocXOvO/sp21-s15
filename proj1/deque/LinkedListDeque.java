package deque;
import java.util.Comparator;
import java.util.LinkedList;

public class LinkedListDeque<Anytype> {
    public class LinkedListNode {

        private LinkedListNode prev;
        private Anytype item;
        private LinkedListNode next;

        public LinkedListNode(LinkedListNode prev, Anytype item, LinkedListNode next) {
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

    public void addFirst(Anytype item) {
        LinkedListNode newnode = new LinkedListNode(sentinel,item,sentinel.next);
        sentinel.next.prev = newnode;
        sentinel.next = newnode;
        size = size + 1;
    }

    public void addLast(Anytype item) {
        LinkedListNode newnode = new LinkedListNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = newnode;
        sentinel.prev = newnode;
        size = size + 1;

    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkedListNode reference = sentinel.next;
        while (reference != sentinel) {
            System.out.println(reference.item);
            System.out.println(" ");
            reference = reference.next;
        }
        System.out.println("\n");
    }

    public Anytype removeFirst() {
        if (!isEmpty()) {
            LinkedListNode RemoveNode = sentinel.next;
            sentinel.next = RemoveNode.next;
            RemoveNode.next.prev = sentinel;
            size--;
            return RemoveNode.item;
        }
        return null;
    }

    public Anytype removeLast() {
        if (!isEmpty()) {
            LinkedListNode RemoveNode = sentinel.prev;
            sentinel.prev = RemoveNode.prev;
            RemoveNode.prev.next = sentinel;
            size--;
            return RemoveNode.item;
        }
        return null;
    }

    public Anytype get(int index) {
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

    public Anytype getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    public Anytype getRecursiveHelper(int index, LinkedListNode node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }
    public boolean equals(Object o){
        if (o instanceof LinkedList){
            LinkedList<?> oPointer = (LinkedList<?>) o;
            for (int i = 0;i< size();i++){
                if (oPointer.get(i) != get(i)){
                    return false;
                }
            }
        }
        return false;
    }
    /*
    public Iterator<Anytype> Iterator(){

    }
    */
}
