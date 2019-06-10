package algo4.chap2_Sort;

/**
 * @author wenghengcong
 * @className: Selection
 * @desc:
 * @date 2019-06-1021:58
 */
/**
* 选择排序
* 算法思想：
 * 1. 找到数组中最小的那个元素
 * 2. 将它和数组的第一个元素交换位置（如果第一个元素就是最小的，那么就和自己交换位置)
 * 3. 在剩下的额元素找到最小的元素，将它与数组的第二个元素交换位置
 * 4. 如此往复，直到将整个数组排序
*
* 性能分析：
 * 1. 对于长度为N的数组，选择排序需要大约N²/2次比较 和 N次交换
 * 2. 运行时间和输入无关：长度固定，那么输入的数组如何排序，不会决定运行时间
 * 3. 数据移动时最少的，每次交换都会改变两个元素的值，只用了N次交换
 * 4. 空间为N
 * 5. 稳定排序
*
* */
public class Selection extends SortTemplate {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将a[i] 和 a[i+1..N]中的最小元素交换
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

}
