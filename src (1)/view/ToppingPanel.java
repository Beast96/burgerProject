package view;

import model.Bill;
import model.Burger;
import model.Topping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToppingPanel extends JPanel implements ActionListener {
    private ArrayList<JButton> toppingAddBtns;
    private ArrayList<JButton> toppingRemoveBtns;
    private ArrayList<JLabel> toppingsCountLabels;
    private ArrayList<Integer> toppingsCount;
    private JLabel toppingsHeading;
    private JButton orderNowBtn;

    private Burger burger;
    private Integer toppingsLeft;
    private ArrayList<Topping> toppings;

    private BurgerListener burgerListener;

    ToppingPanel(ArrayList<Topping> toppings){
        this.toppings=toppings;
        toppingAddBtns  = new ArrayList<>();
        toppingRemoveBtns  = new ArrayList<>();
        toppingsCountLabels  = new ArrayList<>();
        toppingsCount  = new ArrayList<>();
        toppingsHeading = new JLabel("Toppings:");
        orderNowBtn = new JButton("Order Now");

        orderNowBtn.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx=1;
        gc.gridy=0;
        gc.weighty=1;

        gc.anchor= GridBagConstraints.CENTER;
        add(toppingsHeading,gc);

        gc.gridx=4;
        add(new JLabel("Count"),gc);

        gc.weightx=1;
        for(Topping t: toppings){
            gc.gridx=0;
            gc.gridy++;

            JButton toppingAddBtn = new JButton("+");
            JLabel toppingName= new JLabel(t.toString());
            JButton toppingRemoveBtn = new JButton("-");
            JLabel toppingCountLabel = new JLabel("0");
            toppingsCount.add(0);

            toppingAddBtn.addActionListener(this);
            toppingRemoveBtn.addActionListener(this);

            toppingAddBtns.add(toppingAddBtn);
            toppingRemoveBtns.add(toppingRemoveBtn);
            toppingsCountLabels.add(toppingCountLabel);

            gc.anchor= GridBagConstraints.LINE_END;
            add(toppingRemoveBtn,gc);

            gc.gridx++;
            gc.anchor= GridBagConstraints.CENTER;
            add(toppingName,gc);

            gc.gridx++;
            gc.anchor= GridBagConstraints.LINE_START;
            add(toppingAddBtn,gc);

            gc.gridx++;
            gc.anchor= GridBagConstraints.CENTER;
            add(Box.createRigidArea(new Dimension(10, 0)),gc);

            gc.gridx++;
            gc.anchor= GridBagConstraints.CENTER;
            add(toppingCountLabel,gc);

            gc.gridx++;
            gc.anchor= GridBagConstraints.CENTER;
            add(Box.createRigidArea(new Dimension(10, 0)),gc);
//            add(toppingPanel);
//            add(Box.createRigidArea(new Dimension(0, 5)));
        }
        gc.gridy++;
        gc.gridx=1;
        gc.anchor=GridBagConstraints.CENTER;
        add(orderNowBtn,gc);

    }
    public void setBurger(Burger burger){
        this.burger=burger;
        resetToppings();
    }
    public void setBurgerListener(BurgerListener burgerListener){this.burgerListener=burgerListener;}

    @Override
    public void actionPerformed(ActionEvent e) {
       JButton clickedBtn = (JButton) e.getSource();
       switch (clickedBtn.getText()) {
           case "+":
           {
               int index = toppingAddBtns.indexOf(clickedBtn);
               addTopping(index);
               break;
           }
           case "-":{
               int index= toppingRemoveBtns.indexOf(clickedBtn);
               removeTopping(index);
               break;
           }
           case "Order Now":
               for(int i=0;i<toppingsCount.size();i++){
                   int count=toppingsCount.get(i);
                   if(count!=0){
                       while(count!=0){
                           burger.setToppings(toppings.get(i));
                           count--;
                       }
                   }
               }
               if(burgerListener!=null){
                   burgerListener.sendBurger(burger);
               }
               break;
       }
        toppingsLeft = burger.getMaxToppings()-getTotalToppings();
        toppingsHeading.setText(String.format("Topping(%d left):",toppingsLeft));
    }
    private void addTopping(int index){
        if(getTotalToppings()==burger.getMaxToppings()){
            //Display Message
            JOptionPane.showMessageDialog(this,"Max Toppings Allowed is "+burger.getMaxToppings());
        }else{
            toppingsCount.set(index,toppingsCount.get(index)+1);
            toppingsCountLabels.get(index).setText((toppingsCount.get(index).toString()));
        }
    }
    private void removeTopping(int index){
        if(toppingsCount.get(index)==0){
            //display message
        }else{
            toppingsCount.set(index,toppingsCount.get(index)-1);
            toppingsCountLabels.get(index).setText((toppingsCount.get(index).toString()));
        }
    }
    private int getTotalToppings(){
        int sum=0;
        for(Integer i: toppingsCount){sum+=i;}
        return sum;
    }
    private void resetToppings(){
        for(int i=0;i<toppingsCount.size();i++){
            toppingsCount.set(i,0);
            toppingsCountLabels.get(i).setText("0");
        }
        toppingsLeft = burger.getMaxToppings()-getTotalToppings();
        toppingsHeading.setText(String.format("Topping(%d left):",toppingsLeft));

    }
}
