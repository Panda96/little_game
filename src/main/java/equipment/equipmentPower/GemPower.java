package equipment.equipmentPower;

import constant.Constant;
import constant.Element;
import constant.Quality;
import equipment.Capability;
import equipment.Equipment;
import equipment.Gem;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class GemPower implements EquipmentPower, Constant {

    public int getBase(Quality quality) {
        return (int) (quality.getPower() * Constant.gemCoefficient);
    }

    public Capability getCapability(Equipment equipment) {
        Gem gem = (Gem) equipment;
        Quality quality = gem.getQuality();
        int base = getBase(quality);
        Element gemElement = gem.getElement();
        Equipment mainEquipment = gem.getEquipment();
        if (mainEquipment == null) {
            return new Capability(base);
        } else {
            Capability capability = mainEquipment.getCapability();
            int[] elements = capability.getElements();
            elements[gemElement.getType()] += base;
            return capability;
        }


    }
}
