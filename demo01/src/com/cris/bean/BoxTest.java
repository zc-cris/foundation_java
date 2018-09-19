package com.cris.bean;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {

    private Box box = new Box(4.0,5.0,3.0);

    @Test
    public void getVolume() {
        Double volume = box.getVolume();
        System.out.println("volume = " + volume);
    }

    @Test
    public void getInfo() {
        String info = box.getInfo();
        System.out.println("info = " + info);
    }
}