package equipment.weapon;

import constant.EquipmentType;
import constant.Quality;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Wand extends Weapon {
    public Wand(Quality quality) {
        super(quality);
        this.setType(EquipmentType.WAND);
        this.setWeaponBehavior(new WandBehavior());
    }
}
