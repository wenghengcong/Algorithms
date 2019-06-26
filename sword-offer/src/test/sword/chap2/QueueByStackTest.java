package sword.chap2;

import org.junit.Before;

/**
 * @author wenghengcong
 * @className: QueueByStackTest
 * @desc:
 * @date 2019-06-2617:41
 */
public class QueueByStackTest {

    private QueueByStack queueByStack;

    @Before
    public void before() {
        queueByStack = new QueueByStack();
    }

    @org.junit.Test
    public void push() {
        queueByStack.push(5);
        queueByStack.push(8);
        queueByStack.push(2);
        queueByStack.push(10);

        int pop1 = queueByStack.pop();
        int pop2 = queueByStack.pop();

        int top1 = queueByStack.top();
        int top2 = queueByStack.top();

        String print = "out: " + pop1 + pop2 + top1 + top2;
        System.out.println(print);
    }
}