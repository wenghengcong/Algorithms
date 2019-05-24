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
    public void testFabonacci() {
        int n = 8;
        log.info(Fibonacci.fibonacciByArray(n));
        log.info(Fibonacci.fibonacciByNotRecursion(n));
        log.info(Fibonacci.fibonacciByRecursion(n));
    }

    @Test
    public void testReplaceBlank() {

        char[] oldString = "LintCode and Jiuzhang".toCharArray();
        //测试的时候，保证输入的字符数组足够大，否则会数组越界
        char[] replaceString = new char[100];
        for(int i=0;i<oldString.length;i++)
            replaceString[i] = oldString[i];
        //注意传入的length是test1
        ReplaceBlank.replaceBlank(replaceString, oldString.length);
        log.info(String.valueOf(replaceString));
    }

    @Test
    public void testCountOnes() {
        int count = HammingWeight.countOnes(5);
        log.info(count);
    }

    @Test
    public void testHammingWeight() {
        int num = -12;
        log.info(HammingWeight.countOnes(num) + ":"
                + HammingWeight.countOnesSecond(num)) ;
    }

    @Test
    public void testReverseListNode (){
        ListNode head = new  ListNode(13);
        ListNode sec = new ListNode(4);
        ListNode thr = new ListNode(8);
        ListNode four = new ListNode(22);
        head.next = sec; sec.next = thr; thr.next = four;

        log.info(head.toString());
        // 翻转
        ListNode reverse = ListNode.reverse(head);
        log.info(reverse.toString());

        // 再次翻转
        ListNode reverseAgain = ListNode.reverseIteration(reverse);
        log.info(reverseAgain.toString());
    }

}
