package com.java;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.logging.Logger;


/**
 * @ClassName Teacher
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Teacher {

    private Integer age;
    private String name;

    private static Logger LOGGER = Logger.getLogger(String.valueOf(Teacher.class));

    public static void main(String[] args) {
        Teacher cris = new Teacher().setAge(12).setName("cris");
        System.out.println("cris = " + cris);
        LOGGER.info("hello");

    }
}
