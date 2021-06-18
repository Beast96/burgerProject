import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BurgerPanel extends JPanel {
    private JLabel heading;
    private ArrayList<JButton> burgersBtn;
    BurgerPanel(ArrayList<Burger> burgers){
        heading = new JLabel("BRAMPTON BURGERS");
        heading.setFont (new Font("Times new Roman", Font.BOLD, 35));
        burgersBtn = new ArrayList<>();

        setSize(getPreferredSize());
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

//        gc.weightx = 1;
//        gc.weighty = 1;

        //        First Row
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(heading,gc);

        // 2nd Row
        gc.gridx=0;
        gc.gridy++;
        gc.weighty=5;
        gc.weightx = 0.1;
        for(Burger b: burgers){
            JButton btn = new JButton(b.getName());
            burgersBtn.add(btn);
            add(btn,gc);
            gc.gridx++;
        }
    }
}
