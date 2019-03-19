package equipment.weapon;

import constant.EquipmentType;
import constant.Quality;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Sword extends Weapon{
    public Sword(Quality quality) {
        super(quality);
        this.setType(EquipmentType.SWORD);
    }
}
