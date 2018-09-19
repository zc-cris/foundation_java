package com.java.object05;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zc-cris
 */
public class PersonTest {

    @Test
    public void test1() {
        Person[] persons = {new Person(12, "cris", new Car("宝马", 23.0, 1)),
                new Person(23, "james", new Car("法拉利", 290.90, 3))};
        for (Person person : persons) {
            System.out.println("person = " + person);
        }
    }
}