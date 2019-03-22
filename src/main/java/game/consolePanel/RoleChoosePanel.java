package game.consolePanel;


import constant.HeroType;
import game.Game;
import game.GameFrame;
import game.mainPanel.GamePanel;
import game.mainPanel.MainPanel;
import role.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class RoleChoosePanel extends Console implements ActionListener {
    JButton test;
    GameFrame frame;
    Game game;

    public RoleChoosePanel(GameFrame frame, Game game){
        super();
        this.game = game;
        this.setBackground(Color.WHITE);
        this.frame = frame;

//        this.setLayout(new GridLayout(4,1, 10, 100));
        JPanel head = new JPanel();
        head.setBackground(Color.WHITE);
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.WHITE);

        this.setLayout(new BorderLayout());


        JLabel label = new JLabel("选择英雄:");
        JButton warrior_bt = new JButton("战士");
        warrior_bt.setActionCommand("warrior");
        warrior_bt.addActionListener(this);
        JButton shooter_bt = new JButton("射手");
        shooter_bt.setActionCommand("shooter");
        shooter_bt.addActionListener(this);
        JButton wizard_bt = new JButton("法师");
        wizard_bt.setActionCommand("wizard");
        wizard_bt.addActionListener(this);


        head.setLayout(new FlowLayout());
        head.add(label);
        head.setAlignmentX(FlowLayout.LEFT);
        this.add(BorderLayout.NORTH, head);

        buttons.setLayout(new GridLayout(3,1, 100,100));
        buttons.add(warrior_bt);
        buttons.add(shooter_bt);
        buttons.add(wizard_bt);
        this.add(BorderLayout.CENTER, buttons);

//        this.add(label);
//        this.add(warrior_bt);
//        this.add(shooter_bt);
//        this.add(wizard_bt);


    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        HeroType heroType;
        if (command.equals("warrior")){
            heroType = HeroType.WARRIOR;
        }else if (command.equals("wizard")){
            heroType = HeroType.WIZARD;
        }else{
            heroType = HeroType.SHOOTER;
        }
        this.game = new Game(heroType);
        GamePanel gamePanel = new GamePanel(game);
        frame.setGamePanel(gamePanel);
        JPanel mainPanel = frame.getMainPanel();
        mainPanel.add(gamePanel,"1");
        frame.getMainCard().show(mainPanel, "1");

        GameControlPanel gameControlPanel = new GameControlPanel(game, frame);
        frame.setGameControlPanel(gameControlPanel);
        JPanel console = frame.getConsole();
        console.add(gameControlPanel,"1");
        frame.getConsoleCard().show(console, "1");

    }
}
