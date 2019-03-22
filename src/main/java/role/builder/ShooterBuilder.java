package role.builder;

import constant.*;
import equipment.*;
import role.Bag;

import java.util.ArrayList;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class ShooterBuilder extends HeroBuilder {

    public void setImageInfo() {
        role.setX(300);
        role.setY(215);
        role.setWidth(105);
        role.setHeight(120);
        role.setImage_path(Constant.shooter_path);
    }

    public void buildBasicCapability() {
        Capability capability = new Capability(Constant.heroCapabilityBase);
        int[] elements = new int[5];
        elements[Element.METAL.getType()] = Constant.heroCapabilityElement;
        capability.setElements(elements);
        role.setBaseCapability(capability);
    }

    public void buildArmor() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        gemValues.add(new GemValue(Quality.LOW, Element.METAL));
        Equipment armor = EquipmentFactory.createArmor(Quality.LOW, gemValues);
        role.setArmor(armor);

    }

    public void buildWeapon() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        gemValues.add(new GemValue(Quality.LOW, Element.METAL));
        Equipment weapon = EquipmentFactory.createWeapon(Quality.LOW, gemValues, EquipmentType.GUN);
        role.setWeapon(weapon);

    }



}
