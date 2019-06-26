package sword.chap2;

/**
 * @author wenghengcong
 * @className: SearchMatrix
 * @desc: 搜索二维矩阵
 *
 * @date 2019-06-2419:26
 */
/**
 * 搜索二维矩阵
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 * Lint Code: https://www.lintcode.com/problem/search-a-2d-matrix-ii/description?_from=ladder&&fromId=6
 * 题解：https://www.jiuzhang.cn/solution/search-a-2d-matrix-ii/#tag-highlight
 * 这个矩阵具有以下特性：
 *
 * 每行中的整数从左到右是排序的。
 * 每一列的整数从上到下是排序的。
 * 在每一行或每一列中没有重复的整数。
 *
* */
public class SearchMatrix {

    /*
    * 从左下角开始逐步往右上角移动
    *
    * */
    public static int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix[0].length;   //列的长度
        int n = matrix.length;      //行的长度

        int x = n-1;
        int y = 0;

        int count = 0;  //计数

        while (x >=0 && y < m){
            if (matrix[x][y] < target) {
                y++;
            } else if(matrix[x][y] > target) {
                x--;
            } else {
                x--;
                y++;
                count += 1;
            }
        }
        return count;
    }
}
