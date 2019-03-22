package role;

import constant.Constant;
import constant.SkillType;
import equipment.Capability;
import equipment.Equipment;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/18.
 */
public abstract class Role implements Constant {
    int x;
    int y;
    int width;
    int height;
    String image_path;
    int maxLife;
    int currentLife;
    int exp;
    int money;
    Equipment armor;
    Equipment weapon;
    Bag bag;

    Capability baseCapability;


    public abstract void attack(Role role, List<SkillType> skills);

    public void beAttacked(Capability attack){
        Capability defense = getDefenseCapability();
//        System.out.println("defense");
//        defense.show();
        attack.minus(defense);
        currentLife -= attack.getBase();
        currentLife -= attack.getElementPower();

    }

    public Capability getDefenseCapability() {
        Capability copyBase = this.baseCapability.clone();
        copyBase.add(this.armor.getCapability());
        return copyBase;
    }

    public Capability getAttackCapability() {
        Capability copyBase = this.baseCapability.clone();
        copyBase.add(this.weapon.getCapability());
        return copyBase;
    }

    public int getLevel() {
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

    public void show(String roleName){
        System.out.println(roleName);
        System.out.println("Life:"+currentLife+",\tMoney:"+ money+",\tExp:"+ exp);
        System.out.println(bag.toString());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getImage_path() {
        return image_path;
    }
}