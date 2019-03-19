import com.sun.xml.internal.messaging.saaj.soap.impl.ElementFactory;
import constant.Element;
import constant.Quality;
import equipment.*;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class Main {
    public static void main(String[] args) {
        Gem gem = new Gem(Quality.LOW, Element.WATER);
        Capability capability = gem.getCapability();
        System.out.println(capability.getBase());
        for(int a : capability.getElements()){
            System.out.print(a+" ");
        }
        System.out.println();
        for(GemValue gemValue: gem.getDecorators()){
            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
        }
        System.out.println(gem.getDecorators().size());

        Equipment armor = new Armor(Quality.HIGH);
        System.out.println(capability.getBase());
        for(int a : capability.getElements()){
            System.out.print(a+" ");
        }
        System.out.println();
        for(GemValue gemValue: armor.getDecorators()){
            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
        }
        System.out.println(armor.getDecorators().size());


        gem.setEquipment(armor);
        armor = gem;
        armor = new Gem(Quality.MEDIUM, Element.METAL, armor);
        capability = armor.getCapability();
        System.out.println(capability.getBase());
        for(int a : capability.getElements()){
            System.out.print(a+" ");
        }
        System.out.println();
        for(GemValue gemValue: armor.getDecorators()){
            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
        }
        System.out.println(armor.getDecorators().size());

        armor = EquipmentFactory.addGem(armor, new GemValue(Quality.MEDIUM, Element.WOOD));
        capability = armor.getCapability();
        System.out.println(capability.getBase());
        for(int a : capability.getElements()){
            System.out.print(a+" ");
        }
        System.out.println();
        for(GemValue gemValue: armor.getDecorators()){
            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
        }
        System.out.println(armor.getDecorators().size());

        armor = EquipmentFactory.removeArmorGem(armor, new GemValue(Quality.LOW, Element.WATER));
        capability = armor.getCapability();
        System.out.println(capability.getBase());
        for(int a : capability.getElements()){
            System.out.print(a+" ");
        }
        System.out.println();
        for(GemValue gemValue: armor.getDecorators()){
            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
        }
        System.out.println(armor.getDecorators().size());
    }
}
