package deque;
public class LinkedListDeque<Anytype> {
    private LinkedListDeque<Anytype> prev;
    private Anytype item;
    private LinkedListDeque<Anytype> next;
    private int size = 0;

    private LinkedListDeque<Anytype> sentinel;

    public LinkedListDeque(Anytype x){
        this.item = x;
    }

    public LinkedListDeque(){
        sentinel = new LinkedListDeque<>(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(Anytype item){
        LinkedListDeque<Anytype> newnode = new LinkedListDeque<>(item);
        newnode.next = sentinel.next;
        newnode.prev = sentinel;
        sentinel.next.prev = newnode;
        sentinel.next = newnode;
        size = size + 1;
    }

    public void addLast(Anytype item){
        LinkedListDeque<Anytype> newnode = new LinkedListDeque<>(item);
        newnode.next = sentinel;
        newnode.prev = sentinel.next;
        sentinel.next.next = newnode;
        sentinel.prev = newnode;
        size = size + 1;

    }

    public boolean isEmpty(){
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        LinkedListDeque<Anytype> reference = sentinel.next;
        while (reference == sentinel){
            System.out.println(reference.item);
            System.out.println(" ");
            reference = reference.next;
        }
        System.out.println("\n");
    }

    public Anytype removeFirst(){
        if (!isEmpty()) {
            LinkedListDeque<Anytype> RemoveNode = sentinel.next;
            sentinel.next = RemoveNode.next;
            RemoveNode.next.prev = sentinel;
            size--;
            return RemoveNode.item;
        }
        return null;
    }

    public Anytype removeLast(){
        if (!isEmpty()){
            LinkedListDeque<Anytype> RemoveNode = sentinel.prev;
            sentinel.prev = RemoveNode.prev;
            RemoveNode.prev.next = sentinel;
            size--;
            return RemoveNode.item;
        }
        return null;
    }

    public Anytype get(int index){
        if (index > size - 1 || index < 0){
            return null;
        }
        LinkedListDeque<Anytype> node = sentinel.next;
        while (node.next != sentinel && index != 0) {
            node = node.next;
            index--;
        }
        return node.item;
    }

    public Anytype getRecursive(int index){
        if (index < 0 || index > size - 1){
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    public Anytype getRecursiveHelper(int index,LinkedListDeque<Anytype> node){
        if (index == 0){
            return node.item;
        }
        return getRecursiveHelper(index - 1,node.next);
    }
}
