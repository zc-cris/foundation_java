package com.java.object05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Person
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person {
    private Integer age;
    private String name;
    private Car car;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Car {
    private String brand;
    private Double price;
    private Integer count;
}
