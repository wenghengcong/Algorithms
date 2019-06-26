package algo4.chap2_Sort;

import org.junit.Test;

/**
 * @author wenghengcong
 * @className: SelectionSortTest
 * @desc:
 * @date 2019-06-1022:14
 */
public class SelectionSortTest {

    @Test
    public void sort() {
        // 测试12ms
        // 排序后：A E E L M O P R S T X
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println("排序前");
        SelectionSort.show(a);
        SelectionSort.sort(a);
        System.out.println("排序后");
        SelectionSort.show(a);
    }
}