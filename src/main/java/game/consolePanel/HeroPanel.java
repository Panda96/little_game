package game.consolePanel;

import constant.Constant;
import constant.EquipmentType;
import constant.SkillType;
import equipment.Equipment;
import game.Game;
import game.GameFrame;
import role.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class HeroPanel extends JPanel implements ActionListener{
    private GameFrame frame;
    private MonsterPanel monsterPanel;
    private Game game;
    private Hero hero;
    private boolean isCombo;
    private List<SkillType> skills;
    private HeroPanel that;
    private JButton next_monster;

    private EquipmentFrame equipmentFrame;

    private JLabel m_name, m_capability, m_level, m_life, m_money, m_gem;

    public HeroPanel(Game game, GameFrame frame, MonsterPanel monsterPanel){
        that = this;
        this.frame = frame;
        this.monsterPanel = monsterPanel;
        this.game = game;
        this.hero = (Hero)game.getHero();
        this.isCombo = false;
        this.skills = new ArrayList<SkillType>();
        this.equipmentFrame = new EquipmentFrame(hero,this);

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        m_name = new JLabel();
        m_name.setFont(Constant.header_fond);
        m_capability = new JLabel();
        m_capability.setFont(Constant.normal_fond);
        m_level = new JLabel();
        m_level.setFont(Constant.normal_fond);
        m_life = new JLabel();
        m_life.setFont(Constant.normal_fond);
        m_money = new JLabel();
        m_money.setFont(Constant.normal_fond);
        m_gem = new JLabel();
        m_gem.setFont(Constant.normal_fond);



        JButton armor = new JButton("铠甲");
        armor.setActionCommand("armor");
        armor.addActionListener(new Adjust());

        JButton weapon = new JButton("武器");
        weapon.setActionCommand("weapon");
        weapon.addActionListener(new Adjust());

        JButton clear_bag = new JButton("清空背包");
        clear_bag.addActionListener(new ClearBag());

        JLabel skills_label = new JLabel("技能：");
        BoxLayout bl = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(bl);

        this.add(m_name);
        this.add(m_life);
        this.add(m_level);
        this.add(m_capability);
        this.add(m_money);
        this.add(m_gem);
        this.add(armor);
        this.add(weapon);
        this.add(clear_bag);
        this.add(skills_label);

        List<SkillType> skills = hero.getSkills();
        JButton[] skill_buttons = new JButton[4];
        int i = 1;
        for(;i<=4;i++){
            skill_buttons[i-1] = new JButton("技能"+i);
            skill_buttons[i-1].setActionCommand(""+i);
            skill_buttons[i-1].addActionListener(this);
            if (i > skills.size()){
                skill_buttons[i-1].setEnabled(false);
            }
            this.add(skill_buttons[i-1]);
        }

        skill_buttons[3].setText("组合技");

        next_monster = new JButton("下一个怪物");
        next_monster.addActionListener(new NextListener());

        this.add(next_monster);

        next_monster.setEnabled(false);
        this.update();


    }


    public void update(){
        m_name.setText("英雄:");
        m_level.setText("等级: LV"+hero.getLevel());
        m_life.setText("生命: "+hero.getCurrentLife());
        m_capability.setText("能力:"+hero.getBaseCapability().getBase());
        m_money.setText("金钱: "+hero.getMoney());
        m_gem.setText("宝石: "+hero.getBag().toString());
    }





    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("4")){
            isCombo = true;
//            skills = new ArrayList<SkillType>();
        }else {
            SkillType skill = SkillType.getSkill(Integer.parseInt(command));
            skills.add(skill);
            if(!isCombo){
                game.heroAttack(skills);
                game.monsterAttack();
                skills = new ArrayList<SkillType>();
            }else{
                if(skills.size() >= 2){
                    isCombo = false;
                    game.heroAttack(skills);
                    game.monsterAttack();
                    skills = new ArrayList<SkillType>();
                }
            }


        }
        if(game.getMonster().is_dead()){
            next_monster.setEnabled(true);
        }else if (game.getState().equals(game.getGameOverState())){
            frame.getMainCard().show(frame.getMainPanel(), "2");
        }
        monsterPanel.update(game.getMonster());
        this.update();
        frame.getGamePanel().repaint();

    }

    class NextListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            game.prepare();
            next_monster.setEnabled(false);
            frame.getGamePanel().repaint();
            that.update();
            monsterPanel.update(game.getMonster());
        }
    }

    class ClearBag implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            int cost = hero.getBag().sellAll();
            hero.setMoney(hero.getMoney()+cost);
            that.update();
        }
    }

    class Adjust implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("armor")){
                equipmentFrame.initial(EquipmentType.ARMOR);
                equipmentFrame.setVisible(true);
            }else{
                equipmentFrame.initial(EquipmentType.GUN);
                equipmentFrame.setVisible(true);
            }
        }
    }
}
