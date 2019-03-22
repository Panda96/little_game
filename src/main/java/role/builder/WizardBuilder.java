package role.builder;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class WizardBuilder extends HeroBuilder{

    public void setImageInfo() {
        role.setX(300);
        role.setY(215);
        role.setWidth(105);
        role.setHeight(120);
        role.setImage_path(wizard_path);
    }

    public void buildBasicCapability() {

    }

    public void buildArmor() {

    }

    public void buildWeapon() {

    }
}
