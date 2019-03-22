package game.gameState;

import constant.SkillType;

import java.util.List;

/**
 * Created by PandaLin on 2019/3/19.
 */
public interface GameState {

    public void heroAttack(List<SkillType> skills);

    public void monsterAttack();

    public void prepare();
}
