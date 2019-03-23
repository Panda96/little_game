package game.gameState;

import constant.SkillType;
import equipment.Capability;
import game.Game;
import role.Role;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class GameInitialState implements GameState{
    Game game;

    public GameInitialState(Game game) {
        this.game = game;
    }


    public Capability heroAttack() {
        Capability hero_attack = game.getHero().attack(game.getMonster());

        return hero_attack;
    }

    public void monsterBeAttacked(Capability hero_attack) {
        game.getMonster().beAttacked(hero_attack);
        if(game.getMonster().is_dead()){
            game.setState(game.getNextMonsterState());
        }else{
            game.setState(game.getAttackHeroState());
        }

    }

    public Capability monsterAttack() {
        System.out.println("Not Monster Turn.");
        return null;
    }

    public void heroBeAttacked(Capability monster_attack) {
        System.out.println("Not Monster Turn.");

    }

    public void prepare() {
        System.out.println("Monster hasn't been defeated.");
    }
}
