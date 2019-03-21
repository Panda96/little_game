package game.gameState;

import game.Game;
import role.Hero;
import role.Role;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class NextMonsterState implements GameState{
    Game game;

    public NextMonsterState(Game game) {
        this.game = game;
    }

    public void heroAttack() {
        System.out.println("Hero is preparing.");
    }

    public void monsterAttack() {
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
