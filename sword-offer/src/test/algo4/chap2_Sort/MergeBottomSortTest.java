package algo4.chap2_Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenghengcong
 * @className: MergeBottomSortTest
 * @desc:
 * @date 2019-06-1323:14
 */
public class MergeBottomSortTest {

    @Test
    public void sort() {

        // 排序后：A E E L M O P R S T X
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println("排序前");
        MergeBottomSort.show(a);
        MergeBottomSort.sort(a);
        System.out.println("排序后");
        MergeBottomSort.show(a);
    }
}