package game.consolePanel;

import constant.EquipmentType;
import equipment.EquipComponents;
import equipment.Equipment;
import equipment.Gem;
import equipment.GemValue;
import role.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by PandaLin on 2019/3/22.
 */
public class EquipmentFrame extends JFrame implements ActionListener {
    Equipment equipment;
    EquipmentType type;
    Hero hero;
    JFrame that;
    HeroPanel heroPanel;

    JPanel head,mainEquip, equipped, bag, confirm_panel;
    JButton upgrade, confirm;
    JLabel head_title, equip_quality;

    public EquipmentFrame(Hero hero, HeroPanel heroPanel) {
        this.hero = hero;
        this.heroPanel = heroPanel;
        that = this;

        this.setLayout(new GridLayout(5, 1));
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(false);

        head = new JPanel();
        head.setBackground(Color.WHITE);
        mainEquip = new JPanel();
        mainEquip.setBackground(Color.WHITE);
        equipped = new JPanel();
        equipped.setBackground(Color.WHITE);
        equipped.setAlignmentX(FlowLayout.LEFT);
        bag = new JPanel();
        bag.setBackground(Color.WHITE);
        bag.setAlignmentX(FlowLayout.LEFT);
        confirm_panel = new JPanel();
        confirm_panel.setBackground(Color.WHITE);

        equip_quality = new JLabel();
        upgrade = new JButton("升级");
        upgrade.addActionListener(new UpgradeEquip());
        mainEquip.add(equip_quality);
        mainEquip.add(upgrade);

        head_title = new JLabel();
        head.add(head_title);

        confirm = new JButton("确认");
        confirm.addActionListener(new Confirm());
        confirm_panel.add(confirm);

        this.add(head);
        this.add(mainEquip);
        this.add(equipped);
        this.add(bag);
        this.add(confirm_panel);

//        initial();


    }

    public void initial(EquipmentType type) {
        this.type = type;

        equipped.removeAll();
        bag.removeAll();


        if (type.equals(EquipmentType.ARMOR)) {
            head_title.setText("铠甲");
            equipment = hero.getArmor();
        } else {
            head_title.setText("武器");
            equipment = hero.getWeapon();
        }

        Gem gem = (Gem) equipment;
        EquipComponents split = gem.split();

        equip_quality.setText("等级："+split.getEquipment().getQuality().toString().charAt(0));

//        System.out.println("gems:"+split.getGems().size());
//        split.showGems();

        List<GemValue> gems = split.getGems();

        equipped.add(new JLabel("已装备: "));

        for (int i = 0; i < gems.size(); i++) {
            GemValue gm = gems.get(i);
            String text = gm.toString();
            JButton button = new JButton(text);
            button.setActionCommand("remove," + i);
            button.addActionListener(this);
            equipped.add(button);

        }

        bag.add(new JLabel("未装备: "));

        List<GemValue> bag_gems = hero.getBag().getGems();
        for (int i = 0; i < bag_gems.size(); i++) {
            GemValue gm = bag_gems.get(i);
            String text = gm.toString();
            JButton button = new JButton(text);
            button.setActionCommand("add," + i);
            button.addActionListener(this);
            bag.add(button);

        }

        equipped.updateUI();
        bag.updateUI();
        equipped.repaint();
        bag.repaint();

    }

    public void actionPerformed(ActionEvent e) {


        String command = e.getActionCommand();
        String[] split = command.split(",");
        if (split[0].equals("add")) {
            System.out.println(command);
            hero.addEquipGem(this.equipment, Integer.parseInt(split[1]));
        } else {
            System.out.println(command);
            hero.removeEquipGem(this.equipment, Integer.parseInt(split[1]));
        }

        initial(type);
        heroPanel.update();



    }

    class Confirm implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            that.setVisible(false);
        }
    }

    class UpgradeEquip implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            hero.strengthenEquip(equipment);
            if(type.equals(EquipmentType.ARMOR)){
                equipment = hero.getArmor();
            }else{
                equipment = hero.getWeapon();
            }
            Gem gem = (Gem)equipment;
            equip_quality.setText("等级："+gem.split().getEquipment().getQuality().toString().charAt(0));

            heroPanel.update();

        }
    }
}
