package com.cris.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Box
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Box {
    private Double length;
    private Double wide;
    private Double height;

    public Double getVolume() {
        return this.height * this.length * this.wide;
    }

    public String getInfo() {
        return "this length is " + this.length + ", this wide is " + this.wide + ", this height is " + this.height;
    }

}
