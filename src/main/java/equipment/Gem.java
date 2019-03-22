package equipment;


import constant.Element;
import constant.EquipmentType;
import constant.Quality;
import equipment.equipmentPower.GemPower;
import equipment.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Gem extends EquipmentDecorator {
    private Equipment equipment;
    private Element element;

    public Gem(GemValue gemValue){
        super(gemValue.getQuality());
        setElement(gemValue.getElement());
        setType(EquipmentType.GEM);
    }

    public Gem(Quality quality, Element element) {
        super(quality);
        setElement(element);
        setType(EquipmentType.GEM);
    }

    public Gem(Quality quality, Element element, Equipment equipment) {
        super(quality);
        setEquipment(equipment);
        setElement(element);
        setType(EquipmentType.GEM);
    }


    public Capability getCapability() {
        GemPower gemPower = new GemPower();
        return gemPower.getCapability(this);
    }

    public List<GemValue> getDecorators() {
        EquipComponents split = split();
        return split.getGems();
    }

    public EquipComponents split(){
        EquipComponents equipComponents = new EquipComponents();
        List<GemValue> decorators = new ArrayList<GemValue>();

        Equipment equip = this;
        while(equip.getClass().toString().equals("class equipment.Gem")){
            Gem temp = (Gem)equip;
            decorators.add(temp.getGemValue());
            equip = temp.equipment;


        }
        equipComponents.setEquipment(equip);
        equipComponents.setGems(decorators);
        return equipComponents;

    }

    public GemValue getGemValue(){
        return new GemValue(getQuality(), getElement());
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        equipment.getDecorators().add(new GemValue(getQuality(), getElement()));
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
