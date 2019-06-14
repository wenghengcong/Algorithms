package algo4.chap2_Sort;

/**
 * @author wenghengcong
 * @className: MergeBottomSort
 * @desc:
 * @date 2019-06-1207:37
 */
/**
* 归并排序：自底向上的归并排序
* 算法思想：
 *
 *
 *
 *
*
* 性能分析：
 *
 *
 *
 *
*
*
* 适用场景：
 *
 *
 *
*
* */
public class MergeBottomSort extends SortTemplate {

    private static Comparable[] aux;    //归并所需要的辅助数组

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new  Comparable[N];
        // sz是子数组的大小
        for (int sz = 1; sz < N; sz = sz+sz) {
            for (int lo = 0; lo < N-sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
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
