package view;

import model.Burger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BurgerPanel extends JPanel implements ActionListener {
    private JLabel heading;
    private ArrayList<JRadioButton> burgersBtn;
    private ButtonGroup burgerGrp;

    private BurgerListener burgerListener;
    ArrayList<Burger> burgers;
    BurgerPanel(ArrayList<Burger> burgers){
        this.burgers=burgers;
        heading = new JLabel("Please Select a Burger");
//        heading.setFont (new Font("Times new Roman", Font.BOLD, 35));
        burgersBtn = new ArrayList<>();
        burgerGrp = new ButtonGroup();
        setSize(getPreferredSize());
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 1;
        gc.gridy = 0;
        gc.weighty=0.5;

        //        First Row
        gc.anchor = GridBagConstraints.CENTER;
        add(heading,gc);

        // 2nd Row
        gc.gridx=1;
        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        for(Burger b: burgers){
            JRadioButton btn = new JRadioButton(b.getName());
            burgersBtn.add(btn);
            burgerGrp.add(btn);

            btn.addActionListener(this);
            btn.setActionCommand(burgers.indexOf(b)+"");

            add(btn,gc);
            gc.gridy++;
            gc.gridx=1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.burgerListener!=null){
            this.burgerListener.sendBurger(burgers.get(Integer.parseInt(burgerGrp.getSelection().getActionCommand())));
//            System.out.println(burgerGrp.getSelection().getActionCommand());

        }
    }
    public void setBurgerListener(BurgerListener burgerListener){this.burgerListener=burgerListener;}
}
