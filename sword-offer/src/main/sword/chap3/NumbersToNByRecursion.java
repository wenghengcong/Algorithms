package sword.chap3;

/**
 * @author wenghengcong
 * @className: NumbersToNByRecursion
 * @desc: 用递归的方法找到从1到最大的N位整数。
 * @date 2019-07-0307:50
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 用递归的方法找到从1到最大的N位整数。
 * 问题： https://www.lintcode.com/problem/print-numbers-by-recursion/description?_from=ladder&&fromId=6
 * 题解：https://www.jiuzhang.com/accounts/register/?next=/solution/print-numbers-by-recursion/
 * 解法：
 * 1.用下面这种方式去递归其实很容易：
 * recursion(i) {
 *     if i > largest number:
 *         return
 *     results.add(i)
 *     recursion(i + 1)
 * }
 * 但是这种方式会耗费很多的递归空间，导致堆栈溢出。你能够用其他的方式来递归使得递归的深度最多只有 N 层么？
 *
 * 2. 用递归完成，而非循环的方式。
 *
 * */
public class NumbersToNByRecursion {

    public static List<Integer> numbersByRecursion(int n) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        num(n, 0, res);
        return res;
    }

    /**
     * n：几位数
     * ans：最后计算出的具体值，理解为1到9，乘以n-1个10的循环
     * */
    private static void num(int n, int ans,ArrayList<Integer> res){
        if(n == 0){
            if(ans > 0){
                res.add(ans);
            }
            return;
        }

        int i;
        for(i = 0; i <= 9; i++){
            num(n - 1, ans * 10 + i, res);
        }
    }
}
