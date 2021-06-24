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
    private Font font;

    private BurgerListener burgerListener;
    ArrayList<Burger> burgers;
    BurgerPanel(ArrayList<Burger> burgers){
        this.burgers=burgers;
        font = new Font("Comic Sans MS", Font.BOLD, 20);
        heading = new JLabel("Brampton Burgers");
        heading.setFont (font);
        burgersBtn = new ArrayList<>();
        burgerGrp = new ButtonGroup();
        setSize(getPreferredSize());
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 1;
        gc.gridy = 0;
        gc.weighty=0.5;

        //        0th Row
        gc.anchor = GridBagConstraints.CENTER;
        add(heading,gc);

        // 2nd Row
        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        for(Burger b: burgers){
            JRadioButton btn = new JRadioButton(b.getName());
            btn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            btn.setBackground(Color.white);
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        int w = getWidth();
//        int h = getHeight();
//        Color color1 = new Color(134, 168, 255);
//        Color color2 = new Color(134,168,255, 102);
//        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
//        g2d.setPaint(gp);
//        g2d.fillRect(0, 0, w, h);
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
