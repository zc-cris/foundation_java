package day16;

/**
 * 测试lambda 表达式以及函数式接口 代替匿名内部类
 *
 * @author zc-cris
 * @version 1.0
 **/
public class Test01 {
    public static void main(String[] args) {
        func(() -> System.out.println("宝马"));
    }

    public static void func(Car car) {
        car.fun();
    }
}

@FunctionalInterface
interface Car {
    /**
     * 功能型接口
     */
    void fun();
}
