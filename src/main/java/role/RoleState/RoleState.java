package role.RoleState;

import constant.SkillType;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/20.
 */
public interface RoleState {
    public void upgrade();

    public void useFirstSkill();

    public void useSecondSkill();

    public void useThirdSkill();

    public void combo(List<SkillType> skills);
}
