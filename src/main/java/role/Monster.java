package role;

import equipment.Capability;
import equipment.Gem;
import equipment.weapon.Weapon;
import util.ImageInfo;
import util.ImageHelper;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/20.
 */
public class Monster extends Role {
    private List<Attack> atks = new ArrayList<Attack>();

    public Capability attack(Role role) {
        atks = new ArrayList<Attack>();

        Gem gem = (Gem)getWeapon();
        Weapon weapon = (Weapon)gem.split().getEquipment();
        ImageInfo stick = weapon.useWeapon();
        int x = getX() - stick.getWidth();
        int y = ImageHelper.getCenterPosition(getY(), getHeight(), stick.getHeight());

        Attack atk = new Attack(x, y, stick, role,false);
        atks.add(atk);
        Thread t = new Thread(atk);
        t.start();

        Capability attack = getAttackCapability();
        System.out.println("Monster Attack");
        return attack;

    }

    public List<Attack> getAtks() {
        return atks;
    }

    public void setAtks(List<Attack> atks) {
        this.atks = atks;
    }
}
