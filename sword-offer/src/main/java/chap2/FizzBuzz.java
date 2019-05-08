package chap2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Fizz Buzz
* https://www.lintcode.com/problem/fizz-buzz/?_from=ladder&&fromId=6
*
* 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

如果这个数被3整除，打印fizz.
如果这个数被5整除，打印buzz.
如果这个数能同时被3和5整除，打印fizz buzz.
如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
* @author wenghengcong
* */
public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList();
        Map fizzMap = new HashMap();
        Map buzzMap = new HashMap();
        fizzMap.put(3, "fizz ");
        buzzMap.put(5, " buzz");
        for (int i=0; i<=n;i++) {
            String mapFizz = (String) fizzMap.get(i%3+3);
            String mapBuzz = (String) buzzMap.get(i%5+5);
            String nStr = mapFizz + " " + mapBuzz;
            // 1.fizz为空，即null_buzz
            // 2.buzz为空，即fizz_null
            // 3.fizz__buzz
            nStr = nStr.replaceFirst(" ", "");
            nStr = nStr.replaceAll("null ", "");
            if (nStr.length() == 0) {
                nStr = String.valueOf(i);
            }
            result.add(nStr);
        }
        return result;
    }
}
