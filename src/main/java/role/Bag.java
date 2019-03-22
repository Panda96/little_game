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
        gems = new ArrayList<GemValue>();
        return cost;

    }

    public List<GemValue> getGems() {
        return gems;
    }

    public String toString(){
//        System.out.println("Bag:");
        String gems_str = "";
        for(GemValue gem:gems){
            gems_str+=(gem.toString()+" ");
        }
        return gems_str;
    }
}
