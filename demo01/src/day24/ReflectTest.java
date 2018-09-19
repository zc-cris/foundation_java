package day24;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class ReflectTest {
    @Test
    public void test() throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = systemClassLoader.loadClass("java.lang.String");
        Class<String> clazz2 = String.class;
        Class<? extends String> clazz3 = "".getClass();
        Class<?> clazz4 = Class.forName("java.lang.String");
        System.out.println("(clazz4==clazz) = " + (clazz4 == clazz));
        System.out.println("(clazz3==clazz) = " + (clazz3 == clazz));
        System.out.println("(clazz2==clazz) = " + (clazz2 == clazz));
    }

    @Test
    public void test2() {
        System.out.println("true = ");
    }

}
