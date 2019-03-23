package equipment.weapon;

import constant.Constant;
import util.ImageInfo;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class GunBehavior implements WeaponBehavior {
    public ImageInfo useWeapon() {
        return new ImageInfo(Constant.bullet_path,225,65);
    }
}
