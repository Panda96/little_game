package role.builder;

import constant.Element;
import constant.EquipmentType;
import constant.Quality;
import equipment.Capability;
import equipment.Equipment;
import equipment.EquipmentFactory;
import equipment.GemValue;
import role.Bag;

import java.util.ArrayList;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class MonsterBuilder extends RoleBuilder {
    public void setBasicInfo() {
        role.setMaxLife(1000 + getRandomNum(1000));
        role.setCurrentLife(role.getMaxLife());
        role.setBag(new Bag());
        role.setMoney(100 + getRandomNum(100));
        role.setExp(100 + getRandomNum(100));
    }

    public void buildArmor() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        gemValues.add(new GemValue(getRandomQuality(), getRandomElement()));
        Equipment armor = EquipmentFactory.createArmor(getRandomQuality(), gemValues);
        role.setArmor(armor);
    }

    public void buildWeapon() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        gemValues.add(new GemValue(getRandomQuality(), getRandomElement()));
        Equipment weapon = EquipmentFactory.createWeapon(getRandomQuality(), gemValues, EquipmentType.STICK);
        role.setWeapon(weapon);
    }

    public void buildBasicCapability() {
        Capability capability = new Capability(10 + getRandomNum(10));
        int[] elements = new int[5];
        elements[getRandomElement().getType()] = getRandomNum(2 + getRandomNum(2));
        capability.setElements(elements);
        role.setBaseCapability(capability);

    }


    private Quality getRandomQuality() {
        Quality[] qualities = Quality.values();
        int num = qualities.length;
        int id = getRandomNum(num);
        return qualities[id];
    }

    private Element getRandomElement() {
        Element[] elements = Element.values();
        int num = elements.length;
        int id = getRandomNum(num);
        return elements[id];
    }

    private int getRandomNum(int num) {
        return (int) (Math.random() * num);
    }


}
