package game.gameState;

import constant.SkillType;
import game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class AttackHeroState implements GameState {
    Game game;

    public AttackHeroState(Game game) {
        this.game = game;
    }

    public void heroAttack(List<SkillType> skills) {
        System.out.println("Not Hero Turn.");
    }

    public void monsterAttack() {
        game.getMonster().attack(game.getHero(), new ArrayList<SkillType>());
        if(game.getHero().is_dead()){
            game.setState(game.getGameOverState());
        }else{
            game.setState(game.getGameInitialState());
        }

    }

    public void prepare() {
        System.out.println("Monster hasn't been defeated.");
    }
}
