package day22;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person implements Serializable {

    private static final long serialVersionUID = -191549087896618751L;

    private int age;
    private String name;
    private double weight;
    private static String school = "南开中学";

}
