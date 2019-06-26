package algo4.chap2_Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenghengcong
 * @className: MergeTopSortTest
 * @desc:
 * @date 2019-06-1323:14
 */
public class MergeTopSortTest {

    @Test
    public void sort() {
        // 10ms
        // 排序后：A E E L M O P R S T X
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println("排序前");
        MergeTopSort.show(a);
        MergeTopSort.sort(a);
        System.out.println("排序后");
        MergeTopSort.show(a);
    }
}