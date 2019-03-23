package game.gameState;

import constant.SkillType;
import equipment.Capability;
import game.Game;
import role.Role;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class GameOverState implements GameState {
    Game game;

    public GameOverState(Game game) {
        this.game = game;
    }

    public Capability heroAttack() {
        System.out.println("Game Over");
        return null;
    }

    public void monsterBeAttacked(Capability hero_attack) {
        System.out.println("Game Over");
    }

    public Capability monsterAttack() {
        System.out.println("Game Over");
        return null;
    }

    public void heroBeAttacked(Capability monster_attack) {
        System.out.println("Game Over");
    }

    public void prepare() {
        System.out.println("Game Over");
    }
}
