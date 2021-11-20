import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node right,left;
        private int size;

        private Node(K k, V v) {
            key = k;
            value = v;
            size = 1;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key)!=null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node p, K key) {
        if (p == null) {
            return null;
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            return get(p.left, key);
        } else if (cmp > 0) {
            return get(p.right, key);
        } else {
            return p.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node p) {
        if (p == null) {
            return 0;
        }
        return p.size;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node p, K key, V value) {
        if (p == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            p.left = put(p.left, key, value);
        } else if (cmp >0) {
            p.right = put(p.right, key, value);
        } else {
            p.value = value;
        }
        p.size = size(p.left) + size(p.right) + 1;
        return p;
    }

    private Node select(int k) {
        if (k < 0|| k>=size()) {
            throw new IllegalArgumentException();
        }
        return select(root, k);
    }

    private Node select(Node p, int k) {
        if (p == null) {
            return null;
        }
        int t = size(p.left);
        if (t > k) {
            return select(p.left, k);
        } else if (t < k) {
            return select(p.right, k);
        } else {
            return p;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> BSTSet = new HashSet<>();
        for (int i = 0;i < size(); i++) {
            BSTSet.add(select(i).key);
        }
        return BSTSet;
    }

    @Override
    public V remove(K key) {
        if (!containsKey(key)) {
            return null;
        }
        V toRemove = get(key);
        root = remove(root, key);
        return toRemove;
    }

    private Node remove(Node p, K key) {
        if (p == null) {
            return null;
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            return remove(p.left, key);
        } else if (cmp >0) {
            return remove(p.right, key);
        } else {
            if (p.left == null) {
                return p.right;
            }
            if (p.right == null) {
                return p.left;
            }
            Node findLeftax = findMax(p.left);
            findLeftax.left = p.left;
            findLeftax.right = p.right;
        }
        p.size = size(p.right) + size(p.left) +1;
        return p;
    }

    private Node findMax(Node p) {
        if (p == null) {
            return null;
        }
        if (findMax(p.right) == null) {
            return p;
        } else {
            return findMax(p.right);
        }
    }

    @Override
    public V remove(K key, V value) {
        if (!containsKey(key)) {
            return null;
        }
        if (!get(key).equals(value)) {
            return null;
        }
        root = remove(root, key);
        return value;
    }

    private class BSTMapIterator implements Iterator<K> {
        private Stack<Node> stack = new Stack<>();

        public BSTMapIterator(Node src) {
            while (src != null) {
                stack.push(src);
                src =src.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            Node curr = stack.pop();
            if (curr.right != null) {
                Node temp = curr.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return curr.key;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator(root);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node p) {
        if(p == null) {
            return;
        }
        printInOrder(p.left);
        System.out.println(p.key+" "+p.value);
        printInOrder(p.right);
    }
}
