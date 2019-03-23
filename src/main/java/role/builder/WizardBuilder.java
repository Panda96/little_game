package role.builder;

import constant.Constant;
import constant.Element;
import constant.EquipmentType;
import constant.Quality;
import equipment.Capability;
import equipment.Equipment;
import equipment.EquipmentFactory;
import equipment.GemValue;

import java.util.ArrayList;

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
        Capability capability = new Capability(Constant.heroCapabilityBase);
        int[] elements = new int[5];
        elements[Element.FIRE.getType()] = Constant.heroCapabilityElement;
        capability.setElements(elements);
        role.setBaseCapability(capability);
    }

    public void buildArmor() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        gemValues.add(new GemValue(Quality.LOW, Element.FIRE));
        Equipment armor = EquipmentFactory.createArmor(Quality.LOW, gemValues);
        role.setArmor(armor);

    }

    public void buildWeapon() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        gemValues.add(new GemValue(Quality.LOW, Element.FIRE));
        Equipment weapon = EquipmentFactory.createWeapon(Quality.LOW, gemValues, EquipmentType.WAND);
        role.setWeapon(weapon);

    }
}
