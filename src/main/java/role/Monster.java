package role;

import equipment.Capability;

/**
 * Created by PandaLin on 2019/3/20.
 */
public class Monster extends Role {

    public void attack(Role role) {

        Capability attack = getAttackCapability();
        System.out.println("Monster Attack");
//        attack.show();
        role.beAttacked(attack);
    }

}
