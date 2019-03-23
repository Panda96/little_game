package role.skills;

import constant.SkillType;
import role.Hero;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/23.
 */
public class ComboSkill implements Skill {
    List<SkillType> skills;
    public ComboSkill(List<SkillType> skills) {
        this.skills = skills;
    }
    public int execute() {
        int total = 0;
        for(SkillType skillType:skills){
            total += skillType.getSkillNumber();
        }
        return total;
    }
}
