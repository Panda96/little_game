package role;

import constant.SkillType;
import equipment.Capability;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/20.
 */
public class Monster extends Role {

    public void attack(Role role, List<SkillType> skills) {

        Capability attack = getAttackCapability();
        System.out.println("Monster Attack");
//        attack.show();
        role.beAttacked(attack);
    }

}
