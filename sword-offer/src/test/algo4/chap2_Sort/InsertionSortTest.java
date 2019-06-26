package algo4.chap2_Sort;

import org.junit.Test;

/**
 * @author wenghengcong
 * @className: InsertionSortTest
 * @desc:
 * @date 2019-06-1023:05
 */
public class InsertionSortTest {

    @Test
    public void sort() {
        // 测试6ms
        // 排序后：A E E L M O P R S T X
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println("排序前");
        InsertionSort.show(a);
        InsertionSort.sort(a);
        System.out.println("排序后");
        InsertionSort.show(a);
    }
}