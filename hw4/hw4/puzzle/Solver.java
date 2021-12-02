package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import java.util.*;
import org.w3c.dom.Node;

public class Solver {
    private List<WorldState> solution;
    private HashMap<WorldState, Integer> estimatedDistance;
    private MinPQ<aStarNode> pq = new MinPQ<>(new aStarNodeComparator());

    private class aStarNode{
        private WorldState now;
        private int moves = 0;
        private aStarNode prev;

        private aStarNode(WorldState state, int move, aStarNode pre) {
            now = state;
            moves = move;
            prev = pre;
        }

    }



    private class aStarNodeComparator implements Comparator<aStarNode> {
        @Override
        public int compare(aStarNode a, aStarNode b) {
            return getG(a) - getG(b);
        }

        private int getG(aStarNode a) {
            if (!estimatedDistance.containsKey(a.now)) {
                estimatedDistance.put(a.now,a.now.estimatedDistanceToGoal());
            }
            return a.moves + estimatedDistance.get(a.now);
        }
    }

    public Solver(WorldState initial) {
        estimatedDistance = new HashMap<>();
        pq.insert(new aStarNode(initial, 0, null));
        solution = getSolution();
    }

    private List<WorldState> getSolution() {
        List<WorldState> solu = new ArrayList<>();
        while (!pq.isEmpty()) {
            aStarNode currNode = pq.delMin();
            if (currNode.now.isGoal()) {
                pq.insert(currNode);
                break;
            }
            for (WorldState ws : currNode.now.neighbors()) {
                if (currNode.prev != null && ws.equals(currNode.prev.now)) {
                    continue;
                }
                pq.insert(new aStarNode(ws, currNode.moves + 1, currNode));
            }
        }
        Stack<WorldState> path = new Stack<>();
        for (aStarNode n = pq.delMin(); n != null; n = n.prev) {
            path.push(n.now);
        }
        while (!path.isEmpty()) {
            solu.add(path.pop());
        }
        return solu;
    }

    public int moves() {
        return solution.size() - 1;
    }

    public Iterable<WorldState> solution() {
        return solution;
    }
}
