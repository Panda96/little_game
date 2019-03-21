package game.gameState;

import game.Game;

/**
 * Created by PandaLin on 2019/3/19.
 */
public class GameOverState implements GameState {
    Game game;

    public GameOverState(Game game) {
        this.game = game;
    }

    public void heroAttack() {
        System.out.println("Game Over");

    }

    public void monsterAttack() {
        System.out.println("Game Over");
    }

    public void prepare() {
        System.out.println("Game Over");
    }
}
