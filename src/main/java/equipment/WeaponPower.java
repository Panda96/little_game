package equipment;

import constant.Element;
import constant.Quality;

import java.util.List;

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
