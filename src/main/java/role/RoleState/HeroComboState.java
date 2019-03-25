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
public class HeroComboState implements RoleState, Constant {
    private Hero hero;

    public HeroComboState(Hero hero) {
        this.hero = hero;
    }

    public void upgrade(int exp) {
        hero.addExp(exp);
        int level = hero.getLevel();
    }


}
