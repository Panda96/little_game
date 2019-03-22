package role.builder;

import constant.Constant;
import role.Role;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class RoleDirector implements Constant {
    private RoleBuilder builder;

    public RoleDirector(){

    }

    public RoleDirector(RoleBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(RoleBuilder builder){
        this.builder = builder;
    }

    public Role construct(){
        builder.setImageInfo();
        builder.setBasicInfo();
        builder.buildArmor();
        builder.buildWeapon();
        builder.buildBasicCapability();
        return builder.getRole();
    }
}
