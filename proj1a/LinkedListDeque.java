public class LinkedListDeque<T> {
    private class ListDeque {
        private T item;
        private ListDeque next;
        private ListDeque last;

        private ListDeque(T i, ListDeque n, ListDeque l) {
            item = i;
            next = n;
            last = l;
        }
    }

    private int size;
    private ListDeque first;
    private ListDeque last;

    //    private LinkedListDeque first;
    public LinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }
//    public LinkedListDeque(T x){
//        first = new ListDeque(x,null,null);
//        last = new ListDeque(x,null,null);
//        size = 1;
//    }
//    public LinkedListDeque(T x, ListDeque n, ListDeque l){
//        first = new ListDeque(x,n,l);
//        last = new ListDeque(x,n,l);
//        size = 1;
//    }

    public void addFirst(T x) {
        first = new ListDeque(x, first, null);
        if (first.next != null) {
            first.next.last = first;
        }
        size = size + 1;
        if (size == 1) {
            last = first;
        }
    }

    public void addLast(T x) {
        last = new ListDeque(x, null, last);
        if (last.last != null) {
            last.last.next = last;
        }
        size = size + 1;
        if (size == 1) {
            first = last;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListDeque p = first;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T fr = first.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.last = null;
        }
        size = size - 1;
        return fr;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T la = last.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.last;
            last.next = null;
        }
        size = size - 1;
        return la;
    }

    public T get(int index) {
        ListDeque p = first;
        if (index + 1 > size) {
            return null;
        }
        int i = 0;
        while (i != index) {
            p = p.next;
            i = i + 1;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index + 1 > size) {
            return null;
        }
        return helpgetRecursive(0, index, first);
    }

    private T helpgetRecursive(int nw, int index, ListDeque tm) {
        if (nw == index) {
            return tm.item;
        } else {
            return helpgetRecursive(nw + 1, index, tm.next);
        }
    }
}
