package com.cris.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @ClassName Architect
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class Architect extends Designer{
    private Integer stock;

    public Architect(Integer id, String name, Integer age, Double salary, Equipment equipment, Double bonus, Integer stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }
}
