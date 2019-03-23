package equipment.weapon;

import constant.Constant;
import util.ImageInfo;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class StickBehavior implements WeaponBehavior{

    public ImageInfo useWeapon() {
        return new ImageInfo(Constant.stick_path, 148, 32);
    }
}
