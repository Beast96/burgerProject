import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private BurgerPanel burgerPanel;
    MainFrame(){
        super("Brampton Burgers");
        new Restaurant();

        Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/2,screenSize.height/2);
        setMinimumSize(new Dimension(500,500));
        this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        burgerPanel =  new BurgerPanel(Restaurant.getBurgers());
        setLayout(new CardLayout());
        add(burgerPanel);
    }
}
