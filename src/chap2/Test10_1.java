package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test10_1
 * @Author: wenbai
 * @Description: 剑指offer第10题 1 求斐波那契数列的第n项
 * 写一个函数，输入n，求斐波那契(Fibonacci)数列的第n项
 * @Date: 2019/9/17 10:53
 * @Version: 1.0
 */
public class Test10_1 {

    /**
     * 递归解法(不推荐)
     * 效率太慢
     * @param n
     * @return
     */
    static long fibonacci1(int n) {
        if ( n < 2 ) {
            return n;
        }
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

    /**
     * 迭代法(推荐)
     * 看上去很傻 但是实用
     * @param n
     * @return
     */
    static long fibonacci2(int n) {
        long a = 0;
        long b = 1;
        while ( n > 0 ) {
            b = a + b;
            a = b - a;
            n--;
        }
        return a;
    }

    public static void main(String[] args) {
        long start1 = System.nanoTime();
        System.out.print(fibonacci1(40));
        long end1 = System.nanoTime();
        System.out.println(" time:"+(end1-start1)+"ns");
        long start2 = System.nanoTime();
        System.out.print(fibonacci2(40));
        long end2 = System.nanoTime();
        System.out.println(" time:"+(end2-start2)+"ns");

    }

}
