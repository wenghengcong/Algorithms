package algo4.chap2_Sort;

/**
 * @author wenghengcong
 * @className: BubbleSort
 * @desc:
 * @date 2019-06-1207:37
 */
/**
* 冒泡排序
* 算法思想：
 * 1. 每一趟比较相邻的两个元素，将更大的元素一直往后移动，第一趟下来就能将最大的元素移动到最后。
 * 2. 依次重复以上，直到最后
 *
* 性能分析：
 * 1. 访问数组次数，都是 N²/2 次
 * 2. 交换次数
 * 3. 稳定排序
 * 4. 原地排序
 *
*
* 适用场景：
 *
 *
 *
 *
*
* */
public class BubbleSort extends SortTemplate {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-i-1; j++) {
                if (less(a[j+1], a[j])) {
                    exch(a, j, j+1);
                }
            }
        }
    }
}
