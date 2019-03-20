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
//        Gem gemCoefficient = new Gem(Quality.LOW, Element.WATER);
//        Capability capability = gemCoefficient.getCapability();
//        System.out.println(capability.getBase());
//        for(int a : capability.getElements()){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for(GemValue gemValue: gemCoefficient.getDecorators()){
//            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
//        }
//        System.out.println(gemCoefficient.getDecorators().size());
//
//        Equipment armorCoefficient = new Armor(Quality.HIGH);
//        System.out.println(capability.getBase());
//        for(int a : capability.getElements()){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for(GemValue gemValue: armorCoefficient.getDecorators()){
//            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
//        }
//        System.out.println(armorCoefficient.getDecorators().size());
//
//
//        gemCoefficient.setEquipment(armorCoefficient);
//        armorCoefficient = gemCoefficient;
//        armorCoefficient = new Gem(Quality.MEDIUM, Element.METAL, armorCoefficient);
//        capability = armorCoefficient.getCapability();
//        System.out.println(capability.getBase());
//        for(int a : capability.getElements()){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for(GemValue gemValue: armorCoefficient.getDecorators()){
//            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
//        }
//        System.out.println(armorCoefficient.getDecorators().size());
//
//        armorCoefficient = EquipmentFactory.addGem(armorCoefficient, new GemValue(Quality.MEDIUM, Element.WOOD));
//        capability = armorCoefficient.getCapability();
//        System.out.println(capability.getBase());
//        for(int a : capability.getElements()){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for(GemValue gemValue: armorCoefficient.getDecorators()){
//            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
//        }
//        System.out.println(armorCoefficient.getDecorators().size());
//
//        armorCoefficient = EquipmentFactory.removeArmorGem(armorCoefficient, new GemValue(Quality.LOW, Element.WATER));
//        capability = armorCoefficient.getCapability();
//        System.out.println(capability.getBase());
//        for(int a : capability.getElements()){
//            System.out.print(a+" ");
//        }
//        System.out.println();
//        for(GemValue gemValue: armorCoefficient.getDecorators()){
//            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
//        }
//        System.out.println(armorCoefficient.getDecorators().size());

        Capability capability = new Capability(100);
        Capability copy = capability.clone();
        copy.setBase(200);
        copy.getElements()[3] = 100;
        capability.show();
        copy.show();
    }
}
