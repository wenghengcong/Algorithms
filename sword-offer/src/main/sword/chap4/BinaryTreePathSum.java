package sword.chap4;

import foundation.TreeNodeInt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenghengcong
 * @className: BinaryTreePathSum
 * @desc:
 * @date 2019-07-2816:40
 */
/**
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。一个有效的路径，指的是从根节点到叶节点的路径。
 * 题目： https://www.lintcode.com/problem/binary-tree-path-sum/description
 * 题解：
 * */

/**
 * 由于路径是从根结点出发到叶结点， 也就是说路径总是以根结点为起始点，因此我们首先需要遍历根结点。
 * 在树的前序、中序、后序三种遍历方式中，只有前序遍历是首先访问根结点的。
 * 当用前序遍历的方式访问到某一结点时，我们把该结点添加到路径上，并累加该结点的值。
 * 如果该结点为叶结点并且路径中结点值的和刚好等于输入的整数，则当前的路径符合要求，我们把它打印出来。
 * 如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归函数将自动回到它的父结点。
 * 因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根结点到父结点的路径。
 *
 * 不难看出保存路径的数据结构实际上是一个枝， 因为路径要与递归调用状态一致， 而递归调用的本质就是一个压栈和出栈的过程。
 * 选择树的先序遍历作为流程框架。动态保存根节点到当前节点的path。若当前节点为叶子节点，则判断路径和是否为给定的整数值。直到树的遍历结束。
 *
 * */
public class BinaryTreePathSum {

    public List<List<Integer>> binaryTreePathSum(TreeNodeInt root, int target) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        findPath(root, target, temp, list);
        return list;
    }

    /**
     * root: 根节点
     * target：目标值
     * temp：保存此次寻找的路径
     * path：返回符合的路径集合
     * */
    private void findPath(TreeNodeInt root,int target, List<Integer> temp, List<List<Integer>> path)
    {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 当前节点为根节点
            if (root.val == target) {
                List<Integer> temp2=new ArrayList<Integer>();
                temp2.addAll(temp);
                temp2.add(root.val);
                path.add(temp2);
            }
        } else {
            // 当前节点不是根节点
            temp.add(root.val);
            // 在左子树寻找符合的路径
            findPath(root.left, target - root.val, temp, path);
            // 在右子树寻找符合的路径
            findPath(root.right, target - root.val, temp, path);
            // 在左右子树寻找后，退回temp
            temp.remove(temp.size() - 1);
        }
    }
}
