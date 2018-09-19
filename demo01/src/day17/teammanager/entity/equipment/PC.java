package day17.teammanager.entity.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 台式机类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings({"unused", "AlibabaClassNamingShouldBeCamel"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PC implements Equipment {
    private String model;
    private String display;

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
