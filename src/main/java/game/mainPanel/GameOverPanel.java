package game.mainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class GameOverPanel extends MainPanel {

    public GameOverPanel() {
        super();
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Game Over!", JLabel.CENTER);


        label.setFont(new Font("微软雅黑", Font.BOLD, 50));
        label.setForeground(Color.WHITE);
        this.add(label);
    }


}
