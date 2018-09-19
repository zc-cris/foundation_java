package day19;

import java.util.Arrays;

/**
 * check myArrayList is ok ?
 *
 * @author zc-cris
 * @version 1.0
 **/
public class MyArrayListTest {
    public static void main(String[] args) throws NoSuchFieldException {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("james");
        myArrayList.add("cris");
        myArrayList.add("harden");
        myArrayList.add(null);


        /*myArrayList.set(2,"思密达");
        Arrays.stream(myArrayList.toArray()).forEach(System.out::println);*/

        /*myArrayList.insert(1,4);
        Arrays.stream(myArrayList.toArray()).forEach(System.out::println);*/

        /*Object o = myArrayList.get(3);
        System.out.println("o = " + o);*/

     /*   myArrayList.remove(2);
        Arrays.stream(myArrayList.toArray()).forEach(System.out::println);*/

        /*myArrayList.remove("cris");
        Arrays.stream(myArrayList.toArray()).forEach(System.out::println);*/


       /* boolean result = myArrayList.contains(null);
        System.out.println("result = " + result);*/

        /*int cris = myArrayList.indexOf("cris");
        System.out.println("cris = " + cris);*/

/*        for (int i = 0; i < 20; i++) {
            myArrayList.add(i);
        }
        System.out.println("myArrayList.size = " + myArrayList.size());
        System.out.println("myArrayList.capacity = " + myArrayList.capacity());
        Object[] objects = myArrayList.toArray();
        for (Object object : objects) {
            System.out.println("object = " + object);
        }*/

    }
}
