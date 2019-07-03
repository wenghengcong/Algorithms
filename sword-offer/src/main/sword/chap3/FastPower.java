package sword.chap3;

/**
 * @author wenghengcong
 * @className: FastPower
 * @desc: 计算an % b，其中a，b和n都是32位的非负整数。
 * @date 2019-07-0311:20
 */

/**
 * 计算an % b，其中a，b和n都是32位的非负整数。
 * 题目：https://www.lintcode.com/problem/fast-power/description?_from=ladder&&fromId=6
 * 题解：https://www.jiuzhang.com/solution/fast-power/
 * 在O(logn)时间复杂度内实现
 *
 * 解题思路：
 * 取模运算的乘法法则： http://baike.baidu.com/view/4887065.htm
 * 1. (a * b) % p = (a % p * b % p) % p （3）
 *
 * 2.a^n % b
    = (a^(n/2) * a^(n/2) * (a)) %b
    = ((a^(n/2) * a^(n/2))%b * (a)%b) %b
    = ((a^(n/2)%b * a^(n/2)%b)%b * (a)%b) %b
 * */
public class FastPower {

    public static int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }

        long result = fastPower(a, b, n/2);
        result = (result * result)%b;
        if (n%2 == 1) {
            result = (result * a)%b;
        }
        return (int) result;
    }
}
