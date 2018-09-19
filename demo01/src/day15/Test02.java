package day15;


import com.java.object05.Person;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(new Outer());
        myClass.fun();
    }
}

class Outer {
    abstract class Inner {
        abstract void fun();
    }
}

class MyClass extends Outer.Inner {

    MyClass(Outer outer) {
        outer.super();
    }

    @Override
    void fun() {
        System.out.println("myclass...." );
    }
}

