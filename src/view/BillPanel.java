package view;

import model.Bill;
import model.Burger;
import model.Topping;

import javax.swing.*;
import java.awt.*;

public class BillPanel extends JPanel {
    private Burger burger;
    BillPanel(){
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
    }
    public void setBurger(Burger burger){
        this.burger=burger;
        Bill bill= new Bill(burger);
        setLayout(new GridLayout(burger.getToppings().size()+8,3));

//        1st Row
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(new JLabel("Order Receipt"));
        add(Box.createRigidArea(new Dimension(10, 0)));

        //        2nd Row
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(new JLabel("Order No. - "+ String.format("%04d", bill.getOrderNo())));
        add(Box.createRigidArea(new Dimension(10, 0)));

        //3rd Row
        add(new JLabel("Burger"));
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(Box.createRigidArea(new Dimension(10, 0)));

        //        4th Row
        add(new JLabel(burger.getName()));
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(new JLabel(burger.getPrice()+""));

        //        5th Row
        add(new JLabel("Toppings"));
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(Box.createRigidArea(new Dimension(10, 0)));

        //        6th Row
        for(Topping t: burger.getToppings()){
            add(new JLabel(t.getName()));
            add(Box.createRigidArea(new Dimension(10, 0)));
            add(new JLabel(t.getPrice().toString()));
        }

        add(Box.createRigidArea(new Dimension(10, 0)));
        add(new JLabel("Sub Total"));
        add(new JLabel(bill.getSubTotal()+""));

        add(Box.createRigidArea(new Dimension(10, 0)));
        add(new JLabel("Tax "));
        add(new JLabel(String.format("%.2f",bill.getTax())));

        add(Box.createRigidArea(new Dimension(10, 0)));
        add(new JLabel("Total "));
        add(new JLabel(String.format("%.2f",bill.getTotal())));

        revalidate();
    }
}
