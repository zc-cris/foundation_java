package day19;

import java.util.Arrays;

/**
 * test myLinkedList
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("cris");
        myLinkedList.add("james");
        myLinkedList.add(null);
        myLinkedList.remove("cris");
        Arrays.stream(myLinkedList.toArray()).forEach(System.out::println);
        System.out.println("myLinkedList.count() = " + myLinkedList.count());



//        System.out.println("myLinkedList.get(1) = " + myLinkedList.get(2));


      /*  myLinkedList.add("cris");
        myLinkedList.add("cris");
        Arrays.stream(myLinkedList.toArray()).forEach(System.out::println);
        System.out.println("myLinkedList.count() = " + myLinkedList.count());*/

    }
}
