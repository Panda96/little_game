package role.builder;

import role.Role;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class RoleDirector {
    private RoleBuilder builder;

    public RoleDirector(RoleBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(RoleBuilder builder){
        this.builder = builder;
    }

    public Role construct(){
        builder.setBasicInfo();
        builder.buildArmor();
        builder.buildWeapon();
        builder.buildBasicCapability();
        return builder.getRole();
    }
}
