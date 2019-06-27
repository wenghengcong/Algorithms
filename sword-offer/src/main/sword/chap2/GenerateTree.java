package sword.chap2;

/**
 * @author wenghengcong
 * @className: GenerateTree
 * @desc:
 * @date 2019-06-2619:52
 * 前序的第一个为根，在中序中找到根的位置。
 * 中序中根的左右两边即为左右子树的中序遍历。同时可知左子树的大小size-left。
 * 前序中根接下来的size-left个是左子树的前序遍历。
 * 由此可以递归处理左右子树。
 */
public class GenerateTree {

    /**
     *@param preorder : 前序
     *@param inorder : 中序
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null
                || preorder.length == 0
                || preorder.length != inorder.length
        ) {
            return null;
        }
        return iterateBuildTree(inorder, 0, inorder.length-1,
                preorder, 0, preorder.length-1);
    }

    /**
    * 查找中序[start end]中，对应root的位置
    * */
    private int findRootPosition(int[] inorder, int instart, int inend, int root) {

        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 迭代构造左右子树
     * 注意左右子树的起始位置
     * */
    private TreeNode iterateBuildTree(int[] inorder, int instart, int inend,
                                      int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        // 找到根节点在中序树中的位置
        int position = findRootPosition(inorder, instart, inend, root.val);

        //构造左右子树
        //左子树的长度根据inorder算出：leftsize=position-instart
        //右子树的长度：rightsize=inend-postion
        //左子树在preorder中的边界为：[prestart+1, prestart+leftsize]
        //右子树在preorder中的边界为：[preend-rightsize+1, preend]
        root.left = iterateBuildTree(inorder, instart, position-1,
                preorder, prestart+1, prestart + (position-instart) );
        root.right = iterateBuildTree(inorder, position+1, inend,
                preorder, position - inend + preend + 1, preend);
        return root;
    }

    /**
     * 打印数组
     * */
    public void printTree(TreeNode root) {

    }
}
