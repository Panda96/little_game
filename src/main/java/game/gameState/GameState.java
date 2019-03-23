package game.gameState;


import equipment.Capability;

/**
 * Created by PandaLin on 2019/3/19.
 */
public interface GameState {

    public Capability heroAttack();

    public void monsterBeAttacked(Capability hero_attack);

    public Capability monsterAttack();

    public void heroBeAttacked(Capability monster_attack);

    public void prepare();
}
