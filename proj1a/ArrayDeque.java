public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /**
     * my solustion is read from first to last and push in [0,size]
     */
    @SuppressWarnings("checkstyle:WhitespaceAround")
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int f2 = nextFirst;
        for (int i = 0; i < size; i++) {
            if (f2 + 1 == items.length) {
                f2 = 0;
            } else {
                f2 = f2 + 1;
            }
            a[i] = items[f2];
        }
        nextLast = size;
        nextFirst = capacity - 1;
        items = a;

    }

    private void checkresize() {
        if (size < items.length / 4 && items.length >= 16) {
            int size2 = items.length / 2;
            resize(size2);
        } else {
            return;
        }
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst = nextFirst - 1;
        }
        size = size + 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast = nextLast + 1;
        }
        size = size + 1;
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
        int fr = nextFirst;
        for (int i = 0; i < size; i++) {
            if (fr + 1 == items.length) {
                fr = 0;
            } else {
                fr = fr + 1;
            }
            System.out.print(items[fr] + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T re;
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst = nextFirst + 1;
        }
        re = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        checkresize();
        return re;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T re;
        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast = nextLast - 1;
        }
        re = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        checkresize();
        return re;
    }

    public T get(int index) {
        int fr = nextFirst + 1;
        fr = fr + index;
        if (fr >= items.length) {
            fr = fr - items.length;
        }
        return items[fr];
    }

}
