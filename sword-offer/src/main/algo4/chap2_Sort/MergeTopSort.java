package algo4.chap2_Sort;

/**
 * @author wenghengcong
 * @className: MergeTopSort
 * @desc: p170   2.2节
 * @date 2019-06-1207:35
 * @author wenghengcong
 */
/**
* 归并排序：自顶向下的归并排序
* 算法思想：
 * 分治思想的体现
 * 1. 要将一个数组排序，可以先（递归地）将它分成两半排序
 * 2. 然后将排序结果进行合并。
 *
*
* 性能分析：
 * 1. 自顶向下的归并排序需要 ½ NlgN到 NlgN 次比较
 * 2. 自顶向下的归并排序需要 6NlgN 次访问数组
 *
*
* 适用场景：
 *
 *
 *
*
* */
public class MergeTopSort extends SortTemplate {
    private static Comparable[] aux;    // 归并所需要的辅助数组

    public static void sort(Comparable[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    /**
    * 排序
    * */
    private static void sort(Comparable[] a, int lo, int hi) {
        //将数组a[lo..hi]排序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi-lo)/2;
        // 1.先排序
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        // 2.再合并
        merge(a, lo, mid, hi);
    }

    /**
     * 将 a[lo..mid] 和 a[mid+1..hi]合并
     * 两个子数组都有序
    * */
    private static void merge(Comparable[]a, int lo, int mid ,int hi) {
        int i = lo, j = mid+1;
        // 将数组拷贝，作为辅助排序用
        for (int k=0; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // i已经移动到mid之后，即左半边已用尽，直接取右半边元素
                a[k] = aux[j++];
            } else if (j > hi) {
                // j已经移动到hi之后，即右半边已用尽，取左半边元素
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                // 左右半边均未用尽，取两边指针小的值
                // 此次比较j与i，假如j更小，将j的值赋给a[k]，且j++
                // 否则取i的值，且i++
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
