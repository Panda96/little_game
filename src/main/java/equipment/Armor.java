package equipment;

import constant.EquipmentType;
import constant.Quality;
import equipment.equipmentPower.ArmorPower;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class Armor extends Equipment{

    public Armor(Quality quality) {
        super(quality);
        this.setType(EquipmentType.ARMOR);
    }

    public Capability getCapability() {
        ArmorPower armorPower = new ArmorPower();
        return armorPower.getCapability(this);
    }

}
