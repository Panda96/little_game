package role.RoleState;

import constant.Constant;
import constant.SkillType;
import role.Hero;
import util.Generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/20.
 */
public class HeroOneSkillState implements RoleState, Constant {
    private Hero hero;


    public HeroOneSkillState(Hero hero) {
        this.hero = hero;
    }

    public void upgrade(int exp) {
        hero.addExp(exp);
        int level = hero.getLevel();
        if (level >= Constant.comboSkillLevel) {
            this.hero.setState(this.hero.getHeroComboState());
        }else if(level >= Constant.threeSkillLevel){
            List<SkillType> skills = new ArrayList<SkillType>();
            skills.add(SkillType.FIRST);
            skills.add(SkillType.SECOND);
            skills.add(SkillType.THIRD);
            hero.setSkills(skills);
            this.hero.setState(this.hero.getHeroThreeSkillsState());
        }else if(level >= Constant.twoSkillLevel){
            hero.addSkill(SkillType.SECOND);
            this.hero.setState(this.hero.getHeroTwoSkillsState());
        }


    }

//    public List<SkillType> chooseSkill() {
//        List<SkillType> attackSkills = new ArrayList<SkillType>();
//        List<SkillType> skills = hero.getSkills();
//        int skillId = Generator.getRandomNum(skills.size());
//        attackSkills.add(skills.get(skillId));
//        return attackSkills;
//    }


}
