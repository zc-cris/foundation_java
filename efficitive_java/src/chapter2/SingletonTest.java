package chapter2;

/**
 * @ClassName SingletonTest
 * @Description test singleton class
 * @Author zc-cris
 * @Version 1.0
 **/
public class SingletonTest {
    public static void main(String[] args) {
        Toy instance = Toy.INSTANCE;
        Toy instance1 = Toy.INSTANCE;
        System.out.println("(instance1 ==instance =) " + (instance1 ==instance));

        Sun instance2 = Sun.INSTANCE;
        Sun instance3 = Sun.INSTANCE;
        System.out.println("(instance3==instance2) = " + (instance3==instance2));
    }
}
/**
 * @Author zc-cris
 * @Description first method to complete Singleton class
 * @Param
 * @return
 **/
class Toy {
    public static final Toy INSTANCE = new Toy();

    private Toy() {
    }

    public void play() {
        System.out.println("好玩的玩具");
    }

}

/**
 * @Author zc-cris
 * @Description second method to complete Singleton class
 * @Param
 * @return
 **/
class Singleton{
    private static final Singleton SINGLETON = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return SINGLETON;
    }
}
/**
 * @Author zc-cris
 * @Description third method to complete Singleton class
 * @Param
 * @return
 **/
enum Sun{
    /**
     * @Author zc-cris
     * @Description 单例
     * @Param
     * @return
     **/
    INSTANCE

}