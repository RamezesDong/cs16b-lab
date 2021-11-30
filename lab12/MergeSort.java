import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     * <p>
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /**
     * Returns a queue of queues that each contain one item from items.
     */
    private static <Item extends Comparable> Queue<Queue<Item>>
        makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> result = new Queue<>();
        for (Item item : items) {
            Queue<Item> a = new Queue<>();
            a.enqueue(item);
            result.enqueue(a);
        }
        return result;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     * <p>
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return A Queue containing all of the q1 and q2 in sorted order, from least to
     * greatest.
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> result = new Queue<>();
        int n = q1.size(), m = q2.size();
        if (n == 0) {
            return q2;
        } else if (m == 0) {
            return q1;
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek().compareTo(q2.peek()) < 0) {
                Item na = q1.dequeue();
                result.enqueue(na);
            } else {
                Item na = q2.dequeue();
                result.enqueue(na);
            }
        }
        while (!q1.isEmpty()) {
            result.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            result.enqueue(q2.dequeue());
        }
        return result;
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        int n = items.size();
        if (n == 1 || n == 0) {
            return items;
        }
        Queue<Item> result;
        Queue<Item> lq = new Queue<>();
        Queue<Item> rq = new Queue<>();
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            lq.enqueue(items.dequeue());
        }
        for (int i = mid; i < n; i++) {
            rq.enqueue(items.dequeue());
        }
        lq = mergeSort(lq);
        rq = mergeSort(rq);
        result = mergeSortedQueues(lq, rq);
        return result;
    }

    public static void main(String[] args) {
        Queue<String> ads = new Queue<>();
        ads.enqueue("yellow");
        ads.enqueue("red");
        ads.enqueue("apple");
        ads.enqueue("jerk");
        ads.enqueue("anmoie");
        for (String s : ads) {
            System.out.println(s);
        }
        Queue<String> add = mergeSort(ads);
        for (String s : add) {
            System.out.println(s);
        }
    }
}
