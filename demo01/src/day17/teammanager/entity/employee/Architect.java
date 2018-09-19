package day17.teammanager.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 架构师类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Architect extends Designer {
    private int stock;

    @Override
    public String getMessage() {
        return getBasicMessage() + "架构师\t" + getBonus() + "\t" + getStock();
    }

    @Override
    public String toString() {
        return getInfo() + "架构师" + "\t" +
                getStatus() + "\t"
                + getBonus() + "\t"
                + stock + "\t"
                + getEquipment().getDescription()
                ;
    }
}
