package lab11.graphs;

/**
 * @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private boolean hasCycle = false;
    private Maze maze;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        marked = new boolean[maze.V()];
    }

    @Override
    public void solve() {
        for (int s = 0; s < maze.V(); s++) {
            if (!marked[s]) {
                helpDFSCycle(s, s);
            }
        }
    }

    private void helpDFSCycle(int x, int u) {
        marked[x] = true;
        announce();
        for (int w : maze.adj(x)) {
            if (!marked[w]) {
                edgeTo[w] = x;
                marked[w] = true;
                announce();
                helpDFSCycle(w, x);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }
    // Helper methods go here
}

