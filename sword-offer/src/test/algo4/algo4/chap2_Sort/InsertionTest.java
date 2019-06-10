package algo4.chap2_Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenghengcong
 * @className: InsertionTest
 * @desc:
 * @date 2019-06-1023:05
 */
public class InsertionTest {

    @Test
    public void sort() {
        // 排序后：A E E L M O P R S T X
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println("排序前");
        Insertion.show(a);
        Insertion.sort(a);
        System.out.println("排序后");
        Insertion.show(a);
    }
}