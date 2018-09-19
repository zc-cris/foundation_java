package day13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test01 {

    int a = 0;
    int b = 1;
    public void get(){
        a = 4;
        b = 6;
    }

    public static void main(String[] args) {

        long round = Math.round(-11.5);
        System.out.println("round = " + round);
        long round1 = Math.round(11.5);
        System.out.println("round1 = " + round1);

        Integer integer = Integer.valueOf("3");
        int i = Integer.parseInt("5");
        System.out.println("i = " + i);
        System.out.println("integer = " + integer);

        double a = 0.5;
        double b = 0.5;
        System.out.println("(a==b) = " + (a == b));

        new C().printX();

        int test = test(3, 5);
        System.out.println("test = " + test);

        Integer[] integers = {1,2,3,4};
        int[] ints = {1,2};
        List<int[]> list = Arrays.asList(ints);
        System.out.println("list.size() = " + list.size());
        System.out.println("list = " + list);

        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("sum = " + sum);

    }
    public static int test(int x, int y){
        int result = x;
        try{
            if(x<0 || y<0){
                return 0;
            }
            result = x + y;
            return result;
        }finally{
            result = x - y;
        }
    }


}
class A{
    int x = 1;
}
interface B{
    int X = 1;
}
class C extends A implements B{
    public void printX(){
        System.out.println("x = " + x);
    }
}
