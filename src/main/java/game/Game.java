package game;

import constant.HeroType;
import constant.SkillType;
import game.gameState.*;
import game.mainPanel.MainPanel;
import role.Role;
import role.builder.BuilderFactory;
import role.builder.RoleBuilder;
import role.builder.RoleDirector;

import javax.swing.*;
import java.util.List;


/**
 * Created by PandaLin on 2019/3/19.
 */
public class Game implements GameState {
    private GameState gameInitialState;
    private GameState attackHeroState;
    private GameState gameOverState;
    private GameState nextMonsterState;

    private GameState state;

    private Role hero;
    private Role monster;

    private HeroType heroType;


    public Game(HeroType heroType) {
        this.heroType = heroType;
        this.gameInitialState = new GameInitialState(this);
        this.attackHeroState = new AttackHeroState(this);
        this.gameOverState = new GameOverState(this);
        this.nextMonsterState = new NextMonsterState(this);

        initial(heroType);

        this.state = gameInitialState;

    }

    private void initial(HeroType heroType) {

        BuilderFactory builderFactory = new BuilderFactory();
        RoleBuilder heroBuilder = builderFactory.getHeroBuilder(heroType);
        RoleDirector roleDirector = new RoleDirector(heroBuilder);
        this.hero = roleDirector.construct();
        this.monster = createMonster();

    }

    public void heroAttack(List<SkillType> skills) {
        state.heroAttack(skills);
    }

    public void monsterAttack() {
        state.monsterAttack();
    }

    public void prepare() {
        state.prepare();
    }

    public Role
    createMonster() {
        BuilderFactory builderFactory = new BuilderFactory();
        RoleBuilder monsterBuilder = builderFactory.getMonsterBuilder();
        RoleDirector roleDirector = new RoleDirector(monsterBuilder);
        roleDirector.setBuilder(monsterBuilder);
        return roleDirector.construct();
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }


    public void run(){
        JFrame frame = new JFrame("Little Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = null;
        panel = new MainPanel();
        frame.getContentPane().add(panel);
        frame.setSize(1750, 820);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setVisible(true);


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

    public HeroType getHeroType() {
        return heroType;
    }

    public void show() {
        hero.show("hero");
        monster.show("monster");
        System.out.println("----------------------------------------------");
    }


}
