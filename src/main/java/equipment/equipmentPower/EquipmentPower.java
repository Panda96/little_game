package equipment.equipmentPower;



import equipment.Capability;
import equipment.Equipment;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public interface EquipmentPower {
    Capability getCapability(Equipment equipment);
}
