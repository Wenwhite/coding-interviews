package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test10_2
 * @Author: wenbai
 * @Description: 剑指offer第10题 2 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶 也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有几种跳法
 * @Date: 2019/9/17 11:32
 * @Version: 1.0
 */
public class Test10_2 {

    /**
     * f(1) = 1,f(2)=2
     * f(3) = f(1) + f(2)
     * f(n) = f(n-1) + f(n-2)
     * 斐波那契数列
     * @param n
     * @return
     */
    static long jump(int n) {
        int a = 1;
        int b = 2;
        while (n > 1) {
            b = a + b;
            a = b - a;
            n--;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(jump(3));
    }
}
