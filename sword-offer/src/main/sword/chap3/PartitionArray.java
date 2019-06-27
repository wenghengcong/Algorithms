package sword.chap3;

/**
 * @author wenghengcong
 * @className: PartitionArray
 * @desc: 分隔一个数组，使得该数组中的奇数在前，偶数在后
 * @date 2019-06-2719:36
 */
/**
 * 分割一个整数数组，使得奇数在前偶数在后。
 * 答案不唯一。你只需要给出一个合法的答案。
 * 在原数组中完成，不使用额外空间。
 *
 * Lint Code : https://www.lintcode.com/problem/partition-array-by-odd-and-even/description?_from=ladder&&fromId=6
 * 题解：https://www.jiuzhang.com/solution/partition-array-by-odd-and-even/
 * */
public class PartitionArray {

    /**
     * 原题目很简单，只需要将原数组扫描两遍，第一遍加入奇数，第二遍加入偶数，然后把答案数组覆盖原数组即可。
     *
     * 对于challenge问题，我们需要采用双指针（two pointer）的方法，一个从头开始，
     * 一个从尾开始，头指针定位到从前到后的第一个偶数，
     * 尾指针定位到从后到前的第一个奇数，两者交换即可。直到尾指针在头之前前面。
     * */
    public static void partitionArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // write your code here
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            while (nums[start]%2 == 1 && start < end) {
                //是偶数，将start一直向后推移
                start++;
            }
            while (nums[end]%2 == 0 && start < end){
                //是奇数，就将end指针往前推移
                end--;
            }
            if (start < end) {
                exch(nums, start, end);
                start++;
                end--;
            }
        }
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
