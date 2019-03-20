package role.builder;

import constant.HeroType;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class BuilderFactory {

    public RoleBuilder getHeroBuilder(HeroType heroType) {
        if (heroType.equals(HeroType.SHOOTER)) {
            return new ShooterBuilder();
        } else if (heroType.equals(HeroType.WARRIOR)) {
            return new WarriorBuilder();
        } else if (heroType.equals(HeroType.WIZARD)) {
            return new WizardBuilder();
        } else {
            return null;
        }

    }

    public RoleBuilder getMonsterBuilder() {
        return new MonsterBuilder();
    }
}
