package algo4.chap2_Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wenghengcong
 * @className: ShellSortTest
 * @desc:
 * @date 2019-06-1206:20
 */
public class ShellSortTest {

    @Test
    public void sort() {
        // 测试5ms
        // 排序后：A E E L M O P R S T X
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println("排序前");
        ShellSort.show(a);
        ShellSort.sort(a);
        System.out.println("排序后");
        ShellSort.show(a);
    }
}