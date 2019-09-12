package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test05
 * @Author: wenbai
 * @Description: 剑指offer第5题 替换空格
 * 请实现一个函数 把字符串中的每个空格替换成%20
 * 如：输入"We are happy" 输出"We%20are%20happy"
 * @Date: 2019/9/12 19:26
 * @Version: 1.0
 */
public class Test05 {

    /**
     * 第一反应 调用replace方法 直接替换
     * @param stringBuffer 输入
     * @return 输出
     */
    static String replaceBlank(StringBuffer stringBuffer) {
        if ( stringBuffer == null) {
            return null;
        }
        for (int i = 0; i < stringBuffer.length(); i++) {
            if ( stringBuffer.charAt( i )==' ' ) {
                stringBuffer.replace( i, i+1, "%20" );
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 偷懒得更加彻底 调用replaceAll
     * @param stringBuffer 输入
     * @return 输出
     */
    static String replaceBlank2(StringBuffer stringBuffer) {
        return stringBuffer.toString().replaceAll(" ", "%20");
    }

    /**
     * 先用空格切分成String[] 然后循环相加 中间加上%20
     * 纯属胡闹
     * @param stringBuffer 输入
     * @return 输出
     */
    static String replaceBlank4(StringBuffer stringBuffer) {
        String[] strings = stringBuffer.toString().split(" ");
        StringBuffer result = new StringBuffer(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            result.append("%20");
            result.append(strings[i]);
        }
        return result.toString();
    }

    /**
     * 【原理】
     * 循环计算空格的数量
     * 新建字符串 长度为原字符串长度+空格扩增的长度
     * 两个指针 从后往前遍历并写入
     * @param stringBuffer
     * @return
     */
    static String replaceBlank3(StringBuffer stringBuffer) {
        if ( stringBuffer == null ) {
            return null;
        }
        int spaceNum = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            if ( stringBuffer.charAt( i ) == ' ' ) {
                spaceNum++;
            }
        }
        int oldPoint = stringBuffer.length()-1;
        stringBuffer.setLength( stringBuffer.length() + spaceNum*2 );
        int newPoint = stringBuffer.length()-1;

        while ( oldPoint >= 0 ) {
            if ( stringBuffer.charAt( oldPoint )==' ' ) {
                stringBuffer.setCharAt( newPoint--, '0' );
                stringBuffer.setCharAt( newPoint--, '2' );
                stringBuffer.setCharAt( newPoint--, '%' );
            }else {
                stringBuffer.setCharAt( newPoint--, stringBuffer.charAt( oldPoint ) );
            }
            oldPoint--;
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We are happy");
        System.out.println(replaceBlank(stringBuffer));
        stringBuffer = new StringBuffer("We are happy");
        System.out.println(replaceBlank2(stringBuffer));
        stringBuffer = new StringBuffer("We are happy");
        System.out.println(replaceBlank3(stringBuffer));
        stringBuffer = new StringBuffer("We are happy");
        System.out.println(replaceBlank4(stringBuffer));
    }
}
