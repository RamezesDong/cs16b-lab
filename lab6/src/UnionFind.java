public class UnionFind {
    private int[] parents;

    public UnionFind(int n) {
        parents =new int[n];
        for(int i=0;i<n;i++) {
            parents[i]=-1;
        }
    }

    public void validate(int v1) {
        if(v1 > parents.length || v1 < 0) {
                throw new IllegalArgumentException("not valid index");
        }
    }

    public int sizeOf(int v1) {
        return -parent(find(v1));
    }

    public int parent(int v1) {
        validate(v1);
        return parents[v1];
    }

    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        if(find(v1) == find(v2)) {
            return true;
        }
        return false;
    }

    public void union(int v1, int v2) {
        if(connected(v1,v2)) {
            return;
        } else {
            if(sizeOf(v1) > sizeOf(v2)) {
                parents[find(v1)] -= sizeOf(v2);
                parents[find(v2)] = find(v1);
            } else {
                parents[find(v2)] -=sizeOf(v1);
                parents[find(v1)] = find(v2);
            }
        }
    }

    public int find(int v1) {
        validate(v1);
        int p=v1;
        if (parents[p] < 0) {
            return p;
        } else {
            int cun = v1;
            while(parents[p] >=0) {
                p = parents[p];
            }
            parents[cun] = p;
            return p;
        }
    }
}
