package role.builder;

import role.Role;

/**
 * Created by PandaLin on 2019/3/19.
 */
public abstract class RoleBuilder {
    protected Role role = new Role();

    public abstract void setBasicInfo();

    public abstract void buildArmor();

    public abstract void buildWeapon();

    public abstract void buildBasicCapability();

    public Role getRole() {
        return role;
    }

}
