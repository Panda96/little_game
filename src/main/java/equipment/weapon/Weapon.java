package equipment.weapon;

import constant.Quality;
import equipment.Capability;
import equipment.Equipment;
import equipment.equipmentPower.WeaponPower;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Weapon extends Equipment {
    WeaponBehavior weaponBehavior;

    public Weapon(Quality quality) {
        super(quality);
    }

    public Capability getCapability() {
        WeaponPower weaponPower = new WeaponPower();
        return weaponPower.getCapability(this);
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public void attack(){
        weaponBehavior.useWeapon();
    }
}
