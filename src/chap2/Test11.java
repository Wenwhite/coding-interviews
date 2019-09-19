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
     * 复杂度O(n)
     * 个人思路 已知原数组为递增数组 经过旋转后 将开头的若干元素搬到数组末尾
     * 故遍历数组 当numbers[i] > numbers[i+1]时 则i+1项为最小元素
     * @param numbers 数组
     * @return 最小元素
     */
    static int min1(int[] numbers) {

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

    /**
     * 复杂度O(logn)【推荐】
     * 利用旋转数组的特性 类似于二分查找 前后两组递增数组 最小项为第二组数组的第一个元素
     * 两个指针index1和index2分别指向0和length-1 判断中间的元素a的大小
     * 若numbers[index1] < numbers[a] 则说明a项还在前一个递增数组内 此时将index1指向a 继续
     * 若numbers[index2] > numbers[a] 则说明a项还在后一个递增数组内 此时将index2指向a 继续
     * 直到index2-index1==1时，此时index1在第一个数组最后一项 index2在第二个数组第一项
     * 最小值为numbers[index2]
     * @param numbers 数组
     * @return 数组最小值
     */
    static int min2(int[] numbers) {
        if ( numbers!=null && numbers.length != 0 ) {

            int index1 = 0;
            int index2 = numbers.length-1;
            int indexMin = 0;
            while ( numbers[index1] > numbers[index2] ) {
                if ( index2-index1 == 1 ) {
                    indexMin = index2;
                    break;
                }
                indexMin = (index1+index2)/2;
                if ( numbers[index1] <= numbers[indexMin] ) {
                    index1 = indexMin;
                }else if ( numbers[index2] >= numbers[indexMin] ) {
                    index2 = indexMin;
                }
            }
            return numbers[indexMin];
        }
        return 0;

    }

    public static void main(String[] args) {
        int numbers[] = new int[]{3,4,5,1,2};
        System.out.println(min1(numbers));
        System.out.println(min2(numbers));
    }

    
}
