package role.builder;

import constant.Constant;
import role.Role;

/**
 * Created by PandaLin on 2019/3/19.
 */
public abstract class RoleBuilder implements Constant {
    protected Role role;

    public abstract void setBasicInfo();

    public abstract void buildBasicCapability();

    public abstract void buildArmor();

    public abstract void buildWeapon();

    public Role getRole(){
        return role;
    }


}
