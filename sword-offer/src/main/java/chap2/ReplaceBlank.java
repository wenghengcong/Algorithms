package chap2;

/*
* 空格替换
* https://www.lintcode.com/problem/space-replacement/description
*
* 设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。

你的程序还需要返回被替换后的字符串的长度。
* */
public class ReplaceBlank {

    public static int numberOfBlank(char[] string) {
        if (string.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < string.length; i++) {
            if(string[i] == ' ')
                count++;
        }
        return count;
    }

    public static int replaceBlank(char[] string, int length) {
        if (string == null) return 0;
        int count = numberOfBlank(string);
        int i = length - 1, j = length + 2 * count - 1;
        while(i < j) {
            if(string[i] != ' ') {
                string[j] = string[i];
                i--;
                j--;
            } else {
                string[j] = '0';
                string[j-1] = '2';
                string[j-2] = '%';
                j = j - 3;
                i--;
            }
        }
        return length + 2 * count;
    }
}
