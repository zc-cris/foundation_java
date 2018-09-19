package day11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Circle extends Graphic {

    private Double radius;

    @Override
    double getArea() {
        return (Math.PI * Math.pow(radius, 2)) / 2;
    }
}
