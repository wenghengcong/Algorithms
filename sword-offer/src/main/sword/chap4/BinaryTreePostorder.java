package sword.chap4;

import foundation.TreeNodeInt;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wenghengcong
 * @className: BinaryTreePostorder
 * @desc:
 * @date 2019-07-3010:00
 */
/**
 * 后续遍历
 * 给出一棵二叉树，返回其节点值的后序遍历。
 * 题目：https://www.lintcode.com/problem/binary-tree-postorder-traversal/description?_from=ladder&&fromId=6
 *
 * */
public class BinaryTreePostorder {

    //Recursive
    public ArrayList<Integer> postorderTraversal(TreeNodeInt root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;
    }



    //Iterative
    public ArrayList<Integer> postorderTraversal2(TreeNodeInt root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNodeInt> stack = new Stack<TreeNodeInt>();
        TreeNodeInt prev = null; // previously traversed node
        TreeNodeInt curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.empty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }
}
