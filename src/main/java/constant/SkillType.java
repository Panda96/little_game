package constant;

import java.util.SimpleTimeZone;

/**
 * Created by PandaLin on 2019/3/20.
 */
public enum SkillType {
    FIRST(0), SECOND(1), THIRD(2);

    private int skillNumber;

    private SkillType(int skillNumber){
        this.skillNumber = skillNumber;
    }

    public int getSkillNumber() {
        return skillNumber;
    }

    public static SkillType getSkill(int number){
        SkillType[] skills = SkillType.values();
        for(SkillType skillType: skills) {
            if (skillType.getSkillNumber() == number) {
                return skillType;
            }
        }
        return null;

    }
}
