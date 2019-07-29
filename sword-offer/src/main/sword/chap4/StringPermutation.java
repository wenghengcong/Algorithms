package sword.chap4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenghengcong
 * @className: StringPermutation
 * @desc:
 * @date 2019-07-2917:20
 */
/**
 * 给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。
 * 置换的意思是，通过改变顺序可以使得两个字符串相等。
 *
 * 题目：https://www.lintcode.com/problem/string-permutation/
 *
 * */
public class StringPermutation {

    /**
     * （1）判断A，B两个字符串长度是否相同。不相同返回false.
     * （2）用map记录A中每个字符的个数
     * （3）遍历B中的每个字符，map中个数-1，为0移出map
     * （4）判断map长度，如果长度为0，返回true,否则返回false.
     * */
    public static boolean stringPermutation(String A, String B) {
        if (A.equals("") && B.equals("")) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i))) {
                map.put(B.charAt(i), 1);
            } else {
                map.put(B.charAt(i), map.get(B.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                if (map.get(A.charAt(i)) == 1) {
                    map.remove(A.charAt(i));
                } else {
                    map.put(A.charAt(i), map.get(A.charAt(i)) - 1);
                }
            }

        }

        return map.size() == 0;
    }

    /**
     * 建立一个数组，记录字母出现的次数
     * */
    public boolean stringPermutation2(String A, String B) {

        if(A==null && B==null) {
            return true;
        }
        if(A==null || B==null) {
            return false;
        }
        if(A.length() !=B.length()) {
            return false;
        }

        int[] cnt = new int[256];
        for (int i = 0; i < A.length(); i++) {
            cnt[(int) A.charAt(i)] += 1;
            cnt[(int) B.charAt(i)] -= 1;
        }

        for (int i = 0; i < 256; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
