package role;


import equipment.Equipment;
import equipment.Gem;
import equipment.GemValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Bag {
    List<GemValue> gems;

    public Bag() {
        initial();
    }

    public void initial() {
        this.gems = new ArrayList<GemValue>();
    }



    public void addGem(GemValue gem) {
        this.gems.add(gem);
    }

    public void addGems(List<GemValue> gems){
        for(GemValue gemValue:gems){
            this.gems.add(gemValue);
        }
    }

    public int sellAll() {
        int cost = gems.size();
        return cost;

    }

    public List<GemValue> getGems() {
        return gems;
    }

    public void show(){
//        System.out.println("Bag:");
        System.out.print("gems:");
        for(GemValue gem:gems){
            System.out.print("("+gem.getElement()+",\t"+gem.getQuality()+") ");
        }
        System.out.println();
    }
}
