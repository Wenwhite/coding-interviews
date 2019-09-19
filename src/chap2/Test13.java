package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test13
 * @Author: wenbai
 * @Description: 剑指offer第13题 机器人的运动范围
 * 地上有一个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，
 * 它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，k=18时，机器人能够进入方格(35,37)，因为3+5+3+7=18。但是不能进入方格(35,38)，因为3+5+3+8=19>18
 * 请问机器人能够到达多少格子：
 * @Date: 2019/9/19 10:41
 * @Version: 1.0
 */
public class Test13 {


    static int moveCount(int threadholdValue, int rows, int cols) {
        if ( rows <=0 || cols <=0 ||threadholdValue <0 ) {
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];
        int result = countCore(threadholdValue, 0, 0, rows, cols, visited);
        return result;
    }

    /**
     * 回溯法类似于穷举，每进入一个格就把这个格的前后左右格能够访问的格子数加起来
     * @param threadholdValue 阈值
     * @param row 行数
     * @param col 列数
     * @param rows 总行数
     * @param cols 总列数
     * @param visited
     * @return
     */
    private static int countCore(int threadholdValue, int row, int col, int rows, int cols, boolean[][] visited) {
        int count = 0;
        if ( check(threadholdValue, row, col, rows, cols, visited) ) {
            visited[row][col] = true;
            count = countCore(threadholdValue, row-1, col, rows, cols, visited) +
                    countCore(threadholdValue, row+1, col, rows, cols, visited) +
                    countCore(threadholdValue, row, col+1, rows, cols, visited) +
                    countCore(threadholdValue, row, col+1, rows, cols, visited) + 1;
        }
        return count;
    }

    /**
     * 判断是否能够进入方格
     * @param threadholdValue 阈值
     * @param rows 总行数
     * @param cols 总列数
     * @param row 行数
     * @param col 列数
     * @param visited
     * @return
     */
    private static boolean check(int threadholdValue, int row, int col, int rows, int cols, boolean[][] visited){
        return row >=0 && row <rows &&
                col >=0 && col < cols &&
                !visited[row][col] && digitSum(row)+digitSum(col) <= threadholdValue;
    }


    /**
     * 计算各数位的和
     * @param number
     * @return
     */
    private static int digitSum(int number) {
        int result = 0;
        while ( number > 0 ) {
            result += number%10;
            number = number/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(moveCount(18, 40, 40));
    }

}
