package day17.teammanager.entity.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 打印机类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Printer implements Equipment {

    private String type;
    private String name;

    @Override
    public String getDescription() {
        return type + "(" + name + ")";
    }
}
