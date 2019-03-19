package equipment.weapon;

import constant.EquipmentType;
import constant.Quality;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Gun extends Weapon {
    public Gun(Quality quality) {
        super(quality);
        this.setType(EquipmentType.GUN);
        this.setWeaponBehavior(new GunBehavior());
    }
}
