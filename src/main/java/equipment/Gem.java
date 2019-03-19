package equipment;


import constant.Element;
import constant.Quality;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Gem extends EquipmentDecorator {
    private Equipment equipment;
    private Element element;

    public Gem(Quality quality, Element element, Equipment equipment) {
        super(quality);
        setEquipment(equipment);
        setElement(element);
    }

//    public int getPower() {
//        GemPower gemPower = new GemPower();
//        return gemPower.getBase(getQuality());
//    }

    public Capability getCapability() {
        GemPower gemPower = new GemPower();
        return gemPower.getCapability(this);
    }

    public List<GemValue> getDecorators() {
        List<GemValue> decorators = equipment.getDecorators();
        GemValue gemValue = new GemValue(getQuality(), getElement());
        decorators.add(gemValue);
        return decorators;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
