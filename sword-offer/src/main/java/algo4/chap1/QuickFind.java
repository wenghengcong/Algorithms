package algo4.chap1;

/**
 * @author wenghengcong
 * @className: QuickFind
 * @desc: 并查集，p136
 * @date 2019-05-2811:11
 */
public class QuickFind {

    /**
    * 分量id，以触点作为索引
    * id中索引是触点，id对应的值为触点所在的连通分量
    * */
    private int[] id;

    /**
     * 连通分量数量
     */
    private int count;
    /**
     * 构造方法：一开始有N个分量，每个触点都构成了触点i
     * */
    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * p（0到N-1）所在的分量标识符
     * */
    public int find(int p) {
        return id[p];
    }

    /**
     * 在触点p和触点q之间添加一条连接
     * 此时如果p和q不在同一个连通分量，连接后，就会减少一个连通分量
     * 1.触点p和触点q对应的连通分量由find方法获取，为pID、qID
     * 2.如果p和q的连通分量相等，即在同一个连通分量中，union无须操作
     * 3.否则，需要将p对应连通分量中的触点，修改为q触点对应的连通分量值qID
     *   也可以将q触点对应的连通分量中的触点，修改为p触点对应的连通分量pID
     * */
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }
        // 将所有p所指的分量内的触点修改为触点q对应的分量
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
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
