package algo4.chap2_Sort;

/**
 * @author wenghengcong
 * @className: InsertionSort
 * @desc:
 * @date 2019-06-1022:28
 */

/**
 * 插入排序
 * 算法思想：
    * 1. 算法类似于整理扑克牌的方法是一张一张的来，将每一张出入到其他已经有序的牌中适当的位置
    * 2. 在计算机中，为了要给插入的元素腾出空间，需要将其余所有的元素在插入之前都向右移动一位
    *
 * 性能分析：
    * 一般性：插入排序 > 选择排序
    * 平均情况：~ N²/4 次比较和交换
    * 最坏情况：~ N²/2 次比较和交换
    * 最好情况：N-1 次比较和0次交换
 * 适用场景
    * 部分有序的数组
    * 1. 数组中的每个元素距离它的最终位置都不远
    * 2. 一个有序的数组接一个有序的小数组
    * 3. 数组中只有几个元素的位置不正确
 * */
public class InsertionSort extends SortTemplate {


    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将a[i] 插入到a[i-1]、a[i-2]、a[i-3]的数组中
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                }
            }
        }
    }

    // 改进方法一：在内循环比较后，将较大元素都向右移动，而不总是交换两个元素，这样访问数组元素的次数就能减半

}
