package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test12
 * @Author: wenbai
 * @Description: 剑指offer第12题 矩阵中的路径
 * 请设计一个函数 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中上、下、左、右移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再进入该格子。
 * 例如下面矩阵：
 * a b t g
 * c f c s
 * j d e h
 * 包含字符串"bfce"的路径 但是不包含"abfb"路径
 * @Date: 2019/9/19 9:02
 * @Version: 1.0
 */
public class Test12 {

    /**
     * 利用【回溯法】 判断path是否在二维数组matrix中
     * @param path 被判断字符
     * @param matrix 二维数组
     * @return 是否存在
     */
    static boolean containPath( String path, char[][] matrix ) {
        if ( path==null || matrix == null ) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //用来记录查找到字符串的第几个字符
        int pathLength = 0;
        //二维数组 记录哪些格子已经走过
        boolean[][] visited = new boolean[rows][cols];
        //从矩阵的每一个元素为开头进行遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ( contains( path, matrix, i, j, pathLength, visited ) ){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯法 通过递归进行判断
     * @param path
     * @param matrix
     * @param row
     * @param col
     * @param pathLength
     * @param visited
     * @return
     */
    private static boolean contains( String path, char[][] matrix, int row, int col, int pathLength, boolean[][] visited ) {
        boolean hasContain = false;

        if ( pathLength == path.length() ){
            return true;
        }


        if ( row >= 0 && row < matrix.length &&
                col >= 0 && col < matrix[0].length &&
                matrix[row][col] == path.charAt(pathLength) && !visited[row][col]) {

            visited[row][col] = true;
            ++pathLength;
            hasContain = contains(path, matrix, row-1, col, pathLength, visited) ||
                    contains(path, matrix, row, col-1, pathLength, visited) ||
                    contains(path, matrix, row, col+1, pathLength, visited) ||
                    contains(path, matrix, row+1, col, pathLength, visited);

            if ( !hasContain ) {
                visited[row][col] = false;
                --pathLength;
            }
        }
        return hasContain;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][]{
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        char[][] matrix1 = new char[][]{
                {'a', 'b', 't', 'g'}
        };
        char[][] matrix2 = new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}
        };
        String path1 = "bfce";
        String path2 = "abfb";
        String path3 = null;
        String path4 = "abtg";
        String path5 = "aaaa";
        System.out.println(containPath(path1, matrix));
        System.out.println(containPath(path2, matrix));
        System.out.println(containPath(path3, matrix));
        System.out.println(containPath(path4, matrix1));
        System.out.println(containPath(path5, matrix2));

    }

}
