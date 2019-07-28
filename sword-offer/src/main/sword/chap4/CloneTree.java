package sword.chap4;

import foundation.TreeNodeInt;

/**
 * @author wenghengcong
 * @className: CloneTree
 * @desc:
 * @date 2019-07-2817:02
 */
/**
 * 深度复制一个二叉树。
 * 给定一个二叉树，返回一个他的 克隆品 。
 * 题目：https://www.lintcode.com/problem/clone-binary-tree/description?_from=ladder&&fromId=6
 * */
public class CloneTree {

    public static TreeNodeInt cloneTree(TreeNodeInt root) {
        if (root == null) {
            return null;
        }

        TreeNodeInt clone_root = new TreeNodeInt(root.val);
        clone_root.left = cloneTree(root.left);
        clone_root.right = cloneTree(root.right);
        return clone_root;
    }

}
