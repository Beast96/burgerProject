package view;

import controller.Restaurant;
import model.Burger;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BurgerPanel burgerPanel;
    private ToppingPanel toppingsPanel;
    private BillPanel billPanel;
    public MainFrame(){
        super("Brampton Burgers");
        new Restaurant();

        Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2,screenSize.height/2);
        setMinimumSize(new Dimension(500,500));
        this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        burgerPanel =  new BurgerPanel(Restaurant.getBurgers());
        toppingsPanel = new ToppingPanel(Restaurant.getToppings());
        billPanel = new BillPanel();
        burgerPanel.setBackground(Color.BLUE);
        toppingsPanel.setBackground(Color.RED);
//        toppingsPanel.setVisible(false);

        setLayout(new BorderLayout());
        JPanel tmp = new JPanel();
        tmp.setLayout(new BoxLayout(tmp,BoxLayout.Y_AXIS));
        tmp.add(burgerPanel);
        tmp.add(toppingsPanel);
        add(tmp,BorderLayout.CENTER);
        add(billPanel,BorderLayout.EAST);

        //EVENT LISTENERS
        burgerPanel.setBurgerListener(new BurgerListener() {
            @Override
            public void sendBurger(Burger burger) {
                toppingsPanel.setVisible(true);
                toppingsPanel.setBurger(burger);
            }
        });
        toppingsPanel.setBurgerListener(new BurgerListener() {
            @Override
            public void sendBurger(Burger burger) {
                billPanel.setBurger(burger);
            }
        });
    }
}
