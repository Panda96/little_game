package equipment;

import constant.Element;
import constant.Quality;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class ArmorPower implements EquipmentPower {

    public Capability getCapability(Equipment equipment) {
        Quality quality = equipment.getQuality();
        int base = (int)(quality.getPower()*0.1);
        Capability defense = new Capability(base);
        int[] elements = {0, 0, 0, 0, 0};
        defense.setElements(elements);
        return defense;
    }
}
