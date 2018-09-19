package com.cris.bean;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName BookTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class BookTest {

    @Test
    public void test(){
        Book[] books = new Book[3];
        books[0] = new Book(1,"金瓶梅","崔章见",8.8,5,3);
        books[1] = new Book(1,"骚男崔狗","张大帅",2.5,100,1);
        books[2] = new Book(1,"少男保养指南","唐小弟",6.6,8,3);
        for (Book book : books) {
            System.out.println("book = " + book);
        }
    }
}
