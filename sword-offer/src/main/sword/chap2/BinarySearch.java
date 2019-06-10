package sword.chap2;

/**
 * @author wenghengcong
 * @className: BinarySearch
 * @description: 二分查找
 * @date 2019-05-2621:43
 */
public class BinarySearch {

    public static int binarySearch(int key, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (key < nums[mid]) {
                hi = mid - 1;
            } else if (key > nums[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchByRecursion(int key, int[] nums, int lower, int high) {
        int mid = lower + (high - lower) / 2;
        if (key < nums[mid]) {
            high = mid - 1;
            return binarySearchByRecursion(key, nums, lower, high);
        } else if (key > nums[mid]) {
            lower = mid + 1;
            return binarySearchByRecursion(key, nums, lower, high);
        } else {
            return mid;
        }
    }
}
