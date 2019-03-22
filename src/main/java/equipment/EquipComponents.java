package equipment;

import equipment.weapon.Weapon;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/21.
 */
public class EquipComponents {
    private Equipment equipment;
    private List<GemValue> gems;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public List<GemValue> getGems() {
        return gems;
    }

    public void setGems(List<GemValue> gems) {
        this.gems = gems;
    }

    public Equipment assemble(){
        Equipment equip = this.equipment;
        for (GemValue gemValue : gems){
            equip = new Gem(gemValue.getQuality(), gemValue.getElement(), equip);
        }
        return equip;
    }

    public void showGems(){
        for(GemValue gm:gems){
            System.out.print(gm.toString()+" ");
        }
        System.out.println();
    }
}
