package game;

import constant.HeroType;
import game.gameState.*;
import role.Role;
import role.builder.BuilderFactory;
import role.builder.RoleBuilder;
import role.builder.RoleDirector;


/**
 * Created by PandaLin on 2019/3/19.
 */
public class Game {
    private GameState gameInitialState;
    private GameState attackMonsterState;
    private GameState attackheroState;
    private GameState gameOverState;
    private GameState nextMonsterState;

    private GameState state;

    private Role hero;
    private Role monster;


    public Game(HeroType heroType) {
        this.gameInitialState = new GameInitialState(this);
        this.attackMonsterState = new AttackMonsterState(this);
        this.attackheroState = new AttackHeroState(this);
        this.gameOverState = new GameOverState(this);
        this.nextMonsterState = new NextMonsterState(this);
        initial(heroType);
        this.state = gameInitialState;

    }

    public void initial(HeroType heroType){
        heroType = HeroType.SHOOTER;
        BuilderFactory builderFactory = new BuilderFactory();
        RoleBuilder heroBuilder = builderFactory.getHeroBuilder(heroType);
        RoleDirector roleDirector = new RoleDirector(heroBuilder);
        this.hero = roleDirector.construct();
        RoleBuilder monsterBuilder = builderFactory.getMonsterBuilder();
        roleDirector.setBuilder(monsterBuilder);
        this.monster = roleDirector.construct();

    }

    public Role getHero() {
        return hero;
    }

    public void setHero(Role hero) {
        this.hero = hero;
    }

    public Role getMonster() {
        return monster;
    }

    public void setMonster(Role monster) {
        this.monster = monster;
    }
}
