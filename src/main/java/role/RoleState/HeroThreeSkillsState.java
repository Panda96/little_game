package role.RoleState;

import constant.Constant;
import constant.SkillType;
import role.Hero;
import role.Role;
import util.Generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/20.
 */
public class HeroThreeSkillsState implements RoleState, Constant {
    private Hero hero;

    public HeroThreeSkillsState(Hero hero) {
        this.hero = hero;
    }

    public void upgrade(int exp) {
        hero.addExp(exp);
        int level = hero.getLevel();
        if (level >= Constant.comboSkillLevel) {
            this.hero.setState(this.hero.getHeroComboState());
        }
    }

    public List<SkillType> chooseSkill() {
        List<SkillType> attackSkills = new ArrayList<SkillType>();
        List<SkillType> skills = hero.getSkills();
        int skillId = Generator.getRandomNum(skills.size());
        attackSkills.add(skills.get(skillId));
        return attackSkills;
    }

}
