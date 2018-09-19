package day14;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.awt.color.ProfileDataException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName Test02
 * @Description 利用Stream API 排序
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        /// 方法1排序
        Circle circle = new Circle(12.0);
        Circle circle1 = new Circle(1.0);
        Circle circle2 = new Circle(5.0);
        Circle[] circles = {circle,circle1,circle2};
        Arrays.stream(circles).sorted(Comparator.comparingDouble(Circle::getRadius));
        System.out.println("Arrays.toString(circles) = " + Arrays.toString(circles));
       
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Circle implements Comparable{

    private double radius;

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!(o instanceof Circle)) {
            throw new ClassCastException();
        }
        return (int)(this.getRadius() - ((Circle)o).getRadius());
    }
}
