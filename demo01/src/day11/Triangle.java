package day11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Triangle
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Triangle extends Graphic {

    private Double a;
    private Double b;
    private Double c;

    @Override
    double getArea() {
        double d = (a + b + c) / 2;
        return Math.sqrt(d * (d - a) * (d - b) * (d - c));
    }
}
