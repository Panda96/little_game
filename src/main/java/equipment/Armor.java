package equipment;

import constant.Quality;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class Armor extends Equipment{

    public Armor(Quality quality) {
        super(quality);

    }

    public Capability getCapability() {
        ArmorPower armorPower = new ArmorPower();
        return armorPower.getCapability(this);
    }

}
