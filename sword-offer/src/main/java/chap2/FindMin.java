package chap2;

/**
 * @author wenghengcong
 * @className: FindMin
 * 假设一个排好序的数组在其某一未知点发生了旋转（比如0 1 2 4 5 6 7 可能变成4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * @date 2019-05-2617:38
 * 题目：https://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array/description?_from=ladder&&fromId=6
 * 九章解法：https://www.jiuzhang.com/solution/find-minimum-in-rotated-sorted-array/#tag-highlight-lang-java
 * LeetCode：https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMin {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                // 如果mid位置小于right，那么mid...right是有序的
                // right收缩
                right = mid;
            } else {
                // 假如mid大于等于right，则发生了旋转，说明mid...right里无序
                // 说明最小值在mid...right，因为旋转后，一定是小数旋转到了mid...right里
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
