package sword.chap4;

import foundation.TreeNodeInt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wenghengcong
 * @className: BinaryTreeLevelOrder
 * @desc:
 * @date 2019-07-3009:50
 */
/**
 *  层次遍历：给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 *  题目：https://www.lintcode.com/problem/binary-tree-level-order-traversal/description?_from=ladder&&fromId=6
 *  二叉树的层次遍历通常实现方式为使用队列不断压入节点遍历,每次取出队列首个元素遍历左右子节点，继续压入子节点即可。
 * */
public class BinaryTreeLevelOrder {

    /**
     * BFS
     * 先将根节点入队，当前节点是队头节点，将其出队并访问，
     * 如果当前节点的左节点不为空将左节点入队，如果当前节点的右节点不为空将其入队。
     * 所以出队顺序也是从左到右依次出队
     * */
    public List<List<Integer>> levelOrder(TreeNodeInt root) {
        List result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNodeInt> queue = new LinkedList<TreeNodeInt>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeInt head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }


    /**
     * BFS two queues
     * */
    public List<List<Integer>> levelOrder2(TreeNodeInt root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        List<TreeNodeInt> Q1 = new ArrayList<TreeNodeInt>();
        List<TreeNodeInt> Q2 = new ArrayList<TreeNodeInt>();

        Q1.add(root);
        while (Q1.size() != 0) {
            List<Integer> level = new ArrayList<Integer>();
            Q2.clear();
            for (int i = 0; i < Q1.size(); i++) {
                TreeNodeInt node = Q1.get(i);
                level.add(node.val);
                if (node.left != null) {
                    Q2.add(node.left);
                }
                if (node.right != null) {
                    Q2.add(node.right);
                }
            }

            // swap q1 and q2
            List<TreeNodeInt> temp = Q1;
            Q1 = Q2;
            Q2 = temp;

            // add to result
            result.add(level);
        }

        return result;
    }


    /**
     * BFS, queue with dummy node
     * */
    public List<List<Integer>> levelOrder3(TreeNodeInt root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNodeInt> Q = new LinkedList<TreeNodeInt>();
        Q.offer(root);
        Q.offer(null); // dummy node

        List<Integer> level = new ArrayList<Integer>();
        while (!Q.isEmpty()) {
            TreeNodeInt node = Q.poll();
            if (node == null) {
                if (level.size() == 0) {
                    break;
                }
                result.add(level);
                level = new ArrayList<Integer>();
                Q.offer(null); // add a new dummy node
                continue;
            }

            level.add(node.val);
            if (node.left != null) {
                Q.offer(node.left);
            }
            if (node.right != null) {
                Q.offer(node.right);
            }
        }

        return result;
    }


    /**
     * DFS
     * */
    public List<List<Integer>> levelOrder4(TreeNodeInt root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (root == null) {
            return results;
        }

        int maxLevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }

            results.add(level);
            maxLevel++;
        }

        return results;
    }

    private void dfs(TreeNodeInt root,
                     List<Integer> level,
                     int curtLevel,
                     int maxLevel) {
        if (root == null || curtLevel > maxLevel) {
            return;
        }

        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }

        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }

}
