package equipment;

import constant.Element;
import constant.Quality;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class GemPower implements EquipmentPower {

    public int getBase(Quality quality){
        return (int) (quality.getPower() * 0.01);
    }

    public Capability getCapability(Equipment equipment) {
        Gem gem = (Gem)equipment;
        Quality quality = gem.getQuality();
        int base = getBase(quality);
        Element gemElement = gem.getElement();
        Equipment mainEquipment = gem.getEquipment();
        Capability capability = mainEquipment.getCapability();
        int[] elements = capability.getElements();
        elements[gemElement.getType()]+=base;
        return capability;

    }
}
