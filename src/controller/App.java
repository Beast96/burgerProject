package controller;

import view.MainFrame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
//        new controller.Restaurant();
//
//       controller.Restaurant.displayBurgers();
//
//       model.Burger selectedBurger =  controller.Restaurant.selectBurger();
//
//       controller.Restaurant.displayToppings();
//
//       controller.Restaurant.chooseToppings(selectedBurger);
//
//       model.Bill bill = new model.Bill(selectedBurger);
//
//       bill.generateReciept();

    }
}
