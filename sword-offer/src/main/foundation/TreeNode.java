package foundation;

/**
 * @author wenghengcong
 * @className: TreeNode
 * @desc: 树节点
 * @date 2019-06-2619:51
 */
public class TreeNode<Key extends Comparable<Key>, Value> {

    /**
     * 键
     * */
    public Key key;
    /**
     * 值
     * */
    public Value val;
    /**
     *  //左右子树
     * */
    public TreeNode left;
    public TreeNode right;
    /**
     * 以该结点为根的子树中的结点总数
     * */
    public int N;

    public TreeNode(Value val) {
        this.val = val;
        this.left = this.right = null;
    }

}
