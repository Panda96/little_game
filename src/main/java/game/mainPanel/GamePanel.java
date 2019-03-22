package game.mainPanel;

import constant.Constant;
import constant.HeroType;
import game.Game;
import game.consolePanel.Console;
import role.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class GamePanel extends MainPanel implements Constant {
    Game game;
    Hero hero;

    public GamePanel(Game game){
        super();
        this.game = game;
        this.hero = (Hero)game.getHero();

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Image background = new ImageIcon(Constant.bg_path).getImage();
        g.drawImage(background, 0, 0, 1422, 800, this);
        Image hero_img = new ImageIcon(game.getHero().getImage_path()).getImage();
        g.drawImage(hero_img, 300, 215, hero.getWidth(), 120, this);

        if(!game.getMonster().is_dead()){
            Image monster = new ImageIcon(Constant.monster_path).getImage();
            g.drawImage(monster, 1050, 215, 115, 130, this);
        }

    }

}
