package day11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Rectangle extends Graphic {

    private Double length;
    private Double wide;

    @Override
    double getArea() {
        return this.length * this.wide;
    }
}
