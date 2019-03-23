package game.mainPanel;

import constant.Constant;
import constant.HeroType;
import game.Game;
import game.consolePanel.Console;
import role.Attack;
import role.Hero;
import role.Monster;
import util.ImageInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class GamePanel extends MainPanel implements Constant, Runnable{
    Game game;
    Hero hero;
    Monster monster;

    public GamePanel(Game game){
        super();
        this.game = game;


    }


    @Override
    public void paint(Graphics g) {
        this.hero = (Hero)game.getHero();
        this.monster = (Monster)game.getMonster();
        super.paint(g);
        Image background = new ImageIcon(Constant.bg_path).getImage();
        g.drawImage(background, 0, 0, 1422, 800, this);
        Image hero_img = new ImageIcon(game.getHero().getImage_path()).getImage();
        g.drawImage(hero_img, 300, 215, hero.getWidth(), 120, this);

        List<Attack> hero_atks = hero.getAtks();
        for (Attack attack : hero_atks){
            if(attack.isValid()){
                paintAttack(g, attack);
            }
        }

        List<Attack> monster_atks = monster.getAtks();
        for (Attack attack : monster_atks){
            if(attack.isValid()){
                paintAttack(g, attack);
            }
        }

        if(!game.getMonster().is_dead()){
            Image monster = new ImageIcon(Constant.monster_path).getImage();
            g.drawImage(monster, 1050, 215, 115, 130, this);
        }

    }

    public void paintAttack(Graphics g, Attack attack){
        ImageInfo imageInfo = attack.getImageInfo();
        String path = imageInfo.getPath();
        Image atk = new ImageIcon(path).getImage();
        g.drawImage(atk, attack.getX(), attack.getY(), imageInfo.getWidth(), imageInfo.getHeight(), this);
    }

    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
