package day11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName GraphicTest
 * @Description Stream API 快速完成对象的排序
 * @Author zc-cris
 * @Version 1.0
 **/
public class GraphicTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入名字：");
        char s = scanner.nextLine().charAt(0);
        if (s == 'a') {
            System.out.println("000000000");
        }else {
            System.out.println("s = " + s);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("cris");
        System.out.println("list = " + list);
        String remove = list.remove(0);
        System.out.println("list = " + list);


    }

    @Test
    public void test() {
        Circle g = new Circle((double) 4);
        Rectangle g1 = new Rectangle(3.0, 4.0);
        Triangle g2 = new Triangle(3.0, 4.0, 5.0);
        printArea(g);
        printArea(g1);
        printArea(g2);

        List<Graphic> collect = Stream.of(g, g1, g2).sorted(Comparator.comparingDouble(x -> x.getArea())).collect(Collectors.toList());
        collect.forEach(x -> System.out.println(x.getArea() + "---"));
    }

    public static void printArea(Graphic g) {
        System.out.println("g.getArea() = " + g.getArea());

    }
}
