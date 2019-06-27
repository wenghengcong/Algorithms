package sword.chap3;

import org.junit.Test;


/**
 * @author wenghengcong
 * @className: PartitionArrayTest
 * @desc:
 * @date 2019-06-2719:59
 */
public class PartitionArrayTest {

    @Test
    public void testPartitionArray() throws Exception {
        int[] nums = new int[]{1, 2, 3, 4, 5, 7, 8, 10};
        PartitionArray.partitionArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme