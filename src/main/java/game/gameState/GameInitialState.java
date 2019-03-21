package game.gameState;

import game.Game;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class GameInitialState implements GameState{
    Game game;

    public GameInitialState(Game game) {
        this.game = game;
    }

    public void heroAttack() {
        game.getHero().attack(game.getMonster());
        if(game.getMonster().is_dead()){
            game.setState(game.getNextMonsterState());
        }else{
            game.setState(game.getAttackHeroState());
        }

    }

    public void monsterAttack() {
        System.out.println("Not Monster Turn.");

    }

    public void prepare() {
        System.out.println("Monster hasn't been defeated.");
    }
}
