package role;


import equipment.Equipment;
import equipment.GemValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class Bag {
    List<Equipment> armors;
    List<Equipment> weapons;
    List<GemValue> gems;

    public Bag() {
        this.armors = new ArrayList<Equipment>();
        this.weapons = new ArrayList<Equipment>();
        this.gems = new ArrayList<GemValue>();

    }
}
