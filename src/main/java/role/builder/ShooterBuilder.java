package role.builder;

import constant.Element;
import constant.EquipmentType;
import constant.Quality;
import equipment.*;
import equipment.weapon.GunBehavior;
import equipment.weapon.WeaponBehavior;
import role.Bag;

import java.util.ArrayList;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class ShooterBuilder extends RoleBuilder {
    public void setBasicInfo() {
        role.setMaxLife(10000);
        role.setCurrentLife(role.getMaxLife());
        role.setBag(new Bag());
        role.setExp(0);
        role.setMoney(0);


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


    public void buildBasicCapability() {
        Capability capability = new Capability(50);
        int[] elements = new int[5];
        elements[Element.METAL.getType()] = 5;
        capability.setElements(elements);
        role.setBaseCapability(capability);
    }
}
