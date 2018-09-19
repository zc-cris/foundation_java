package com.cris.bean;

import org.junit.Test;

/**
 * @ClassName ProgrammerTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ProgrammerTest {

    @Test
    public void test() {
        Programmer programmer = new Programmer(1, "james", 23, 333.30, new Equipment("小米", "笔记本"));
        System.out.println("employee = " + programmer);

        Designer designer = new Designer(1, "cris", 24, 34.34, new Equipment("苹果", "笔记本"), 88.88);
        System.out.println("designer = " + designer);

        Architect architect = new Architect(3, "思密达", 25, 432.23, new Equipment("华硕", "游戏本"), 88.88, 243);
        System.out.println("architect = " + architect);

    }
}
