package algo4.chap3_search;

/**
 * @author wenghengcong
 * @className: BinarySearchTree
 * @desc: 二分查找树
 * @date 2019-07-0315:47
 */
/**
 * 二分查找树
 * p 250
 *
 * */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        /**
         * 所有操作都是基于key
         * 查找、插入、删除、最大、最小等
         * */
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key; this.val = val; this.size = size;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    /**
     * 获取key对应的值
     * */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        // 在以node为根结点的子树中查找并返回key对应的值
        // 如果找不到则返回null
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if(cmp > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }

    /**
     * 查找key，找到则更新它的值，否则为它创建一个新结点并插入
     * */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value value) {
        // 如果key存在于以node为根结点的子树中，则更新它的值
        // 否则将以key和value为键值对的新结点插入到该树中
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            //可能在左子树中
            return put(node.left, key, value);
        } else if(cmp > 0){
            // 可能在右子树中
            return put(node.right, key, value);
        } else {
            // 找到
            node.val = value;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 寻找最小结点的Key
     * */
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    /**
     * 获取最大的结点Key
     * */
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    /**
     * 选择第k个键Key——排名为k的键，即树中真好有k个小于它的键
     * 如果左子树中的结点数 t 大于 k，那么就在左子树中继续寻找排名为k的键
     * 如果 t=k ，那么就返回根结点中的键；
     * 如果 t>k ，那么就在右子树中继续寻找排名为（k-t-1）键
     * */
    public Key select(int k) {
        return select(root, k).key;
    }

    public Node select(Node node, int k) {
        if (node == null) {
            return null;
        }
        int t = size(node.left);
        if (t < k) {
            return select(node.right, k-t-1);
        } else if(t > k) {
            return select(node.left, k);
        } else {
            return node;
        }
    }

    /**
     * 返回键的排名
     * 如果给定的结点和根结点的减相等，就返回左子树中的结点t
     * 如果给定的结点小于根结点，就返回该键在左子树中的排名；
     * 如果给定的结点大于根结点，就返回 （t+1+在右子树中的排名）
     * */
    public int rank(Key key) {
        return rank(root, key);
    }


    /**
     * 返回以node为根结点的子树中小于node.key的键的数量
     * */
    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            // 在左子树
            return rank(node.left, key);
        } else if(cmp > 0) {
            return 1 + size(node.left) + rank(node.right, key);
        } else {
            return node.left.size;
        }

    }

    /**
     * 删除值最小的结点
     * 根据二叉查找树的规律
     * */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root ,key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            // 在左子树中删除
            node.left = delete(node.left, key);
        } else if(cmp > 0) {
            // 在右子树中删除
            node.right = delete(node.right, key);
        } else {
            // 删除结点-该结点为待删除
            if (node.right == null) {
                // 如果删除结点的右子树为空，那么左子树直接顶替该结点
                return node.left;
            }

            if (node.left == null) {
                // 如果删除结点的左子树为空，那么右子树直接顶替该结点
                return node.right;
            }

            // 左右子树都不为空：那么就将（右子树中最小的结点）作为新结点顶替要删除的结点
            // 先将将要删除的结点保留，以备后面保留左子树
            Node preDelNode = node;
            // 找到右子树中最小的结点
            node = min(node.right);

            // 删除右子树中最小的结点，并保留删除后的右子树
            node.right = deleteMin(node.right);

            // 右子树中最小节点的左子树为 即将删除结点的左子树
            node.left = preDelNode.left;

        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

}
