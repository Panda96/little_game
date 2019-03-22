package role;


import constant.Constant;
import constant.EquipmentType;
import constant.Quality;
import constant.SkillType;
import equipment.*;
import role.RoleState.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/20.
 */
public class Hero extends Role {
    private RoleState heroOneSkillState;
    private RoleState heroTwoSkillsState;
    private RoleState heroThreeSkillsState;
    private RoleState heroComboState;
    private RoleState state;

    private List<SkillType> skills;

    public Hero() {
        this.heroComboState = new HeroComboState(this);
        this.heroThreeSkillsState = new HeroThreeSkillsState(this);
        this.heroTwoSkillsState = new HeroTwoSkillsState(this);
        this.heroOneSkillState = new HeroOneSkillState(this);
        this.skills = new ArrayList<SkillType>();
        this.skills.add(SkillType.FIRST);
        this.state = this.heroOneSkillState;

    }

    public void upgrade(int exp){
        state.upgrade(exp);
    }

    public void pickup(Role role){
        this.money += role.getMoney();
        this.bag.addGems(role.getBag().getGems());

    }

    public void addEquipGem(Equipment equipment, int BagGemId){

        Gem equip = (Gem)equipment;
        EquipComponents components = equip.split();
        components.showGems();
        List<GemValue> gems = components.getGems();
        List<GemValue> bagGems = bag.getGems();
        GemValue gv = bagGems.get(BagGemId);
        if(gems.size()<5){
            gems.add(gv);
            components.setGems(gems);

            if(components.getEquipment().getType().equals(EquipmentType.ARMOR)){
                setArmor(components.assemble());
                Equipment eqip = getArmor();
                ((Gem)eqip).split().showGems();
            }else{
                setWeapon(components.assemble());
            }

            bagGems.remove(BagGemId);
        }else{
            System.out.println("最多装5个宝石");
        }


//        return this;
    }

    public void removeEquipGem(Equipment equipment, int gemId){

        Gem equip = (Gem)equipment;
        EquipComponents components = equip.split();
        List<GemValue> gems = components.getGems();
        if(gems.size() > 1){
            GemValue gm = gems.get(gemId);
            getBag().addGem(gm);
            gems.remove(gemId);
        }else{
            System.out.println("至少装备1个宝石");
        }
        Equipment quip = components.assemble();
        if(components.getEquipment().getType().equals(EquipmentType.ARMOR)){
            setArmor(quip);
        }else{
            setWeapon(quip);
        }

//        return this;

    }

    public void strengthenEquipGem(Equipment equipment, int gemId){
        Gem equip = (Gem)equipment;
        EquipComponents components = equip.split();
        List<GemValue> gems = components.getGems();
        GemValue gem = gems.get(gemId);
        Quality quality = gem.getQuality();
        int qualityId = quality.getId();
        if(qualityId < Quality.HIGH.getId()){
            qualityId += 1;
            this.money -= Constant.moneyForEquipmentUpgrade;
            gem.setQuality(Quality.getQualityById(qualityId));
            equipment = components.assemble();
        }

    }

    public void strengthenEquip(Equipment equipment){
        Gem equip = (Gem)equipment;
        EquipComponents components = equip.split();
        Equipment weapon = components.getEquipment();
        Quality quality = weapon.getQuality();
        int qualityId = quality.getId();
        if(qualityId < Quality.HIGH.getId()){
            qualityId += 1;
            this.money -= Constant.moneyForEquipmentUpgrade;
            weapon.setQuality(Quality.getQualityById(qualityId));
            equipment = components.assemble();
        }

    }


    public void attack(Role role, List<SkillType> skills) {

//        List<SkillType> skills = state.chooseSkill();
        Capability attack = getSkillCapability(skills);
        System.out.println("Hero Attack");
//        attack.show();
        role.beAttacked(attack);
    }

    private Capability getSkillCapability(List<SkillType> skills){
        Capability total = getAttackCapability();
        int attackTimes = 0;
        for (SkillType skill:skills){
            attackTimes += skill.getSkillNumber();
        }
        return total.multiple(attackTimes);
    }

    public void addExp(int exp){
        this.exp += exp;
    }

    public void addSkill(SkillType skill){
        this.skills.add(skill);
    }


    public void setState(RoleState heroState){
        this.state = heroState;
    }


    public RoleState getHeroOneSkillState() {
        return heroOneSkillState;
    }

    public RoleState getHeroTwoSkillsState() {
        return heroTwoSkillsState;
    }

    public RoleState getHeroThreeSkillsState() {
        return heroThreeSkillsState;
    }

    public RoleState getHeroComboState() {
        return heroComboState;
    }

    public List<SkillType> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillType> skills) {
        this.skills = skills;
    }
}
