package com.cris.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @ClassName Programmer
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class Programmer extends Employee {
    private Equipment equipment;

    public Programmer(Integer id, String name, Integer age, Double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }
}
