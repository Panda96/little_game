package game.mainPanel;

import constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class RolePanel extends MainPanel implements Constant{


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        Image warrior = new ImageIcon(Constant.warrior_path).getImage();
        Image shooter = new ImageIcon(Constant.shooter_path).getImage();
        Image wizard = new ImageIcon(Constant.wizard_path).getImage();

        g.drawImage(warrior, 200, 300,this);
        g.drawImage(shooter, 600, 300,this);
        g.drawImage(wizard, 1000, 300,this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 30));
        g.drawString("战　士", 220, 550);
        g.drawString("射　手", 610, 550);
        g.drawString("法　师", 1020, 550);

    }

}
