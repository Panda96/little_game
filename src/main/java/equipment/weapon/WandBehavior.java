package equipment.weapon;

import constant.Constant;
import util.ImageInfo;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class WandBehavior implements WeaponBehavior {
    public ImageInfo useWeapon() {
        return new ImageInfo(Constant.fire_path, 90, 127);
    }
}
