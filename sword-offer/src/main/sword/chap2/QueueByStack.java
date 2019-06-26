package sword.chap2;


import java.util.Stack;

/**
 * @author wenghengcong
 * @className: QueueByStack
 * @desc:
 * @date 2019-06-2420:00
 */

/**
* 用栈实现队列
* 正如标题所述，你需要使用两个栈来实现队列的一些操作。
* 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
* pop和top方法都应该返回第一个元素的值。
* Lint Code : https://www.lintcode.com/problem/implement-queue-by-two-stacks/description?_from=ladder&&fromId=6
* 题解：https://www.jiuzhang.cn/solution/implement-queue-by-two-stacks/
* */
public class QueueByStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        return stack1.peek();
    }

}
