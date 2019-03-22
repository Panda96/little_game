package equipment;

import constant.Element;
import constant.EquipmentType;
import constant.Quality;
import equipment.weapon.*;
import util.Generator;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class EquipmentFactory {
    public static Equipment createArmor(Quality armorQuality, List<GemValue> decorators) {
        Equipment armor = new Armor(armorQuality);
//        System.out.println(decorators.size());
        if (decorators.size() <= 5) {
            for (GemValue gem : decorators) {
                armor = new Gem(gem.getQuality(), gem.getElement(), armor);
            }
            return armor;
        }

        return null;
    }

    public static Equipment createWeapon(Quality weaponQuality, List<GemValue> decorators, EquipmentType type) {
        Equipment weapon = null;
        if(type.equals(EquipmentType.GUN)){
            weapon = new Gun(weaponQuality);
        }else if (type.equals(EquipmentType.SWORD)){
            weapon = new Sword(weaponQuality);
        }else if (type.equals(EquipmentType.WAND)){
            weapon = new Wand(weaponQuality);
        }else if (type.equals(EquipmentType.STICK)){
            weapon = new Stick(weaponQuality);
        }

        if (decorators.size() <= 5) {
            for (GemValue gem : decorators) {
                weapon = new Gem(gem.getQuality(), gem.getElement(), weapon);
            }
            return weapon;
        }

        return null;
    }

    public static Gem createRandomGem(){
        Element element = Generator.getRandomElement();
        Quality quality = Generator.getRandomQuality();
        return new Gem(quality, element);
    }

    public static Equipment addGem(Equipment equipment, GemValue gem) {
        List<GemValue> decorators = equipment.getDecorators();
        if (decorators.size() + 1 <= 5) {
            equipment = new Gem(gem.getQuality(), gem.getElement(), equipment);
            return equipment;
        }
        return null;

    }

    public static Equipment removeWeaponGem(Equipment equipment, GemValue gem) {
        List<GemValue> decorators = equipment.getDecorators();
        if (decorators.size() > 0) {
            for(int i = 0;i<decorators.size();i++){
                GemValue gemValue = decorators.get(i);
                if(gemValue.getQuality().equals(gem.getQuality()) && gemValue.getElement().equals(gem.getElement())){
                    decorators.remove(i);
                    break;
                }
            }
            return createWeapon(equipment.getQuality(), decorators, equipment.getType());
        }
        return null;
    }

    public static Equipment removeArmorGem(Equipment equipment, GemValue gem) {
        List<GemValue> decorators = equipment.getDecorators();
        if (decorators.size() > 0) {
            for(int i = 0;i<decorators.size();i++){
                GemValue gemValue = decorators.get(i);
                if(gemValue.getQuality().equals(gem.getQuality()) && gemValue.getElement().equals(gem.getElement())){
                    decorators.remove(i);
                    break;
                }
            }
            return createArmor(equipment.getQuality(), decorators);
        }
        return null;
    }
}
