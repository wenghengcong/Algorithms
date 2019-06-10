package chap2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import sword.chap2.FindMin;

/**
 * @author wenghengcong
 * @className: FindMinTest
 * @description:
 * @date 2019-05-2620:34
 */
public class FindMinTest {

    private static final Logger log = LogManager.getLogger(TestChap2.class.getName());

    @Test
    public void findMin() {
        int[] testarr = new int[]{4,5,6,7,1,2};
        int min = FindMin.findMin(testarr);
        log.info(min);
    }
}
