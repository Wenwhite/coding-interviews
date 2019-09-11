package chap2;

import java.util.HashMap;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test03
 * @Author: wenbai
 * @Description: 剑指offer第3题 数组中的重复数字
 * 在一个长度为n的数组里 所有数字都在0~n-1的范围内
 * 数组中某些数字是重复的 但不知道有几个数字重复了，也不知道重复了几次
 * 请找出数组中任意一个重复的数字
 * @Date: 2019/9/10 20:18
 * @Version: 1.0
 */
public class Test03 {

    /**
     * 第一想法 直接用一个HashMap 将每一个数都当成key存进去 在存之前先判断 如果已存在 则说明有重复数字
     * @param numbers 输入的数组
     * @param length 数组的长度 numbers.length
     * @param duplication 用来存储重复的数字 duplication[0]
     * @return 是否有重复的数字
     */
    public static boolean duplicate1(int numbers[], int length, int[] duplication) {
        if ( numbers == null || length == 0 ) {
            return false;
        }
        HashMap hashMap = new HashMap(16);
        for (int i = 0; i < length; i++) {
            if ( hashMap.containsKey( numbers[i] ) ) {
                duplication[0] = numbers[i];
                return true;
            }else {
                hashMap.put(numbers[i], 1);

            }
        }
        return false;
    }

    /**
     * 已知数字都在0~n-1范围内 那么如果没有重复 通过排序之后 数字i应该出现在下标为i的位置 
     * 如果有重复的数字 有些位置可能存在多个数字 有些位置可能没有数字
     * 
     * 对数组进行排序 从头到尾依次扫描么一个数字 当扫描到下标为i的数字时 首先比较这个数字m是否等于i 
     * 如果等于 继续扫描下一个
     * 如果不等于 则将它和下标为m的数字进行比较
     * 如果相等 成功找到相同数字
     * 如果不相等 就让m和下标为m的数字交换顺序 将m放到属于它的位置上去 然后重复
     * 直至找到重复数字
     * @param numbers 输入的数组
     * @param length 数组长度
     * @param duplication 返回的数组 [0]记录重复数字
     * @return 是否有重复数字
     */
    public static boolean duplicate2(int numbers[], int length, int[] duplication) {
        if ( numbers == null || length == 0 ) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if ( numbers[i] < 0 || numbers[i] > length ) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while ( numbers[i] != i ) {
                if ( numbers[i] == numbers[numbers[i]] ) {
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return false;
    }

    private static void swap( int[] numbers, int p, int q ) {
        int temp = numbers[p];
        numbers[p] = numbers[q];
        numbers[q] = temp;
    }


    public static void main(String[] args) {
        int[] duplication1 = new int[1];
        int[] duplication2 = new int[1];
        int[] numbers = new int[]{1,2,3,4,5,5,6,6};
        boolean result1 = duplicate1(numbers, 8, duplication1);
        if (result1) {
            System.out.println(duplication1[0]);
        }
        boolean result2 = duplicate2(numbers, 8, duplication2);

        if (result2) {
            System.out.println(duplication2[0]);
        }
    }




}
