package role;

import equipment.WeaponBehavior;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class Role {
    int life;
    int experience;
    WeaponBehavior weaponBehavior;

    public void attack(){
        weaponBehavior.useWeapon();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
