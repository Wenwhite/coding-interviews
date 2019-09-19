package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test11
 * @Author: wenbai
 * @Description: 剑指offer第11题 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 * 例如：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小元素为1
 * @Date: 2019/9/17 20:34
 * @Version: 1.0
 */
public class Test11 {

    /**
     * 个人思路 已知原数组为递增数组 经过旋转后 将开头的若干元素搬到数组末尾
     * 故遍历数组 当numbers[i] > numbers[i+1]时 则i+1项为最小元素
     * @param numbers 数组
     * @return 最小元素
     */
    static int min(int[] numbers) {

        if ( numbers!=null && numbers.length!=0 ) {
            int result = numbers.length-1;
            for (int i = 0; i < numbers.length-1; i++) {
                if ( numbers[i] > numbers[i+1] ) {
                    result = numbers[i+1];
                    break;
                }
            }
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        int numbers[] = new int[]{3,4,5,1,2};
        System.out.println(min(numbers));

    }

    
}
