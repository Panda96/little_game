package equipment.equipmentPower;

import constant.Constant;
import constant.Quality;
import equipment.Capability;
import equipment.Equipment;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class ArmorPower implements EquipmentPower, Constant {

    public Capability getCapability(Equipment equipment) {
        Quality quality = equipment.getQuality();
        int base = (int) (quality.getPower() * Constant.armorCoefficient);
        Capability defense = new Capability(base);
        int[] elements = {0, 0, 0, 0, 0};
        defense.setElements(elements);
        return defense;
    }
}
