package algo4.chap2_Sort;

/**
 * @author wenghengcong
 * @className: QuickSort
 * @desc:
 * @date 2019-06-1207:37
 */
/**
* 快速排序
 * 快速排序是一种分治的排序算法
 * 1. 将一个数组分成两个，将两部分独立的排序
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
* 适用场景：
 *
 *
 *
 *
 *
*
* */
public class QuickSort extends SortTemplate {

    public static void sort(Comparable[] a) {
        // 将数组先随机化处理，此处省略
//        shuffle(a)
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1]，a[i]，a[i+1..hi]
        // 左右扫描指针
        int i = lo, j= hi+1;
        // 切分元素
        Comparable v = a[lo];

        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            // 从左开始扫描，递增i，一直递增到hi停止，如果未停止，则在左边找到了比v大的元素
            while (less(a[++i], v)) if (i == hi) break;
            // 从右开始扫描，递减j，一直递减到lo停止，如果未停止，则在右边找到了比v小的元素
            while (less(v, a[--j])) if (j == lo) break;
            // 如果递减后，i>=j，跳出循环。
            // 比如，找到一个i比v大的元素，但是，没有找到j比v小的元素，i=j，跳出，并进行交换
            if (i >= j) break;;
            // 否则，找到了i位置比v小的元素，找到了j位置比v大的元素，进行交换
            exch(a, i, j);
        }
        // 将v = a[j] 放入到正确的位置上
        exch(a, lo, j);
        // 现在a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
        return j;
    }

}
