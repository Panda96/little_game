package equipment.weapon;

import constant.EquipmentType;
import constant.Quality;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Stick extends Weapon {
    public Stick(Quality quality) {
        super(quality);
        this.setType(EquipmentType.STICK);
        this.setWeaponBehavior(new StickBehavior());
    }
}
