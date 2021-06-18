import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
//        new Restaurant();
//
//       Restaurant.displayBurgers();
//
//       Burger selectedBurger =  Restaurant.selectBurger();
//
//       Restaurant.displayToppings();
//
//       Restaurant.chooseToppings(selectedBurger);
//
//       Bill bill = new Bill(selectedBurger);
//
//       bill.generateReciept();

    }
}
