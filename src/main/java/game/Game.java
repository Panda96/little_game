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
public class Game implements GameState{
    private GameState gameInitialState;
    private GameState attackHeroState;
    private GameState gameOverState;
    private GameState nextMonsterState;

    private GameState state;

    private Role hero;
    private Role monster;


    public Game(HeroType heroType) {
        this.gameInitialState = new GameInitialState(this);
        this.attackHeroState = new AttackHeroState(this);
        this.gameOverState = new GameOverState(this);
        this.nextMonsterState = new NextMonsterState(this);

        initial(heroType);

        this.state = gameInitialState;

    }

    private void initial(HeroType heroType){

        BuilderFactory builderFactory = new BuilderFactory();
        RoleBuilder heroBuilder = builderFactory.getHeroBuilder(heroType);
        RoleDirector roleDirector = new RoleDirector(heroBuilder);
        this.hero = roleDirector.construct();
        this.monster = createMonster();

    }

    public void heroAttack() {
        state.heroAttack();
    }

    public void monsterAttack() {
        state.monsterAttack();
    }

    public void prepare() {
        state.prepare();
    }

    public Role createMonster(){
        BuilderFactory builderFactory = new BuilderFactory();
        RoleBuilder monsterBuilder = builderFactory.getMonsterBuilder();
        RoleDirector roleDirector = new RoleDirector(monsterBuilder);
        roleDirector.setBuilder(monsterBuilder);
        return roleDirector.construct();
    }



    public void setState(GameState state){
        this.state = state;
    }

    public GameState getState() {
        return state;
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

    public GameState getGameInitialState() {
        return gameInitialState;
    }

    public GameState getAttackHeroState() {
        return attackHeroState;
    }

    public GameState getGameOverState() {
        return gameOverState;
    }

    public GameState getNextMonsterState() {
        return nextMonsterState;
    }

    public void show(){
        hero.show("hero");
        monster.show("monster");
        System.out.println("----------------------------------------------");
    }


}
