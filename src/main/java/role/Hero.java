package role;


import constant.Constant;
import equipment.Capability;

/**
 * Created by PandaLin on 2019/3/20.
 */
public class Hero extends Role {
    public void attack() {

    }

    public void beAttacked() {

    }

    public Capability getAttackCapability() {
        Capability copyBase = this.baseCapability.clone();
        copyBase.add(this.weapon.getCapability());
        return copyBase;
    }

    public Capability getDefenseCapability() {
        Capability copyBase = this.baseCapability.clone();
        copyBase.setBase((int) (copyBase.getBase() * Constant.armorCoefficient));
        copyBase.add(this.weapon.getCapability());
        return copyBase;
    }

}
