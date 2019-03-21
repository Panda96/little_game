package role.builder;

import constant.Constant;
import constant.EquipmentType;
import constant.Quality;
import equipment.*;
import role.Bag;
import role.Monster;
import util.Generator;

import java.util.ArrayList;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class MonsterBuilder extends RoleBuilder {

    public MonsterBuilder() {
        this.role = new Monster();
    }

    public void setBasicInfo() {
        role.setMaxLife(Constant.monsterInitialMaxLife + Generator.getRandomNum(Constant.monsterInitialMaxLife));
        role.setCurrentLife(role.getMaxLife());
        Bag bag = new Bag();
        bag.addGem(new GemValue(Generator.getRandomQuality(), Generator.getRandomElement()));
        role.setBag(bag);
        role.setMoney(Constant.monsterInitialMoney + Generator.getRandomNum(Constant.monsterInitialMoney));
        role.setExp(Constant.monsterInitialExp + Generator.getRandomNum(Constant.monsterInitialExp));
    }

    public void buildArmor() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        Equipment armor = EquipmentFactory.createArmor(Quality.NONE, gemValues);
        role.setArmor(armor);
    }

    public void buildWeapon() {
        ArrayList<GemValue> gemValues = new ArrayList<GemValue>();
        gemValues.add(new GemValue(Generator.getRandomQuality(), Generator.getRandomElement()));
        Equipment weapon = EquipmentFactory.createWeapon(Generator.getRandomQuality(), gemValues, EquipmentType.STICK);
        role.setWeapon(weapon);
    }

    public void buildBasicCapability() {
        Capability capability = new Capability(Constant.monsterCapabilityBase + Generator.getRandomNum(Constant.monsterCapabilityBase));
        int[] elements = new int[5];
        elements[Generator.getRandomElement().getType()] = Generator.getRandomNum(Constant.monsterCapabilityElement + Generator.getRandomNum(Constant.monsterCapabilityElement));
        capability.setElements(elements);
        role.setBaseCapability(capability);

    }





}
