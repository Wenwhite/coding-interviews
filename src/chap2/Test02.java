package chap2;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test02
 * @Author: wenbai
 * @Description: 剑指offer第2题 实现单例模式
 * @Date: 2019/9/10 18:59
 * @Version: 1.0
 */
public class Test02 {


    public static void main(String[] args) {
        System.out.println( Singleton1.instance == Singleton1.instance );
        System.out.println( Singleton2.getInstance() == Singleton2.getInstance() );
        System.out.println( Singleton3.instance == Singleton3.instance );
        System.out.println( Singleton4.instance == Singleton4.instance );
        System.out.println( Singleton5.getInstance() == Singleton5.getInstance() );
        System.out.println( Singleton6.getInstance() == Singleton6.getInstance() );
        System.out.println( Singleton7.INSTANCE == Singleton7.INSTANCE );
    }


    /**
     * 单例模式 饿汉式 线程不安全
     */
    public static class Singleton1 {

        private static Singleton1 instance = null;
        private Singleton1() {

        }
        public Singleton1 getInstance(){
            if ( instance == null ) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    /**
     * 单例模式 懒汉式 线程安全
     */
    public static class Singleton2 {
        private final static Singleton2 instance = new Singleton2();
        private Singleton2(){

        }

        public static Singleton2 getInstance(){
            return instance;
        }
    }

    /**
     * 单例模式 饿汉式 线程安全 多线程下效率不高
     */
    public static class Singleton3 {
        private static Singleton3 instance = null;
        private Singleton3(){

        }
        public static synchronized Singleton3 getInstance(){
            if ( instance == null ) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    /**
     * 单例模式 饿汉式 变种 利用静态代码块 线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;
        private Singleton4() {

        }

        static {
            instance = new Singleton4();
        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式 懒汉式 使用静态内部类 线程安全【推荐】
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5 (){

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类 饿汉式 双重校验 代码有点复杂 线程安全【不是很推荐】
     */
    public static class Singleton6 {
        private volatile static Singleton6 instance = null;
        private Singleton6() {

        }

        public static Singleton6 getInstance() {

            if ( instance == null ) {
                synchronized (Singleton6.class) {
                    if ( instance == null ) {
                        instance = new Singleton6();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 静态内部类 枚举 线程安全【推荐(怎么想到的)】
     */
    public enum Singleton7 {
        INSTANCE;
    }


}
