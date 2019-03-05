package chap2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TestChap2 {

    private static final Logger log = LogManager.getLogger(TestChap2.class.getName());

    @Test
    public void testFizzBuzz() {
        List<String> fz = FizzBuzz.fizzBuzz(15);
        log.info(fz);
    }

    @Test
    public void testReplaceBlank() {

        char[] oldString = "LintCode and Jiuzhang".toCharArray();
        //测试的时候，保证输入的字符数组足够大，否则会数组越界
        int replaceLength = ReplaceBlank.numberOfBlank(oldString)*2 + oldString.length;
        char[] replaceString = new char[replaceLength];
        for(int i=0;i<oldString.length;i++)
            replaceString[i] = oldString[i];
        //注意传入的length是test1
        ReplaceBlank.replaceBlank(replaceString, oldString.length);
        log.info(String.valueOf(replaceString));
    }
}
