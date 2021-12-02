package hw4.puzzle;
import java.util.*;
import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState{
    private int[][] cowmoo;
    private final int BLANK = 0;
    private int size;

    public Board(int[][] tiles) {
        if (tiles == null) {
            throw new NullPointerException();
        }
        int n = tiles.length;
        int m = tiles[0].length;
        cowmoo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cowmoo[i][j] = tiles[i][j];
            }
        }
        size = n;
    }

    public int tileAt(int i , int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IndexOutOfBoundsException();
        }
        return cowmoo[i][j];
    }

    public int size() {
        return size;
    }

    /**
    * @author  hug
     * */

    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }

    public int hamming() {
        int now = 0;
        int hammi = 0;
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j <size; j ++) {
                if (now == size * size) {
                    break;
                }
                if (tileAt(i,j) != now++) {
                    hammi++;
                }
            }
        }
        return hammi;
    }

    public int manhattan() {
        int manhat = 0;
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j <size; j ++) {
                int now = tileAt(i,j);
                if (now == BLANK) {
                    continue;
                }
                int l = (now - 1) / size, c = (now - 1) % size;
                manhat += Math.abs(i - l) + Math.abs(j - c);
            }
        }
        return manhat;
    }

    @Override
    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Board word1 = (Board) o;

        if (word1.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if (this.tileAt(i,j) != word1.tileAt(i,j)) {
                    return  false;
                }
            }
        }
        return true;
    }


     /** Returns the string representation of the board.
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
