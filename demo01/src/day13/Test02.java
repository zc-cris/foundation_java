package day13;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        Zi zi = new Zi();
    }
}

class Fu {

    private static int k = getNum();

    public static int getNum() {
        k++;
        System.out.println("k = " + k);
        return k;
    }

    private int i = test();

    {
        i++;
        System.out.println("i = " + i);
    }

    Fu() {
        System.out.println("父类的无参构造函数");

    }

    public int test() {
        System.out.println("i=" + i);
        i++;
        return i;
    }
}

class Zi extends Fu {

    private static int m = getNum();

    public static int getNum() {
        m++;
        System.out.println("m = " + m);
        return m;
    }

    private int j = test();

    {
        j++;
        System.out.println("j = " + j);
    }

    Zi() {
        System.out.println("子类的无参构造函数");
        System.out.println("j = " + j);
    }

    @Override
    public int test() {
        System.out.println("j=" + j);
        j++;
        return j;
    }

}
