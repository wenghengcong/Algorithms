package sword.chap3;

import foundation.TreeNode;

/**
 * @author wenghengcong
 * @className: ISSubtree
 * @desc: 判断 T2 是不是 T1 的子树
 * @date 2019-07-0314:38
 */
public class ISSubtree {

    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            // 空子树是任何树结构的子树
            return true;
        }
        if (T1 == null) {
            // 空子树没有子树
            return false;
        }

        if (isEqual(T1, T2)) {
            return true;
        }
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) {
            return true;
        }
        return false;
    }

    /**
     * 判断两个节点数是否一致
     * 即根节点一致，且根节点下左右节点也是一致
     * */
    private static boolean isEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) {
            return T1 == T2;
        }
        if (T1.val != T2.val) {
            return false;
        }
        return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }
}
