package role.skills;

import constant.SkillType;

/**
 * Created by PandaLin on 2019/3/23.
 */
public class SingleSkill implements Skill {
    SkillType skillType;

    public SingleSkill(SkillType skillType) {
        this.skillType = skillType;
    }

    public int execute() {
        return skillType.getSkillNumber();
    }
}
