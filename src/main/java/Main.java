import constant.Element;
import constant.Quality;
import equipment.*;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/18.
 */
public class Main {
    public static void main(String[] args) {
        Equipment armor = new Armor(Quality.HIGH);
        Capability capability = armor.getCapability();
        System.out.println(capability.getBase());
        for(int a : capability.getElements()){
            System.out.print(a+" ");
        }
        System.out.println();
        for(GemValue gemValue: armor.getDecorators()){
            System.out.print(gemValue.getElement().getType()+" "+ gemValue.getQuality()+ "; ");
        }
        System.out.println(armor.getDecorators().size());

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

        armor = new Gem(Quality.HIGH, Element.FIRE, armor);
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
