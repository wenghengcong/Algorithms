package algo4.chap1;

/**
 * @author wenghengcong
 * @className: WeightedQuickUnion
 * @desc: 加权Quick Union算法，p145
 * @date 2019-05-2817:33
 */
public class WeightedQuickUnion {

    /**
     * 分量id，以触点作为索引
     * id中索引是触点，id对应的值为同一个分量中另一个触点的值，如果指向自己，那么该触点就是根触点
     * 触点指向另外一个触点的联系，称作“”链接"
     * */
    private int[] id;

    /**
     * 权重：各个根节点说对应的分量的大小
     * */
    private int[] sz;

    /**
     * 连通分量数量
     */
    private int count;
    /**
     * 构造方法：一开始有N个分量，每个触点都构成了触点i
     * sz初始为权重1，即指向自己
     * */
    public WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    /**
     * p（0到N-1）所在的分量根触点，相当于该分量的标识符
     * */
    public int find(int p) {
        //查找到根触点，返回
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 在触点p和触点q之间添加一条连接
     * 此时如果p和q不在同一个连通分量，连接后，就会减少一个连通分量
     * 1.触点p和触点q对应的连通分量由find方法获取对应的根触点，为pRoot、qRoot
     * 2.如果p和q的根触点相等，即在同一个连通分量中，union无须操作
     * 3.否则，需要将p对应根触点，将其链接的触点，修改为q触点对应的根触点qRoot
     *   也可以将q触点对应的根触点，修改为p触点对应根触点pRoot
     * */
    public void union(int p, int q){
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 将小树的根节点连接到大树的根节点
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        id[pRoot] = qRoot;
        // 连通分量减少
        count--;
    }

    /**
     * 如果p和q在同一个连通分量中，返回true
     * */
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
}
