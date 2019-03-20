package role;

import constant.Constant;
import equipment.Capability;
import equipment.Equipment;

/**
 * Created by PandaLin on 2019/3/18.
 */
public abstract class Role implements Constant {
    int maxLife;
    int currentLife;
    int exp;
    int money;
    Equipment armor;
    Equipment weapon;

    Bag bag;

    Capability baseCapability;


    public abstract void attack();

    public abstract void beAttacked();

    public abstract Capability getAttackCapability();

    public abstract Capability getDefenseCapability();


    public int getLevel(){
        return this.exp / Constant.ExpPerLevel;
    }


    public boolean is_dead() {
        return currentLife <= 0;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void setArmor(Equipment armor) {
        this.armor = armor;
    }

    public Equipment getWeapon() {
        return weapon;
    }

    public void setWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Capability getBaseCapability() {
        return baseCapability;
    }

    public void setBaseCapability(Capability baseCapability) {
        this.baseCapability = baseCapability;
    }

}