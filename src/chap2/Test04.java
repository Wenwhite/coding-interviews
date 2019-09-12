package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test04
 * @Author: wenbai
 * @Description: 剑指offer第4题 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增，每一列都按照从上到下递增。
 * 完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否含有该整数
 * @Date: 2019/9/12 16:26
 * @Version: 1.0
 */
public class Test04 {

    /**
     * 【推荐做法】
     * 从二维数组的右上角(换成左上角也可以)开始遍历
     * 如果相等 说明存在 返回true
     * 如果大于右上角的数 则说明大于该行所有数 去掉该行 将剩下的数组继续遍历右上角
     * 如果小于右上角的数 则说明小于该列所有数 去掉该列 将剩下的数组继续遍历
     * @param matrix 二维数组
     * @param rows 行数
     * @param columns 列数
     * @param number 待查找的数字
     * @return 是否存在
     */
    static boolean find( int[][] matrix, int rows, int columns, int number ) {

        boolean result = false;
        if ( matrix != null && rows > 0 && columns > 0 ) {
            int row = 0;
            int column = columns - 1;
            while ( row < rows && column >= 0 ) {
                if ( matrix[row][column] == number ) {
                    result = true;
                    break;
                }else if ( matrix[row][column] > number ) {
                    column--;
                }else if ( matrix[row][column] < number ) {
                    row++;
                }
            }
        }
        return result;
    }

    /**
     * 自己的想法 每一行都是顺序数组 可以循环遍历每一行 用二分法
     * 一次二分查找操作复杂度是O(lg columns)
     * 总复杂度应该是O(rows lg columns)
     *
     * 注：因为从第一行开始往下进行 而由于每一列从上往下逐渐递增
     * 所以如果待查找数小于数组中被比较的数 则可以直接舍弃该列的所有数 下一行无需全部比较完
     * @param matrix
     * @param rows
     * @param columns
     * @param number
     * @return
     */
    static boolean find2( int[][] matrix, int rows, int columns, int number ) {
        boolean result = false;
        if ( matrix != null && rows > 0 && columns > 0 ) {
            int high = columns-1;
            for (int i = 0; i < rows; i++) {
                int low = 0;
                while ( low <= high ) {
                    int mid = low + (high - low)/2;
                    if ( matrix[i][mid] == number) {
                        result = true;
                        return result;
                    }else if ( matrix[i][mid] > number ) {
                        high = mid-1;
                    }else {
                        low = mid+1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] numbers = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        int number = 7;
        boolean result = find(numbers, numbers.length, numbers[0].length, number);
        System.out.println(result);
        result = find2(numbers, numbers.length, numbers[0].length, number);
        System.out.println(result);
    }

}
