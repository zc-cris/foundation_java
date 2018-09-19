package day17.teammanager.entity.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 笔记本类
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class NoteBook implements Equipment {

    private String model;
    private double price;

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
