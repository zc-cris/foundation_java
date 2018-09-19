package com.java.study03;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @ClassName Test7
 * @Description 使用lambda+Stream API 完成二维数组的平均分统计
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test7 {

    private static int number;
    private static int hangshu;
    private static int renshu;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入小组数：");
        hangshu = scanner.nextInt();
        int[][] array = new int[hangshu][];
        for (int i = 0; i < array.length; i++) {
            System.out.println("请输入第" + (i + 1) + "小组的人数");
            number = scanner.nextInt();
            renshu += number;
            array[i] = new int[number];
        }
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                System.out.println("请输入第" + (i + 1) + "组第" + (i1 + 1) + "个同学的成绩");
                array[i][i1] = scanner.nextInt();
            }
        }
        Stream<int[]> stream = Arrays.stream(array);
        Optional<Integer> reduce = stream.map(x -> {
            return Arrays.stream(x).reduce(Integer::sum).getAsInt();
        }).reduce(Integer::sum);
        double v = reduce.get() / (double) (renshu);
        System.out.println("v = " + v);


    }

    public static void test() {
        Integer[][] a = new Integer[3][4];
        Stream<Integer> integerStream = Arrays.stream(a).flatMap(Arrays::stream);
    }
}
