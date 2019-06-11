package algo4.chap2_Sort;

/**
 * @author wenghengcong
 * @className: ShellSort
 * @desc:
 * @date 2019-06-1023:09
 */

/**
 * 希尔排序
 * 算法思想：
    * 1. 是插入排序的优化版本，将数组分为多个子数组，每个子数组进行插入排序。
    * 2. 优化的点在于，希尔排序，可以交换不相邻的元素，而插入排序只能交换相邻的元素，
    *       这就插入保证了在极端情况下，即一端逐个移到另一端的情况。
    * 3. 使数组中任意间隔为h的元素都是有序的，这样的数组被称为h有序数组。
 *
 * 性能分析：
    * 1. 使用递增序列1，4，14，40，121，364...的希尔排序所需的比较次数不会超过 （N的若干倍 * 递增序列的长度）
    * 2. 和递增序列关系很大。
     * 不稳定排序
 * 适用场景
    * 部分有序的数组，无须额外的内存空间
    *
 * */
public class ShellSort extends SortTemplate {

    public static void sort (Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }

        while (h > 1) {
            // 将数组变为h有序
            for (int i = 0; i < N; i++) {
                for (int j = i; j >= h ; j=j-h) {
                    // 将a[i]插入到a[i-h]、a[i-2h]、a[i-3h]中
                    if (less(a[j] , a[j-h])) {
                        exch(a, j, j-h);
                    }
                }
            }
            h = h/3;
        }
    }
}
