package chap2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
* FizzBuzz class
* https://www.lintcode.com/problem/fizz-buzz/?_from=ladder&&fromId=6
*
* 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
* 如果这个数被3整除，打印fizz.
* 如果这个数被5整除，打印buzz.
* 如果这个数能同时被3和5整除，打印fizz buzz.
* 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
* @author wenghengcong
* */
public class FizzBuzz {

    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public static List<String> fizzBuzz(int n) {
        // write your code here
        List<String> result = new ArrayList();
        Map fizzMap = new HashMap();
        Map buzzMap = new HashMap();
        fizzMap.put(3, "fizz ");
        buzzMap.put(5, " buzz");
        for (int i=1;i <= n ;i++ ) {
            String mapFizz = (String)fizzMap.get(i%3+3);
            String mapBuzz = (String)buzzMap.get(i%5+5);
            String nStr = mapFizz + mapBuzz;
            nStr = nStr.replaceFirst(" ", "");
            nStr = nStr.replaceAll("null", "");
            if (nStr.length() == 0) {
                nStr = String.valueOf(i);
            }
            result.add(nStr);
        }
        return result;
    }
}
