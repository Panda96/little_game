package role.builder;

import constant.Constant;
import constant.Element;
import constant.EquipmentType;
import constant.Quality;
import equipment.Capability;
import equipment.Equipment;
import equipment.EquipmentFactory;
import equipment.GemValue;
import role.Bag;
import role.Monster;

import java.util.ArrayList;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class MonsterBuilder extends RoleBuilder {

    public MonsterBuilder() {
        this.role = new Monster();
    }

    public void setBasicInfo() {
        role.setMaxLife(Constant.monsterInitialMaxLife + getRandomNum(Constant.monsterInitialMaxLife));
        role.setCurrentLife(role.getMaxLife());
        role.setBag(new Bag());
        role.setMoney(Constant.monsterInitialMoney + getRandomNum(Constant.monsterInitialMoney));
        role.setExp(Constant.monsterInitialExp + getRandomNum(Constant.monsterInitialExp));
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
        Capability capability = new Capability(Constant.monsterCapabilityBase + getRandomNum(Constant.monsterCapabilityBase));
        int[] elements = new int[5];
        elements[getRandomElement().getType()] = getRandomNum(Constant.monsterCapabilityElement + getRandomNum(Constant.monsterCapabilityElement));
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
