package com.cris.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @ClassName Designer
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class Designer extends Programmer{
    private Double bonus;

    public Designer(Integer id, String name, Integer age, Double salary, Equipment equipment, Double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }
}
