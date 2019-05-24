package chap2;

/**
 * @author wenghengcong
 * @className: Fibonacci
 * @description: 查找斐波纳契数列中第 N 个数。
 * @date 2019-05-2323:18
 */
public class Fibonacci {

    /**
    * 递归方式
    * 空间：O(1),时间：O(2^n)
    * */
    public static int fibonacciByRecursion(int n) {
        if (n < 3) {
            return n-1;
        }
        return fibonacciByRecursion(n-1) + fibonacciByRecursion(n-2);
    }

    /**
     * 非递归方式
     * 空间：O(n)、时间：O(n)
     * */
    public static int fibonacciByNotRecursion(int n) {
        if (n < 3) {
            return n-1;
        }
        int nFirst = 0;
        int nSecond = 1;
        int nThird = 0;
        for (int i = 2; i < n; i++) {
            nThird = nFirst + nSecond;
            nFirst = nSecond;
            nSecond = nThird;
        }
        return nThird;
    }

    /**
     * 采用数组方式实现
     * 空间：O(n)、时间：O(n)
     * */
    public static int fibonacciByArray(int n) {
        if (n < 3) {
            return n-1;
        }
        int[] fab_arr = new int[n];
        fab_arr[0] = 0;
        fab_arr[1] = 1;
        for (int i = 2; i < n; i++) {
            fab_arr[i] = fab_arr[i-1] + fab_arr[i-2];
        }
        return fab_arr[n-1];
    }
}
