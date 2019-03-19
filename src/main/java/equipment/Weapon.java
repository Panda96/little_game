package equipment;

import constant.Quality;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Weapon extends Equipment{
    WeaponBehavior weaponBehavior;

    public Weapon(Quality quality, WeaponBehavior weaponBehavior) {
        super(quality);
    }

    public Capability getCapability() {
        WeaponPower weaponPower = new WeaponPower();
        return weaponPower.getCapability(this);
    }
}
