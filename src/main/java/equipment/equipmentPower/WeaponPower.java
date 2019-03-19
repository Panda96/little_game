package equipment.equipmentPower;

import constant.Quality;
import equipment.Capability;
import equipment.Equipment;
import equipment.equipmentPower.EquipmentPower;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class WeaponPower implements EquipmentPower {

    public Capability getCapability(Equipment equipment) {
        Quality quality = equipment.getQuality();

        int base = quality.getPower();
        Capability attack = new Capability(base);
        int[] elements = {0, 0, 0, 0, 0};
        attack.setElements(elements);
        return attack;
    }
}
