package chap2;

/*
* https://www.lintcode.com/problem/count-1-in-binary/description?_from=ladder&&fromId=6
* 计算在一个 32 位的整数的二进制表示中有多少个 1。
*
* 挑战 如果整数有 n 位，并且有 m 位个 1。你能在 O(m) 的时间内解决它吗？
* 该问题是：Hamming weight，https://en.wikipedia.org/wiki/Hamming_weights
* 正整数的更多解法：http://javabypatel.blogspot.com/2017/01/count-set-bits-in-number-java.html
* */
public class HammingWeight {

    /*
    * http://www.runoob.com/java/java-basic-datatypes.html
    * 复习：byte 8,short 16,int 32, long 64,float 32, double 64,boolean 1,char 16
    * 注意：int是32位，其取值范围：-2^31 ~ 2^31，有符号数是用补码表示的。
    * 补码：最高位是符号位，正数为0，负数为1。
    * 正整数的补码是正整数本身，负整数=负整数的绝对值+1
    * */

    /*
    * 速度快
    * 每一次num &= num - 1会使得num最低位的1变为0。
    * 例如12二进制表示为000...0001100(后面省略高位0)，11的二进制表示为1011，1100 & 1011 = 1000. 即 1100 -> 1000，最低位的1变成了0，被抹去。
    * 注意到了吗，减1后，最低位的1变成了0，而最低位的1后面的0全变成了1，高位不变。
    * 这样和原数按位与之后得到的结果与原数对比，就是原数最低位的1被抹去了。
    * 所以该过程循环了多少次，就说明抹掉了多少个1。这对于其余正整数也是适用的。
    *
    * 对于整数如上，那么负数呢？
    * -12，首先其表示为：100000....00000100。补码表示：即最高位为1，剩下部分为1100，取反+1，即0011+1，为0100。
    * 最后表示为10000000.....0100
    * */
    public static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    /*
    * 用1不断左移，每次和num做按位与看是否为0，不是0的话说明这一位是1。左移32次后停止。
    * */
    public static int countOnesSecond(int num) {
        // write your code here
        int count = 0;
        while (num != 0) {
            if( (num&1) == 1) {
                count ++;
            }
            num = num >>> 1;    //无符号右移
        }
        /*
        or
        if(number % 2 == 1 ){
             count++;
        }
        number = number / 2;
         */
        return count;
    }

}
