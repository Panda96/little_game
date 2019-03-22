package game.consolePanel;

import game.Game;
import game.GameFrame;
import role.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class GameControlPanel extends Console implements ActionListener {
    Game game;
    GameFrame frame;

    public GameControlPanel(Game game, GameFrame frame){
        super();
        this.frame = frame;
        this.game = game;
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        MonsterPanel monsterPanel = new MonsterPanel(game.getMonster());
        HeroPanel hero_panel = new HeroPanel(game, frame, monsterPanel);

        JButton end_button = new JButton("结束游戏");
        end_button.addActionListener(this);
        JPanel end_panel = new JPanel();
        end_panel.setBackground(Color.WHITE);
        end_panel.add(end_button);

        this.add(BorderLayout.NORTH, monsterPanel);
        this.add(BorderLayout.CENTER,hero_panel);
        this.add(BorderLayout.SOUTH,end_panel);


    }


    public void actionPerformed(ActionEvent e) {
        game.setState(game.getGameOverState());
        frame.getMainCard().show(frame.getMainPanel(), "2");
    }
}
