package game;

import com.sun.deploy.panel.JavaPanel;
import constant.HeroType;
import game.consolePanel.Console;
import game.consolePanel.GameControlPanel;
import game.consolePanel.RoleChoosePanel;
import game.mainPanel.GameOverPanel;
import game.mainPanel.GamePanel;
import game.mainPanel.MainPanel;
import game.mainPanel.RolePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class GameFrame extends JFrame implements ActionListener{
    private Game game;
    private JPanel mainPanel;
    private JPanel console;
    private CardLayout mainCard;
    private CardLayout consoleCard;

    private RolePanel rolePanel;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;

    private GameControlPanel gameControlPanel;
    private RoleChoosePanel roleChoosePanel;

    public GameFrame(){
        this.setLayout(null);
        mainCard = new CardLayout();
        consoleCard = new CardLayout();

        mainPanel = new JPanel(mainCard);
        mainPanel.setBounds(0,0,1422,800);
        console = new JPanel(consoleCard);
        console.setBounds(1422, 0, 228,800);
        rolePanel = new RolePanel();
        gameOverPanel = new GameOverPanel();
        roleChoosePanel = new RoleChoosePanel(this, game);

        mainPanel.add(rolePanel, "0");
        mainPanel.add(gameOverPanel, "2");
        console.add(roleChoosePanel,"0");

        this.add(mainPanel);
        this.add(console);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1650, 820);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getConsole() {
        return console;
    }

    public void setConsole(JPanel console) {
        this.console = console;
    }

    public CardLayout getMainCard() {
        return mainCard;
    }

    public void setMainCard(CardLayout mainCard) {
        this.mainCard = mainCard;
    }

    public CardLayout getConsoleCard() {
        return consoleCard;
    }

    public void setConsoleCard(CardLayout consoleCard) {
        this.consoleCard = consoleCard;
    }

    public RolePanel getRolePanel() {
        return rolePanel;
    }

    public void setRolePanel(RolePanel rolePanel) {
        this.rolePanel = rolePanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GameControlPanel getGameControlPanel() {
        return gameControlPanel;
    }

    public void setGameControlPanel(GameControlPanel gameControlPanel) {
        this.gameControlPanel = gameControlPanel;
    }

    public RoleChoosePanel getRoleChoosePanel() {
        return roleChoosePanel;
    }

    public void setRoleChoosePanel(RoleChoosePanel roleChoosePanel) {
        this.roleChoosePanel = roleChoosePanel;
    }


}
