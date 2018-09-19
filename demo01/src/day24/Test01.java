package day24;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class Test01 {
    @Test
    public void test() {
        System.out.println("true = " + true);

    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 用钱买笔，各自种类的数量组合
     * @Param []
     **/
    @Test
    public void calculatePencil() {

        for (int a = 0; a < 34; a++) {
            for (int b = 0; b < 50; b++) {
                for (int c = 0; c < 200; c++) {
                    if (3 * a + 2 * b + 0.5 * c == 100 && a + b + c == 100) {
                        System.out.println("c = " + c);
                        System.out.println("b = " + b);
                        System.out.println("a = " + a);
                    }
                }
            }

        }

    }

    /**
     * @return int
     * @Author zc-cris
     * @Description 斐波拉契数列的双递归实现
     * @Param [n]
     **/
    private static int feibolaqi(int index) {
        return index >= 2 ? feibolaqi(index - 1) + feibolaqi(index - 2) : 1;
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 计算球多次弹地的高度和经过的总距离
     * @Param [height, times]
     **/
    private static void calculateHeight(double height, int times) {
        double distance = 0;
        for (int i = 0; i < times; i++) {
            distance += height;
            height = height - height / 2;
            distance += height;
        }
        System.out.println("第" + times + "次反弹后的高度为：" + height);
        System.out.println("第" + times + "次落地时共经过：" + (distance - height) + "米");

    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 求指定数组的左边之和等于右边之和的索引
     * @Param [array]
     **/
    private static void calculateNum(int[] array) {
        if (array.length < 3) {
            System.out.println("数组长度小于3，无法计算");
            return;
        }
        IntStream.rangeClosed(1, array.length - 1).filter(x -> {
            int leftResult = 0;
            int rightResult = 0;
            for (int i = 0; i < x; i++) {
                leftResult += array[i];
            }
            for (int i = x + 1; i < array.length; i++) {
                rightResult += array[i];
            }
            if (leftResult == rightResult) {
                return true;
            }
            return false;
        }).forEach(x -> System.out.println("满足条件的索引有：" + x));
    }

    /**
     * @return int
     * @Author zc-cris
     * @Description 二分查找指定字符索引
     * @Param [chars, key, low, high]
     **/
    private static int getIndex(char[] chars, char key, int low, int high) {
        if (low > high || key > chars[high] || key < chars[low]) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (key == chars[middle]) {
            return middle;
        } else if (key > chars[middle]) {
            return getIndex(chars, key, middle + 1, high);
        } else {
            return getIndex(chars, key, low, middle - 1);
        }
    }

    @Test
    public void getAge2() {
        Integer integer = Stream.iterate(10, x -> x + 2).skip(7).findFirst().get();
        System.out.println("integer = " + integer);
    }

    @Test
    public void getAge() {
        int reduce = IntStream.rangeClosed(2, 8).reduce(10, (a, b) -> b = a + 2);
        System.out.println("reduce = " + reduce);
    }

    @Test
    public void getAge3Test() {
        Test01 test01 = new Test01();
        int age3 = test01.getAge3(8);
        System.out.println("age3 = " + age3);

    }

    public int getAge3(int num) {
        return num > 1 ? (2 + getAge3(num - 1)) : 10;
    }

    /**
     * @return boolean
     * @Author zc-cris
     * @Description 判断质数
     * @Param [i]
     **/
    private static boolean isPrime(int i) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(i))).noneMatch(x -> i % x == 0);
    }


    /**
     * @return void
     * @Author zc-cris
     * @Description 打印等腰三角形
     * @Param [n]
     **/
    private static void func4(int n) {
        IntStream.rangeClosed(1, n).forEach(x -> {
            for (int i = 0; i < n - x; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < 2 * x - 1; i++) {
                System.out.print("*");
            }
            System.out.println();
        });
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 快速求和
     * @Param [x]
     **/
    private static void func3(int x) {
        OptionalInt reduce = IntStream.rangeClosed(1, x).reduce(Integer::sum);
        int sum = IntStream.rangeClosed(1, x).sum();
        System.out.println("sum = " + sum);
        System.out.println("reduce.getAsInt() = " + reduce.getAsInt());
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 快速求相邻阶乘之和
     * @Param []
     **/
    private static void func2() {
        long sum = LongStream.rangeClosed(1, 20).map(x -> {
            return LongStream.rangeClosed(1, x).reduce(1, (a, b) -> a * b);
        }).sum();
        System.out.println("sum = " + sum);
    }

    private static void maoPaoSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }
    }

    private static void maoPaoSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    array[j] = array[j] ^ array[j - 1];
                    array[j - 1] = array[j] ^ array[j - 1];
                    array[j] = array[j] ^ array[j - 1];

                }
            }
        }
    }

    private static void xuanzeSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }

            }
        }
    }

    private static void xuanzeSort2(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }
            }
        }
    }

    private static void charuSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                    i = j;
                }
            }
        }
    }

    private static void charuSort2(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                    i = j;
                }
            }
        }
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 快速求和
     * @Param []
     **/
    private static void func1() {
        int sum = IntStream.iterate(1, x -> x < 100, x -> x + 2).sum();
        System.out.println("sum = " + sum);
    }

    @Test
    public void test14() {
        Test01 test01 = new Test01();
        long num = test01.getNum(10);
        System.out.println("num = " + num);
    }

    public long getNum(int i) {
        return i > 5 ? i + getNum(i - 1) : 15;
    }

    @Test
    public void test11() {
        int num = 98765;
        String s = String.valueOf(num);
        s = new StringBuilder(s).reverse().toString();
        System.out.println("string = " + s);
    }

    @Test
    public void test12() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 5, 6, 1, 9, 3, 25, 4);
        Set<Integer> set = new HashSet<>(list);
        System.out.println("set = " + set);
    }

    @Test
    public void test13() {
        String string = "中中国55kkfff";
        char[] chars = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            if (map.containsKey(ch)) {
                Integer integer = map.get(ch);
                map.put(ch, integer + 1);
            } else {
                map.put(ch, 1);
            }
        }
        map.forEach((k, v) -> System.out.println(String.format("k=%c,v=%d", k, v)));
    }

}



