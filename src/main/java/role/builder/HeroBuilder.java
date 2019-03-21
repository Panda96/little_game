package role.builder;

import constant.Constant;
import role.Bag;
import role.Hero;
import role.Role;

/**
 * Created by PandaLin on 2019/3/20.
 */
public abstract class HeroBuilder extends RoleBuilder {

    public HeroBuilder() {
        this.role = new Hero();
    }

    public void setBasicInfo() {
        role.setMaxLife(Constant.heroInitialMaxLife);
        role.setCurrentLife(role.getMaxLife());
        role.setBag(new Bag());
        role.setExp(Constant.heroInitialExp);
        role.setMoney(Constant.heroInitialMoney);

    }

    public Role getRole(){
        return role;
    }

}
