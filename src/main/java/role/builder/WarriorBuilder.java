package role.builder;

import constant.Constant;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class WarriorBuilder extends HeroBuilder {

    public void setImageInfo() {
        role.setX(300);
        role.setY(215);
        role.setWidth(90);
        role.setHeight(120);
        role.setImage_path(Constant.warrior_path);
    }

    public void buildBasicCapability() {

    }

    public void buildArmor() {

    }

    public void buildWeapon() {

    }
}
