package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test14
 * @Author: wenbai
 * @Description: 剑指offer第14题 剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成m段(n>1,m>1，n、m为整数)
 * 每段绳子的长度记为k[0]，k[1]，...k[m]，请问k[1]*k[2]*...*k[m]可能的最大乘积是多少？
 * 例如：当绳子的长度是8时，我们把它剪成长度分别为2 3 3三段，此时得到的最大乘积是18
 * @Date: 2019/9/19 13:33
 * @Version: 1.0
 */
public class Test14 {

    /**
     * 【动态规划版本】
     * 首先定义函数f(n)为把长度为n的绳子剪成若干段后各段长度乘积的最大值。
     * 在剪第一刀时，有n-1种选择，也就是可能剪出来的长度为1，2，..，n-1。
     * 因此f(n) = max(f(i)*f(n-i)) 0<i<n 这是一个从上到下的递归 可以改成从下到上的循环
     * f(2) = 1,f(3) = max(2*1,1*1*1)=2,f(4) = 2,
     * @param length 绳子长度
     * @return
     */
    static int maxProductAfterCutting1(int length){
        if ( length < 2 ) {
            return 0;
        }
        if ( length == 2 ) {
            return 1;
        }
        if ( length == 3 ) {
            return 2;
        }
        // 加1是因为需要访问到products[length]
        int[] products = new int[length+1];

        for (int i = 0; i <= 3; i++) {
            products[i] = i;
        }

        int max = 0;
        // 从products[4]到products[length]放的是f(4)~f(n)的值
        for (int i = 4; i <= length; i++) {
            max = 0;
            // 对所有相乘情况进行遍历求出f(i)的最优解
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if (max < product) {
                    max = product;
                }
                // 得到f(i)的最优解
                products[i] = max;
            }
        }
        // 返回f(n)
        max = products[length];
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting1(8));
    }

}
