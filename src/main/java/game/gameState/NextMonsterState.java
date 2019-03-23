package game.gameState;

import constant.SkillType;
import equipment.Capability;
import game.Game;
import role.Hero;
import role.Role;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class NextMonsterState implements GameState{
    Game game;

    public NextMonsterState(Game game) {
        this.game = game;
    }

    public Capability heroAttack() {
        System.out.println("Hero is preparing.");
        return null;
    }

    public void monsterBeAttacked(Capability hero_attack) {
        System.out.println("Hero is preparing.");
    }

    public Capability monsterAttack() {
        System.out.println("Monster hasn't wake up.");
        return null;
    }

    public void heroBeAttacked(Capability monster_attack) {
        System.out.println("Monster hasn't wake up.");
    }

    public void prepare() {
        Hero hero = (Hero) game.getHero();
        Role mons = game.getMonster();
        hero.upgrade(mons.getExp());
        hero.pickup(mons);

        Role monster = game.createMonster();
        game.setMonster(monster);
        game.setState(game.getGameInitialState());

    }
}
