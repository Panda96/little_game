package equipment.weapon;

import constant.Constant;
import util.ImageInfo;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class SwordBehavior implements WeaponBehavior {
    public ImageInfo useWeapon() {
        return new ImageInfo(Constant.sword_path, 225, 59);
    }
}
