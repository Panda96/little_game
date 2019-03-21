package role.RoleState;

import constant.SkillType;
import role.Role;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/20.
 */
public interface RoleState {
    public void upgrade(int exp);

    public List<SkillType> chooseSkill();
}
