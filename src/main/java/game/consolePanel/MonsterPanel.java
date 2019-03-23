package game.consolePanel;

import constant.Constant;
import role.Monster;
import role.Role;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class MonsterPanel extends JPanel implements Constant {
    Role monster;
    JLabel m_name, m_capability, m_level, m_life, m_money, m_gem;

    public MonsterPanel(Role monster){
        this.monster = monster;

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        m_name = new JLabel();
        m_name.setFont(Constant.header_font);
        m_capability = new JLabel();
        m_capability.setFont(Constant.normal_font);
        m_level = new JLabel();
        m_level.setFont(Constant.normal_font);
        m_life = new JLabel();
        m_life.setFont(Constant.normal_font);
        m_money = new JLabel();
        m_money.setFont(Constant.normal_font);
        m_gem = new JLabel();
        m_gem.setFont(Constant.normal_font);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(m_name);
        this.add(m_life);
        this.add(m_level);
        this.add(m_capability);
        this.add(m_money);
        this.add(m_gem);
        this.update(monster);

    }

    public void update(Role monster){
        m_name.setText("怪物:");
        m_capability.setText("能力:"+monster.getBaseCapability().getBase());
        m_level.setText("等级: LV"+monster.getLevel());
        m_life.setText("生命: "+monster.getCurrentLife());
        m_money.setText("金钱: "+monster.getMoney());
        m_gem.setText("宝石: "+monster.getBag().toString());
    }
}
