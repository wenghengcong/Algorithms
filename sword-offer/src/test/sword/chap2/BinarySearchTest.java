package chap2;

import org.junit.Test;
import sword.chap2.BinarySearch;

/**
 * @author wenghengcong
 * @className: BinarySearchTest
 * @description:
 * @date 2019-05-2621:51
 */
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        int[] test = new int[]{1, 2, 3, 5, 8, 10 ,12, 18};
        int pos = BinarySearch.binarySearch(12, test);
        System.out.println(pos);
    }

    @Test
    public void binarySearchByRecursion() {
        int[] test = new int[]{1, 2, 3, 5, 8, 10 ,12, 18};
        int pos = BinarySearch.binarySearchByRecursion(10, test, 0, test.length-1);
        System.out.println(pos);
    }
}
