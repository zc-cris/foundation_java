package day17;

/**
 * TODO
 *
 * @author zc-cris
   * @version 1.0
 **/
@SuppressWarnings("unused")
public class Singleton {

    public static final Singleton SINGLETON = new Singleton();

    private Singleton() {
    }
}

@SuppressWarnings("ALL")
class Singleton2 {
    private static Singleton2 singleton2;

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    private Singleton2() {
    }

    ;


}


