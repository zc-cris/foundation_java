package day17.teammanager.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 设计师类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Designer extends Programmer {
    private double bonus;

    @Override
    public String getMessage() {
        return getBasicMessage() + "设计师\t" + getBonus();
    }


    @Override
    public String toString() {
        return getInfo() + "设计师" + "\t" +
                getStatus() + "\t"
                + bonus + "\t" + "\t"
                + getEquipment().getDescription()
                ;
    }
}
