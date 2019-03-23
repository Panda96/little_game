package game.gameState;

import equipment.Capability;
import game.Game;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class AttackHeroState implements GameState {
    Game game;

    public AttackHeroState(Game game) {
        this.game = game;
    }

    public Capability heroAttack(Capability attack) {
        System.out.println("Not Hero Turn.");
        return null;
    }

    public Capability monsterAttack(Capability attack) {
        Capability monster_attack = game.getMonster().attack(game.getHero());
        if(game.getHero().is_dead()){
            game.setState(game.getGameOverState());
        }else{
            game.setState(game.getGameInitialState());
        }

        return monster_attack;
    }

    public Capability heroAttack() {
        System.out.println("Not Hero Turn.");
        return null;
    }

    public void monsterBeAttacked(Capability hero_attack) {
        System.out.println("Not Hero Turn.");

    }

    public Capability monsterAttack() {
        Capability monster_attack = game.getMonster().attack(game.getHero());
        return monster_attack;
    }

    public void heroBeAttacked(Capability monster_attack) {
        game.getHero().beAttacked(monster_attack);
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
